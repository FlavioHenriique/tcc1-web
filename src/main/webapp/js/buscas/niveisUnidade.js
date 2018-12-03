function orgaoSuperior(urlInicial) {
    console.log("executando orgao Superior");
    return cliqueFuncao = {
        events: {
            click: function (event) {
                let url = urlInicial + this.name + '/';
                alterarUrl(urlPagina, url, "funcao");
                client.open('GET', url, false);
                client.send(null);
                console.log(url);
                if (client.status == 200) {
                    json = JSON.parse(client.responseText);
                    mudarDados(json, orgao(url));
                }
            }
        }
    };
}

function orgao(urlInicial) {
    console.log("executando orgao");
    return cliqueSubfuncao = {
        events: {
            click: function (event) {
                let url = urlInicial + this.name + '/';
                client.open('GET', url, false);
                alterarUrl(urlPagina, url, "subfuncao");
                console.log(url);
                client.send(null);
                if (client.status == 200) {
                    json = JSON.parse(client.responseText);
                    mudarDados(json, unidade(url));
                }
            }
        }
    }
}

function unidade(urlInicial) {
    console.log("executando unidade");
    return cliqueAcao = {
        events: {
            click: function (event) {
                swal({
                    title: "Opa...",
                    text: "Não há mais níveis de detalhamento disponíveis!",
                    icon: "error",
                });
                alterarUrl(urlPagina, url, "programa");
            }
        }
    }
}

