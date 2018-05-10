/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.filial;

import br.senac.pi3.daos.FilialDAO;
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
@WebServlet(name = "FilialServlet", urlPatterns = { "/protegido/filiais" })
public class FilialServlet extends HttpServlet {
    
    public FilialDAO filialDao = new FilialDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("filiais", filialDao.todos());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/filialIndex.jsp");
        dispatcher.forward(request, response);
    }
}
