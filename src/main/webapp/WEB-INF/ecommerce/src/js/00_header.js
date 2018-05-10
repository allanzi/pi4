const app = angular.module('astec', ['ngSanitize', 'ngCookies']);

(function () {
    app.controller('headerController', headerController);

    function headerController($scope) {
        $scope.toggleCarrinho = function () {
            $('#sidenav-carrinho').sidenav({
                edge: 'right'
            });
            $('#sidenav-carrinho').sidenav('open');
        }

        $scope.toggleMobileMenu = function () {
            $('#mobile-sidenav').sidenav();
            $('#mobile-sidenav').sidenav('open');
        }
    }
})();

