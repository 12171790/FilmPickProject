#  [ Project ] Filmpick
***

## :sparkles: [ Summary ]
> 영화 정보와 영화에 대한 리뷰 그리고 사용자들 간의 커뮤니티를 구현한 Filmpick 사이트

## :date: [ Develop Date ]
> <p>$\large{2024.02.12\ ~ \ 2024.03.29}$</p>
> 1주 차 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 요구사항 분석 <br>
> 2주 차 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: DB설계       <br>
> 3 ~ 4주 차 : 화면 설계 및 화면 구현        <br>
> 5 ~ 7주 차 : 기능 구현 및 테스트            <br>

발표 ppt


## 🧑🏻‍💻 [ Contribute ]
> - <p>$\bf{\color{#5882FA} 배기웅 : 영화|인물 검색, 영화 상세보기, 리뷰 남기기, 좋아요 표시, 다른 사용자 정보 보기}$</p>
> - 이용훈 : 영화 탐색, 메인페이지
> - 김호용 : 게시판, 공지사항, 없는 영화 신청, 사용자 및 게시글 신고
> - 한수민 : 관리자 페이지, 신규 영화 등록, 신규 인물 등록, 신고글 처리
> - 정은정 : 마이페이지, 리뷰 수정하기, 좋아요 표시 영화 보기, 내가 남긴 게시글 보기
> - 김지우 : 사용자 관리, 신고된 사용자 처리, 없는 영화 신청 처리  


## :four_leaf_clover: [ Stack ]
<div>
  <img src="https://img.shields.io/badge/HTML5-E34F26?logo=html5&logoColor=white" height="30px"> 			&nbsp;
  <img src="https://img.shields.io/badge/CSS3-1572B6?logo=css3&logoColor=white" height="30px"> 				&nbsp;
  <img src="https://img.shields.io/badge/JavaScript-F7DF1E?logo=javascript&logoColor=black" height="30px"> 		&nbsp;
  <img src="https://img.shields.io/badge/jQuery-0769AD?logo=jquery&logoColor=white" height="30px"> 			<br><br>
  <img src="https://img.shields.io/badge/Java11-007396?logo=OpenJDK&logoColor=white" height="30px"> 			&nbsp;
  <img src="https://img.shields.io/badge/Oracle-F80000?logo=oracle&logoColor=white" height="30px"> 			<br><br> 
  <img src="https://img.shields.io/badge/VScode-007ACC?logo=visualstudiocode&logoColor=white" height="30px">  &nbsp;
  <img src="https://img.shields.io/badge/github-181717?logo=github&logoColor=white" height="30px"> 			&nbsp;	<br><br> 
  <img src="https://img.shields.io/badge/bootstrap5-7952B3?logo=bootstrap&logoColor=black" height="30px"> 		&nbsp;
</div>

***


## ⚙️ [ Functions ]

### 1. [ 로그인 ]
> 사이트 접속 시 가장 처음 나오는 페이지로 로그인하면 메인페이지로 이동할 수 있습니다. <br>
> 아이디와 비밀번호 찾기를 진행할 수 있습니다.

#### 1-1. 아이디 찾기
> iziModal을 활용하여 개인 사번 입력 시 자신의 아이디를 화면에 출력합니다. <br>

![_2024_06_27_23_03_03_55-ezgif com-video-to-gif-converter](https://github.com/12171790/RolloWa/assets/112368201/34747958-8765-458e-807d-e6c7108d144d)
#### 1-2 비밀번호 찾기
> iziModal과 CoolSMS API를 사용하여, 전화번호 인증을 받아야 비밀번호 찾기를 할 수 있습니다. <br>
> 전화번호 입력 시 유효성 검사를 거치며, 인증 문자 발송 시 타이머가 작동됩니다. 타이머가 0초가 되면 더 이상 입력할 수 없습니다. <br>

> ![_2024_06_27_23_03_49_620-ezgif com-video-to-gif-converter](https://github.com/12171790/RolloWa/assets/112368201/5caefdb1-77db-4709-b8e2-cb3eeca9b104)

### 2. 마이페이지
> 전화번호, 이메일, 주소 등 개인정보를 변경할 수 있습니다. <br>
> 전화번호는 CoolSMS API를 사용하여 문자 인증을 받아야만 변경할 수 있습니다. <br>
> 주소는 카카오 주소 찾기 API를 활용하였습니다. <br>
> 그 외에 프로필 이미지와 비밀번호 변경이 가능합니다. <br>

#### 2-1. 프로필 이미지 변경
> AJAX를 사용해 프로필 이미지를 클릭하여 이미지 변경 시 변경사항이 바로 반영됩니다. <br>

> ![_2024_06_27_23_06_43_627-ezgif com-video-to-gif-converter](https://github.com/12171790/RolloWa/assets/112368201/c4a1062e-ec6e-433b-ac8c-8678f1a9940d)

#### 2-2. 개인정보 변경
> 문자 인증을 통해 전화번호를 변경할 수 있습니다. <br>
> 카카오 주소 찾기 api를 통해 본인의 주소를 변경할 수 있습니다. <br>
> 그 외에 이메일, 계좌번호를 변경할 수 있습니다. <br>

> ![_2024_06_27_23_08_50_243-ezgif com-video-to-gif-converter](https://github.com/12171790/RolloWa/assets/112368201/3c5d003c-52de-4833-86ea-3c2c703a1513)

#### 2-3. 비밀번호 변경
> 입력한 비밀번호에 대해 정규표현식을 통해 유효성 검사를 진행합니다. <br>
> 제출 시 현재 비밀번호가 일치해야 비밀번호 변경이 됩니다. <br>
> Spring Security의 암호화 기능을 통해 비밀번호를 암호화하여 DB에 저장합니다. <br>
> 비밀번호 변경 성공 시 로그인 페이지로 이동합니다. <br>

> ![_2024_06_27_23_13_56_571-ezgif com-video-to-gif-converter (1)](https://github.com/12171790/RolloWa/assets/112368201/69933407-00ac-4007-8007-b36c24ac26fe)

### 3. 알림
> SockJS와 STOMP를 활용하여 알림 기능을 구현했습니다. <br>
> 부서 공지사항을 등록하면 해당하는 부서원들에게 알림이 갑니다. <br>
> 부서 일정을 등록하면 co-worker로 지정된 사원들에게 알림이 갑니다. <br>

#### 3-1. 부서 공지사항 등록 시 알림
> 공지사항 등록 시 부서원들에게 알림이 갑니다. <br>
> 알림을 받은 사원이 '알림으로 이동' 버튼을 클릭하면 등록된 공지사항 페이지로 이동할 수 있습니다. <br>

> ![_2024_06_27_23_28_21_689-ezgif com-video-to-gif-converter](https://github.com/12171790/RolloWa/assets/112368201/418cf40c-82a9-4f7e-ae63-c9970d248502)
#### 3-2. 부서 일정 등록 시 알림
> 일정 등록 시 co-worker로 지정된 사원들에게 알림이 갑니다. <br>
> 알림을 받은 사원이 '알림으로 이동' 버튼을 클릭하면 일정 페이지로 이동할 수 있습니다. <br>

> ![_2024_06_27_23_28_45_77-ezgif com-video-to-gif-converter](https://github.com/12171790/RolloWa/assets/112368201/a5a97acd-bfd7-4293-b536-ebc3ad48253b)
### 4. 채팅
> SockJS와 STOMP를 활용하여 채팅 기능을 구현했습니다. <br>
> 그룹채팅, 1대1 채팅이 가능합니다. <br>
> 사원을 채팅방에 초대할 수 있습니다. <br>
> 멘션 기능을 통해 사원에게 알림을 보낼 수 있습니다. <br>
***

### ❔ 
- 내가 기능적으로 부족했던 부분	<br>
      
- 협업에서 부족한 부분		<br>





