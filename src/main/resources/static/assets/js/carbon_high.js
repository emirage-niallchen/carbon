

var dom_carbon_high = document.getElementById('carbon_high');
var myChart_carbon_high = echarts.init(dom_carbon_high,null,{
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
    xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name: '北京',
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line',
            smooth: true
        },
        {
            name: '天津',
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line',
            smooth: true
        },
        {
            name: '河北',
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line',
            smooth: true
        },
        {
            name: '京津冀',
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line',
            smooth: true
        }
    ]
};

let yearArr_carbon_high=[]
let beiArr_carbon_high=[]
let tianArr_carbon_high=[]
let heArr_carbon_high=[]
let jingjinjiArr_carbon_high=[]


$.post(
    "/anticipate/high",
    function (data) {
        data.forEach(item=>{
            yearArr_carbon_high.push(item.year)
            beiArr_carbon_high.push(item.beijing)
            tianArr_carbon_high.push(item.tianjin)
            heArr_carbon_high.push(item.hebei)
            jingjinjiArr_carbon_high.push(item.sum)
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
            xAxis: {
                type: 'category',
                data: yearArr_carbon_high
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: '北京',
                    data: beiArr_carbon_high,
                    type: 'line',
                    smooth: true
                },
                {
                    name: '天津',
                    data: tianArr_carbon_high,
                    type: 'line',
                    smooth: true
                },
                {
                    name: '河北',
                    data: heArr_carbon_high,
                    type: 'line',
                    smooth: true
                },
                {
                    name: '京津冀',
                    data: jingjinjiArr_carbon_high,
                    type: 'line',
                    smooth: true
                }
            ]
        };


        if (option1 && typeof option1 === 'object') {
            myChart_carbon_high.setOption(option1);
        }


    }
)

window.addEventListener('resize', myChart_carbon_high.resize);

