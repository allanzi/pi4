<%-- 
    Document   : filialIndex
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
        <title>Parallax Template - Materialize</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/ju/dt-1.10.16/b-1.4.2/b-html5-1.4.2/datatables.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.4.2/css/buttons.dataTables.min.css"/>
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <nav style="transform: translateY(-21px);" class="teal">
            <div class="container">
                <div class="nav-wrapper">
                    <div class="col s12">
                        <a href="${pageContext.request.contextPath}/protegido/telaInicial" class="breadcrumb">Inicío</a>
                        <a href="${pageContext.request.contextPath}/protegido/filiais" class="breadcrumb">Filiais</a>
                    </div>
                </div>
            </div>
        </nav>


        <main class="container-fluid">
            <table class="striped responsive-table">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Cnpj</th>
                        <th>Cep</th>
                        <th>Localidade</th>
                        <th>Logradouro</th>
                        <th>Número</th>
                        <th>Ação</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${filiais}" var="filial">
                        <tr>
                            <td><c:out value="${filial.getNome()}" /></td>
                            <td><c:out value="${filial.getCnpj()}" /></td>
                            <td><c:out value="${filial.getCep()}" /></td>
                            <td><c:out value="${filial.getLocalidade()}" /></td>
                            <td><c:out value="${filial.getLogradouro()}" /></td>
                            <td><c:out value="${filial.getNumeroResidencia()}" /></td>
                            <td><a href="${pageContext.request.contextPath}/protegido/filiais/editar?id=${filial.getId()}" class="waves-effect waves-light btn"><i class="material-icons left">edit</i>Editar</a>
                                <a data-target="delete" class="waves-effect waves-light btn red modal-trigger" id="${pageContext.request.contextPath}/protegido/filiais/excluir?id=${filial.getId()}"><i class="material-icons left">delete</i>Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>

        <br/>

        <div class="fixed-action-btn">
            <a class="btn-floating btn-large tooltipped darken-3" data-position="left" data-delay="50" data-tooltip="Nova Filial" href="${pageContext.request.contextPath}/protegido/filiais/cadastro">
                <i class="large material-icons">add</i>
            </a>
        </div>

        <jsp:include page="footer.jsp"/>

        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/materialize.js"></script>
        <script src="${pageContext.request.contextPath}/js/init.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/v/ju/dt-1.10.16/b-1.4.2/b-html5-1.4.2/datatables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.2/js/dataTables.buttons.min.js"></script>
        <script type="text/javascript" src="//cdn.datatables.net/buttons/1.4.2/js/buttons.flash.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
        <script type="text/javascript" src="//cdn.datatables.net/buttons/1.4.2/js/buttons.print.min.js"></script>
    </body>
</html>