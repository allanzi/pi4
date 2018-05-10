/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.ecommerce;

import br.senac.pi3.daos.DescricaoProdutoDao;
import br.senac.pi3.entidades.DescricaoProdutoEntidade;
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
@WebServlet(name = "ShowEcommerceServlet", urlPatterns = { "/show" })
public class ShowEcommerceServlet extends HttpServlet{
    
    private DescricaoProdutoDao dao = new DescricaoProdutoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        if (this.wantsJson(request)) {
            int id = Integer.parseInt(request.getParameter("id"));
            response.setContentType("application/json");
            DescricaoProdutoEntidade entidade = this.dao.find(id);
            
            String json = new Gson().toJson(entidade);
            response.getWriter().write(json);
            return;
        }
//        request.setAttribute("cliente", clientesDao.find(id));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ecommerce/dist/show.jsp");
        dispatcher.forward(request, response);
    }
    
    private boolean wantsJson(HttpServletRequest request) {
        return request.getHeader("Accept").contains("application/json");
    }
}
