$(function(){
	loadCustomerServeData();
});


function loadCustomerServeData(){
	$.ajax({
		type:"get",
		url:ctx+"/report/queryCustomerServe",
		dataType:"json",
		success:function(msg){
			if(msg.code==200){
				
				// 基于准备好的dom，初始化echarts实例
				var myChart = echarts.init(document.getElementById('main'));
				option = {
					    title : {
					        text: '南丁格尔玫瑰图',
					        subtext: '纯属虚构',
					        x:'center'
					    },
					    tooltip : {
					        trigger: 'item',
					        formatter: "{a} <br/>{b} : {c} ({d}%)"
					    },
					    legend: {
					        x : 'center',
					        y : 'bottom',
					        data:msg.data
					    },
					    toolbox: {
					        show : true,
					        feature : {
					            mark : {show: true},
					            dataView : {show: true, readOnly: false},
					            magicType : {
					                show: true,
					                type: ['pie', 'funnel']
					            },
					            restore : {show: true},
					            saveAsImage : {show: true}
					        }
					    },
					    calculable : true,
					    series : [
					        {
					            name:'半径模式',
					            type:'pie',
					            radius : [20, 110],
					            center : ['25%', '50%'],
					            roseType : 'radius',
					            label: {
					                normal: {
					                    show: false
					                },
					                emphasis: {
					                    show: true
					                }
					            },
					            lableLine: {
					                normal: {
					                    show: false
					                },
					                emphasis: {
					                    show: true
					                }
					            },
					            data:msg.value
					        },
					        {
					            name:'面积模式',
					            type:'pie',
					            radius : [30, 110],
					            center : ['75%', '50%'],
					            roseType : 'area',
					            data:msg.value
					        }
					    ]
					};
				myChart.setOption(option);
			}else{

			}
		}

	});
}