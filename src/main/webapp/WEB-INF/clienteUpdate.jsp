<%-- 
    Document   : clienteIndex
    Created on : 03/10/2017, 20:14:36
    Author     : allan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>Astec Games</title>
         

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <nav style="transform: translateY(-21px);" class="teal">
            <div class="container">
                <div class="nav-wrapper">
                    <div class="col s12">
                        <a href="${pageContext.request.contextPath}/protegido/telaInicial" class="breadcrumb">Inicío</a>
                        <a href="${pageContext.request.contextPath}/protegido/clientes" class="breadcrumb">Clientes</a>
                        <a href="${pageContext.request.contextPath}/protegido/clientes/atualizar?id=${cliente.getId()}" class="breadcrumb">Edição de Clientes</a>
                    </div>
                </div>
            </div>
        </nav>

        <main class="container">
            <div class="row">
                <form name="form-clientes" action="#" method="POST" class="col s12" accept-charset="UTF-8">
                    <div class="row">
                        <div class="input-field col s12 m12 l4">
                            <label for="nome">Nome</label>
                            <input name="nome" id="nome" type="text" class="validate" required="required" value="${cliente.getNome()}">
                        </div>

                        <div class="input-field col s12 m12 l4">
                            <label for="email">Email</label>
                            <input name="email" id="email" type="email" class="validate" required="required" value="${cliente.getEmail()}">
                        </div>

                        <div class="input-field col s12 m12 l4">
                            <label for="telefone">Telefone</label>
                            <input name="telefone" id="telefone" type="text" class="validate" required="required" data-mask="(00) 00000-0000" value="${cliente.getTelefone()}">
                        </div>

                        <div class="input-field col s12 m6 l6">
                            <label for="cpf">Cpf</label>
                            <input name="cpf" id="cpf" type="text" class="validate" required="required" data-mask="000.000.000-00" value="${cliente.getCpf()}">
                        </div>

                        <div class="input-field col s12 m6 l6">
                            <label for="cep">Cep</label>
                            <input name="cep" id="cep" type="text" class="validate col s11" data-mask="00000-000" value="${cliente.getCep()}">
                            <i class="material-icons col s1" id="search-cep" style="transform: translateY(21px);cursor: pointer;">search</i>
                        </div>

                        <div class="input-field col s12 m6 l6">
                            <label for="logradouro">Logradouro</label>
                            <input name="logradouro" id="logradouro" type="text" class="validate" value="${cliente.getLogradouro()}">
                        </div>

                        <div class="input-field col s12 m6 l6">
                            <label for="numero">Número</label>
                            <input name="numero" id="numero" type="number" class="validate" value="${cliente.getNumeroResidencia()}">
                        </div>

                        <div class="input-field right">
                            <a href="${pageContext.request.contextPath}/protegido/clientes" class="waves-effect waves-light btn grey lighten-3 black-text"><i class="material-icons left">arrow_back</i>Voltar</a>
                            <button type="submit" class="waves-effect waves-light btn"><i class="material-icons left">send</i>Confirmar</button>
                        </div>
                    </div>
                </form>
            </div>
        </main>

        <jsp:include page="footer.jsp" />

        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.mask.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/materialize.js"></script>
        <script src="${pageContext.request.contextPath}/js/init.js"></script>

    </body>
</html>
