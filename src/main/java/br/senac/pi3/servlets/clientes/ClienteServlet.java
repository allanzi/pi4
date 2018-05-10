/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.clientes;

import br.senac.pi3.daos.ClienteDAO;
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
@WebServlet(name = "ClienteServlet", urlPatterns = { "/protegido/clientes" })
public class ClienteServlet extends HttpServlet {
    
    public ClienteDAO clientesDao = new ClienteDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("clientes", clientesDao.todos(request.getSession().getAttribute("filial_id")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/clienteIndex.jsp");
        dispatcher.forward(request, response);
    }
}
