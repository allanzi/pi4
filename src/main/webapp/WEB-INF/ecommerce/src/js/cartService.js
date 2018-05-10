(function () {
    app.service('cartService', cartService);

    function cartService($cookies) {
        this.carrinho = $cookies.get('cart') === undefined ? [] : JSON.parse($cookies.get('cart'));

        this.adicionarCarrinho = function (id, nome, valor, imagem) {

            const produto = {
                "id": id,
                "nome": nome,
                "valor": valor,
                "imagem": imagem
            };

            this.carrinho.push(produto);

            $cookies.putObject('cart', this.carrinho);
        };
    }
})();