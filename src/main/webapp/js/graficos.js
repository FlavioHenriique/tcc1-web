var chart;
function intervalos(json, clique) {

    console.log(json);
    chart = Highcharts.chart('container', {
        title: {
            text: json.title
        },
        tooltip: {
            pointFormat: 'Valor: <b>R$ {point.y},00</b>'
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

function mudarDados(json, clique) {
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


function diferencas(json, clique) {

    chart = Highcharts.chart('container', {
        title: {
            text: json.title
        },
        chart: {
            type: json.type
        },
        tooltip: {
            pointFormat: 'Valor: <b>R$ {point.y},00</b>'
        },
        xAxis: {
            categories: json.categorias
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0,
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                showInLegend: true,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                },
            }
        },
        series: [{
                name: json.primeiroIntervalo,
                data: json.valoresPrimeiroIntervalo,
                point: clique

            }, {
                name: json.segundoIntervalo,
                data: json.valoresSegundoIntervalo,
                point: clique
            }]
    });
}

function evolucao(json, clique) {

    chart = Highcharts.chart('container', {

        title: {
            text: json.title
        },

        yAxis: {
            title: {
                text: json.name
            }
        },
        /*xAxis: {
         categories: json.categorias
         },*/
        plotOptions: {
            area: {
                stacking: 'normal',
                lineColor: '#666666',
                lineWidth: 1,
                marker: {
                    lineWidth: 1,
                    lineColor: '#666666'
                }
            },
            series: {
                pointStart: 0,
                pointInterval: 1,
                color: '#F28F43'
            }
        },

        tooltip: {
            pointFormat: 'Valor: <b>R$ {point.y},00</b>'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle'
        },

        series: json.series,

        responsive: {
            rules: [{
                    condition: {
                        maxWidth: 500
                    },
                    chartOptions: {
                        legend: {
                            layout: 'horizontal',
                            align: 'center',
                            verticalAlign: 'bottom'
                        }
                    }
                }]
        }

    });
}