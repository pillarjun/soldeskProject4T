$(function() {
	const sortableList = document.querySelector(".sortableList");
	const items = sortableList.querySelectorAll(".item");
	
	items.forEach(item => {
	    item.addEventListener("dragstart", () => {
	        setTimeout(() => item.classList.add("dragging"), 0);
	    });
	    item.addEventListener("dragend", () => item.classList.remove("dragging"));
	});
	const reorderList = (e) => {
	    e.preventDefault();
	    const draggingItem = document.querySelector(".dragging");
	    // 드래깅 아닌 항목들을 모두 가져와 배열로 저장.
	    let siblings = [...sortableList.querySelectorAll(".item:not(.dragging)")];
	    //드래깅중인 항목이 배치되어야 하는 형제 항목 찾기.
	    let nextSibling = siblings.find(sibling => {
	    	 return e.clientY <= sibling.offsetTop + sibling.offsetHeight * 2;
	    });
	    // 현재 드래깅중인 요소를 배치되어야 하는 요소 형제항목 앞에 추가
	    sortableList.insertBefore(draggingItem, nextSibling);
	}
	sortableList.addEventListener("dragover", reorderList);

	$("#contentWriteBtn").click(function(){
		if(this.checked){
			$("#libraryContent").prop("readonly", false);
		}
	});
	$("#noticeWriteBtn").click(function(){
		if(this.checked){
			$("#libraryNotice").prop("readonly", false);
		}
	});
	$("#bgmWriteBtn").click(function(){
		if(this.checked){
			$("#libraryBgm").prop("readonly", false);
		}
	});
	$("#photoWriteBtn").click(function(){
		if(this.checked){
			$("#libraryPhoto").prop("readonly", false);
		}
	});
	$("#channelWriteBtn").click(function(){
		if(this.checked){
			$("#libraryChannel").prop("readonly", false);
		}
	});
	$("#eventWriteBtn").click(function(){
		if(this.checked){
			$("#libraryEvent").prop("readonly", false);
		}
	});
	$("#tagWriteBtn").click(function(){
		if(this.checked){
			$("#libraryTag").prop("readonly", false);
		}
	});
	$("#etcWriteBtn").click(function(){
		if(this.checked){
			$("#libraryEtc").prop("readonly", false);
		}
	});

	$("#libraryContent").keyup(function(){
		$("#libraryFinishContent").text($("#libraryContent").val());
	});
	$("#libraryContent").focus(function(){
		$("#libraryFinishContent").text($("#libraryContent").val());
	});
	$("#libraryNotice").keyup(function(){
		$("#libraryFinishNotice").text($("#libraryNotice").val());
	});
	$("#libraryNotice").focus(function(){
		$("#libraryFinishNotice").text($("#libraryNotice").val());
	});
	$("#libraryBgm").keyup(function(){
		$("#libraryFinishBgm").text($("#libraryBgm").val());
	});
	$("#libraryBgm").focus(function(){
		$("#libraryFinishBgm").text($("#libraryBgm").val());
	});
	$("#libraryPhoto").keyup(function(){
		$("#libraryFinishPhoto").text($("#libraryPhoto").val());
	});
	$("#libraryPhoto").focus(function(){
		$("#libraryFinishPhoto").text($("#libraryPhoto").val());
	});
	$("#libraryChannel").keyup(function(){
		$("#libraryFinishChannel").text($("#libraryChannel").val());
	});
	$("#libraryChannel").focus(function(){
		$("#libraryFinishChannel").text($("#libraryChannel").val());
	});
	$("#libraryEvent").keyup(function(){
		$("#libraryFinishEvent").text($("#libraryEvent").val());
	});
	$("#libraryEvent").focus(function(){
		$("#libraryFinishEvent").text($("#libraryEvent").val());
	});
	$("#libraryTag").keyup(function(){
		$("#libraryFinishTag").text($("#libraryTag").val());
	});
	$("#libraryTag").focus(function(){
		$("#libraryFinishTag").text($("#libraryTag").val());
	});
	$("#libraryEtc").keyup(function(){
		$("#libraryFinishEtc").text($("#libraryEtc").val());
	});
	$("#libraryEtc").focus(function(){
		$("#libraryFinishEtc").text($("#libraryEtc").val());
	});
	
	$("#contentBtn").click(function(){
		if(this.checked){
			$("#libraryFinishContentAll").append('<a id="libraryFinishContent" style="white-space:pre-wrap">${libraryContent }</a>');
			$("#libraryContent").focus();
		}
		else{
			$("#libraryFinishContent").remove();
		}
	});
	$("#notBtn").click(function(){
		if(this.checked){
			$("#libraryFinishNoticeAll").append('<a id="libraryFinishNotice" style="white-space:pre-wrap">${libraryNotice }</a>');
			$("#libraryNotice").focus();
		}
		else{
			$("#libraryFinishNotice").remove();
		}
	});
	$("#bgmBtn").click(function(){
		if(this.checked){
			$("#libraryFinishBgmAll").append('<a id="libraryFinishBgm" style="white-space:pre-wrap">${libraryBgm }</a>');
			$("#libraryBgm").focus();
		}
		else{
			$("#libraryFinishBgm").remove();
		}
	});
	$("#photoBtn").click(function(){
		if(this.checked){
			$("#libraryFinishPhotoAll").append('<a id="libraryFinishPhoto" style="white-space:pre-wrap">${libraryPhoto }</a>');
			$("#libraryPhoto").focus();
		}
		else{
			$("#libraryFinishPhoto").remove();
		}
	});
	$("#channelBtn").click(function(){
		if(this.checked){
			$("#libraryFinishChannelAll").append('<a id="libraryFinishChannel" style="white-space:pre-wrap">${libraryChannel }</a>');
			$("#libraryChannel").focus();
		}
		else{
			$("#libraryFinishChannel").remove();
		}
	});
	$("#eventBtn").click(function(){
		if(this.checked){
			$("#libraryFinishEventAll").append('<a id="libraryFinishEvent" style="white-space:pre-wrap">${libraryEvent }</a>');
			$("#libraryEvent").focus();
		}
		else{
			$("#libraryFinishEvent").remove();
		}
	});
	$("#tagBtn").click(function(){
		if(this.checked){
			$("#libraryFinishTagAll").append('<a id="libraryFinishTag" style="white-space:pre-wrap">${libraryTag }</a>');
			$("#libraryTag").focus();
		}
		else{
			$("#libraryFinishTag").remove();
		}
	});
	$("#etcBtn").click(function(){
		if(this.checked){
			$("#libraryFinishEtcAll").append('<a id="libraryFinishEtc" style="white-space:pre-wrap">${libraryEtc }</a>');
			$("#libraryEtc").focus();
		}
		else{
			$("#libraryFinishEtc").remove();
		}
	});
	
});


$(function () {
    $('#copyBtn').click(function () {
 
      var copyText = document.getElementById("libraryAllList");
      var textArea = document.createElement("textarea");
      var a = copyText.textContent
      
      textArea.value = copyText.textContent;//textarea에 텍스트 입력
      document.body.appendChild(textArea);//body에 textarea 추가
      
      textArea.select();
      document.execCommand("Copy");
      textArea.remove();
      
      alert("복사되었습니다.");
      
    });

});

