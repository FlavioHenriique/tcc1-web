let client = new XMLHttpRequest();

btAnos.onclick = function () {
    fecharmodal(document.getElementById("modalAno"));
    let json;
    let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
            '/ano/' + ano1.value + "/" + ano2.value;
    client.open('GET', url, false);
    client.send(null);

    if (client.status == 200) {
        json = JSON.parse(client.responseText);
        intervalos(json, cliquesAno(ano1.value, ano2.value));
    } else {
        swal({
            title: "Erro!",
            text: "Valores indisponíveis",
            icon: "error",
        });
    }
}

btSemestre.onclick = function () {
    let semestres;
    fecharmodal(document.getElementById("modalSemestre"));
    let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
            '/semestre/' + document.getElementById('semestre').value
            + anoSemestre.value;
    client.open('GET', url, false);
    client.send(null);

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
}

btMeses.onclick = function () {
    fecharmodal(document.getElementById("modalMes"));

    let json;
    let client = new XMLHttpRequest();
    let valormes1 = '' + anoMes1.value + mes1.value;
    let valormes2 = '' + anoMes2.value + mes2.value;
    let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
            '/mes/' + valormes1 + "/" + valormes2;
    client.open('GET', url, false);
    client.send(null);
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
}

function cliquesAno(ano1, ano2) {
    return cliqueFuncao = {
        events: {
            click: function (event) {
                let funcao = this.name;
                let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
                        '/ano/' + ano1 + "/" + ano2 + '/' + funcao + '/';
                client.open('GET', url, false);
                client.send(null);

                if (client.status == 200) {
                    json = JSON.parse(client.responseText);
                    mudarDados(json, subfuncao(url));
                }
            }
        }
    };
}
function cliqueSemestre(semestre, anoSemestre) {
    return cliqueFuncao = {
        events: {
            click: function (event) {
                let funcao = this.name;
                let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
                        '/semestre/' + semestre + anoSemestre + '/' + funcao + '/';
                client.open('GET', url, false);
                client.send(null);

                if (client.status == 200) {
                    json = JSON.parse(client.responseText);
                    mudarDados(json, subfuncao(url));
                }
            }
        }
    };
}

function cliqueMeses(valormes1, valormes2) {
    return cliqueFuncao = {
        events: {
            click: function (event) {
                let funcao = this.name;
                let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
                        '/mes/' + valormes1 + "/" + valormes2 + '/'+ funcao + '/';
                client.open('GET', url, false);
                client.send(null);
                if (client.status == 200) {
                    json = JSON.parse(client.responseText);
                    mudarDados(json, subfuncao(url));
                }
            }
        }
    };
}

