var urlUnidades = 'http://localhost:8080/tcc1-web/api/unidade';

function buscaUnidadesAnos() {

    fecharmodal(document.getElementById("modalAno"));
    let url = urlUnidades + '/ano/' + ano1.value + "/" + ano2.value + '/';
    buscaDados(url, orgaoSuperior);
}

function buscaUnidadesSemestres() {
    fecharmodal(document.getElementById("modalSemestre"));
    let url = urlUnidades + '/semestre/' + document.getElementById('semestre').value
            + anoSemestre.value + '/';
    buscaDados(url, orgaoSuperior);
}

function buscaUnidadesMeses() {
    fecharmodal(document.getElementById("modalMes"));
    let valormes1 = '' + anoMes1.value + mes1.value;
    let valormes2 = '' + anoMes2.value + mes2.value;
    let url = urlUnidades + '/mes/' + valormes1 + "/" + valormes2 + '/';
    buscaDados(url, orgaoSuperior);
}

function buscaDados(url, funcao) {
    client.open('GET', url, false);
    client.send(null);
    if (client.status == 200) {
        json = JSON.parse(client.responseText);
        intervalos(json, funcao(url));
    } else {
        swal({
            title: "Erro!",
            text: "Valores indisponíveis",
            icon: "error",
        });
    }
}