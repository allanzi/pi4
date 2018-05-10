/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.fornecedores;

import br.senac.pi3.servlets.fornecedores.*;
import br.senac.pi3.daos.FornecedorDAO;
import br.senac.pi3.entidades.FornecedorEntidade;
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
@WebServlet(name = "FornecedorServletEditar", urlPatterns = { "/protegido/fornecedores/editar" })
public class FornecedoresEditarServlet extends HttpServlet{
    public FornecedorDAO fornecedoresDao = new FornecedorDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("fornecedor", fornecedoresDao.find(id));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/fornecedorUpdate.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String cnpj = request.getParameter("cnpj");
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        int numero = Integer.parseInt(request.getParameter("numero"));
        Object filialId = request.getSession().getAttribute("filial_id");
        
        FornecedorEntidade fornecedorAtualizado = new FornecedorEntidade(nome, email, telefone, cnpj, cep, logradouro, numero, filialId);
        int id = Integer.parseInt(request.getParameter("id"));
        fornecedoresDao.atualizar(id, fornecedorAtualizado);
        
        response.sendRedirect(request.getContextPath() + "/protegido/fornecedores");
        
    }
}
