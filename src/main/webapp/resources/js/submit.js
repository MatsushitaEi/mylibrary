/**
 * 共通スクリプト vuejsを利用
 */

// Vueで初期化
var app = new Vue({
	// elementを指定
	el : '#submit',
	// 変数の宣言
	methods : {
		submit : function(event) {
			// `event` は、ネイティブ DOM イベントです
			if (event) {
				event.preventDefault();
				$('#logout').submit();
			}
		}
	}
})