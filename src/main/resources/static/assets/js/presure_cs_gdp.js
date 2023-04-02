
var dom = document.getElementById('pressure_cs_gdp');
var myChart_pressure_cs_gdp = echarts.init(dom, null, {
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

let yearArr_pressure_cs_gdp=[]
let beiArr_pressure_cs_gdp=[]
let tianArr_pressure_cs_gdp=[]
let heArr_pressure_cs_gdp=[]



$.post(
    "/pressure/cs/gdp",
    {},
    function (data) {
        data.forEach(item=>{
            yearArr_pressure_cs_gdp.push(item.year)
            beiArr_pressure_cs_gdp.push(item.beijing)
            tianArr_pressure_cs_gdp.push(item.tianjin)
            heArr_pressure_cs_gdp.push(item.hebei)
        })
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
                    data:yearArr_pressure_cs_gdp
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
                    data: beiArr_pressure_cs_gdp
                },
                {
                    name: '天津',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: tianArr_pressure_cs_gdp
                },
                {
                    name: '河北',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: heArr_pressure_cs_gdp
                }
            ]
        };


        if (option1 && typeof option1 === 'object') {
            myChart_pressure_cs_gdp.setOption(option1);
        }


    }
)

window.addEventListener('resize', myChart_pressure_cs_gdp.resize);

