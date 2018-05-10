<%-- 
    Document   : fornecedorIndex
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
                        <a href="${pageContext.request.contextPath}" class="breadcrumb">Inicío</a>
                        <a href="${pageContext.request.contextPath}/protegido/estoque" class="breadcrumb">Estoque</a>
                        <a href="${pageContext.request.contextPath}/protegido/estoque/atualizar?id=${estoque.getId()}" class="breadcrumb">Edição de Estoque</a>
                    </div>
                </div>
            </div>
        </nav>
        
        <main class="container">
            <div class="row">
                <form name="form-estoque" action="#" method="POST" class="col s12" accept-charset="UTF-8">
                    <div class="row">
                        
                        <div class="input-field col s12 m12 l4">
                            <label for="nome">Nome</label>
                            <input name="nome" id="nome" type="text" class="validate" required="required" data-length="150" maxlength="150">
                        </div>
                        
                        
                        <div class="input-field col s12 m12 l4">
                            <label for="valor">Valor</label>
                            <input name="valor" id="valor" type="number" class="validate" required="required" data-mask="000.000,00" >
                        </div>
                        
                        <div class="input-field col s12 m12 l4">
                            <label for="desenvolvedora">Desenvolvido Por</label>
                            <input name="desenvolvedora" id="desenvolvedora" type="text" class="validate" required="required" data-length="80" maxlength="80">
                        </div>

                        <div class="input-field col s12 m4 l4">
                            <label for="plataforma">Console</label>
                            <input name="plataforma" id="plataforma" type="text" class="validate" required="required" data-length="80" maxlength="80">
                        </div>

                        <div class="input-field col s12 m4 l4">
                            <label for="quantidade">Quant. Estoque</label>
                            <input name="quantidade" id="quantidade" type="number" class="validate" required="required" maxlength="6">
                        </div>
                        
                        <div class="input-field col s12 m4 l4">
                            <label for="codigo">Código</label>
                            <input name="codigo" id="codigo" type="number" class="validate" required="required" data-mask="00000000">
                        </div>

                    
                        <div class="input-field right">
                            <a href="${pageContext.request.contextPath}/protegido/estoque" class="waves-effect waves-light btn grey lighten-3 black-text"><i class="material-icons left">arrow_back</i>Voltar</a>
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
