/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.filial;

import br.senac.pi3.daos.FilialDAO;
import br.senac.pi3.entidades.FilialEntidade;
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
@WebServlet(name = "FilialServletEditar", urlPatterns = { "/protegido/filiais/editar" })
public class FilialEditarServlet extends HttpServlet{
    public FilialDAO filiaisDao = new FilialDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("filial", filiaisDao.find(id));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/filialUpdate.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String cep = request.getParameter("cep");
        String localidade = request.getParameter("localidade");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String telefone = request.getParameter("telefone");
        
        FilialEntidade filialAtualizado = new FilialEntidade(nome, cnpj, cep, localidade, logradouro, numero, telefone);
        int id = Integer.parseInt(request.getParameter("id"));
        filiaisDao.atualizar(id, filialAtualizado);
        
        response.sendRedirect(request.getContextPath() + "/protegido/filiais");
        
    }
}
