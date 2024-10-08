package com.fp.noMovie.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.fp.common.model.vo.Attachment;
import com.fp.common.template.MyFileRenamePolicy;
import com.fp.movie.model.vo.Category;
import com.fp.noMovie.model.service.NoMovieService;
import com.fp.noMovie.model.vo.NoMovie;
import com.fp.person.model.vo.Person;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class NoMovieInsertController
 */
@WebServlet("/insertNoMovie.mv")
public class NoMovieInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoMovieInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 100 * 1024 * 1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/upfiles");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			/*-------------------------------------------------------------------------------------------------------*/
			// NO_MOVIE_ENROLL 테이블에 데이터 기록 
			NoMovie nm = new NoMovie();
			String nmTitle = multiRequest.getParameter("movieName"); // 없는영화 제목
			String nmViewGrade = multiRequest.getParameter("viewGrade"); // 관람등급
			String nmStory = multiRequest.getParameter("movieStory"); // 줄거리
			String nmReleaseDate = multiRequest.getParameter("releaseDate"); // 개봉일
			String nmRunTime = multiRequest.getParameter("runTime"); // 러닝타임
			String nmNation = multiRequest.getParameter("nation"); // 국가 (1국내 | 2해외)
			String nmUserRequest = multiRequest.getParameter("userRequest"); // 사용자 요청사항
			String nmNicknameStatus = multiRequest.getParameter("nicknameStatus"); // 닉네임 제공여부
			int memNo = Integer.parseInt(multiRequest.getParameter("memNo")); // 글 작성한 회원번호
			if(nmNicknameStatus == null) {
				nmNicknameStatus = "N";
			}
			nm.setNmTitle(nmTitle); // 없는영화 제목
			nm.setNmViewGrade(nmViewGrade); // 관람등급
			nm.setNmStory(nmStory); // 줄거리
			nm.setNmReleaseDate(nmReleaseDate); // 개봉일
			nm.setNmRunTime(nmRunTime); // 러닝타임
			nm.setNmNation(nmNation); // 국가 (1국내 | 2해외)
			nm.setNmUserRequest(nmUserRequest); // 사용자 요청사항
			nm.setNmNicknameStatus(nmNicknameStatus);  // 닉네임 제공여부
			nm.setMemNo(memNo);  // 글 작성한 회원번호
			// 영화 메인포스터 경로
			String changeName1 = multiRequest.getFilesystemName("upfile1");
			String nmPoster = "resources/upfiles/" + changeName1;
			nm.setNmPoster(nmPoster);
			// 영화 메인예고편 경로
			String changeName2 = multiRequest.getFilesystemName("upfile2");
			String nmPreview = "resources/upfiles/" + changeName2;
			nm.setNmPreview(nmPreview);
			
			HttpSession session = request.getSession();
			
			/*-------------------------------------------------------------------------------------------------------*/
			// NO_MOVIE_CAST 테이블에 데이터 기록 (Person Vo 객체에 담아서)
			List<Person> pList = new ArrayList<>();
			
			String[] personNos = multiRequest.getParameterValues("personNo");
			String[] movieJobs =  multiRequest.getParameterValues("movieJob");
			for(int i=0; i<personNos.length; i++) {
				Person p = new Person();
				String personNo = personNos[i];
				String movieJob = movieJobs[i];
				p.setpNo(Integer.parseInt(personNo));
				p.setpJob(movieJob);
				pList.add(p);
				// pList[0] : [인물번호, 감독]
				// pList[1] : [인물번호, 배역명]
				// pList[2] : [인물번호, 배역명]
			}
			// pList[i]에는 출연인물번호 및 배역이 담겨있음
			/*-------------------------------------------------------------------------------------------------------*/
			// NO_MOVIE_GENRE 테이블에 데이터 기록 (Category vo 객체에 담아서)
			String[] categoryArr = multiRequest.getParameterValues("category");
			List<Category> cList = new ArrayList<>();
			for(int i=0; i<categoryArr.length; i++) {
				Category c = new Category();
				String category = categoryArr[i];
				c.setCategoryNo(Integer.parseInt(category));
				cList.add(c);
				// cList[0] : 액션
				// cList[1] : 로맨스
				// cList[2] : 느와르
			}
			/*-------------------------------------------------------------------------------------------------------*/
			// ATACHMENT 테이블에 데이터 기록 (Attachment Vo 객체에 담아서)
			Attachment at = null;
			int ext = 1;
			// 이건 추가 파일에 대한 내용
			if(multiRequest.getOriginalFileName("upfile3") != null) {	
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile3"));
				at.setChangeName(multiRequest.getFilesystemName("upfile3"));
				at.setFilePath("resources/upfiles/");
				if(at.getChangeName().substring(at.getChangeName().lastIndexOf(".")).equals("mp4")) {
					ext = 2;
				}
			}
			
			// 이건 메인 영화포스터에 대한 내용
			Attachment at1 = new Attachment();
			at1.setOriginName(multiRequest.getOriginalFileName("upfile1"));
			at1.setChangeName(multiRequest.getFilesystemName("upfile1"));
			at1.setFilePath("resources/upfiles/");
			
			// 이건 메인 영화예고편에 대한 내용 
			Attachment at2 = new Attachment();
			at2.setOriginName(multiRequest.getOriginalFileName("upfile2"));
			at2.setChangeName(multiRequest.getFilesystemName("upfile2"));
			at2.setFilePath("resources/upfiles/");
			/*-------------------------------------------------------------------------------------------------------*/
			int result = new NoMovieService().insertNoMovie(nm, pList, cList, at, ext, at1, at2);
			
			if(result > 0) {
				session.setAttribute("alertMsg", "성공적으로 게시글이 등록되었습니다.");
				response.sendRedirect(request.getContextPath() + "/list.noMv?memNo=" + nm.getMemNo() + "&page=" + 1);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
