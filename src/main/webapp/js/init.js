(function ($) {
    $(function () {

        $('select').material_select();
        $('.button-collapse').sideNav();
        $('.parallax').parallax();
        $('.modal').modal();
        $(".dropdown-button").dropdown();

        $('#search-cep').click(() => {
            let cep = $("#cep").val();
            if (cep == "") {
                alert("Campo CEP vazio");
            }

            let url = 'https://viacep.com.br/ws/';
            url += cep + '/json/';

            $.get(url, (response) => {
                $('#logradouro').val(response.logradouro);
                $('#localidade').val(response.localidade);

                $('#localidade').change();
                $('#logradouro').change();
                $('#numero').focus();
            });
        });

        $("a[data-target='delete']").click((event) => {
            let url = $(event)[0].currentTarget.id;
            $("#delete #btn-delete").attr("href", url);
        });

        $("#search-product").click(() => {
            $("#search-product").attr('disabled', true);
            $('#search-product + .progress-button').css('display', 'block');

            const codigo = $("#codigo-search");
            const url = window.location.href.replace("/cadastro", "/");

            $.ajax({
                url: url + "produto",
                data: {'codigo': codigo.val()},
                success: function (data, textStatus, jqXHR) {
                    if (!data) {
                        alert('Produto não encontrado');

                        $("#search-product").attr('disabled', false);
                        $('#search-product + .progress-button').css('display', 'none');

                        return;
                    }

                    let quantidade = data.quantidade;

                    if ($("input[name='produtos[]'][value='" + data.id + "']").length > 0) {
                        $("input[name='produtos[]'][value='" + data.id + "']").each((key, item) => {
                            quantidade--;
                        });
                    }

                    if (quantidade <= 0) {
                        alert('Produto sem estoque');

                        $("#search-product").attr('disabled', false);
                        $('#search-product + .progress-button').css('display', 'none');

                        return;
                    }

                    const html = "<div class='card'><a onclick='excludeProduct(event)' class='btn-floating halfway-fab waves-effect waves-light btn-close-item grey lighten-3'><i class='material-icons grey-text'>close</i></a><div class='card-content white-text card-products-item'><span class='card-title black-text card-products-title'>" + data.nome + "</span><p class='grey-text darken-3'>R$ " + new Intl.NumberFormat().format(data.valor) + "</p></div><input type='hidden' name='produtos[]' value='" + data.id + "'></div>";
                    $("#cards").append(html);

                    let value = parseFloat($('#value').html().replace(',', '.')) + data.valor;
                    value = parseFloat(value.toFixed(2));

                    $("#value").empty();
                    $("#value").append(String(value).replace('.', ','));

                    $("#search-product").attr('disabled', false);
                    $('#search-product + .progress-button').css('display', 'none');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert('Ops algo deu errado!');

                    $("#search-product").attr('disabled', false);
                    $('#search-product + .progress-button').css('display', 'none');
                }
            });
        });


        $("#search-client").click(() => {
            $("#search-client").attr('disabled', true);
            $('#search-client + .progress-button').css('display', 'block');

            const email = $("#email-search");
            const url = window.location.href.replace("/cadastro", "/");

            $.ajax({
                url: url + "cliente",
                data: {'email': email.val()},
                success: function (data, textStatus, jqXHR) {
                    if (!data) {
                        alert('Cliente não encontrado');

                        $("#search-client").attr('disabled', false);
                        $('#search-client + .progress-button').css('display', 'none');

                        return;
                    }

                    alert('Cliente: ' + data.nome + ', localizado com sucesso.');

                    $("#search-client").attr('disabled', false);
                    $('#search-client +.progress-button').css('display', 'none');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert('Ops algo deu errado!');

                    $("#search-client").attr('disabled', false);
                    $('#search-client + .progress-button').css('display', 'none');
                }
            });

        });


        if ($('table').length) {
            $('table').DataTable({
                language: getTranslate(),
                dom: 'Bfrtip',
                buttons: [
                    'copy', 'csv', 'excel', 'pdf', 'print'
                ],
                stateSave: true
            });
        }

        if ($('#codigo-search').length) {
            $('#codigo-search').autocomplete({
                data: autocompleteProdutoAjax(),
                limit: 20, // The max amount of results that can be shown at once. Default: Infinity.
                onAutocomplete: function (val) {
                    // Callback function when value is autcompleted.
                },
                minLength: 1, // The minimum length of the input for the autocomplete to start. Default: 1.
            });
        }
        
        
        if ($('#email-search').length) {
            $('#email-search').autocomplete({
                data: autocompleteClienteAjax(),
                limit: 20, // The max amount of results that can be shown at once. Default: Infinity.
                onAutocomplete: function (val) {
                    // Callback function when value is autcompleted.
                },
                minLength: 1, // The minimum length of the input for the autocomplete to start. Default: 1.
            });
        }

    }); // end of document ready
})(jQuery); // end of jQuery name space

$(window).load(function () {

    $(".loader_inner").fadeOut();
    $(".loader").delay(400).fadeOut("slow");

});

function getTranslate() {
    return {
        "sEmptyTable": "Nenhum registro encontrado",
        "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
        "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
        "sInfoFiltered": "(Filtrados de _MAX_ registros)",
        "sInfoPostFix": "",
        "sInfoThousands": ".",
        "sLengthMenu": "_MENU_ resultados por página",
        "sLoadingRecords": "Carregando...",
        "sProcessing": "Processando...",
        "sZeroRecords": "Nenhum registro encontrado",
        "sSearch": "Pesquisar",
        "oPaginate": {
            "sNext": "Próximo",
            "sPrevious": "Anterior",
            "sFirst": "Primeiro",
            "sLast": "Último"
        },
        "oAria": {
            "sSortAscending": ": Ordenar colunas de forma ascendente",
            "sSortDescending": ": Ordenar colunas de forma descendente"
        }
    }
}

function excludeProduct(event) {
    const html = $(event.path[2]);

    const productValue = parseFloat($(html.children().children()[3]).html().replace('R$ ', '').replace(',', '.'));
    let value = parseFloat($('#value').html().replace(',', '.')) - productValue;
    value = parseFloat(value.toFixed(2));

    $("#value").empty();
    $("#value").append(String(value).replace('.', ','));

    html.empty();
}

function addClient() {
    const nome = $('#nome').val();
    const email = $('#email').val();
    const telefone = $('#telefone').val();
    const cpf = $('#cpf').val();

    const url = window.location.href.replace("/vendas/cadastro", "/");

    $.ajax({
        type: 'POST',
        url: url + "clientes/cadastro/api",
        data: {
            'nome': nome,
            'email': email,
            'telefone': telefone,
            'cpf': cpf
        },
        success: function (data, textStatus, jqXHR) {
            $('#email-search').val(email);
            $('#email-search').change();
            $('#modal1').modal('close');
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Ops algo deu errado!');
        }
    });
}

function autocompleteProdutoAjax() {

    const url = window.location.href.replace("/vendas/cadastro", "/");
    let codes = [];

    $.ajax({
        type: 'GET',
        url: url + "vendas/produto/autocomplete",
        async: false,
        cache: false,
        timeout: 30000,
        success: function (data, textStatus, jqXHR) {
            $.each(data, (key, item) => {
                codes.push(codes[item.codigo] = '');
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Ops algo deu errado!');
        }
    });

    return convArrToObj(codes);
}

function autocompleteClienteAjax() {

    const url = window.location.href.replace("/vendas/cadastro", "/");
    let codes = [];

    $.ajax({
        type: 'GET',
        url: url + "vendas/cliente/autocomplete",
        async: false,
        cache: false,
        timeout: 30000,
        success: function (data, textStatus, jqXHR) {
            $.each(data, (key, item) => {
                codes.push(codes[item.email] = '');
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Ops algo deu errado!');
        }
    });

    return convArrToObj(codes);
}

var convArrToObj = function (array) {
    var thisEleObj = new Object();
    if (typeof array == "object") {
        for (var i in array) {
            var thisEle = convArrToObj(array[i]);
            thisEleObj[i] = thisEle;
        }
    } else {
        thisEleObj = array;
    }
    return thisEleObj;
}