
function getFileExtension(fileName) {
    return fileName.slice((fileName.lastIndexOf(".") - 1 >>> 0) + 2);
}

function validateForm(){
	var fileInput = document.getElementById('fileInput');
	
	if(fileInput.files.length>0){
		var fileName = fileInput.files[0].name;
		var fileExtension = getFileExtension(fileName);
		if(fileExtension==='mp4'){
			console.log("mp4파일.")
			return true;
		}else{
			alert("잘못된 형식의 파일입니다(mp4만 가능)");
			return false;
		}
	}else{
		console.log("선택된 파일없음");
	}
	
	return false;
	
}