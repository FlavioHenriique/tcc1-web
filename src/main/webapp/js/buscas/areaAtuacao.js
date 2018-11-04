var urlArea = 'http://localhost:8080/tcc1-web/api/atuacao/';

function PreencherAreas() {
    client.open('GET', urlArea + 'todas', false);
    client.send(null);
    if (client.status == 200) {
        let array = client.responseText.split(',');
        for (i in array) {
            areas.options[areas.options.length] = new Option(array[i], i);
        }
    }
}

PreencherAreas();

function buscaAreasDeAtuacao() {
    let area = areas.options[areas.selectedIndex].text;
    let url = urlArea + area + '/';
    client.open('GET', url, false);
    client.send(null);
    if (client.status == 200) {
        let json = JSON.parse(client.responseText);
        intervalos(json, subfuncao(url));
    }
}