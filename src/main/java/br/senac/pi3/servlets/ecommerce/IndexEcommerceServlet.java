/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.ecommerce;

import br.senac.pi3.daos.EcommerceIndexDAO;
import br.senac.pi3.entidades.EcommerceIndexEntidade;
import com.google.gson.Gson;
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
@WebServlet(name = "IndexEcommerceServlet", urlPatterns = { "/index" })
public class IndexEcommerceServlet extends HttpServlet{
    private EcommerceIndexDAO dao = new EcommerceIndexDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        if (this.wantsJson(request)) {
            response.setContentType("application/json");
            EcommerceIndexEntidade entidade = new EcommerceIndexEntidade();
            entidade.setProdutos(dao.todos());
            entidade.setDestaques(dao.destaques());
            
            String json = new Gson().toJson(entidade);
            response.getWriter().write(json);
            return;
        }
        
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ecommerce/dist/index.jsp");
        dispatcher.forward(request, response);
    }
    
    private boolean wantsJson(HttpServletRequest request) {
        return request.getHeader("Accept").contains("application/json");
    }
}
