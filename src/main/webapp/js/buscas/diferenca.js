var urlDiferenca = 'http://localhost:8080/tcc1-web/api/diferenca/';
var urlBuscaDiferenca = '';

function buscaAnos() {
    fecharmodal(document.getElementById('modalAno'));
    urlBuscaDiferenca = urlDiferenca + 'anos/' + ano1.value + '/' + ano2.value + '/';
    let area = areasAnos.options[areasAnos.selectedIndex].text;
    if (verificarAreaAtuacao(area)) {
        client.open('GET', urlBuscaDiferenca, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
            diferencas(json, funcao(urlBuscaDiferenca));
        } else {
            swal({
                title: "Erro!",
                text: "Valores indisponíveis",
                icon: "error",
            });
        }
    } else {
        let urlArea = urlBuscaDiferenca + area;
        client.open('GET', urlArea, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
            diferencas(json, funcao(urlArea));
        }
    }

}

function buscaSemestres() {
    fecharmodal(document.getElementById('modalSemestre'));
    urlBuscaDiferenca = urlDiferenca + 'semestres/' + semestre1.value
            + anoSemestre1.value + '/' + semestre2.value + anoSemestre2.value + '/';
    let area = areasAnos.options[areasAnos.selectedIndex].text;
    if (verificarAreaAtuacao(area)) {
        console.log(urlBuscaDiferenca);
        client.open('GET', urlBuscaDiferenca, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
            diferencas(json, funcao(urlBuscaDiferenca));
        } else {
            swal({
                title: "Erro!",
                text: "Valores indisponíveis",
                icon: "error",
            });
        }
    } else {
        let urlArea = urlBuscaDiferenca + area;
        client.open('GET', urlArea, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
            diferencas(json, funcao(urlArea));
        }
    }
    
}

function buscaMeses() {
    fecharmodal(document.getElementById('modalMes'));
    let valormes1 = '' + anoMes1.value + mes1.value;
    let valormes2 = '' + anoMes2.value + mes2.value;
    let area = areasAnos.options[areasAnos.selectedIndex].text;
    urlBuscaDiferenca = urlDiferenca + 'meses/' + valormes1 + '/' + valormes2 + '/';
    if (verificarAreaAtuacao(area)) {
        console.log(urlBuscaDiferenca);
        client.open('GET', urlBuscaDiferenca, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
            diferencas(json, funcao(urlBuscaDiferenca));
        } else {
            swal({
                title: "Erro!",
                text: "Valores indisponíveis",
                icon: "error",
            });
        }
    } else {
        let urlArea = urlBuscaDiferenca + area;
        client.open('GET', urlArea, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
            diferencas(json, funcao(urlArea));
        }
    }
}


function verificarAreaAtuacao(area) {
    return !area != "Selecione uma área de atuação";
}