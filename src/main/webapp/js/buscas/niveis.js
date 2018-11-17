function funcao(urlInicial) {
    console.log("executando funcao");
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
                    mudarDados(json, subfuncao(url));
                }
            }
        }
    };
}

function subfuncao(urlInicial) {
    console.log("executando subfuncao");
    return cliqueSubfuncao = {
        events: {
            click: function (event) {
                let url = urlInicial + this.name + '/';
                client.open('GET', url, false);
                alterarUrl(urlPagina, url, "subfuncao");
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
    console.log("executando programa");
    return cliquePrograma = {
        events: {
            click: function (event) {
                let url = urlinicial + this.name;
                alterarUrl(urlPagina, url, "programa");
                client.open('GET', url, false);
                client.send(null);
                console.log(url);
                if (client.status == 200) {
                    json = JSON.parse(client.responseText);
                    mudarDados(json, acao(url));
                }
            }
        }
    }
}

function acao(urlInicial) {
    console.log("executando acao");
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

function subirNivel() {
    if (urlPagina != urlAnterior) {
        let f = tipoDados + "('" + urlAnterior + "')";
        console.log(f);
        var func = new Function(f);
        mudarDados(buscarDados(urlAnterior), func());
        //intervalos(buscarDados(urlAnterior), func());
    }
}

function descerNivel() {
    alert("desceu");
}