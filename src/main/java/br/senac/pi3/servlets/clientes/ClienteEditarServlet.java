/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.clientes;

import br.senac.pi3.daos.ClienteDAO;
import br.senac.pi3.entidades.ClienteEntidade;
import java.io.IOException;
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
@WebServlet(name = "ClienteServletEditar", urlPatterns = { "/protegido/clientes/editar" })
public class ClienteEditarServlet extends HttpServlet{
    public ClienteDAO clientesDao = new ClienteDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("cliente", clientesDao.find(id));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/clienteUpdate.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String cpf = request.getParameter("cpf");
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        int numero = Integer.parseInt(request.getParameter("numero"));
        Object filialId = request.getSession().getAttribute("filial_id");
        
        ClienteEntidade clienteAtualizado = new ClienteEntidade(nome, email, cpf, telefone, logradouro, numero, cep, filialId);
        int id = Integer.parseInt(request.getParameter("id"));
        clientesDao.atualizar(id, clienteAtualizado);
        
        response.sendRedirect(request.getContextPath() + "/protegido/clientes");
        
    }
}
