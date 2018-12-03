var urlFavorecido = 'http://localhost:8080/tcc1-web/api/favorecidos/';
var urlBuscaFavorecido = '';
var estado = 0;
var jsonFavorecido = null;

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

function buscaMeses() {
    fecharmodal(document.getElementById('modalMes'));
    let valormes1 = '' + anoMes1.value + mes1.value;
    let valormes2 = '' + anoMes2.value + mes2.value;
    urlBuscaFavorecido = urlFavorecido + 'meses/' + valormes1 + "/" + valormes2 + '/';
    let valor = nomeCNPJMeses.value;
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
        jsonFavorecido = JSON.parse(client.responseText);
        for (k = 0; k < jsonFavorecido.favorecidos.length; k++) {
            $('#valoresFavorecidos').append(
                    '<tr><td>' + jsonFavorecido.favorecidos[k] + '</td>' +
                    '<td><button class="button is-success" onclick="favorecidoSelecionado(\'' + jsonFavorecido.favorecidos[k] + '\')">Visualizar</button></td></tr>')
                    .attr('id', 'valoresFavorecidos');
        }
    }
}

function favorecidoSelecionado(favorecido) {
    let url = urlBuscaFavorecido + favorecido + '/';
    urlBuscaFavorecido = url;
    fecharmodal(document.getElementById("modalFavorecido"));
    client.open('GET', url, false);
    client.send(null);
    console.log(url);
    if (client.status == 200) {
        jsonFavorecido = JSON.parse(client.responseText);
        estado = 0;
        geraTabela(jsonFavorecido);
    } else {
        swal({
            title: "Opa...",
            text: "Não foi encontrado nenhum resultado para este intervalo de tempo!",
            icon: "error",
        });
    }
}

function geraTabela(json) {
    $("#container table").remove();
    estado++;
    $("#titulo").html(json.titulo);
    let $teste = $("<table class='table' style='width: 100%;' id='tabelaDados'>");
    $teste.append("<tr id='tr'>"
            + '<th>Área de atuação</th>'
            + '<th>Ano</th>'
            + '<th>Mês</th>'
            + '<th>Unidade gestora</th>'
            + '<th>Valor</th>'
            + '<th>Nível de detalhamento</th>'
            + '</tr>');

    for (k = 0; k < json.dados.length; k++) {
        $teste.append(
                '<tr><td>' + json.dados[k].detalhamento + '</td>' +
                '<td>' + json.dados[k].ano + '</td>' +
                '<td>' + json.dados[k].mes + '</td>' +
                '<td>' + json.dados[k].unidadeGestora + '</td>' +
                '<td>' + 'R$ ' + json.dados[k].total + '</td>' +
                '<td><button class="button is-success" onclick="descerNivel(\'' + json.dados[k].detalhamento + '\')">Detalhar</button></td></tr>')
                .attr('id', 'valoresFavorecidos');
    }
    $teste.append("</table>");
    $teste.appendTo("#container");

}

function descerNivel(detalhamento) {
    urlBuscaFavorecido = urlBuscaFavorecido + detalhamento + '/';
    client.open('GET', urlBuscaFavorecido, false);
    client.send(null);
    if (client.status == 200) {
        jsonFavorecido = JSON.parse(client.responseText);
        geraTabela(jsonFavorecido);
    } else {
        swal({
            title: "Opa...",
            text: "Não há mais níveis de detalhamento disponíveis!",
            icon: "error",
        });
    }
}

function ordenarDados() {
    let ordena = ordenacao.options[ordenacao.selectedIndex].value;
    if (ordena == 1) {
        jsonFavorecido.dados.sort(function (a, b) {
            return a.unidadeGestora - b.unidadeGestora;
        });
        console.log(jsonFavorecido);
        geraTabela(jsonFavorecido);
        console.log("ordenou");
    } else {
        console.log("calma");
    }
}

