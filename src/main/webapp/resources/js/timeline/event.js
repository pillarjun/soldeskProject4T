

$(document).ready(()=>{
	console.log("document ready");
	var token = $("#token").val();
	
	function showLoadingScreen() {
		$('#loading-overlay').show();
	}

	function hideLoadingScreen() {
		$('#loading-overlay').hide();
	}
	
	function showTextArea() {
	    $('#vtt_textArea').show();
	}

	function hideTextArea() {
	    $('#vtt_textArea').hide();
	}
	
	function showSummaryButton() {
		$('#getSummary').show();
	}

	function hideSummaryButton() {
		$('#getSummary').hide();
	}
	
	hideTextArea();
	hideSummaryButton();
	
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
				console.log(transcript);
				$("#transcript").attr("value",transcript);
				
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
				
				showSummaryButton();
				
			},
			error:function(){
				console.log("실패")
				hideLoadingScreen();
			}
			
		});
	});
	
	
	$("#getSummary").click(function(){
		showLoadingScreen();
//		hideSummaryButton();
		$.ajax({
			url:"getSummary",
			method:"POST",
			data:{transcript:$("#transcript").val()},
			complete:function(){
				hideLoadingScreen();
			},
			success:function(summary){
		        console.log("Summary:", summary);
		        $("#vtt_textArea").val(function (index,value) {
		            return value + "\n" + summary;
		        });

			},
			error:function(jqXHR, textStatus, errorThrown){
				console.log("요약 불가");
				console.log("AJAX Error:", textStatus, errorThrown);
				showSummaryButton();
			},
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




