var urlFavorecido = 'http://localhost:8080/tcc1-web/api/favorecidos/';
var urlBuscaFavorecido = '';
$("#botoesIntervalo").load("trechos/botoesIntervalos.html");

function buscaAnos() {
    fecharmodal(document.getElementById('modalAno'));
    urlBuscaFavorecido = urlFavorecido + 'anos/' + ano1.value + '/' + ano2.value + '/';
    let valor = nomeCNPJAno.value;
    if (isNaN(valor)) {
        favorecidoPorNome(valor);
    } else {
        favorecidoPorCNPJ(valor);
    }
}

function buscaSemestre() {
    fecharmodal(document.getElementById('modalSemestre'));
    urlBuscaFavorecido = urlFavorecido + 'semestres/' + document.getElementById('semestre').value
            + anoSemestre.value + '/';
    let valor = nomeCNPJSemestre.value;
    if (isNaN(valor)) {
        favorecidoPorNome(valor);
    } else {
        favorecidoPorCNPJ(valor);
    }
}


function favorecidoPorNome(nome) {
    let url = urlFavorecido + 'nome/' + nome;
    buscarFavorecidos(url);
}

function favorecidoPorCNPJ(cnpj) {
    let url = urlFavorecido + 'cnpj/' + cnpj;
    buscarFavorecidos(url);
}

function buscarFavorecidos(url) {

    client.open('GET', url, false);
    client.send(null);
    abrirmodal(document.getElementById("modalFavorecido"));
    $("#valoresFavorecidos tr td").remove();
    if (client.status == 200) {
        let json = JSON.parse(client.responseText);
        for (k = 0; k < json.favorecidos.length; k++) {
            $('table').append(
                    '<tr><td>' + json.favorecidos[k] + '</td>' +
                    '<td><button class="button is-success" onclick="favorecidoSelecionado(\'' + json.favorecidos[k] + '\')">Visualizar</button></td></tr>')
                    .attr('id', 'valoresFavorecidos');
        }
    }
}

function favorecidoSelecionado(favorecido) {
    let url = urlBuscaFavorecido + favorecido + '/';
    fecharmodal(document.getElementById("modalFavorecido"));
    client.open('GET', url, false);
    client.send(null);
    console.log(url);
    if (client.status == 200) {
        let json = JSON.parse(client.responseText);
        intervalos(json, funcao(url));
    } else {
        swal({
            title: "Erro!",
            text: "Valores indisponíveis",
            icon: "error",
        });
    }
}

