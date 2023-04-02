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

let yearArr=[]
let seriesArr=[]
let beiArr=[]
let tianArr=[]
let heArr=[]



    $.post(
        "/index/1",
        {"id":1},
        function (data) {
            data.forEach(item=>{
                yearArr.push(item.year)
                beiArr.push(item.beijing)
                tianArr.push(item.tianjin)
                heArr.push(item.hebei)
            })
            console.log(yearArr)
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
                        data:yearArr
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
                        data: beiArr
                    },
                    {
                        name: '天津',
                        type: 'bar',
                        stack: 'Ad',
                        emphasis: {
                            focus: 'series'
                        },
                        data: tianArr
                    },
                    {
                        name: '河北',
                        type: 'bar',
                        stack: 'Ad',
                        emphasis: {
                            focus: 'series'
                        },
                        data: heArr
                    }
                ]
            };


            if (option1 && typeof option1 === 'object') {
                myChart.setOption(option1);
            }


        }
    )

window.addEventListener('resize', myChart.resize);

