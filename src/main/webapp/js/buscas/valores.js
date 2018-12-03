var urlValores = 'http://localhost:8080/tcc1-web/api/valor/';
var client = new XMLHttpRequest();

function PreencherAreas() {
    client.open('GET', urlValores + 'areas', false);
    client.send(null);
    if (document.getElementById("areasAnos")) {
        if ((client.status == 200)) {
            let json = JSON.parse(client.responseText);
            let array = json.valores;
            for (i in array) {
                areasAnos.options[areasAnos.options.length] = new Option(array[i], i);
                areasSemestres.options[areasSemestres.options.length] = new Option(array[i], i);
                areasMeses.options[areasMeses.options.length] = new Option(array[i], i);
            }
        }
    }
}

function anos() {
    client.open('GET', urlValores + 'anos', false);
    client.send(null);
    if (client.status == 200) {
        let json = JSON.parse(client.responseText);
        let array = json.valores;
        for (i in array) {
            ano1.options[ano1.options.length] = new Option(array[i], array[i]);
            ano2.options[ano2.options.length] = new Option(array[i], array[i]);
            anoMes1.options[anoMes1.options.length] = new Option(array[i], array[i]);
            anoMes2.options[anoMes2.options.length] = new Option(array[i], array[i]);
            anoSemestre.options[anoSemestre.options.length] = new Option(array[i], array[i]);
        }
    }
}
function meses() {
    client.open('GET', urlValores + 'meses', false);
    client.send(null);
    if (client.status == 200) {
        let json = JSON.parse(client.responseText);
        let array = json.valores;
        for (i = 0; i <= array.length; i++) {
            if (i+1 < 10) {
                mes1.options[mes1.options.length] = new Option(array[i], '0' + i);
                mes2.options[mes2.options.length] = new Option(array[i], '0' + i);
            } else {
                mes1.options[mes1.options.length] = new Option(array[i], i);
                mes2.options[mes2.options.length] = new Option(array[i], i);
            }
        }
    }
}
PreencherAreas();
anos();
meses();
