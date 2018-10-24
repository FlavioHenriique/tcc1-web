function subfuncao(urlInicial) {
    return cliqueSubfuncao = {
        events: {
            click: function (event) {
                let url = urlInicial + this.name + '/';
                client.open('GET', url, false);
                console.log(url);
                client.send(null);
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
                console.log(url);
                client.open('GET', url, false);
                client.send(null);
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

