let client = new XMLHttpRequest();

btAnos.onclick = function () {
    fecharmodal(document.getElementById("modalAno"));

    let json;
    let client = new XMLHttpRequest();
    let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
        '/anos/' + ano1.value + "/" + ano2.value;
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

        let cliqueFuncao = {
            events: {
                click: function (event) {
                    swal("semestre " + this.name);
                }
            }
        };
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
                let client2 = new XMLHttpRequest();
                let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
                    '/anos/' + this.name + '/' + ano1 + "/" + ano2;

                client.open('GET', url, false);
                client.send(null);

                if (client.status == 200) {
                    json = JSON.parse(client.responseText);
                    let cliqueSubfuncao = {
                        events: {
                            click: function (event) {
                                alert(this.name);
                            }
                        }
                    }
                    //intervalos(json, cliqueSubfuncao);
                    mudarDados(json,cliqueSubfuncao);
                }
            }
        }
    };
}
function cliqueSemestre(semestre, anoSemestre) {
    return cliqueFuncao = {
        events: {
            click: function (event) {
                let client2 = new XMLHttpRequest();
                let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
                    '/semestre/' + this.name + '/' + semestre + anoSemestre;
                client.open('GET', url, false);
                client.send(null);

                if (client.status == 200) {
                    json = JSON.parse(client.responseText);
                    let cliqueSubfuncao = {
                        events: {
                            click: function (event) {
                                alert(this.name);
                            }
                        }
                    }
                    //intervalos(json, cliqueSubfuncao);
                    mudarDados(json,cliqueSubfuncao);
                }
            }
        }
    };
}

function cliqueMeses(valormes1, valormes2) {
    return cliqueFuncao = {
        events: {
            click: function (event) {
                let client2 = new XMLHttpRequest();
                let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
                    '/mes/' + this.name + '/' + valormes1 + "/" + valormes2;
                client.open('GET', url, false);
                client.send(null);

                if (client.status == 200) {
                    json = JSON.parse(client.responseText);
                    let cliqueSubfuncao = {
                        events: {
                            click: function (event) {
                                alert(this.name);
                            }
                        }
                    }
                    //intervalos(json, cliqueSubfuncao);
                    mudarDados(json,cliqueSubfuncao);
                }
            }
        }
    };
}

