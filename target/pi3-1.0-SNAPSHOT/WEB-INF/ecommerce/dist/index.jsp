<%-- 
    Document   : index
    Created on : 27/04/2018, 20:35:08
    Author     : allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt" ng-app="astec">
<head>
    <meta charset="UTF-8">
    <title>Astec Games | A melhor loja de game online</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body ng-controller="indexController">

<div ng-include="'${pageContext.request.contextPath}/components/header.html'"></div>

<ul id="filter-sidenav" class="sidenav sidenav-fixed sidenav-filtro">
    <li>
        <fieldset>
            <legend>Ordenar por</legend>
            <div class="input-field col s12">
                <select class="browser-default" name="ordenacao" id="ordenacao" ng-model="ordenar">
                    <option value="" disabled selected>---</option>
                    <option ng-value="ordem.id" ng-repeat="(key, ordem) in ordenacao" ng-selected="key == 0">
                        {{ordem.nome}}
                    </option>
                </select>
            </div>
        </fieldset>
    </li>

    <li>
        <fieldset>
            <legend>Pesquisa</legend>
            <div class="input-field col s12">
                <input type="text" class="validate" id="filtro-pesquisa" ng-model="pesquisa">
                <label for="filtro-pesquisa">O que você procura?</label>
            </div>
        </fieldset>
    </li>

    <li>
        <fieldset>
            <legend>Valor Máximo</legend>
            <div class="input-field col s12">
                <i class="material-icons prefix">attach_money</i>
                <input type="number" class="validate" ng-model="valorMaximo" id="valor-maximo" min="0" max="5000">
            </div>
        </fieldset>
    </li>

    <li>
        <fieldset>
            <legend>Valor Mínimo</legend>
            <div class="input-field col s12">
                <i class="material-icons prefix">attach_money</i>
                <input type="number" class="validate" ng-model="valorMinimo" id="valor-minimo" min="0" max="5000">
            </div>
        </fieldset>
    </li>

    <li>
        <fieldset>
            <legend>Categorias</legend>
            <div class="row">
                <label class="col s12">
                    <input type="checkbox" ng-model="playstation4" ng-true-value="'Playstation 4'" ng-false-value="''" ng-change="filtroPlataforma()"/>
                    <span>Playstattion 4</span>
                </label>

                <label class="col s12">
                    <input type="checkbox" ng-model="xboxOne" ng-true-value="'Xbox One'" ng-false-value="''" ng-change="filtroPlataforma()"/>
                    <span>Xbox One</span>
                </label>

                <label class="col s12">
                    <input type="checkbox" ng-model="camera" ng-true-value="'Câmera'" ng-false-value="''" ng-change="filtroPlataforma()"/>
                    <span>Câmera</span>
                </label>

                <label class="col s12">
                    <input type="checkbox" ng-model="controle" ng-true-value="'Controle'" ng-false-value="''" ng-change="filtroPlataforma()"/>
                    <span>Controle</span>
                </label>

                <label class="col s12">
                    <input type="checkbox" ng-model="headset" ng-true-value="'Headset'" ng-false-value="''" ng-change="filtroPlataforma()"/>
                    <span>Headset</span>
                </label>

                <label class="col s12">
                    <input type="checkbox" ng-model="vr" ng-true-value="'VR'" ng-false-value="''" ng-change="filtroPlataforma()"/>
                    <span>VR</span>
                </label>
            </div>
        </fieldset>
    </li>

    <br>
    <br>
    <br>
    <br>
</ul>

<main class="index-main" ng-controller="cartController">
    <div class="row">
        <div class="col s12 hide-on-large-only hide-on-extra-large-only" style="margin: 11px 0">
            <a href="#" class="btn blue-grey" ng-click="toggleFiltro()"><i class="material-icons left">filter_list</i>Exibir Filtros</a>
        </div>

        <div class="col s12">
            <div class="col s12 m6 hide-on-small-only">
                <div class="card hoverable">
                    <div class="card-image">
                        <img ng-src="{{destaques[0].imagem}}">
                        <span class="card-title">{{destaques[0].nome}}</span>
                        <a href="javascript:void(0);"
                           class="btn-floating halfway-fab waves-effect waves-light red tooltipped"
                            ng-click="adicionarCarrinho(destaques[0].id, destaques[0].nome, destaques[0].valor, destaques[0].imagem)">
                                <i class="material-icons">add_shopping_cart</i>
                        </a>
                        <a href="${pageContext.request.contextPath}/show?id={{destaques[0].id}}" class="btn-floating halfway-fab waves-effect waves-light card-btn-detail"><i
                                class="material-icons">pageview</i></a>
                    </div>
                    <div class="card-content">
                        <p class="yellow-text text-darken-4">R$ {{destaques[0].valor | number: 2}}</p>
                        <br>
                        <p>{{destaques[0].descricao_curta}}</p>
                    </div>
                </div>
            </div>

            <br class="hide-on-small-only">
            <br class="hide-on-small-only">

            <div class="col s12 m6 hide-on-small-only">
                <div class="card horizontal hoverable" style="cursor:pointer;" onclick="window.location.href = 'show.html';">
                    <div class="card-image">
                        <img ng-src="{{destaques[1].imagem}}">
                    </div>
                    <div class="card-stacked">
                        <div class="card-content">
                            <p><strong>{{destaques[1].nome}}</strong></p>
                            <p class="yellow-text text-darken-4">R$ {{destaques[1].valor | number: 2}}</p>
                            <p>{{destaques[1].descricao_curta}}</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col s12 m6 hide-on-small-only">
                <div class="card horizontal hoverable" style="cursor:pointer;" onclick="window.location.href = 'show.html';">
                    <div class="card-image">
                        <img ng-src="{{destaques[2].imagem}}">
                    </div>
                    <div class="card-stacked">
                        <div class="card-content">
                            <p><strong>{{destaques[2].nome}}</strong></p>
                            <p class="yellow-text text-darken-4">R$ {{destaques[2].valor | number: 2}}</p>
                            <p>{{destaques[2].descricao_curta}}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col s12 divider index-divider hide-on-small-only"></div>

        <div class="col s12 l4 m6" ng-repeat="(key, produto) in produtos | filter: pesquisa | filter: filtroValorMaximo | filter: filtroValorMinimo | orderBy: ordenar">
            <div class="card hoverable">
                <div class="card-image">
                    <img ng-src="{{produto.imagem}}">
                    <span class="card-title">{{produto.nome}}</span>
                    <a href="javascript:void(0);" class="btn-floating halfway-fab waves-effect waves-light red tooltipped" ng-click="adicionarCarrinho(produto.id, produto.nome, produto.valor, produto.imagem)"><i
                            class="material-icons">add_shopping_cart</i></a>
                    <a href="${pageContext.request.contextPath}/show?id={{produto.id}}" class="btn-floating halfway-fab waves-effect waves-light card-btn-detail"><i
                            class="material-icons">pageview</i></a>
                </div>
                <div class="card-content">
                    <p class="yellow-text text-darken-4">R$ {{produto.valor | number: 2}}</p>
                    <br>
                    <p style="height: 60px">{{produto.descricao_curta}}</p>
                </div>
            </div>
        </div>
    </div>
</main>

<script src="${pageContext.request.contextPath}/js/all.js"></script>
<script>
    $('select').formSelect();
    $('footer').addClass('index-main');
</script>
</body>
</html>