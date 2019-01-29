var urlEvolucao = 'http://localhost:8080/tcc1-web/api/evolucao/';
var urlBuscaEvolucao = '';

function buscaAnos() {
    fecharmodal(document.getElementById('modalAno'));
    urlBuscaEvolucao = urlEvolucao + 'anos/' + ano1.value + '/' + ano2.value + '/';
    let area = areasAnos.options[areasAnos.selectedIndex].text;
    console.log(area);
    if (verificarAreaAtuacao(area)) {
        client.open('GET', urlBuscaEvolucao, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
            evolucao(json, funcao(urlBuscaEvolucao));
            //intervalos(json, funcao(urlBuscaEvolucao));
        } else {
            swal({
                title: "Erro!",
                text: "Valores indisponíveis",
                icon: "error",
            });
        }
    } else {
        let urlArea = urlBuscaEvolucao + area;
        client.open('GET', urlArea, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
            evolucao(json, funcao(urlArea));
            //intervalos(json, funcao(urlBuscaEvolucao));
        }
    }

}

function buscaSemestres() {
    fecharmodal(document.getElementById('modalSemestre'));
    urlBuscaEvolucao = urlEvolucao + 'semestres/' + semestre1.value
            + anoSemestre1.value + '/' + semestre2.value + anoSemestre2.value + '/';
    let area = areasSemestres.options[areasSemestres.selectedIndex].text;
    if (verificarAreaAtuacao(area)) {
        console.log(urlBuscaEvolucao);
        client.open('GET', urlBuscaEvolucao, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
            //intervalos(json, funcao(urlBuscaEvolucao));
            evolucao(json, funcao(urlBuscaEvolucao));
        } else {
            swal({
                title: "Erro!",
                text: "Valores indisponíveis",
                icon: "error",
            });
        }
    } else {
        let urlArea = urlBuscaEvolucao + area;
        client.open('GET', urlArea, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
            //intervalos(json, funcao(urlArea));
            evolucao(json, funcao(urlBuscaEvolucao));
        }
    }
}


function buscaMeses() {
    fecharmodal(document.getElementById('modalMes'));
    let valormes1 = '' + anoMes1.value + mes1.value;
    let valormes2 = '' + anoMes2.value + mes2.value;
    let area = areasMeses.options[areasMeses.selectedIndex].text;
    urlBuscaEvolucao = urlEvolucao + 'a/' + valormes1 + '/' + valormes2 + '/';
    if (verificarAreaAtuacao(area)) {
        console.log(urlBuscaEvolucao);
        client.open('GET', urlBuscaEvolucao, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
            intervalos(json, funcao(urlBuscaEvolucao));
            //evolucao(json, funcao(urlBuscaEvolucao));
        } else {
            swal({
                title: "Erro!",
                text: "Valores indisponíveis",
                icon: "error",
            });
        }
    } else {
        let urlArea = urlBuscaEvolucao + area;
        client.open('GET', urlArea, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
            intervalos(json, funcao(urlArea));
            //evolucao(json, funcao(urlBuscaEvolucao));
        }
    }
}

function verificarAreaAtuacao(area) {
    return area === "Selecione uma área de atuação";
}