/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.filial;

import br.senac.pi3.daos.FilialDAO;
import br.senac.pi3.entidades.FilialEntidade;
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
@WebServlet(name = "FilialServletCadastro", urlPatterns = { "/protegido/filiais/cadastro" })
public class FilialCadastroServlet extends HttpServlet{
    
    public FilialDAO filiaisDao = new FilialDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/filialCreate.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String cep = request.getParameter("cep");
        String localidade = request.getParameter("localidade");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String telefone = request.getParameter("telefone");
        
        FilialEntidade novaFilial = new FilialEntidade(nome, cnpj, cep, localidade, logradouro, numero, telefone);
        filiaisDao.cadastrar(novaFilial);
        
        response.sendRedirect(request.getContextPath() + "/protegido/filiais");
    }
}
