function subfuncao(url1, url2) {
    return cliqueSubfuncao = {
        events: {
            click: function (event) {
                let url = url1 + this.name + url2;
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

function programa(url) {
    return cliquePrograma = {
        events: {
            click: function (event) {
                alert(this.name);
            }
        }
    }
}

