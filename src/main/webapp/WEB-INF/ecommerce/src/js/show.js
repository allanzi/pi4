(function () {
    app.controller('showController', indexController);

    function indexController($scope, $http) {
        $http.get('json/show.json')
            .then((response) => $scope.show = response.data)
    }
})();

