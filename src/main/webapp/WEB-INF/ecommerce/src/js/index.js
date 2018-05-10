(function () {
    app.controller('indexController', indexController);

    function indexController($scope, $http) {
        $scope.valorMaximo = 5000;
        $scope.valorMinimo = 0;

        $http.get('/json/index.json')
            .then((response) => {
                $scope.produtos = response.data.produtos;
                $scope.destaques = response.data.destaques;
            });

        $scope.toggleFiltro = function () {
            $('#filter-sidenav').sidenav();
            $('#filter-sidenav').sidenav('open');
        };

        $scope.ordenacao = [
            {
                id: "mais-relevantes",
                nome: "Mais relevantes"
            },
            {
                id: "--valor",
                nome: "Menor Preço"
            },
            {
                id: "+-valor",
                nome: "Maior Preço"
            }
        ];

        filtros($scope, $http);
    }

    function filtros($scope, $http) {
        $scope.filtroValorMaximo = function (produto) {
            return $scope.valorMaximo >= produto.valor;
        };

        $scope.filtroValorMinimo = function (produto) {
            return $scope.valorMinimo <= produto.valor;
        };

        $scope.filtroPlataforma = function () {
            $http.get('/json/index.json')
                .then((response) => {
                    let novosProdutos = [];

                    response.data.produtos.forEach(function (item, key) {
                        if ($scope.playstation4 !== undefined && item.plataforma == $scope.playstation4) {
                            novosProdutos.push(item);
                        }

                        if ($scope.xboxOne !== undefined && item.plataforma == $scope.xboxOne) {
                            novosProdutos.push(item);
                        }

                        if ($scope.camera !== undefined && item.plataforma == $scope.camera) {
                            novosProdutos.push(item);
                        }

                        if ($scope.controle !== undefined && item.plataforma == $scope.controle) {
                            novosProdutos.push(item);
                        }

                        if ($scope.headset !== undefined && item.plataforma == $scope.headset) {
                            novosProdutos.push(item);
                        }

                        if ($scope.vr !== undefined && item.plataforma == $scope.vr) {
                            novosProdutos.push(item);
                        }
                    });

                    novosProdutos.length > 0 ? $scope.produtos = novosProdutos : $scope.produtos = response.data.produtos;
                });
        };
    }
})();

