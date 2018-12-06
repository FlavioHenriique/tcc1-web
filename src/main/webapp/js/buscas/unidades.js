var urlUnidades = 'http://localhost:8080/tcc1-web/api/unidade';
var urlBuscaUnidades = '';
var jsonUnidades = null;

function buscaUnidadesAnos() {

    fecharmodal(document.getElementById("modalAno"));
    let url = urlUnidades + '/ano/' + ano1.value + "/" + ano2.value + '/';
    urlBuscaUnidades = url;
    buscaDados(url, orgaoSuperior);
}

function buscaUnidadesSemestres() {
    fecharmodal(document.getElementById("modalSemestre"));
    let url = urlUnidades + '/semestre/' + document.getElementById('semestre').value
            + anoSemestre.value + '/';
    urlBuscaUnidades = url;
    buscaDados(url, orgaoSuperior);
}

function buscaUnidadesMeses() {
    fecharmodal(document.getElementById("modalMes"));
    let valormes1 = '' + anoMes1.value + mes1.value;
    let valormes2 = '' + anoMes2.value + mes2.value;
    let url = urlUnidades + '/mes/' + valormes1 + "/" + valormes2 + '/';
    urlBuscaUnidades = url;
    buscaDados(url, orgaoSuperior);
}

function buscaDados(url, funcao) {
    client.open('GET', url, false);
    client.send(null);
    if (client.status == 200) {
        json = JSON.parse(client.responseText);
        //intervalos(json, funcao(url));
        jsonUnidades = json;
        geraTabela(json);
    } else {
        swal({
            title: "Erro!",
            text: "Valores indisponíveis",
            icon: "error",
        });
    }
}

function geraTabela(json) {
    $("#container table").remove();
    $("#titulo").html(json.title);
    let $teste = $("<table class='table' style='width: 100%;' id='tabelaDados'>");
    $teste.append("<tr id='tr'>"
            + '<th>Área de atuação</th>'
            + '<th>Valor</th>'
            + '<th>Nível de detalhamento</th>'
            + '</tr>');

    for (k = 0; k < json.data.length; k++) {
        $teste.append(
                '<tr><td>' + json.data[k][0] + '</td>' +
                '<td>' + 'R$ ' + json.data[k][1] + '</td>' +
                '<td><button class="button is-success" onclick="descerNivel(\'' + json.data[0][0] + '\')">Detalhar</button></td></tr>')
                .attr('id', 'valoresFavorecidos');
    }
    $teste.append("</table>");
    $teste.appendTo("#container");
}

function descerNivel(detalhamento) {
    urlBuscaUnidades = urlBuscaUnidades + detalhamento + '/';
    client.open('GET', urlBuscaUnidades, false);
    client.send(null);
    if (client.status == 200) {
        jsonUnidades = JSON.parse(client.responseText);
        geraTabela(jsonUnidades);
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
        let data = jsonUnidades.data;
        data.sort(function (a, b) {
            return b[1] - a[1];
        });
        jsonUnidades.data = data;
        geraTabela(jsonUnidades);

    } else {
        let data = jsonUnidades.data;
        data.sort(function (a, b) {
            if (a[0] < b[0]) {
                return -1;
            }
            if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });
        jsonUnidades.data = data;
        geraTabela(jsonUnidades);
    }
}

function filtrarDados(unidade) {
    let regex = '\\b' + unidade + '\\b';
    let novoJson = jsonUnidades.data.filter(function (value) {
        return value[0].match(new RegExp(regex, 'gi')) !== null;
    });
    jsonUnidades.data = novoJson;
    geraTabela(jsonUnidades);
}

