var urlIntervalo = 'http://localhost:8080/tcc1-web/api/intervalo';

btAnos.onclick = function () {
    fecharmodal(document.getElementById("modalAno"));
    let json;
    let area = areasAnos.options[areasAnos.selectedIndex].text;
    let url = urlIntervalo + '/ano/' + ano1.value + "/" + ano2.value + '/';
    if (verificarAreaAtuacao(area)) {
        alterarUrl(url, url, "inicial");
        client.open('GET', url, false);
        client.send(null);
        if (client.status == 200) {
            json = JSON.parse(client.responseText);
            intervalos(json, cliquesAno(url));
        } else {
            swal({
                title: "Erro!",
                text: "Valores indisponíveis",
                icon: "error",
            });
        }
    } else {
        buscaAreasDeAtuacao(area, url);
    }
}

btSemestre.onclick = function () {
    let semestres;
    fecharmodal(document.getElementById("modalSemestre"));
    let area = areasSemestres.options[areasSemestres.selectedIndex].text;
    let url = urlIntervalo + '/semestre/' + document.getElementById('semestre').value
            + anoSemestre.value + '/';
    if (verificarAreaAtuacao(area)) {
        client.open('GET', url, false);
        client.send(null);
        alterarUrl(url, url, "inicial");
        if (client.status == 200) {
            semestre = JSON.parse(client.responseText);
            intervalos(
                    semestre, cliqueSemestre(
                            document.getElementById('semestre').value,
                            anoSemestre.value
                            )
                    );

        } else {
            swal({
                title: "Erro!",
                text: "Valores indisponíveis",
                icon: "error",
            });
        }
    } else {
        buscaAreasDeAtuacao(area, url);
    }
}

btMeses.onclick = function () {
    fecharmodal(document.getElementById("modalMes"));
    let json;
    let area = areasMeses.options[areasMeses.selectedIndex].text;
    let valormes1 = '' + anoMes1.value + mes1.value;
    let valormes2 = '' + anoMes2.value + mes2.value;
    let url = urlIntervalo + '/mes/' + valormes1 + "/" + valormes2 + '/';
    if (verificarAreaAtuacao(area)) {
        let client = new XMLHttpRequest();

        client.open('GET', url, false);
        client.send(null);
        alterarUrl(url, url, "inicial");

        if (client.status == 200) {
            json = JSON.parse(client.responseText);
            intervalos(json, cliqueMeses(valormes1, valormes2));

        } else {
            swal({
                title: "Erro!",
                text: "Valores indisponíveis",
                icon: "error",
            });
        }
    } else {
        buscaAreasDeAtuacao(area, url);
    }

}

function cliquesAno(url) {
    console.log("cliques ano");
    return funcao(url);
}

function cliqueSemestre(semestre, anoSemestre) {

    let url = urlIntervalo + '/semestre/' + semestre + anoSemestre + '/';
    return funcao(url);
}

function cliqueMeses(valormes1, valormes2) {
    let url = urlIntervalo + '/mes/' + valormes1 + "/" + valormes2 + '/';
    return funcao(url);
}

function verificarAreaAtuacao(area) {
    if (area != "Selecione uma área de atuação") {
        return false;
    }
    return true;
}