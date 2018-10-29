function funcao(urlInicial) {
    return cliqueFuncao = {
        events: {
            click: function (event) {
                let url = urlInicial + this.name + '/';
                alterarUrl(urlPagina, url);
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

function subfuncao(urlInicial) {
    return cliqueSubfuncao = {
        events: {
            click: function (event) {
                let url = urlInicial + this.name + '/';
                client.open('GET', url, false);
                alterarUrl(urlPagina, url);
                client.send(null);
                urlPagina = url;
                if (client.status == 200) {
                    json = JSON.parse(client.responseText);
                    mudarDados(json, programa(url));
                }
            }
        }
    }
}

function programa(urlinicial) {
    return cliquePrograma = {
        events: {
            click: function (event) {
                let url = urlinicial + this.name;
                alterarUrl(urlPagina, url);
                client.open('GET', url, false);
                client.send(null);
                urlPagina = url;
                if (client.status == 200) {
                    json = JSON.parse(client.responseText);
                    mudarDados(json, acao(url));
                }

            }
        }
    }
}

function acao(urlInicial) {
    return cliqueAcao = {
        events: {
            click: function (event) {
                alert(this.name);
            }
        }
    }
}

function subirNivel() {

}

function descerNivel() {
    alert("desceu");
}