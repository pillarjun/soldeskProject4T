function validcheck() {
	var m_id = document.getElementById("nb_id.insert").value;
	var m_pw = document.getElementById("nb_pw.insert").value;
	var m_title = document.getElementById("nb_title.insert").value;
	var m_content = document.getElementById("nb_content.insert").value;
	if (m_id.length == 0) {
	    alert("아이디를 기입하세요.");
	    return false;
	    } 
	else if (m_pw.length == 0) {
	   	alert("비밀번호를 기입하세요.");
	    return false;
	   }
	else if (m_title.length == 0) {
	   	alert("제목을 기입하세요.");
	    return false;
	   }
	else if (m_content.length == 0){
		alert("내용을 기입하세요.");
	    return false;
	}
	  return true;
};
function validcheck2() {
	var m_title = document.getElementById("nb_title.update").value;
	var m_content = document.getElementById("nb_content.update").value;
	if (m_title.length == 0) {
	   	alert("제목을 기입하세요.");
	    return false;
	   }
	else if (m_content.length == 0){
		alert("내용을 기입하세요.");
	    return false;
	}
	  return true;
	  
};

