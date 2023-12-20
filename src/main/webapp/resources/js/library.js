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
	        return e.clientY <= sibling.offsetTop + sibling.offsetHeight / 2;
	    });
	    // 현재 드래깅중인 요소를 배치되어야 하는 요소 형제항목 앞에 추가
	    sortableList.insertBefore(draggingItem, nextSibling);
	}
	sortableList.addEventListener("dragover", reorderList);

	$("#contentBtn").click(function(){
		if(this.checked){
			$("#libraryFinishContentAll").show();
		}
		else{
			$("#libraryFinishContentAll").hide();
		}
	});
	$("#notBtn").click(function(){
		if(this.checked){
			console.log("asjkdfl;asd;fl");
			$("#libraryFinishNoticeAll").show();
		}
		else{
			$("#libraryFinishNoticeAll").hide();
		}
	});
	$("#bgmBtn").click(function(){
		if(this.checked){
			$("#libraryFinishBgmAll").show();
		}
		else{
			$("#libraryFinishBgmAll").hide();
		}
	});
	$("#photoBtn").click(function(){
		if(this.checked){
			$("#libraryFinishPhotoAll").show();
		}
		else{
			$("#libraryFinishPhotoAll").hide();
		}
	});
	$("#channelBtn").click(function(){
		if(this.checked){
			$("#libraryFinishChannelAll").show();
		}
		else{
			$("#libraryFinishChannelAll").hide();
		}
	});
	$("#eventBtn").click(function(){
		if(this.checked){
			$("#libraryFinishEventAll").show();
		}
		else{
			$("#libraryFinishEventAll").hide();
		}
	});
	$("#tagBtn").click(function(){
		if(this.checked){
			$("#libraryFinishTagAll").show();
		}
		else{
			$("#libraryFinishTagAll").hide();
		}
	});
	$("#etcBtn").click(function(){
		if(this.checked){
			$("#libraryFinishEtcAll").show();
		}
		else{
			$("#libraryFinishEtcAll").hide();
		}
	});
	
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
	$("#libraryNotice").keyup(function(){
		$("#libraryFinishNotice").text($("#libraryNotice").val());
	});
	$("#libraryBgm").keyup(function(){
		$("#libraryFinishBgm").text($("#libraryBgm").val());
	});
	$("#libraryPhoto").keyup(function(){
		$("#libraryFinishPhoto").text($("#libraryPhoto").val());
	});
	$("#libraryChannel").keyup(function(){
		$("#libraryFinishChannel").text($("#libraryChannel").val());
	});
	$("#libraryEvent").keyup(function(){
		$("#libraryFinishEvent").text($("#libraryEvent").val());
	});
	$("#libraryTag").keyup(function(){
		$("#libraryFinishTag").text($("#libraryTag").val());
	});
	$("#libraryEtc").keyup(function(){
		$("#libraryFinishEtc").text($("#libraryEtc").val());
	});

	
});




