

var dom_lmdi_tianjin = document.getElementById('lmdi_tianjin');
var myChart_lmdi_tianjin = echarts.init(dom_lmdi_tianjin,null,{
    renderer: 'canvas',
    useDirtyRect: false
});
var app = {};
var option;

option = {
    title: {
        text: '天津碳排放因素'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross',
            label: {
                backgroundColor: '#6a7985'
            }
        }
    },
    legend: {    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: [
        {
            type: 'category',
            boundaryGap: false,
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
            name: '能源结构',
            type: 'line',
            stack: 'Total',
            areaStyle: {},
            emphasis: {
                focus: 'series'
            },
            data: [120, 132, 101, 134, 90, 230, 210]
        },
        {
            name: '能源消费强度',
            type: 'line',
            stack: 'Total',
            areaStyle: {},
            emphasis: {
                focus: 'series'
            },
            data: [220, 182, 191, 234, 290, 330, 310]
        },
        {
            name: '经济发展',
            type: 'line',
            stack: 'Total',
            areaStyle: {},
            emphasis: {
                focus: 'series'
            },
            data: [150, 232, 201, 154, 190, 330, 410]
        },
        {
            name: '人口规模',
            type: 'line',
            stack: 'Total',
            areaStyle: {},
            emphasis: {
                focus: 'series'
            },
            data: [320, 332, 301, 334, 390, 330, 320]
        }
        ,
        {
            name: '总变化量',
            type: 'line',
            stack: 'Total',
            areaStyle: {},
            emphasis: {
                focus: 'series'
            },
            data: [320, 332, 301, 334, 390, 330, 320]
        }
    ]
};

let yearArr_lmdi_tianjin=[]
let cArr_lmdi_tianjin=[]
let eArr_lmdi_tianjin=[]
let gArr_lmdi_tianjin=[]
let pArr_lmdi_tianjin=[]
let sumArr_lmdi_tianjin=[]

$.get(
    "/pressure/lmdi/tianjin",

    function (data) {
        data.forEach(item=>{
            yearArr_lmdi_tianjin.push(item.year)
            cArr_lmdi_tianjin.push(item.c)
            eArr_lmdi_tianjin.push(item.e)
            gArr_lmdi_tianjin.push(item.g)
            pArr_lmdi_tianjin.push(item.p)
            sumArr_lmdi_tianjin.push(item.sum)
        })
        option1 = {
            title: {
                text: '天津碳排放因素'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    label: {
                        backgroundColor: '#6a7985'
                    }
                }
            },
            legend: {    },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: false,
                    data: yearArr_lmdi_tianjin
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '能源结构',
                    type: 'line',
                    stack: 'Total',
                    areaStyle: {},
                    emphasis: {
                        focus: 'series'
                    },
                    data: eArr_lmdi_tianjin
                },
                {
                    name: '能源消费强度',
                    type: 'line',
                    stack: 'Total',
                    areaStyle: {},
                    emphasis: {
                        focus: 'series'
                    },
                    data: cArr_lmdi_tianjin
                },
                {
                    name: '经济发展',
                    type: 'line',
                    stack: 'Total',
                    areaStyle: {},
                    emphasis: {
                        focus: 'series'
                    },
                    data: gArr_lmdi_tianjin
                },
                {
                    name: '人口规模',
                    type: 'line',
                    stack: 'Total',
                    areaStyle: {},
                    emphasis: {
                        focus: 'series'
                    },
                    data: pArr_lmdi_tianjin
                }
                ,
                {
                    name: '总变化量',
                    type: 'line',
                    stack: 'Total',
                    areaStyle: {},
                    emphasis: {
                        focus: 'series'
                    },
                    data: sumArr_lmdi_tianjin
                }
            ]
        };


        if (option1 && typeof option1 === 'object') {
            myChart_lmdi_tianjin.setOption(option1);
        }
    }
)


