(function () {
    const app = angular.module('astec');

    app.controller('cartController', cartController);

    function cartController($scope, $cookies, cartService) {

        $scope.carrinho = cartService.carrinho;

        $scope.adicionarCarrinho = cartService.adicionarCarrinho;
    }
})();
