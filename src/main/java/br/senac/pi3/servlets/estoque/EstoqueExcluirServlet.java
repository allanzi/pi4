/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.estoque;

import br.senac.pi3.daos.EstoqueDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joao Sergio
 */
@WebServlet(name = "EstoqueExcluirServlet", urlPatterns = { "/protegido/estoque/excluir" })
public class EstoqueExcluirServlet extends HttpServlet{
    
    public EstoqueDAO estoqueDao = new EstoqueDAO();
    
    @Override
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
         
        int id = Integer.parseInt(request.getParameter("id"));
        estoqueDao.excluir(id);
         
        response.sendRedirect(request.getContextPath() + "/protegido/estoque");
     }
}
