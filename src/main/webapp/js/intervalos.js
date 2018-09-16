let client = new XMLHttpRequest();

btAnos.onclick = function () {
    fecharmodal(document.getElementById("modalAno"));

    let json;
    let client = new XMLHttpRequest();
    let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
        '/anos/' + ano1.value + "/" + ano2.value;

    client.open('GET', url, false);
    client.send(null);
    console.log(client.status);
    if (client.status == 200) {
        json = JSON.parse(client.responseText);
        console.log(JSON.stringify(json));

        let clique = {
            events: {
                click: function (event) {
                    alert("ano " + this.name);
                }
            }
        };
        intervalos(json, clique);

    } else {
        alert('valores indisponíveis');
    }
}


btSemestre.onclick = function () {
    let semestres;
    fecharmodal(document.getElementById("modalSemestre"));
    let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
        '/semestre/' + document.getElementById('semestre').value
        + anoSemestre.value;

    console.log(url);
    client.open('GET', url, false);
    client.send(null);
    console.log(client.status);
    if (client.status == 200) {
        semestre = JSON.parse(client.responseText);

        let clique = {
            events: {
                click: function (event) {
                    alert("semestre " + this.name);
                }
            }
        };
        intervalos(semestre, clique);

    } else {
        alert('valores indisponíveis');
    }

}


btMeses.onclick = function () {
    fecharmodal(document.getElementById("modalMes"));

    let json;
    let client = new XMLHttpRequest();
    let url = 'http://localhost:8080/tcc1-web/api/intervalo' +
        '/mes/' + anoMes1.value + mes1.value + "/" + anoMes2.value + mes2.value;
    client.open('GET', url, false);
    client.send(null);
    if (client.status == 200) {
        json = JSON.parse(client.responseText);
        console.log(JSON.stringify(json));

        let clique = {
            events:{
                click: function (event) {
                    alert("meses "+ this.name);
                }
            }
        };
        intervalos(json,clique);

    } else {
        alert('valores indisponíveis');
    }

    
}
