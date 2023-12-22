

$(document).ready(()=>{
	console.log("document ready");
	var token = $("#token").val();
	
	function showLoadingScreen() {
		// 로딩 화면 표시
		$('#loading-overlay').show();
	}

	function hideLoadingScreen() {
		// 로딩 화면 숨김
		$('#loading-overlay').hide();
	}
	
	function showTextArea() {
	  $('#vtt_textArea').show();
	}

	function hideTextArea() {
	  $('#vtt_textArea').hide();
	}
	
	hideTextArea();
	
	$("#getTextData").click(function(){
		showLoadingScreen();
		$.ajax({
			url:"sendToPython",
			method:"GET",
			data:{"token":token},
			complete:function(){
				console.log("완료")
				hideLoadingScreen();
			},
			success:function(res){
				hideLoadingScreen();
				console.log("성공");
				showTextArea();
				var transcript = res.transcript;
				var topWords = res.topWords;
				var wat = res.wat;
				var watLen = wat.length;
				
				var timeline = $("#timeLine");
				for(var i in wat){
					var anchor = $("<a></a>").text(wat[i].word);
					anchor.attr("class","word");
					anchor.data("second",wat[i].second);
					timeline.append(anchor);
					var space = $("<span> </span>");
				    timeline.append(space);
				}
				
				var tw = $("#topWords");
				for(var j in topWords){
					console.log(topWords[j]);
					var topwordBtn = $("<button></button>").text(topWords[j]);
					topwordBtn.addClass("recommendedTag");
					tw.append(topwordBtn);
				}
				
				$(".recommendedTag").click(function() {
			        var buttonText = "#"+ $(this).text();
			       
			        $("#vtt_textArea").val(function(index, value) {
			            return value + buttonText + " ";
			        });
			    });
				
			},
			error:function(){
				console.log("실패")
				hideLoadingScreen();
			}
			
		});
	});
	
	


    var player = videojs('userVideo',{
    	controls:true
    });



});//document.ready

function formatTime(seconds) {
    var date = new Date(null);
    date.setSeconds(seconds);
    return date.toISOString().substr(11, 8);
}



$(document).on('click', '.word', function () {
	var player = videojs('userVideo');
    var secondValue = $(this).data('second');
    console.log(secondValue);
    var formattedTime = formatTime(secondValue);
    console.log(formattedTime);
    var w = $(this).text();
    
    $("#vtt_textArea").val(function (index, value) {
        return value + "\n" + formattedTime +" "+ w;
    });
    
    player.currentTime(secondValue);
});




