/**
 * canvas描画用js
 */
var labels = [];

function createLabel() {
	var date = new Date();
	var day = date.getDay();
	
	// 直近の土曜日の日付を計算
	day = day + (6 - day);
	date.setDate(date.getDate() + day);
	
	//配列に格納
	for(var i=0; i < 5; i++){
		var endDate = date.getMonth()+1 + "/" + date.getDate() ;
		date.setDate(date.getDate() - 6);
		var startDate = date.getMonth()+1 + "/" + date.getDate();
		labels.unshift(startDate + "-" + endDate);
		date.setDate(date.getDate() - 1);
	}
	return labels;

}

window.onload = function() {
	ctx = document.getElementById("chart");
	window.myBar = new Chart(ctx, {
		type : 'bar',
		data : barChartData,
		options : complexChartOption
	});
};

// ここにデータを格納
var barChartData = {
	labels : createLabel(),
	datasets : [
			{
				type : 'line',
				label : '読んだページ数',
				data : [ '0.155', '0.118', '0.121', '0.068', '0.083', '0.060',
						'0.067', '0.121', '0.121', '0.150', '0.118', '0.097',
						'0.078', '0.127', '0.155', '0.140', '0.101', '0.140',
						'0.041', '0.093', '0.189', '0.146', '0.134', '0.127',
						'0.116', '0.111', '0.125', '0.116' ],
				borderColor : "rgba(254,97,132,0.8)",
				pointBackgroundColor : "rgba(254,97,132,0.8)",
				fill : false,
				yAxisID : "y-axis-1",// 追加
			},
			{
				type : 'bar',
				label : '読んだ本数',
				data : [ '0.3', '0.1', '0.1', '0.3', '0.4', '0.2', '0.0',
						'0.2', '0.3', '0.11', '0.5', '0.2', '0.5', '0.4',
						'0.0', '0.3', '0.7', '0.3', '0.6', '0.4', '0.9', '0.7',
						'0.4', '0.8', '0.7', '0.4', '0.7', '0.8' ],
				borderColor : "rgba(54,164,235,0.8)",
				backgroundColor : "rgba(54,164,235,0.5)",
				yAxisID : "y-axis-2",
			}, ],
};

// 描画の設定
var complexChartOption = {
	responsive : true,
	scales : {
		yAxes : [ {
			id : "y-axis-1",
			type : "linear",
			position : "left",
			ticks : {
				max : 50,
				min : 0,
				stepSize : 10
			},
		}, {
			id : "y-axis-2",
			type : "linear",
			position : "right",
			ticks : {
				max : 5,
				min : 0,
				stepSize : 1
			},
			gridLines : {
				drawOnChartArea : false,
			},
		} ],
	}
};
