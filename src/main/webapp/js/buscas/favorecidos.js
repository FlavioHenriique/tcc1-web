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
        let json = JSON.parse(client.responseText);
        for (k = 0; k < json.favorecidos.length; k++) {
            $('#valoresFavorecidos').append(
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
    console.log(url);//
    if (client.status == 200) {
        let json = JSON.parse(client.responseText);
        //intervalos(json, funcao(url));
        $("#titulo").html(json.titulo);
        console.log(json.dados);

        var $teste = $("<table class='table' style='width: 100%;'>");
        $teste.append('<tr>'
                + '<th>Área de atuação</th>'
                + '<th>Ano</th>'
                + '<th>Mês</th>'
                + '<th>Unidade gestora</th>'
                + '<th>Valor</th>'
                + '<th>Nível de detalhamento</th>'
                + '</tr>');
        for (k = 0; k < json.dados.length; k++) {
            //$('#valores').append(
            $teste.append(
                    '<tr><td>' + json.dados[k].detalhamento + '</td>' +
                    '<td>' + json.dados[k].ano + '</td>' +
                    '<td>' + json.dados[k].mes + '</td>' +
                    '<td>' + json.dados[k].unidadeGestora + '</td>' +
                    '<td>' + 'R$ ' + json.dados[k].total + '</td>' +
                    '<td><button class="button is-success" onclick="favorecidoSelecionado()">Detalhar</button></td></tr>')
                    .attr('id', 'valoresFavorecidos');
        }
        $teste.append("</table");
        $teste.appendTo("#container");

    } else {
        swal({
            title: "Erro!",
            text: "Valores indisponíveis",
            icon: "error",
        });
    }
}

