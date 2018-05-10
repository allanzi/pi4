/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.vendas;

import br.senac.pi3.daos.VendaDAO;
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
@WebServlet(name = "VendaServlet", urlPatterns = {"/protegido/vendas"})
public class VendaServlet extends HttpServlet {

    public VendaDAO vendaDao = new VendaDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("vendas", vendaDao.todos(request.getSession().getAttribute("filial_id")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vendaIndex.jsp");
        dispatcher.forward(request, response);
    }
}
