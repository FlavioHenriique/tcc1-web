var urlFavorecido = 'http://localhost:8080/tcc1-web/api/favorecidos/';

$("#botoesIntervalo").load("trechos/botoesIntervalos.html");

function favorecidoPorNome() {
    let url = urlFavorecido + 'nome/' + nomeFavorecido.value;
    buscarFavorecidos(url);
}

function favorecidoPorCNPJ() {
    let url = urlFavorecido + 'cnpj/' + cnpjFavorecido.value;
    buscarFavorecidos(url);
}

function buscarFavorecidos(url) {

    console.log(url);
    client.open('GET', url, false);
    client.send(null);
    abrirmodal(document.getElementById("modalFavorecido"));
    $("#valoresFavorecidos tr td").remove();
    if (client.status == 200) {
        let json = JSON.parse(client.responseText);
        for (k = 0; k < json.favorecidos.length; k++) {
            $('table').append(
                    '<tr><td>' + json.favorecidos[k] + '</td>' +
                    '<td><button class="button is-success" onclick="">Visualizar</button></td></tr>'
                    ).attr('id', 'valoresFavorecidos');
        }
    }
}
