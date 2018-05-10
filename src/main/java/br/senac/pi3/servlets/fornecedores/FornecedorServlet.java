/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.fornecedores;

import br.senac.pi3.daos.FornecedorDAO;
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
@WebServlet(name = "FornecedorServlet", urlPatterns = { "/protegido/fornecedores" })
public class FornecedorServlet extends HttpServlet {
    
    public FornecedorDAO fornecedorDao = new FornecedorDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("fornecedores", fornecedorDao.todos(request.getSession().getAttribute("filial_id")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/fornecedorIndex.jsp");
        dispatcher.forward(request, response);
    }
}
