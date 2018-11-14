function buscaAreasDeAtuacao(area, url) {
    let urlBusca = url + area + '/';
    client.open('GET', urlBusca, false);
    client.send(null);
    if (client.status == 200) {
        let json = JSON.parse(client.responseText);
        intervalos(json, subfuncao(urlBusca));

    }
}
