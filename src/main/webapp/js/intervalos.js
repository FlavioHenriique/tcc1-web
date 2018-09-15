let client = new XMLHttpRequest();


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

    }

    intervalos(semestre);
}

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
    }

    intervalos(json);
}