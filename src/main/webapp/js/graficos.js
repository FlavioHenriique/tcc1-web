var chart;
function intervalos(json, clique) {
    console.log("grafico");
    chart = Highcharts.chart('container', {
        title: {
            text: json.title
        },
        tooltip: {
            pointFormat: 'Valor: <b>R$ {point.y}</b>'
        },
        xAxis: {
            categories: json.categorias
        },
        plotOptions: {

            pie: {
                allowPointSelect: true,
                colorByPoint: true,
                cursor: 'pointer',
                depth: 35,
                showInLegend: true,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                },
            }, bar: {
                dataLabels: {
                    enabled: true
                }
            }

        },
        series: [{
                type: json.type,
                name: json.name,
                data: json.data,
                point: clique
            }]
    });
}

function mudarTipo(tipo) {
    chart.update({
        chart: {
            type: tipo
        },
        series: [{
                type: tipo,
                inverted: false
            }]
    });
}

function mudarDados(json, clique){
    console.log("atualizar");
    chart.update({
        title: {
            text: json.title
        },
        xAxis: {
            categories: json.categorias
        },
        series: [{
                name: json.name,
                data: json.data,
                point: clique
            }]
    });
}
