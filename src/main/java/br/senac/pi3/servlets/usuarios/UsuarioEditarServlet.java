/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.usuarios;

import br.senac.pi3.daos.UsuarioDAO;
import br.senac.pi3.entidades.UsuarioEntidade;
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
@WebServlet(name = "UsuarioServletEditar", urlPatterns = { "/protegido/usuarios/editar" })
public class UsuarioEditarServlet extends HttpServlet{
    public UsuarioDAO usuariosDao = new UsuarioDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("usuario", usuariosDao.find(id));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarioUpdate.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String username = request.getParameter("username");
        
        UsuarioEntidade usuario = new UsuarioEntidade(nome, email, telefone, username);

        int id = Integer.parseInt(request.getParameter("id"));
        usuariosDao.atualizar(id, usuario);
        
        response.sendRedirect(request.getContextPath() + "/protegido/usuarios");
    }
}
