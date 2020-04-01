/**
 * 
 */
var regcheck = function(){
	//이름값
	vname = $('#name').val().trim();
	namelen = vname.length;
	
	//이름길이
	if(namelen <2 || namelen >5){
		alert("이름 2~5 사이입니다.");
		return false;
	}				
						
	//비밀번호------------------------------
	//비밀번호값
	vpass = $('#pass').val().trim();
	passlen = vpass.length;
	
	//비밀번호 길이
	if(passlen < 4|| passlen>10){
		alert("비밀번호 4~10 사이입니다");
		return false;
	}
	
	//비밀번호 정규식
	passreg =  /^[a-zA-Z]+[0-9]+$/;
		if(!(passreg.test(vpass))){
			alert("비밀번호 형식 오류");
			return false;
		}
	
	/////////////////////////////////////////////////
	//생년월일  : 숫자 4자리 - 숫자 2자리 - 숫자 2자리
	vbir = $('#bir').val().trim();
	birlen = vbir.length;
	
	//생년월일 길이
	if(birlen < 0){
		alert("생년월일 입력");
		return false;
	}
	
	//생년월일 형식 숫자 4자리.숫자 2자리.숫자 2자리
	birreg =  /^\d{4}\.\d{2}\.\d{2}$/;
		if(!(birreg.test(vbir))){
			alert("생년월일 형식 오류");
			return false;
		}
	
	
	//휴대폰------------------------------
	//휴대폰값
	vhp = $('#hp').val().trim();
	hplen= vhp.length;	
	
	//휴대 길이
	if(hplen < 0){
		alert("w전화번호 입력");
		return false;
	}
	
	//휴대폰 정규식
	hpleg =  /^\d{3}-\d{4}-\d{4}$/;
		if(!(hpleg.test(vhp))){
			alert("전화번호 형식 오류");
			return false;
		}
	
	
		//이메일------------------------------
		//이메일값
		vmail = $('#mail').val().trim();
		maillen= vmail.length;	
		
		//이메일 길이
		if(maillen == 0){
			alert("이메일 입력");
			return false;
		}
		
		//이메일 정규식
		mailleg =  /^[a-z-A-Z0-9]+@[a-zA-Z-0-9]+(\.[a-z-A-Z0-9]+){1,2}$/;
			if(!(mailleg.test(vmail))){
				alert("전화번호 형식 오류");
				return false;
			}
	
	return true;
	
	
}
	