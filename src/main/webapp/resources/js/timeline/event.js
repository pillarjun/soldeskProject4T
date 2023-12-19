

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
				console.log(res);
				
				var transcript = res.transcript;
				var topWords = res.topWords;
				var wat = res.wat;
				var watLen = wat.length;
				
				var td = $("#timeLine");
				for(var i in wat){
					var anchor = $("<a></a>").text(wat[i].word);
					anchor.attr("class","word");
					anchor.data("second",wat[i].second);
					td.append(anchor);
					var space = $("<span> </span>");
				    td.append(space);
				}
				
				for(var j in topWords){
					console.log(topWords[j]);
				}
				
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

$(document).on('click', '.word', function () {
	var player = videojs('userVideo');
    var secondValue = $(this).data('second');
    console.log(secondValue);
    player.currentTime(secondValue);
});


