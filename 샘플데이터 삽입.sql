INSERT INTO MEMBER (MEM_NO, MEM_ID, MEM_PWD, MEM_NAME, MEM_BD, MEM_GENDER, MEM_EMAIL, MEM_PHONE, PREF_GENRE, NICKNAME, MEM_STATUS, SIGNIN_DATE, MEM_LEVEL, MEM_COLOR, MEM_IMGPATH, MEM_FILE)
SELECT 
  SEQ_MEMBER_NO.NEXTVAL,
  'user' || LPAD(ROWNUM, 3, '0'), -- 아이디를 'user001', 'user002', ... 형식으로 생성
  'password' || LPAD(ROWNUM, 3, '0'), -- 패스워드를 'password001', 'password002', ... 형식으로 생성
  'Name' || LPAD(ROWNUM, 3, '0'), -- 이름을 'Name001', 'Name002', ... 형식으로 생성
  TO_CHAR(TO_DATE('1980-01-01', 'YYYY-MM-DD') + DBMS_RANDOM.VALUE(1, 15000), 'YYYY-MM-DD'), -- 랜덤한 생년월일 생성
  CASE WHEN MOD(ROWNUM, 2) = 0 THEN 'M' ELSE 'F' END, -- 랜덤한 성별 생성
  'user' || LPAD(ROWNUM, 3, '0') || '@example.com', -- 이메일 생성
  '1234567890', -- 랜덤한 전화번호 생성
  CASE WHEN MOD(ROWNUM, 3) = 0 THEN 'Action' WHEN MOD(ROWNUM, 3) = 1 THEN 'Comedy' ELSE 'Drama' END, -- 랜덤한 선호장르 생성
  'Nickname' || LPAD(ROWNUM, 3, '0'), -- 닉네임을 'Nickname001', 'Nickname002', ... 형식으로 생성
  CASE WHEN MOD(ROWNUM, 2) = 0 THEN 'Y' ELSE 'N' END, -- 랜덤한 회원상태 생성
  SYSDATE - DBMS_RANDOM.VALUE(1, 365), -- 랜덤한 회원정보수정일 생성
  CASE WHEN ROWNUM <= 5 THEN 1 WHEN ROWNUM <= 15 THEN 2 ELSE 3 END, -- 회원등급을 1, 2, 3 중에서 랜덤하게 생성
  '#FFFFFF', -- 기본 회원정보색깔
  'resources/xxxx/xxxxx.jpg', -- 기본 회원정보 이미지 경로
  NULL -- NULL 값으로 MEM_FILE 생성
FROM 
  DUAL
CONNECT BY 
  LEVEL <= 30;
  
-- MEMBER 샘플데이터 삽입 끝

INSERT INTO ADMIN (ADMIN_NO, ADMIN_ID, ADMIN_PWD, ADMIN_NAME, ADMIN_PHONE, ADMIN_STATUS)
SELECT 
  SEQ_ADMIN_NO.NEXTVAL,
  'admin' || LPAD(ROWNUM, 2, '0'), -- 관리자 아이디를 'admin01', 'admin02', ... 형식으로 생성
  'password' || LPAD(ROWNUM, 2, '0'), -- 관리자 패스워드를 'password01', 'password02', ... 형식으로 생성
  'AdminName' || LPAD(ROWNUM, 2, '0'), -- 관리자 이름을 'AdminName01', 'AdminName02', ... 형식으로 생성
  '1234567890', -- 랜덤한 전화번호 생성
  CASE WHEN MOD(ROWNUM, 2) = 0 THEN 'Y' ELSE 'N' END -- 랜덤한 활성화 상태 생성
FROM 
  DUAL
CONNECT BY 
  LEVEL <= 5;
  
  -- ADMIN 샘플 데이터 삽입 끝
  
INSERT INTO BOARD (B_NO, B_TITLE, B_CONTENT, B_REGIST_DATE, B_READ_COUNT, B_RECOMMEND_COUNT, B_CATEGORY, B_B_STATUS, B_D_STATUS, MEM_NO)
SELECT 
  SEQ_BOARD_NO.NEXTVAL,
  'Title' || LPAD(ROWNUM, 2, '0'), -- 게시글 제목을 'Title01', 'Title02', ... 형식으로 생성
  'Content' || LPAD(ROWNUM, 2, '0'), -- 게시글 내용을 'Content01', 'Content02', ... 형식으로 생성
  SYSDATE - DBMS_RANDOM.VALUE(1, 365), -- 랜덤한 작성일 생성
  0, -- 초기 조회수를 0으로 설정
  0, -- 초기 추천수를 0으로 설정
  CASE WHEN MOD(ROWNUM, 2) = 0 THEN '1' ELSE '2' END, -- 영화(1) 또는 잡담(2) 카테고리를 랜덤하게 생성
  'N', -- B_B_STATUS의 기본값 'N' 사용
  'N', -- B_D_STATUS의 기본값 'N' 사용
  MOD(ROWNUM, 30) + 1 -- 1부터 30까지의 숫자를 순환하여 MEM_NO 생성
FROM 
  DUAL
CONNECT BY 
  LEVEL <= 30;
  
  -- BOARD 샘플 데이터 삽입 끝
  
  -- 15개의 샘플 데이터 삽입
INSERT INTO CATEGORY (CATEGORY_NO, CATEGORY_NAME, CATEGORY_DATE, CATEGORY_STATUS)
SELECT 
  SEQ_CATEGORY_NO.NEXTVAL,
  CASE 
    WHEN ROWNUM = 1 THEN '액션'
    WHEN ROWNUM = 2 THEN '코미디'
    WHEN ROWNUM = 3 THEN '로맨스'
    WHEN ROWNUM = 4 THEN '스릴러'
    WHEN ROWNUM = 5 THEN '공포'
    WHEN ROWNUM = 6 THEN '판타지'
    WHEN ROWNUM = 7 THEN '어드벤처'
    WHEN ROWNUM = 8 THEN '드라마'
    WHEN ROWNUM = 9 THEN '애니메이션'
    WHEN ROWNUM = 10 THEN 'SF'
    WHEN ROWNUM = 11 THEN '범죄'
    WHEN ROWNUM = 12 THEN '모험'
    WHEN ROWNUM = 13 THEN '다큐멘터리'
    WHEN ROWNUM = 14 THEN '가족'
    WHEN ROWNUM = 15 THEN '뮤지컬'
  END,
  SYSDATE - DBMS_RANDOM.VALUE(1, 365), -- 랜덤한 등록일 생성
  'Y' -- 장르 상태를 기본값 'Y'로 설정
FROM 
  DUAL
CONNECT BY 
  LEVEL <= 15;
-- CATEGORY 샘플 데이터 삽입 끝

-- 30개의 샘플 데이터 삽입
INSERT INTO NOTICE (NOTICE_NO, NOTICE_CATEGORY, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_DATE, NOTICE_READ_COUNT, ADMIN_NO, NOTICE_STATUS)
SELECT 
  SEQ_NOTICE_NO.NEXTVAL,
  CASE WHEN ROWNUM <= 15 THEN '1' ELSE '2' END, -- 일반(1) 또는 이벤트(2) 카테고리를 랜덤하게 생성
  'Title' || LPAD(ROWNUM, 2, '0'), -- 공지사항 제목을 'Title01', 'Title02', ... 형식으로 생성
  'Content' || LPAD(ROWNUM, 2, '0'), -- 공지사항 내용을 'Content01', 'Content02', ... 형식으로 생성
  SYSDATE - DBMS_RANDOM.VALUE(1, 365), -- 랜덤한 작성일 생성
  0, -- 초기 조회수를 0으로 설정
  MOD(ROWNUM, 5) + 1, -- 1부터 5까지의 숫자를 순환하여 ADMIN_NO 생성
  'Y' -- 공지사항 상태를 기본값 'Y'로 설정
FROM 
  DUAL
CONNECT BY 
  LEVEL <= 30;
  -- NOTICE 샘플 데이터 삽입 끝
  
  INSERT INTO REPLY (REPLY_NO, REPLY_CONTENT, ENROLL_DATE, REPLY_B_STATUS, REPLY_D_STATUS, BOARD_NO, MEM_NO)
SELECT 
  SEQ_REPLY_NO.NEXTVAL,
  'Content' || LPAD(ROWNUM, 2, '0'), -- 댓글 내용을 'Content01', 'Content02', ... 형식으로 생성
  SYSDATE - DBMS_RANDOM.VALUE(1, 365), -- 랜덤한 작성일 생성
  CASE WHEN ROWNUM <= 10 THEN 'Y' ELSE 'N' END, -- 처음 10개의 데이터는 'Y', 나머지는 'N'으로 REPLY_B_STATUS 설정
  CASE WHEN ROWNUM <= 10 THEN 'Y' ELSE 'N' END, -- 처음 10개의 데이터는 'Y', 나머지는 'N'으로 REPLY_D_STATUS 설정
  MOD(ROWNUM, 30) + 1, -- 1부터 30까지의 숫자를 순환하여 BOARD_NO 생성
  MOD(ROWNUM, 30) + 1 -- 1부터 30까지의 숫자를 순환하여 MEM_NO 생성
FROM 
  DUAL
CONNECT BY 
  LEVEL <= 120;
  -- REPLY 샘플 데이터 삽입 끝
  
  INSERT INTO movie (MV_NO, MV_NAME, MV_OPENDATE, MV_NATION, MV_RTIME, MV_STORY, FPAGE_EXPOSED, VIEW_RATING, CURRENT_SCREENING, MPAGE_EXPOSED, MV_POSTER, MV_PREVIEW, MV_STATUS, MV_DATE)
SELECT 
  SEQ_MOVIE_NO.NEXTVAL,
  CASE
    WHEN ROWNUM <= 5 THEN '현재 상영 중인 한국영화 ' || ROWNUM
    WHEN ROWNUM <= 10 THEN '현재 상영 중인 해외영화 ' || ROWNUM
    WHEN ROWNUM <= 15 THEN '상영 중이 아닌 한국영화 ' || ROWNUM
    ELSE '상영 중이 아닌 해외영화 ' || ROWNUM
  END,
  TO_CHAR(SYSDATE - DBMS_RANDOM.VALUE(365, 730), 'YYYY-MM-DD'), -- 랜덤한 개봉일 생성 (1년~2년 전)
  CASE WHEN ROWNUM <= 20 THEN '1' ELSE '2' END, -- 한국영화(1) 또는 해외영화(2)를 랜덤하게 선택
  TO_CHAR(TRUNC(DBMS_RANDOM.VALUE(60, 180)), 'FM9999'), -- 랜덤한 러닝타임 생성 (60분~180분)
  '영화 줄거리 ' || ROWNUM, -- 영화 줄거리는 일단 임의의 내용으로 생성
  CASE WHEN ROWNUM <= 5 THEN 'Y' ELSE 'N' END, -- 5개의 영화에 대해 FPAGE_EXPOSED를 'Y'로 설정
  CASE MOD(ROWNUM, 4)
    WHEN 0 THEN '전체관람가'
    WHEN 1 THEN '12세 이상'
    WHEN 2 THEN '15세 이상'
    ELSE '청소년 관람불가'
  END,
  CASE WHEN ROWNUM <= 10 THEN 'Y' ELSE 'N' END, -- 현재 상영 중인 영화에 대해 CURRENT_SCREENING를 'Y'로 설정
  CASE WHEN ROWNUM <= 5 THEN 'Y' ELSE 'N' END, -- 5개의 영화에 대해 MPAGE_EXPOSED를 'Y'로 설정
  ROWNUM, -- 영화 포스터와 예고편은 1번부터 50번까지 순차적으로 부여
  ROWNUM,
  'Y', -- 모든 영화의 상태를 'Y'로 설정
  SYSDATE -- 등록일은 현재 날짜로 설정
FROM 
  DUAL
CONNECT BY 
  LEVEL <= 50;
  -- MOVIE 샘플 데이터 삽입 끝