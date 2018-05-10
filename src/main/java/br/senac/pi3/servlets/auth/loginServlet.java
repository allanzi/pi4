/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.auth;

import br.senac.pi3.entidades.UsuarioEntidade;
import br.senac.pi3.servlets.Filter.UsuarioSistemaService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String senha = request.getParameter("senha");

        UsuarioSistemaService service = new UsuarioSistemaService();
        UsuarioEntidade usuario = service.autenticar(username, senha);

        if (usuario != null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            sessao.setAttribute("usuario_nome", usuario.getNome());
            sessao.setAttribute("usuario_id", usuario.getId());
            sessao.setAttribute("filial_id", usuario.getFilialId());
            sessao.setAttribute("perfil", usuario.getPerfil());
            response.sendRedirect(request.getContextPath() + "/protegido/telaInicial");
        } else {
            request.setAttribute("mensagemErro", "Usuário ou senha inválido");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/login.jsp");
            dispatcher.forward(request, response);
        }

    }

}
