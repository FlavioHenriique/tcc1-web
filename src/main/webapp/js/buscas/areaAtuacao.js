var urlArea = 'http://localhost:8080/tcc1-web/api/atuacao/';

function PreencherAreas() {
    client.open('GET', urlArea + 'todas', false);
    client.send(null);
    if (client.status == 200) {
        let array = client.responseText.split(',');
        for (i in array) {
            areasAnos.options[areasAnos.options.length] = new Option(array[i], i);
            areasSemestres.options[areasSemestres.options.length] = new Option(array[i], i);
            areasMeses.options[areasMeses.options.length] = new Option(array[i], i);
        }
    }
}
PreencherAreas();

function buscaAreasDeAtuacao(area, url) {
    let urlBusca = url + area + '/';
    client.open('GET', urlBusca, false);
    client.send(null);
    if (client.status == 200) {
        let json = JSON.parse(client.responseText);
        intervalos(json, subfuncao(urlBusca));
        
    }
}