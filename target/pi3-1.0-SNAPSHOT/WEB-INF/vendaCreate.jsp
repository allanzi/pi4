<%-- 
    Document   : vendaIndex
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
                        <a href="${pageContext.request.contextPath}/protegido/vendas" class="breadcrumb">Vendas</a>
                        <a href="${pageContext.request.contextPath}/protegido/vendas/cadastro" class="breadcrumb">Cadastro de Venda</a>
                    </div>
                </div>
            </div>
        </nav>


        <main class="container-fluid" id="container-products">
            <div class="row">
                <form name="form-vendas" action="#" method="POST" accept-charset="UTF-8">
                    <div class="col s6">
                        <div class="card blue-grey darken-1">
                            <div class="card-content white-text" id="card-products-container">
                                <nav class="grey lighten-4">
                                    <div class="nav-wrapper">
                                        <a class="brand-logo center bold">Informações de pagamento</a>
                                        <ul id="nav-mobile" class="left hide-on-med-and-down">
                                        </ul>
                                    </div>
                                </nav>
                            </div>
                        </div>

                        <div class="input-field">
                            <label for="email">E-mail do cliente</label>
                            <input id="email-search" type="email" class="validate" name="email-cliente" required="required">

                            <button type="button" class="btn btn-large waves-effect btn-products-search" id="search-client">Pesquisar</button>

                            <div class="progress progress-button">
                                <div class="indeterminate"></div>
                            </div>

                            <a href="#modal1" class="right modal-trigger">Cadastrar cliente</a>
                        </div>

                        <br>

                        <div class="input-field">
                            <select name="pagamento" required="required">
                                <option value="" disabled selected>Escolha uma forma de pagamento</option>
                                <option value="Dinheiro">Dinheiro</option>
                                <option value="Cartão de Crédito">Cartão de Crédito</option>
                                <option value="Cartão de Débito">Cartão de Débito</option>
                                <option value="Vale Alimentação">Vale Alimentação</option>
                            </select>
                            <label>Forma de pagamento</label>
                        </div>
                    </div>
                    <div class="col s6">
                        <div class="card blue-grey darken-1">
                            <div class="card-content white-text" id="card-products-container">
                                <nav class="grey lighten-4">
                                    <div class="nav-wrapper">
                                        <a class="brand-logo center bold"><i class="material-icons left">account_balance_wallet</i> R$ <span id="value">0,00</span></a>
                                        <ul id="nav-mobile" class="left hide-on-med-and-down">
                                        </ul>
                                    </div>
                                </nav>
                            </div>
                        </div>

                        <div class="input-field">
                            <label for="code">Código do produto</label>
                            <input id="codigo-search" type="text" class="validate" data-mask="00000000">

                            <button type="button" class="btn btn-large waves-effect btn-products-search" id="search-product">Pesquisar</button>
                            <div class="progress progress-button">
                                <div class="indeterminate"></div>
                            </div>
                            <br>
                        </div>

                        <div id="cards">

                        </div>
                    </div>

                    <div class="input-field right">
                        <a href="${pageContext.request.contextPath}/protegido/vendas" class="waves-effect waves-light btn grey lighten-3 black-text" id="add-client"><i class="material-icons left">arrow_back</i>Voltar</a>
                        <button type="submit" class="waves-effect waves-light btn"><i class="material-icons left">send</i> Cadastrar</button>
                    </div>
                </form>
            </div>
        </main>

        <div id="modal1" class="modal">
            <div class="modal-content">
                <h4>Cadastro de cliente</h4>
                
                <br>
                
                <form name="form-clientes" action="${pageContext.request.contextPath}/protegido/clientes/cadastro/api" method="POST" class="col s12" accept-charset="UTF-8">
                    <div class="row">
                        <div class="input-field col s12 m12 l4">
                            <label for="nome">Nome</label>
                            <input name="nome" id="nome" type="text" class="validate" required="required">
                        </div>

                        <div class="input-field col s12 m12 l4">
                            <label for="email">Email</label>
                            <input name="email" id="email" type="email" class="validate" required="required">
                        </div>
                        
                        <div class="input-field col s12 m12 l4">
                            <label for="telefone">Telefone</label>
                            <input name="telefone" id="telefone" type="text" class="validate" required="required" data-mask="(00) 00000-0000">
                        </div>
                        
                        <div class="input-field col s12 m12 l12">
                            <label for="cpf">Cpf</label>
                            <input name="cpf" id="cpf" type="text" class="validate" required="required" data-mask="000.000.000-00">
                        </div>

                        <div class="input-field right">
                            <a href="javascript:;" class="modal-action modal-close waves-effect waves-light btn grey lighten-3 black-text"><i class="material-icons left">arrow_back</i>Fechar</a>
                            <a class="waves-effect waves-light btn" onclick="addClient()"><i class="material-icons left">send</i> Cadastrar</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <br/>

        <jsp:include page="footer.jsp"/>

        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/materialize.js"></script>
        <script src="${pageContext.request.contextPath}/js/init.js"></script>

    </body>
</html>
