<%-- 
    Document   : login
    Created on : 27/04/2018, 20:40:12
    Author     : allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="pt" ng-app="astec">
<head>
    <meta charset="UTF-8">
    <title>Astec Games | A melhor loja de game online</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="css/all.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body ng-controller="loginController">

<div ng-include="'./components/header.html'"></div>

<div class="hide-on-small-only">
    <br>
</div>

<main class="container-fluid container-login">
    <div class="row">
        <div class="col m8 l4 s12 offset-m2 offset-l4">
            <div class="card card-login grey lighten-4 hoverable">
                <div class="card-content">
                    <span class="card-title card-title-login center-align">
                        <i class="material-icons">account_circle</i>
                        <br>
                        <strong>Login</strong>
                    </span>

                    <div class="row">
                        <div class="input-field col s12">
                            <input id="email" type="email" class="validate">
                            <label for="email">E-mail</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="password" type="password" class="validate">
                            <label for="password">Senha</label>
                        </div>

                        <br>

                        <div class="col s12">
                            <a class="waves-effect waves-light btn btn-block" href="minha-conta.html">Entrar</a>
                            <a href="#" class="btn-cadastro">Não tem cadastro?</a>
                        </div>

                        <div class="login-outro">
                            <hr class="hr-text hr-login" data-content="OU">

                            <div class="col s6">
                                <a href="#" class="loginBtn loginBtn--facebook">
                                    Login Facebook
                                </a>
                            </div>
                            <div class="col s6">
                                <a href="#" class="loginBtn loginBtn--google">
                                    Login Google
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<script src="js/all.js"></script>
</body>
</html>