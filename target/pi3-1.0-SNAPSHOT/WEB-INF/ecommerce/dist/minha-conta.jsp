<%-- 
    Document   : minha-conta
    Created on : 27/04/2018, 20:41:34
    Author     : allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt" ng-app="astec">
<head>
    <meta charset="UTF-8">
    <title>Astec Games | A melhor loja de game online</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="css/all.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body ng-controller="minhaContaController">

<div ng-include="'./components/header.html'"></div>

<main class="container">
    <div class="row">
        <div class="col s12 sem-sombra">
            <nav class="cart-header-panel" style="height: 46px;line-height: 46px;">
                <div class="nav-wrapper grey lighten-4">
                    <a class="brand-logo center blue-grey-text darken-5 truncate">Meu(s) pedido(s)</a>
                </div>
            </nav>
            <br><br><br>
            <div class="card-panel card-panel-cart">
                <ul class="collection cart-collection">
                    <li class="collection-item collection-item-cart" ng-repeat="item in [1,2,3]">
                        <div class="row">
                            <div class="col s12 m5">
                                <img src="http://materializecss.com/images/sample-1.jpg" alt="Produto"
                                     class="responsive-img">
                            </div>
                            <div class="col s12 m7 qtde-container">
                                <hr class="show-on-small">
                                <p><strong>Data da compra:</strong> 15/04/2018</p>
                                <hr>
                                <p><strong>Produto(s):</strong> Nome dos produtos</p>
                                <hr>
                                <p><strong>Preço total:</strong> R$ 245.50</p>
                                <hr>
                                <p><strong>Status:</strong> <em>Aguardando pagamento</em></p>
                                <hr>
                                <p class="show-on-small"><a href="#">Ver detalhes</a></p>
                                <hr class="show-on-small">
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</main>

<script src="js/all.js"></script>
</body>
</html>
