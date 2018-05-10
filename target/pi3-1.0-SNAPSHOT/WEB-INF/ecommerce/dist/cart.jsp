<%-- 
    Document   : cart
    Created on : 27/04/2018, 20:38:44
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
<body ng-controller="cartController">

<div ng-include="'./components/header.html'"></div>

<div class="col s12 m6">
    <div class="card bg-cart">
        <div class="card-content white-text"></div>
    </div>
</div>

<main class="container">
    <div class="row">
        <div class="col s12 sem-sombra">
            <nav class="cart-header-panel" style="height: 46px;line-height: 46px;">
                <div class="nav-wrapper grey lighten-4">
                    <a class="brand-logo center blue-grey-text darken-5 truncate">Carrinho de compras</a>
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
                                <p><strong>Produto:</strong> Nome do produto</p>
                                <hr>
                                <div class="row">
                                    <div class="col s4 qtde-desc"><strong>Quantidade:</strong></div>
                                    <div class="col s8"><input type="number" name="qtde" id="qtde" value="1"></div>
                                </div>
                                <hr>
                                <p><strong>Preço unitário:</strong> R$ 245.50</p>
                                <hr>
                                <p><strong>Preço total:</strong> R$ 245.50</p>
                                <hr>
                                <p class="show-on-small"><a href="#">Remover produto</a></p>
                                <hr class="show-on-small">
                            </div>
                        </div>
                    </li>
                </ul>

                <div class="row hide-on-small-only hide-on-med-only" style="margin-bottom: 0">
                    <div class="col s12">
                        <p class="flow-text left"><strong>Total:</strong> R$ {{245.50*3 | number : 2}}</p>
                        <a href="#" class="btn btn-large red darken-1 right btn-cart">FINALIZAR COMPRA</a>
                    </div>
                </div>

                <div class="row show-on-medium show-on-small hide-on-med-and-up center" style="margin-bottom: 0">
                    <div class="col s12">
                        <p class="flow-text"><strong>Total:</strong> R$ {{245.50*3 | number : 2}}</p>
                        <a href="#" class="btn btn-large">FINALIZAR COMPRA</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<script src="js/all.js"></script>
<script>
    $('.card-panel-cart').css('min-height', $(window).height() * 0.6);
</script>
</body>
</html>