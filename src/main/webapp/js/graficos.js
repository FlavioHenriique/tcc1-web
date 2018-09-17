function intervalos(json, clique) {
    console.log(JSON.stringify(clique));

    Highcharts.chart('container', {
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: json.title
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y} R$</b>'
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
            },
            /*column: {
             allowPointSelect: true,
             colorByPoint: true,
             cursor: 'pointer',
             depth: 35,
             showInLegend: true,
             dataLabels: {
             enabled: true,
             format: '{point.name}'
             },
             }*/
        },
        series: [{
                type: json.type,
                name: json.name,
                data: json.data,
                point: clique
            }]
    });
}