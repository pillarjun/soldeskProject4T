function pwcheck() {
	  var nb_pw = document.getElementById("nb_pw").value;
	  temp_pw = prompt('비밀번호를 입력해주세요.');
	  if (nb_pw != temp_pw) {
	    alert("비밀번호가 일치하지 않습니다.");
	    return false;
	  }
	  return true;
	};
function replypwcheck() {
	  var r_pw = document.getElementById("r_pw").value;
	  temp_pw = prompt('비밀번호를 입력해주세요.');
	  if (r_pw != temp_pw) {
	    alert("비밀번호가 일치하지 않습니다.");
	    return false;
	  }
	  return true;
	};
function replyvalidcheck() {
	var r_id = document.getElementById("r_id.insert").value;
	var r_pw = document.getElementById("r_pw.insert").value;
	var r_content = document.getElementById("r_content.insert").value;
	if (r_id.length == 0) {
	    alert("댓글 아이디를 기입하세요.");
	    return false;
	    } 
	else if (r_pw.length == 0) {
	   	alert("댓글 비밀번호를 기입하세요.");
	    return false;
	   }
	else if (r_content.length == 0){
		alert("댓글 내용을 기입하세요.");
	    return false;
	}
	  return true;
};

