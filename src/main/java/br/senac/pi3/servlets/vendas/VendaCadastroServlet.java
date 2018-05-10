/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.vendas;

import br.senac.pi3.daos.ClienteDAO;
import br.senac.pi3.daos.EstoqueDAO;
import br.senac.pi3.daos.VendaDAO;
import br.senac.pi3.entidades.ClienteEntidade;
import br.senac.pi3.entidades.EstoqueEntidade;
import br.senac.pi3.entidades.VendaEntidade;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author allan
 */
@WebServlet(name = "VendaCadastroServlet", urlPatterns = { "/protegido/vendas/cadastro" })
public class VendaCadastroServlet extends HttpServlet {

    ClienteDAO clienteDao = new ClienteDAO();
    EstoqueDAO estoqueDao = new EstoqueDAO();
    VendaDAO vendaDao = new VendaDAO();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vendaCreate.jsp");
        dispatcher.forward(request, response);
    }
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        ClienteEntidade cliente = obterCliente(request);
        List<EstoqueEntidade> produtos = obterListaProdutos(request);
        Date data = new Date();
        BigDecimal total = obterTotal(produtos);
        String pagamento = request.getParameter("pagamento");
        Object vendedor = request.getSession().getAttribute("usuario_id");
        Object filialId = request.getSession().getAttribute("filial_id");
        
        VendaEntidade venda = new VendaEntidade(data, cliente, produtos, total, pagamento, vendedor, filialId);
        
        vendaDao.cadastrar(venda);
        
        removerProdutosEstoque(produtos);
        
        response.sendRedirect(request.getContextPath() + "/protegido/vendas");
    }

    private void removerProdutosEstoque(List<EstoqueEntidade> produtos) {
        for (EstoqueEntidade produto : produtos) {
            int quantidade = produto.getQuantidade()-1;
            estoqueDao.atualizarQtde(produto.id, quantidade);
        }
    }

    private BigDecimal obterTotal(List<EstoqueEntidade> produtos) {
        float valor = 0;
        for (EstoqueEntidade produto : produtos) {
            valor += produto.valor;
        }
        return new BigDecimal(valor);
    }

    private List<EstoqueEntidade> obterListaProdutos(HttpServletRequest request) throws NumberFormatException {
        List<EstoqueEntidade> produtoslista = new ArrayList<EstoqueEntidade>();
        String[] produtos = request.getParameterValues("produtos[]");
        
        for (String produto : produtos) {
            produtoslista.add(estoqueDao.find(Integer.parseInt(produto)));
        }
        
        return produtoslista;
    }

    private ClienteEntidade obterCliente(HttpServletRequest request) {
        String email = request.getParameter("email-cliente");
        System.out.println(email);
        return clienteDao.findWhereEmail(email);
    }
}
