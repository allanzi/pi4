/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author allanzi
 */
public class FilterAutentecacao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private String[] Administrador = {
        "/protegido/telaInicial",
        "/protegido/clientes",
        "/protegido/clientes/editar",
        "/protegido/clientes/excluir",
        "/protegido/clientes/cadastro",
        "/protegido/fornecedores",
        "/protegido/fornecedores/editar",
        "/protegido/fornecedores/excluir",
        "/protegido/fornecedores/cadastro",
        "/protegido/estoque",
        "/protegido/estoque/editar",
        "/protegido/estoque/excluir",
        "/protegido/estoque/cadastro",
        "/protegido/vendas",
        "/protegido/vendas/cadastro",
        "/protegido/vendas/produto/autocomplete",
        "/protegido/vendas/cliente/autocomplete",
        "/protegido/vendas/cliente",
        "/protegido/vendas/produto",
        "/protegido/clientes/cadastro/api",
        "/protegido/filiais",
        "/protegido/filiais/editar",
        "/protegido/filiais/excluir",
        "/protegido/filiais/cadastro",
        "/protegido/usuarios",
        "/protegido/usuarios/editar",
        "/protegido/usuarios/excluir",
        "/protegido/usuarios/cadastro"
    };

    private String[] Gerente = {
        "/protegido/telaInicial",
        "/protegido/clientes",
        "/protegido/clientes/editar",
        "/protegido/clientes/excluir",
        "/protegido/clientes/cadastro",
        "/protegido/fornecedores",
        "/protegido/fornecedores/editar",
        "/protegido/fornecedores/excluir",
        "/protegido/fornecedores/cadastro",
        "/protegido/estoque",
        "/protegido/estoque/editar",
        "/protegido/estoque/excluir",
        "/protegido/estoque/cadastro",
        "/protegido/vendas",
        "/protegido/vendas/cadastro",
        "/protegido/vendas/produto/autocomplete",
        "/protegido/vendas/cliente/autocomplete",
        "/protegido/vendas/cliente",
        "/protegido/vendas/produto",
        "/protegido/clientes/cadastro/api",
        "/protegido/usuarios",
        "/protegido/usuarios/editar",
        "/protegido/usuarios/excluir",
        "/protegido/usuarios/cadastro"
    };

    public String[] Comercial = {
        "/protegido/telaInicial",
        "/protegido/fornecedores",
        "/protegido/fornecedores/editar",
        "/protegido/fornecedores/excluir",
        "/protegido/fornecedores/cadastro",
        "/protegido/estoque",
        "/protegido/estoque/editar",
        "/protegido/estoque/excluir",
        "/protegido/estoque/cadastro",
        "/protegido/vendas",
        "/protegido/vendas/cadastro",
        "/protegido/vendas/produto/autocomplete",
        "/protegido/vendas/cliente/autocomplete",
        "/protegido/vendas/cliente",
        "/protegido/vendas/produto",
        "/protegido/clientes/cadastro/api"
    };

    public String[] Caixa = {
        "/protegido/clientes",
        "/protegido/clientes/editar",
        "/protegido/clientes/excluir",
        "/protegido/clientes/cadastro",
        "/protegido/telaInicial",
        "/protegido/vendas",
        "/protegido/vendas/cadastro",
        "/protegido/vendas/produto/autocomplete",
        "/protegido/vendas/cliente/autocomplete",
        "/protegido/vendas/cliente",
        "/protegido/vendas/produto",
        "/protegido/clientes/cadastro/api"
    };

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession sessao = httpRequest.getSession();

        if (sessao.getAttribute("usuario") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        String funcionalidade = httpRequest.getRequestURI().replace(httpRequest.getContextPath(), "");
        Object perfil = sessao.getAttribute("perfil");

        if (perfil.equals("Administrador")) {
            if (!new ArrayList<>(Arrays.asList(this.Administrador)).contains(funcionalidade)) {
                httpRequest.setAttribute("naoAutorizado", "Sinto Muito, você não possui permissão para acessar.");
                RequestDispatcher dispatcher
                        = httpRequest.getRequestDispatcher("/WEB-INF/telaInicial.jsp");
                dispatcher.forward(httpRequest, httpResponse);
            }
        }

        if (perfil.equals("Gerente")) {
            if (!new ArrayList<>(Arrays.asList(this.Gerente)).contains(funcionalidade)) {
                httpRequest.setAttribute("naoAutorizado", "Sinto Muito, você não possui permissão para acessar.");
                RequestDispatcher dispatcher
                        = httpRequest.getRequestDispatcher("/WEB-INF/telaInicial.jsp");
                dispatcher.forward(httpRequest, httpResponse);
            }
        }

        if (perfil.equals("Comercial")) {
            if (!new ArrayList<>(Arrays.asList(this.Comercial)).contains(funcionalidade)) {
                httpRequest.setAttribute("naoAutorizado", "Sinto Muito, você não possui permissão para acessar.");
                RequestDispatcher dispatcher
                        = httpRequest.getRequestDispatcher("/WEB-INF/telaInicial.jsp");
                dispatcher.forward(httpRequest, httpResponse);
            }
        }

        if (perfil.equals("Caixa")) {
            if (!new ArrayList<>(Arrays.asList(this.Caixa)).contains(funcionalidade)) {
                httpRequest.setAttribute("naoAutorizado", "Sinto Muito, você não possui permissão para acessar.");
                RequestDispatcher dispatcher
                        = httpRequest.getRequestDispatcher("/WEB-INF/telaInicial.jsp");
                dispatcher.forward(httpRequest, httpResponse);
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
