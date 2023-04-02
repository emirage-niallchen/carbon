var year =[];
var beijing =[];
var tianjin = [];
var hebei = [];






var dom = document.getElementById('index_carbon_total');
var myChart = echarts.init(dom, null, {
    renderer: 'canvas',
    useDirtyRect: false
});
var app = {};

var option;

option = {
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {},
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: [
        {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        }
    ],
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: [
        {
            name: '北京',
            type: 'bar',
            stack: 'Ad',
            emphasis: {
                focus: 'series'
            },
            data: [120, 132, 101, 134, 90, 230, 210]
        },
        {
            name: '天津',
            type: 'bar',
            stack: 'Ad',
            emphasis: {
                focus: 'series'
            },
            data: [220, 182, 191, 234, 290, 330, 310]
        },
        {
            name: '河北',
            type: 'bar',
            stack: 'Ad',
            emphasis: {
                focus: 'series'
            },
            data: [150, 232, 201, 154, 190, 330, 410]
        }
    ]
};



    // $.ajax({
    //     type: "POST",
    //     url: "index/1",
    //     method: "POST",
    //     dataType: 'json',
    //     contentType: false,
    //     processData: false,
    //     success: function (data) {
    //         for (var i = 0; i < data.length; i++) {
    //             year[i].push(data[i].year)
    //             beijing[i].push(data[i].beijing)
    //             tianjin[i].push(data[i].tianjin)
    //             hebei[i].push(data[i].hebei)
    //         }
    //         myChart.setOption({
    //             xAxis: [
    //                 {
    //                     type: 'category',
    //                     data: year
    //                 }
    //             ],
    //             series: [
    //                 {
    //                     name: '北京',
    //                     type: 'bar',
    //                     stack: 'Ad',
    //                     emphasis: {
    //                         focus: 'series'
    //                     },
    //                     data: beijing
    //                 },
    //                 {
    //                     name: '天津',
    //                     type: 'bar',
    //                     stack: 'Ad',
    //                     emphasis: {
    //                         focus: 'series'
    //                     },
    //                     data: tianjin
    //                 },
    //                 {
    //                     name: '河北',
    //                     type: 'bar',
    //                     stack: 'Ad',
    //                     emphasis: {
    //                         focus: 'series'
    //                     },
    //                     data: hebei
    //                 }
    //             ]
    //         })
    //     }});
    //


    $.post(
        "/index/1",
        {"id":1},
        function (data) {
            for (var i = 0; i < data.length; i++) {
                year[i].push(data[i].year)
                beijing[i].push(data[i].beijing)
                tianjin[i].push(data[i].tianjin)
                hebei[i].push(data[i].hebei)
            }
            myChart.setOption({
                xAxis: [
                    {
                        type: 'category',
                        data: year
                    }
                ],
                series: [
                    {
                        name: '北京',
                        type: 'bar',
                        stack: 'Ad',
                        emphasis: {
                            focus: 'series'
                        },
                        data: beijing
                    },
                    {
                        name: '天津',
                        type: 'bar',
                        stack: 'Ad',
                        emphasis: {
                            focus: 'series'
                        },
                        data: tianjin
                    },
                    {
                        name: '河北',
                        type: 'bar',
                        stack: 'Ad',
                        emphasis: {
                            focus: 'series'
                        },
                        data: hebei
                    }
                ]
            })
        }
    )






if (option && typeof option === 'object') {
    myChart.setOption(option);
}

window.addEventListener('resize', myChart.resize);

