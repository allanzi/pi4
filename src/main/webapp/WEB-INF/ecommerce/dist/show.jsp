<%-- 
    Document   : show
    Created on : 27/04/2018, 20:44:11
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
<body ng-controller="showController">

<div ng-include="'./components/header.html'"></div>
<nav style="height: 50px;line-height: 50px;">
    <div class="nav-wrapper grey lighten-4">
        <div class="col s12 show-breadcrump">
            <a class="breadcrumb blue-grey-text darken-5" ng-repeat="breadcrump in show.breadcrumps">{{breadcrump}}</a>
        </div>
    </div>
</nav>

<main class="container-fluid" style="margin-top: 13px">
    <div class="row">
        <div class="col s12 m12 l6">
            <div class="carousel carousel-slider">
                <div class="carousel-item active">
                    <img ng-src="{{show.produto.imagem}}" alt="">
                </div>
            </div>
        </div>

        <div class="col s12 m12 l6">
            <h4><strong>{{show.produto.nome}}</strong></h4>
            <p>Código: {{show.produto.codigo}}</p>
            <div class="divider"></div>
            <p class="grey-text lighten-3 preco-antes" style="display: none">
                <del>De: {{show.produto.valor_antigo | number: 2}}</del>
            </p>
            <p class="flow-text yellow-text text-darken-4 preco-depois">Preço: R$ {{show.produto.valor| number: 2}}</p>
            <blockquote>Quantidade em estoque: {{show.produto.quantidade}}</blockquote>
            <div class="input-field">
                <input id="qtde" type="number" class="validate" ng-model="qtde" max="{{show.produto.quantidade}}">
                <label for="qtde">Quantidade</label>
            </div>
            <a href="cart.html" class="btn btn-large"><i class="material-icons left">add_shopping_cart</i> Adicionar ao carrinho</a>
        </div>

        <div class="col s12">
            <br>
            <nav style="height: 46px;line-height: 46px;">
                <div class="nav-wrapper grey lighten-4 nav-show">
                    <a href="#" class="brand-logo center blue-grey-text darken-5">Descrição</a>
                </div>
            </nav>
            <div class="card-panel card-show-panel">
                <p ng-bind-html="show.produto.descricao_longa">
                </p>
            </div>
        </div>
    </div>
</main>

<script src="js/all.js"></script>
<script>
    $('select').formSelect();
    $('.carousel').carousel({
        fullWidth: true,
        indicators: true
    });
    $('.materialboxed').materialbox();
</script>
</body>
</html>
