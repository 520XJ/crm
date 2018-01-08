$(function(){
	loadCustomerGc();
});



/**
 * 
 */
function loadCustomerGc(){
	$.ajax({
		type:"get",
		url:ctx+"/report/queryCustomersGc",
		dataType:"json",
		success:function(date){
			if(date.code==200){
				var dataAxis = date.dataAxis;
				var data = date.data;
				var yMax = 10;
				var dataShadow = [];
				var myChart = echarts.init(document.getElementById('main'));

				for (var i = 0; i < data.length; i++) {
				    dataShadow.push(yMax);
				}

				var option = {
				    title: {
				        text: '特性示例：渐变色 阴影 点击缩放',
				        subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
				    },
				    xAxis: {
				        data: dataAxis,
				        axisLabel: {
				            inside: true,
				            textStyle: {
				                color: '#fff'
				            }
				        },
				        axisTick: {
				            show: false
				        },
				        axisLine: {
				            show: false
				        },
				        z: 10
				    },
				    yAxis: {
				        axisLine: {
				            show: false
				        },
				        axisTick: {
				            show: false
				        },
				        axisLabel: {
				            textStyle: {
				                color: '#999'
				            }
				        }
				    },
				    dataZoom: [
				        {
				            type: 'inside'
				        }
				    ],
				    series: [
				        { // For shadow
				            type: 'bar',
				            itemStyle: {
				                normal: {color: 'rgba(0,0,0,0.05)'}
				            },
				            barGap:'-100%',
				            barCategoryGap:'40%',
				            data: dataShadow,
				            animation: false
				        },
				        {
				            type: 'bar',
				            itemStyle: {
				                normal: {
				                    color: new echarts.graphic.LinearGradient(
				                        0, 0, 0, 1,
				                        [
				                            {offset: 0, color: '#83bff6'},
				                            {offset: 0.5, color: '#188df0'},
				                            {offset: 1, color: '#188df0'}
				                        ]
				                    )
				                },
				                emphasis: {
				                    color: new echarts.graphic.LinearGradient(
				                        0, 0, 0, 1,
				                        [
				                            {offset: 0, color: '#2378f7'},
				                            {offset: 0.7, color: '#2378f7'},
				                            {offset: 1, color: '#83bff6'}
				                        ]
				                    )
				                }
				            },
				            data: data
				        }
				    ]
				};
				var zoomSize = 2;
				myChart.on('click', function (params) {
				    console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
				    myChart.dispatchAction({
				        type: 'dataZoom',
				        startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
				        endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
				    });
				});
				myChart.setOption(option);
			}else{
				console.log("暂无数据");
			}
		}
	});
}

