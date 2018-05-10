/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.filial;

import br.senac.pi3.daos.FilialDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author allan
 */
@WebServlet(name = "FilialExcluirServlet", urlPatterns = { "/protegido/filiais/excluir" })
public class FilialExcluirServlet extends HttpServlet{
    
    public FilialDAO filiaisDao = new FilialDAO();
    
    @Override
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        filiaisDao.excluir(id);
         
        response.sendRedirect(request.getContextPath() + "/protegido/filiais");
     }
}
