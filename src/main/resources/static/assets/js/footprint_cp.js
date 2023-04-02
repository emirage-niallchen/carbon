
var dom = document.getElementById('footprint_cp');
var myChart_footprint_cp = echarts.init(dom, null, {
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

let yearArr_footprint_cp=[]
let seriesArr_footprint_cp=[]
let beiArr_footprint_cp=[]
let tianArr_footprint_cp=[]
let heArr_footprint_cp=[]



$.post(
    "/footprint/cp",
    {"id":1},
    function (data) {
        data.forEach(item=>{
            yearArr_footprint_cp.push(item.year)
            beiArr_footprint_cp.push(item.beijing)
            tianArr_footprint_cp.push(item.tianjin)
            heArr_footprint_cp.push(item.hebei)
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
                    data:yearArr_footprint_cp
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
                    data: beiArr_footprint_cp
                },
                {
                    name: '天津',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: tianArr_footprint_cp
                },
                {
                    name: '河北',
                    type: 'bar',
                    stack: 'Ad',
                    emphasis: {
                        focus: 'series'
                    },
                    data: heArr_footprint_cp
                }
            ]
        };


        if (option1 && typeof option1 === 'object') {
            myChart_footprint_cp.setOption(option1);
        }


    }
)

window.addEventListener('resize', myChart_footprint_cp.resize);

