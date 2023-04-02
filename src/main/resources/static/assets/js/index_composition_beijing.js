// private double hum;
// private double agriculture;
// private double energy;
// private double husbandry;
// private double industrial;
// private double waste;



var year =[];
var hum =[];
var agriculture = [];
var energy = [];
var husbandry = [];
var industrial = [];
var waste = [];
var dom = document.getElementById('index_carbon_composition_beijing');
var myChart_composition_beijing = echarts.init(dom, null, {
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

let yearArr_composition_beijing=[]
let seriesArr_composition_beijing=[]
let humArr_composition_beijing=[]
let agricultureArr_composition_beijing=[]
let energyArr_composition_beijing=[]
let husbandryArr_composition_beijing=[]
let industrialArr_composition_beijing=[]
let wasteArr_composition_beijing=[]




$.post(
    "/index/composition/beijing",
    {"id":1},
    function (data) {
        data.forEach(item=>{
            yearArr_composition_beijing.push(item.year)
            humArr_composition_beijing.push(item.hum)
            agricultureArr_composition_beijing.push(item.agriculture)
            energyArr_composition_beijing.push(item.energy)
            husbandryArr_composition_beijing.push(item.husbandry)
            industrialArr_composition_beijing.push(item.industrial)
            wasteArr_composition_beijing.push(item.waste)

        })
        console.log(yearArr_composition_beijing)
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
                    data:yearArr_composition_beijing
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
                    data: humArr_composition_beijing
                },
                {
                    name: '农业活动',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: agricultureArr_composition_beijing
                },
                {
                    name: '能源消费',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: energyArr_composition_beijing
                },
                {
                    name: '畜牧活动',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: husbandryArr_composition_beijing
                },
                {
                    name: '工业生产',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: industrialArr_composition_beijing
                },
                {
                    name: '废弃物排放',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: wasteArr_composition_beijing
                }
            ]
        };


        if (option1 && typeof option1 === 'object') {
            myChart_composition_beijing.setOption(option1);
        }


    }
)

window.addEventListener('resize', myChart_composition_beijing.resize);

