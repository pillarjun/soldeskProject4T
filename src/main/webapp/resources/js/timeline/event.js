

$(document).ready(()=>{
	console.log("document ready");
	var token = $("#token").val();
	
	
	$("#getTextData").click(function(){
		$.ajax({
			url:"sendToPython",
			method:"GET",
			data:{"token":token},
			success:function(res){
				console.log("성공");
				
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




