/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.usuarios;

import br.senac.pi3.daos.UsuarioDAO;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = { "/protegido/usuarios" })
public class UsuarioServlet extends HttpServlet {
    
    public UsuarioDAO usuariosDao = new UsuarioDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("usuarios", usuariosDao.todos(request.getSession().getAttribute("filial_id")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarioIndex.jsp");
        dispatcher.forward(request, response);
    }
}
