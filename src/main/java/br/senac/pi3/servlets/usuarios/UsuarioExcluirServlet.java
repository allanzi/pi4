/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.usuarios;

import br.senac.pi3.daos.UsuarioDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author allan
 */
@WebServlet(name = "UsuarioExcluirServlet", urlPatterns = { "/protegido/usuarios/excluir" })
public class UsuarioExcluirServlet extends HttpServlet{
    
    public UsuarioDAO usuariosDao = new UsuarioDAO();
    
    @Override
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        usuariosDao.excluir(id);
         
        response.sendRedirect(request.getContextPath() + "/protegido/usuarios");
     }
}
