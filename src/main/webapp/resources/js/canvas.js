/**
 * canvas描画用js
 */

var labels = new createLabel();

function createLabel() {
	this.label = new Array();
	this.term = new Array();

	var date = new Date();
	var day = date.getDay();

	// 直近の土曜日の日付を計算
	day = day + (6 - day);
	date.setDate(date.getDate() + day);
	date.setHours(0, 0, 0, 0);

	// 配列に格納
	for (var i = 0; i < 5; i++) {
		var endDate = date.getMonth() + 1 + "/" + date.getDate();
		var rowEndDate = new Date(date);

		date.setDate(date.getDate() - 6);
		var startDate = date.getMonth() + 1 + "/" + date.getDate();
		var rowStartDate = new Date(date);

		this.label.unshift(startDate + "-" + endDate);
		this.term.unshift({
			"start" : rowStartDate,
			"end" : rowEndDate
		})
		this.startDate = date;
		date.setDate(date.getDate() - 1);
	}
	// データの作成
	getReadPage(this);
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
	// ラベルの作成
	labels : labels.label,
	datasets : [
			{
				type : 'line',
				label : '読んだページ数',
				data : labels.data,
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

// 読んだページ数を取得する
function getReadPage(labels) {

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	// リクエストJSON
	var request = {
		"date" : labels.startDate
	};

	// ajaxでservletにリクエストを送信
	$
			.ajax({
				type : "POST",
				url : "/mylibrary/readPage",
				data : {
					data : JSON.stringify(request)
				},
				async : false,
				dataType : 'json',
				success : function(data) {
					var resultArray = [];
					for (var i = 0; i < data.length; i++) {
						readDate = new Date(data[i].createDate);
						readPage = data[i].readPage;
						// 日付別にページ数を格納
						for (var j = 0; j < labels.term.length; j++) {
							if (!(resultArray[j]))
								resultArray[j] = 0;
							var start = new Date(labels.term[j].start);
							var end = new Date(labels.term[j].end);
							if (start <= readDate && end > readDate) {
								resultArray[j] = resultArray[j] + readPage;
								continue;
							}
						}
						labels.data = resultArray;
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("リクエスト時になんらかのエラーが発生しました：" + textStatus + ":\n"
							+ errorThrown);
				}
			});

}
