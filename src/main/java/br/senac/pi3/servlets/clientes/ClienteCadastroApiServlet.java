/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.clientes;

import br.senac.pi3.daos.ClienteDAO;
import br.senac.pi3.entidades.ClienteEntidade;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author allan
 */
@WebServlet(name = "ClienteApiServletCadastro", urlPatterns = { "/protegido/clientes/cadastro/api" })
public class ClienteCadastroApiServlet extends HttpServlet{
    
    public ClienteDAO clienteDao = new ClienteDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String cpf = request.getParameter("cpf");
        Object filialId = request.getSession().getAttribute("filial_id");
        
        ClienteEntidade novoCliente = new ClienteEntidade(nome, email, telefone, cpf, filialId);
        clienteDao.cadastrar(novoCliente);
        
        String json = new Gson().toJson(clienteDao.findWhereEmail(email));
        response.getWriter().write(json);
    }
}
