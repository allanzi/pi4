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
        <link rel="icon" type="imagem/png" href="http://ap.imagensbrasil.org/images/2017/10/19/astec.png" />     


        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body >
        <%@ include file="header.jsp" %>

        <nav style="transform: translateY(-21px);" class="teal">
            <div class="container">
                <div class="nav-wrapper">
                    <div class="col s12">
                        <a href="${pageContext.request.contextPath}/protegido/telaInicial" class="breadcrumb">Inicío</a>
                    </div>
                </div>
            </div>
        </div>
    </nav>

    <div class="container">
        <h5>Bem vindo <%= session.getAttribute("usuario_nome")%>,</h5>
    </div>
    <br>

    <main class="container" id="tela-inicio">           

        <div class="row">

            <c:if test = "${sessionScope.perfil == 'Comercial' 
                            || sessionScope.perfil == 'Administrador'
                            || sessionScope.perfil == 'Gerente'}">
                <div class="col m3 s12">
                    <div class="provider">

                        <a name="icones" class="material-icons darken-text tooltipped"  id="fornecedor" data-delay="50" data-tooltip="Fornecedores" href="${pageContext.request.contextPath}/protegido/fornecedores">local_shipping</a>

                    </div>
                </div>
            </c:if>

            <c:if test = "${sessionScope.perfil == 'Comercial' 
                            || sessionScope.perfil == 'Administrador'
                            || sessionScope.perfil == 'Gerente'}">

                <div class="col m3 s12">
                    <div class="storage">                         

                        <a name="icones" class="material-icons tooltipped" id="estoque" data-delay="50" data-tooltip="Estoque" href="${pageContext.request.contextPath}/protegido/estoque">list</a>
                    </div>
                </div>
            </c:if>

            <c:if test = "${sessionScope.perfil == 'Caixa' 
                            || sessionScope.perfil == 'Administrador'
                            || sessionScope.perfil == 'Gerente'}">
                <div class="col m3 s12">
                    <div class="client">

                        <a name="icones" class="material-icons tooltipped" id="cliente" data-delay="50" data-tooltip="Clientes" href="${pageContext.request.contextPath}/protegido/clientes">group</a>
                    </div>
                </div>
            </c:if>


            <c:if test = "${sessionScope.perfil == 'Administrador'}">
                <div class="col m3 s12">
                    <div class="TI">

                        <a name="icones" class="material-icons tooltipped" id="ti" data-delay="50" data-tooltip="Filiais" href="${pageContext.request.contextPath}/protegido/filiais">store</a>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
    <br>
</div>
</main>

<c:if test="${not empty naoAutorizado}">
    <script>
        alert('Sinto Muito, você não possui permissão para acessar!!')
    </script>
</c:if>
    
<jsp:include page="footer.jsp" />

<!--  Scripts-->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.mask.min.js"></script>
<script src="${pageContext.request.contextPath}/js/materialize.js"></script>
<script src="${pageContext.request.contextPath}/js/init.js"></script>

</body>
</html>
