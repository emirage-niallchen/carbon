// private double hum;
// private double agriculture;
// private double energy;
// private double husbandry;
// private double industrial;
// private double waste;




var dom = document.getElementById('index_carbon_composition_tianjin');
var myChart_composition_tianjin = echarts.init(dom, null, {
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
            name: '人口呼吸',
            type: 'bar',
            stack: 'Ad',
            emphasis: {
                focus: 'series'
            },
            data: [120, 132, 101, 134, 90, 230, 210]
        },
        {
            name: '农业活动',
            type: 'bar',
            stack: 'Ad',
            emphasis: {
                focus: 'series'
            },
            data: [220, 182, 191, 234, 290, 330, 310]
        },
        {
            name: '能源消费',
            type: 'bar',
            stack: 'Ad',
            emphasis: {
                focus: 'series'
            },
            data: [150, 232, 201, 154, 190, 330, 410]
        },
        {
            name: '畜牧活动',
            type: 'bar',
            stack: 'Ad',
            emphasis: {
                focus: 'series'
            },
            data: [150, 232, 201, 154, 190, 330, 410]
        },
        {
            name: '工业生产',
            type: 'bar',
            stack: 'Ad',
            emphasis: {
                focus: 'series'
            },
            data: [150, 232, 201, 154, 190, 330, 410]
        },
        {
            name: '废弃物排放',
            type: 'bar',
            stack: 'Ad',
            emphasis: {
                focus: 'series'
            },
            data: [150, 232, 201, 154, 190, 330, 410]
        }
    ]
};

let yearArr_composition_tianjin=[]
let seriesArr_composition_tianjin=[]
let humArr_composition_tianjin=[]
let agricultureArr_composition_tianjin=[]
let energyArr_composition_tianjin=[]
let husbandryArr_composition_tianjin=[]
let industrialArr_composition_tianjin=[]
let wasteArr_composition_tianjin=[]




$.post(
    "/index/composition/tianjin",
    {"id":1},
    function (data) {
        data.forEach(item=>{
            yearArr_composition_tianjin.push(item.year)
            humArr_composition_tianjin.push(item.hum)
            agricultureArr_composition_tianjin.push(item.agriculture)
            energyArr_composition_tianjin.push(item.energy)
            husbandryArr_composition_tianjin.push(item.husbandry)
            industrialArr_composition_tianjin.push(item.industrial)
            wasteArr_composition_tianjin.push(item.waste)

        })
        console.log(yearArr_composition_tianjin)
        option1 = {
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
                    data:yearArr_composition_tianjin
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '人口呼吸',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: humArr_composition_tianjin
                },
                {
                    name: '农业活动',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: agricultureArr_composition_tianjin
                },
                {
                    name: '能源消费',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: energyArr_composition_tianjin
                },
                {
                    name: '畜牧活动',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: husbandryArr_composition_tianjin
                },
                {
                    name: '工业生产',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: industrialArr_composition_tianjin
                },
                {
                    name: '废弃物排放',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: wasteArr_composition_tianjin
                }
            ]
        };


        if (option1 && typeof option1 === 'object') {
            myChart_composition_tianjin.setOption(option1);
        }


    }
)

window.addEventListener('resize', myChart_composition_tianjin.resize);

