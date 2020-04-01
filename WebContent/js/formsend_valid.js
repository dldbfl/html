/**
 * 
 * 정규식을 이용한 데이타 검증
 * 비교문자값.match('정규식'): 
 * 정규식.test(비교문자값) 	: 문자값이 정규식에 맞는가
 * 						: 결과값 true, false로 리턴  
 */

function sendProc() {
	
	f = document.ff;
	
	// id는 영문자로 시작하고 숫자를 조합해서 8~12사이로 한다.
	idvalue = f.id.value;
	idlen = idvalue.trim().length;
	
	if(idlen == 0){
		alert("아이디를 입력");
		return false;
	}
	if(idlen < 8 || idlen > 12){
		alert("아이디는 8~12입니다.");
		return false;
	}
	idreg = /^[a-zA-z][0-9a-zA-Z]{7,11}$/
	if(!(idreg.test(idvalue))){
		alert("아이디 형식오류");
		return false;
	}
	///////////////////////
	// 이름
	namevalue = f.name.value;
	namelen = namevalue.trim().length;
	if(namelen == 0){
		alert("name입력");
		return false;
	}
	namereg = /^[가-힣]+|^[a-zA-Z]+/;
			if(namereg.test(namevalue)){
				rkor = /^[가-힣]+$/;
				reng = /^[a-zA-Z]+$/;
				
				if(rkor.test(namevalue)){
					if(namelen < 2 || namelen > 5){
						alert("한글이름은 2~5글자로 작성해주세요.");
						return false;
					}
				}else if(reng.test(namevalue)){
					if(namelen < 10 || namelen > 20){
						alert("영문 이름은 10~20글자로 작성해주세요.");
						return false;
					}
				}else{
					alert("이름 형식 오류");
					return false;
				}
			}else{
				alert("이름 형식 오류");
				return false;
			}
			//////////////////////////////////
			// 비밀번호 - 영문 숫자 특수문자가 반드시 한글자 이상씩포함.
			
			// 전방탐색
			// \w+(?=str) --> str을 찾아서, str을 기준으로 앞에 한번이상 나오는 문자나 숫자를 검색한다. 
			// str을 기준으로 앞에 나타나는 문자나 숫자가 없다면 str로 시작한다.
			passvalue = f.pass.value;
			passlen = passvalue.trim().length;
			
			pass2 = f.pass2.value;
			if(passvalue != pass2){
				alert("2개의 비밀번호가 불일치");
				return false;
			}
			
			
			
			if(passlen == 0){
				alert("비밀번호를 입력");
				return false;
			}
			if(passlen < 8 || passlen > 12){
				alert("비밀번호는 8~12압나다.");
				return false;
			}
			passreg = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*]).{8,12}$/;
			if(!(passreg.test(passvalue))){
				alert("비밀번호 형식오류");
				return false;
			}
			///////////////////////////
			// 전화번호
			telvalue = f.tel.value;
			tellen = telvalue.trim().length;
			
			if(tellen == 0){
				alert("전화번호 입력");
				return false;
			}
			telreg = /^\d{3}-\d{4}-\d{4}$/;
			if(!(telreg.test(telvalue))){
				alert("전화번호 형식오류");
				return false;
			}
			///////////////////////////
			// 이메일
			mailvalue = f.mail.value;
			maillen = mailvalue.trim().length;
			
			if(maillen == 0){
				alert("이메일 입력");
				return false;
			}
			mailreg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+){1,2}$/;
			if(!(mailreg.test(mailvalue))){
				alert("이메일 형식오류");
				return false;
			}
			
			
				return true;
}



























