var urlPagina = "";
var urlAnterior = "";
var tipoDados = "";
var client = new XMLHttpRequest();
//
function alterarUrl(urlAnt, urlPag, tipo) {
    urlAnterior = urlAnt;
    urlPagina = urlPag;
    tipoDados = tipo;
    
}

function buscarDados(url) {
    client.open('GET', url, false);
    client.send(null);
    if (client.status == 200) {
        return JSON.parse(client.responseText);
    }

}