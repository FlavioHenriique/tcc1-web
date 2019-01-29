var urlEvolucao = 'http://localhost:8080/tcc1-web/api/evolucao/';
var urlBuscaEvolucao = '';

function buscaAnos() {
    fecharmodal(document.getElementById('modalAno'));
    urlBuscaEvolucao = urlEvolucao + 'anos/' + ano1.value + '/' + ano2.value + '/';
    let area = areasAnos.options[areasAnos.selectedIndex].text;
    if (verificarAreaAtuacao(area)) {
        client.open('GET', urlBuscaEvolucao, false);
        client.send(null);
        if (client.status == 200) {
            let json = JSON.parse(client.responseText);
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
            evolucao(json, funcao(urlArea));
        }
    }

}

function verificarAreaAtuacao(area) {
    return !area != "Selecione uma área de atuação";
}