<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.signup_content{
      border: 1px solid lightgray;
      background-color: white;
      width: 580px;
      margin: auto;
      margin-top: 50px;
      margin-bottom: 50px;
      min-height: 400px;
      padding: 5px;
      border-radius: 0.7em;
    }
    .signup_content th, .signup_content td{
      vertical-align: middle;
    }
    .form-control{
      width: 400px;
    }
</style>
</head>
<body>


 <svg xmlns="http://www.w3.org/2000/svg" class="d-none">
    <symbol id="check2" viewBox="0 0 16 16">
      <path
        d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
    </symbol>
    <symbol id="circle-half" viewBox="0 0 16 16">
      <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z" />
    </symbol>
    <symbol id="moon-stars-fill" viewBox="0 0 16 16">
      <path
        d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z" />
      <path
        d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z" />
    </symbol>
    <symbol id="sun-fill" viewBox="0 0 16 16">
      <path
        d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z" />
    </symbol>
  </svg>

   <!-- <div class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle">
    <button class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center" id="bd-theme" type="button"
      aria-expanded="false" data-bs-toggle="dropdown" aria-label="Toggle theme (auto)">
      <svg class="bi my-1 theme-icon-active" width="1em" height="1em">
        <use href="#circle-half"></use>
      </svg>
      <span class="visually-hidden" id="bd-theme-text">Toggle theme</span>
    </button>
    <ul class="dropdown-menu dropdown-menu-end shadow" aria-labelledby="bd-theme-text">
      <li>
        <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light"
          aria-pressed="false">
          <svg class="bi me-2 opacity-50" width="1em" height="1em">
            <use href="#sun-fill"></use>
          </svg>
          Light
          <svg class="bi ms-auto d-none" width="1em" height="1em">
            <use href="#check2"></use>
          </svg>
        </button>
      </li>
      <li>
        <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark"
          aria-pressed="true">
          <svg class="bi me-2 opacity-50" width="1em" height="1em">
            <use href="#moon-stars-fill"></use>
          </svg>
          Dark
          <svg class="bi ms-auto d-none" width="1em" height="1em">
            <use href="#check2"></use>
          </svg>
        </button>
      </li>
      <li>
        <button type="button" class="dropdown-item d-flex align-items-center active" data-bs-theme-value="auto"
          aria-pressed="false">
          <svg class="bi me-2 opacity-50" width="1em" height="1em">
            <use href="#circle-half"></use>
          </svg>
          Auto
          <svg class="bi ms-auto d-none" width="1em" height="1em">
            <use href="#check2"></use>
          </svg>
        </button>
      </li>
    </ul>
  </div>  -->


  <svg xmlns="http://www.w3.org/2000/svg" class="d-none">
    <symbol id="bootstrap" viewBox="0 0 118 94">
      <title>Bootstrap</title>
      <path fill-rule="evenodd" clip-rule="evenodd"
        d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z">
      </path>
    </symbol>
    <symbol id="home" viewBox="0 0 16 16">
      <path
        d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z" />
    </symbol>
    <symbol id="speedometer2" viewBox="0 0 16 16">
      <path
        d="M8 4a.5.5 0 0 1 .5.5V6a.5.5 0 0 1-1 0V4.5A.5.5 0 0 1 8 4zM3.732 5.732a.5.5 0 0 1 .707 0l.915.914a.5.5 0 1 1-.708.708l-.914-.915a.5.5 0 0 1 0-.707zM2 10a.5.5 0 0 1 .5-.5h1.586a.5.5 0 0 1 0 1H2.5A.5.5 0 0 1 2 10zm9.5 0a.5.5 0 0 1 .5-.5h1.5a.5.5 0 0 1 0 1H12a.5.5 0 0 1-.5-.5zm.754-4.246a.389.389 0 0 0-.527-.02L7.547 9.31a.91.91 0 1 0 1.302 1.258l3.434-4.297a.389.389 0 0 0-.029-.518z" />
      <path fill-rule="evenodd"
        d="M0 10a8 8 0 1 1 15.547 2.661c-.442 1.253-1.845 1.602-2.932 1.25C11.309 13.488 9.475 13 8 13c-1.474 0-3.31.488-4.615.911-1.087.352-2.49.003-2.932-1.25A7.988 7.988 0 0 1 0 10zm8-7a7 7 0 0 0-6.603 9.329c.203.575.923.876 1.68.63C4.397 12.533 6.358 12 8 12s3.604.532 4.923.96c.757.245 1.477-.056 1.68-.631A7 7 0 0 0 8 3z" />
    </symbol>
    <symbol id="table" viewBox="0 0 16 16">
      <path
        d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm15 2h-4v3h4V4zm0 4h-4v3h4V8zm0 4h-4v3h3a1 1 0 0 0 1-1v-2zm-5 3v-3H6v3h4zm-5 0v-3H1v2a1 1 0 0 0 1 1h3zm-4-4h4V8H1v3zm0-4h4V4H1v3zm5-3v3h4V4H6zm4 4H6v3h4V8z" />
    </symbol>
    <symbol id="people-circle" viewBox="0 0 16 16">
      <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
      <path fill-rule="evenodd"
        d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
    </symbol>
    <symbol id="grid" viewBox="0 0 16 16">
      <path
        d="M1 2.5A1.5 1.5 0 0 1 2.5 1h3A1.5 1.5 0 0 1 7 2.5v3A1.5 1.5 0 0 1 5.5 7h-3A1.5 1.5 0 0 1 1 5.5v-3zM2.5 2a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zm6.5.5A1.5 1.5 0 0 1 10.5 1h3A1.5 1.5 0 0 1 15 2.5v3A1.5 1.5 0 0 1 13.5 7h-3A1.5 1.5 0 0 1 9 5.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zM1 10.5A1.5 1.5 0 0 1 2.5 9h3A1.5 1.5 0 0 1 7 10.5v3A1.5 1.5 0 0 1 5.5 15h-3A1.5 1.5 0 0 1 1 13.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zm6.5.5A1.5 1.5 0 0 1 10.5 9h3a1.5 1.5 0 0 1 1.5 1.5v3a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 13.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3z" />
    </symbol>
  </svg>

  <main>
    
    <%@ include file="/views/common/header.jsp" %>

    <div class="content_wrap" style="background-color: black;">
      <div class="content">


        <section class="main_content">

          <div class="signup_content">
              <h2>회원가입</h2>
  
              <form action="<%= contextPath %>/insert.me" method="post">
                  <table class="table">
                      <tr>
                          <td>
                              <input type="text" class="form-control" name="memId" id="memId" placeholder="* 아이디" required>
                          </td>
                          <td>
                            <button type="button" class="btn btn-outline-light" onclick="idCheck();"style="width: 130px; 
                                                                                       --bs-btn-border-color: RGB(247, 39, 140);
                                                                                       --bs-btn-color:RGB(247, 39, 140);
                                                                                       --bs-btn-hover-color: #ffffff;
                                                                                       --bs-btn-hover-bg: RGB(247, 39, 140);
                                                                                       --bs-btn-hover-border-color: #ffffff;">중복확인</button>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <input type="password" class="form-control" name="memPwd" id="memPwd" placeholder="* 비밀번호(8~15자의 영문, 숫자, 특수문자 사용)" required>
                          </td>
                          <td>
  
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <input type="password" class="form-control" name="checkPwd" id="checkPwd" placeholder="* 비밀번호확인" required>
                          </td>
                          <td>
  
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <input type="email" class="form-control" name="memEmail" placeholder="* 이메일주소" required>
                          </td>
                          <td>
  
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <input type="text" class="form-control" name="nickname" placeholder="* 닉네임" required>
                          </td>
                          <td>
                            <button type="button" class="btn btn-outline-light" onclick="nicknameCheck();" style="width: 130px;
                                                                                       --bs-btn-border-color: RGB(247, 39, 140);
                                                                                       --bs-btn-color:RGB(247, 39, 140);
                                                                                       --bs-btn-hover-color: #ffffff;
                                                                                       --bs-btn-hover-bg: RGB(247, 39, 140);
                                                                                       --bs-btn-hover-border-color: #ffffff;">중복확인</button>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <input type="text" class="form-control" name="memName" placeholder="* 이름" required>
                          </td>
                          <td>
  
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <input type="text" class="form-control" name="memBirth" id="memBirth" placeholder="* 생년월일 (ex. 010101)" required>
                          </td>
                          <td>
  
                          </td>
                      </tr>
                      <tr>
                          <td>&nbsp;
                              <input type="radio" name="memGender" id="memGenderM" value="M" required>
                              <label for="radioM">&nbsp;남자</label>
                              <input type="radio" name="memGender" id="memGenderF" value="F" required>
                              <label for="radioF">&nbsp;여자</label>
                          </td>
                          <td>
  
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <input type="text" class="form-control" name="memPhone" placeholder="* 휴대전화번호" required>
                          </td>
                          <td>
                            <button type="submit" class="btn btn-outline-light" style="width: 130px;  font-size: smaller;
                                                                                       --bs-btn-border-color: RGB(247, 39, 140);
                                                                                       --bs-btn-color:RGB(247, 39, 140);
                                                                                       --bs-btn-hover-color: #ffffff;
                                                                                       --bs-btn-hover-bg: RGB(247, 39, 140);
                                                                                       --bs-btn-hover-border-color: #ffffff;">인증번호요청</button>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <input type="text" class="form-control" placeholder="* 인증번호 6자리 입력" required>
                          </td>
                          <td>
                            <button type="button" class="btn btn-outline-light" style="width: 130px;
                                                                                       --bs-btn-border-color: RGB(247, 39, 140);
                                                                                       --bs-btn-color:RGB(247, 39, 140);
                                                                                       --bs-btn-hover-color: #ffffff;
                                                                                       --bs-btn-hover-bg: RGB(247, 39, 140);
                                                                                       --bs-btn-hover-border-color: #ffffff;">인증하기</button>
                          </td>
                      </tr>
                      
                      <td>
                          <select name="genre" id="prefGenre">
                              <option value="action">선호장르를 선택하세요</option>
                              <option value="action">SF</option>
                              <option value="action">스릴러</option>
                              <option value="action">로맨스</option>
                              <option value="action">액션</option>
                              <option value="action">코미디</option>
                              <option value="action">에로</option>
                              <option value="action">범죄</option>
                              <option value="action">애니메이션</option>
                          </select>
                      </td>

                  </table>
                  
                  <button type="submit" class="btn btn-outline-light" style="width: 350px;
                                                                             	   --bs-btn-border-color: RGB(247, 39, 140);
                                                                                   --bs-btn-color:RGB(247, 39, 140);
                                                                                   --bs-btn-hover-color: #ffffff;
                                                                                   --bs-btn-hover-bg: RGB(247, 39, 140);
                                                                                   --bs-btn-hover-border-color: #ffffff;" disabled>가입하기</button>
              </form>    
              
              

			<script>
			function idCheck(){
			
				// 아이디 유효성검사
	            const regExp = /^[a-z0-9]{5,12}$/;
		            if(!regExp.test($(".signup_content input[name=memId]").val())){
				        alert("유효한 아이디의 형식이 아닙니다. 다시 입력해주세요");
				        document.getElementById("memId").select();
				        return false;
		            }
	            
		        // 아이디 중복확인
	            const $idInput = $(".signup_content input[name=memId]");
		            $.ajax({
		            url:"<%=contextPath%>/idCheck.me",
		            data:{checkId: $idInput.val()},
		            success: function(result){
	              				
	              		if(result == "NNNNN"){
		              		// 사용불가능(NNNNN)
		              		alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
		              		$idInput.focus();
	              		}else{
	              			// 사용가능(NNNNY)
	              			if(confirm("사용가능한 아이디입니다. 사용하시겠습니까? : ")){
		              			// 회원가입 버튼 활성화
		              			$(".signup_content :submit").removeAttr("disabled");
		              			// 아이디 입력하는 input요소 수정불가능한 속성 추가
		              			$idInput.attr("readonly", true);
	              			}else{
	              				$idInput.select();
	              			}
	              		}
	              	},
	              	error: function(){
	              	console.log("아이디 중복체크용 ajax 통신 실패")
	              	}
	              	})            		
			}          
			</script>
              
              
			<script>
			$("#checkPwd").focusout(function() {
				
				// 비밀번호 유효성검사
				const regExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d@$!%*#?&]{8,15}$/;	  
					if(!regExp.test($(".signup_content input[name=memPwd]").val())){
						alert("유효한 비밀번호의 형식이 아닙니다. 다시 입력해주세요");
						document.getElementById("memPwd").select();
						return false;
					}
	    
				// 비밀번호 일치 여부 검사 
				const memPwd = document.getElementById("memPwd").value;
				const checkPwd = document.getElementById("checkPwd").value; 
					if(memPwd != checkPwd){
						alert("비밀번호가 일치하지 않습니다.");
						document.getElementById("checkPwd").select();
						return false;	  
					}
			});
			</script> 
               
              
			<script>
			// 닉네임 중복확인
			function nicknameCheck(){

				const $nicknameInput = $(".signup_content input[name=nickname]");
					$.ajax({
					url:"<%=contextPath%>/nicknameCheck.me",
					data:{checkNickname: $nicknameInput.val()},
					method:"post",
					success: function(result){
              				
						if(result == "NNNNN"){
							// 사용불가능(NNNNN)
							alert("이미 존재하는 닉네임입니다.");
							$nicknameInput.focus();
						}else{
							// 사용가능(NNNNY)
							if(confirm("사용가능한 닉네임입니다. 사용하시겠습니까?")){
							// 회원가입 버튼 활성화
								$(".signup_content :submit").removeAttr("disabled");
								// 닉네임 입력하는 input요소 수정불가능한 속성 추가
								$nicknameInput.attr("readonly", true);
							}else{
								$nicknameInput.select();
							}
              			}
              		},
              		error: function(){
              			console.log("닉네임 중복체크용 ajax 통신 실패")
              		}
				})            		
			}          
			</script>
			
			<script>
			// 생년월일
			$("#memBirth").focusout(function(){
				const regExp = /^\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;	
					if(!regExp.test($(".signup_content input[name=memBirth]").val())){
						alert("유효한 생년월일 형식이 아닙니다. 다시 입력해주세요");
						//document.getElementById("memBirth").focus();
						return false;
					}
			});
			</script>
			
			<script>
			// 휴대전화번호
			
			</script>
   			
          </div>
        </section>
      </div>              
    </div> 
    
    




  </div>        
 </div>


	<%@ include file="/views/common/footer.jsp" %>
    </div>


</body>
</html>