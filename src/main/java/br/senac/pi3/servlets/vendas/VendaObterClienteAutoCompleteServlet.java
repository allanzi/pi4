/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.vendas;

import br.senac.pi3.daos.ClienteDAO;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author allan
 */
@WebServlet(name = "VendaObterClienteAutoCompleteServlet", urlPatterns = {"/protegido/vendas/cliente/autocomplete"})
public class VendaObterClienteAutoCompleteServlet extends HttpServlet {

    public ClienteDAO estoqueDao = new ClienteDAO();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String json = new Gson().toJson(estoqueDao.todosAutoComplete(request.getSession().getAttribute("filial_id")));
        response.getWriter().write(json);
    }
}
