package com.fp.noMovie.model.dao;

import static com.fp.common.template.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.fp.common.model.vo.Attachment;
import com.fp.common.model.vo.PageInfo;
import com.fp.movie.model.vo.Category;
import com.fp.noMovie.model.vo.NoMovie;
import com.fp.person.model.vo.Person;

public class NoMovieDao {
	
	private Properties prop = new Properties();
	
	public NoMovieDao() {
		try {
			prop.loadFromXML(new FileInputStream(NoMovieDao.class.getResource("/db/mappers/noMovie-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author 호용
	 * 없는영화 신청을 위한 메소드 NO_MOVIE_ENROLL 인설트
	 */
	public int insertNoMovie(Connection conn, NoMovie nm) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNoMovie");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nm.getNmTitle());
			pstmt.setString(2, nm.getNmStory());
			pstmt.setString(3, nm.getNmReleaseDate());
			pstmt.setString(4, nm.getNmRunTime());
			pstmt.setString(5, nm.getNmUserRequest());
			pstmt.setString(6, nm.getNmNicknameStatus());
			pstmt.setString(7, nm.getNmNation());
			pstmt.setString(8, nm.getNmViewGrade());
			pstmt.setInt(9, nm.getMemNo());
			pstmt.setString(10, nm.getNmPoster());
			pstmt.setString(11, nm.getNmPreview());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/**
	 * @author 호용
	 * 신청한 없는영화 수정을 위한 NO_MOVIE_ENROLL 업데이트
	 */
	public int updateNoMovie(Connection conn, NoMovie nm) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNoMovie");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nm.getNmTitle());
			pstmt.setString(2, nm.getNmStory());
			pstmt.setString(3, nm.getNmReleaseDate());
			pstmt.setString(4, nm.getNmRunTime());
			pstmt.setString(5, nm.getNmUserRequest());
			pstmt.setString(6, nm.getNmNicknameStatus());
			pstmt.setString(7, nm.getNmNation());
			pstmt.setString(8, nm.getNmViewGrade());
			pstmt.setString(9, nm.getNmPoster());
			pstmt.setString(10, nm.getNmPreview());
			pstmt.setInt(11, nm.getNmEnrollNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/**
	 * @author 호용
	 * 없는영화 신청을 위한 메소드 NO_MOVIE_CAST 인설트
	 */
	public int insertNoMoviePerson(Connection conn, List<Person> pList) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNoMoviePerson");
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<pList.size(); i++) {
				pstmt.setInt(1, pList.get(i).getpNo());
				pstmt.setString(2, pList.get(i).getpJob());
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	

	/**
	 * @author 호용
	 * 신청한 없는영화 수정을 위한 NO_MOVIE_CAST 업데이트(DELETE 한 후 INSERT)
	 */
	public int updateNoMoviePerson(Connection conn, List<Person> pList, NoMovie nm) {
		int result = 0;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		String sql1 = prop.getProperty("updateNoMoviePersonDelete");
		// 과정1. delete문 실행
		try {
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, nm.getNmEnrollNo());
			pstmt1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt1);
		}
		// 과정2. insert문 실행
		String sql2 = prop.getProperty("updateNoMoviePersonInsert");
		try {
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(2, nm.getNmEnrollNo());
			for(int i=0; i<pList.size(); i++) {
				pstmt2.setInt(1, pList.get(i).getpNo());
				pstmt2.setString(3, pList.get(i).getpJob());
				result += pstmt2.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt2);
		}
		return result;
	}

	
	/**
	 * @author 호용
	 * 없는영화 신청을 위한 메소드 NO_MOVIE_GENRE 인설트 
	 */
	public int insertNoMovieCategory(Connection conn, List<Category> cList) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNoMovieCategory");
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<cList.size(); i++) {
				pstmt.setInt(1, cList.get(i).getCategoryNo());
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	

	/**
	 * @author 호용
	 * 신청한 없는영화 수정을 위한 NO_MOVIE_GENRE 업데이트 (DELETE 한 후 INSERT)
	 */
	public int updateNoMovieCategory(Connection conn, List<Category> cList, NoMovie nm) {
		int result = 0;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		String sql1 = prop.getProperty("updateNoMovieCategoryDelete");
		try {
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, nm.getNmEnrollNo());
			pstmt1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt1);
		}
		String sql2 = prop.getProperty("updateNoMovieCategoryInsert");
		try {
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(2, nm.getNmEnrollNo());
			for(int i=0; i<cList.size(); i++) {
				pstmt2.setInt(1, cList.get(i).getCategoryNo());
				result += pstmt2.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt2);
		}
		return result;
		
		
	}

	/**
	 * @author 호용
	 * 없는영화 신청을 위한 메소드 ATTACHMENT 인설트(추가적인 파일이 있을 경우)
	 */
	public int insertNoMovieAttachment(Connection conn, Attachment at, int ext) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNoMovieAttachment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ext);
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/**
	 * @author 호용
	 * 없는영화 신청을 위한 메소드 ATTACHMENT 인설트(메인예고편 및 메인포스터)
	 */
	public int insertAttachment(Connection conn, Attachment at1, Attachment at2) {
		int result = 0;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		String sql1 = prop.getProperty("insertAttachment1");
		String sql2 = prop.getProperty("insertAttachment2");
		try {
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, at1.getOriginName());
			pstmt1.setString(2, at1.getChangeName());
			pstmt1.setString(3, at1.getFilePath());
			pstmt1.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt1);
		}
		try {
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, at2.getOriginName());
			pstmt2.setString(2, at2.getChangeName());
			pstmt2.setString(3, at2.getFilePath());
			result = pstmt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt2);
		}
		return result;
	}
	
	/**
	 * @author 호용
	 * 신청한 없는영화 수정을 위한 Attachment 업데이트
	 */
	public int updateNoMovieAttachment(Connection conn, Attachment at, int ext, NoMovie nm) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNoMovieAttachment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ext);
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
			pstmt.setInt(5, nm.getNmEnrollNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/**
	 * 없는영화신청 현황에 띄울 값들을 담기위한 메소드
	 * @param memNo 회원번호
	 * @author 호용 
	 */
	public List<NoMovie> selectNoMovie(Connection conn, int memNo){
		List<NoMovie> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoMovie");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new NoMovie(rset.getInt("NM_ENROLL_NO")
						           , rset.getString("NM_TITLE")
						           , rset.getString("NM_APPROVAL")
						           , rset.getString("NM_ENROLL_DATE")
						           , rset.getString("NM_REFUSE_REASON")
						           , rset.getInt("MEM_NO")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	/**
	 * 없는영화 수정페이지에서 띄울 값들을 담기위한 메소드
	 * @author 호용
	 */
	public NoMovie selectNoMovieAll(Connection conn, int noMovieNo){
		NoMovie nm = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<NoMovie> nList = new ArrayList<>();
		String sql = prop.getProperty("selectNoMovieAll");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noMovieNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				nm = new NoMovie();
				nm.setNmTitle(rset.getString("NM_TITLE"));
				nm.setNmViewGrade(rset.getString("NM_VIEW_GRADE"));
				nm.setNmStory(rset.getString("NM_STORY"));
				nm.setNmReleaseDate(rset.getString("NM_RELEASE_DATE"));
				nm.setNmRunTime(rset.getString("NM_RUN_TIME"));
				nm.setNmNation(rset.getString("NM_NATION"));
				nm.setNmPoster(rset.getString("NM_POSTER"));
				nm.setNmPreview(rset.getString("NM_PREVIEW"));
				nm.setNmUserRequest(rset.getString("NM_USER_REQUEST"));
				nm.setNmNicknameStatus(rset.getString("NM_NICKNAME_STATUS"));
				nm.setMemNo(rset.getInt("MEM_NO"));
				nm.setNmEnrollNo(noMovieNo);
//				nList.add(nm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
//		System.out.println("dao단에서의 nm : " + nm);
		return nm;
	}
	
	/**
	 * 없는영화 수정페이지에서 띄울 인물 값들을 담기위한 메소드
	 * @author 호용
	 */
	public List<Person> selectNoMoviePerson(Connection conn, int noMovieNo){
		Person p = null;
		List<Person> pList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoMoviePerson");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noMovieNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				p = new Person();
				p.setNoMoviePNo(rset.getInt("NM_CAST_NO"));
				p.setpNo(rset.getInt("PERSON_NO"));
				p.setNoMovieNo(rset.getInt("NM_ENROLL_NO"));
				p.setpJob(rset.getString("NM_CASTING"));
				p.setpName(rset.getString("P_NAME"));
				p.setpFile(rset.getString("P_FILE"));
				pList.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return pList;
		
	}
	
	/**
	 * 없는영화 수정페이지에서 띄울 카테고리 값들을 담기위한 메소드
	 * @author 호용 이게 문제야 ㅈ문제
	 */
	public List<Category> selectNoMovieCategory(Connection conn, int noMovieNo){
		Category c = null;
		List<Category> cMyList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoMovieCategory");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noMovieNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				c = new Category();
				c.setCategoryNo(rset.getInt("NM_GENRE_NO")); // 뭔지모를 번호
				c.setNoMovieCNo(rset.getInt("CATEGORY_NO")); // 내가 선택한 카테고리 번호
				cMyList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("cMyList에 담겨있는 값 : " + cMyList);
		return cMyList;
	}
	
	/**
	 * 없는영화 수정페이지에서 띄울 추가 첨부파일 값들을 담기위한 메소드
	 * @author 호용
	 */
	public Attachment selectAttachment(Connection conn, int noMovieNo) {
		Attachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noMovieNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				at = new Attachment();
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return at;
	}
	
	/**
	 * 없는영화신청페이지에 들어갈 때 카테고리에 띄울 카테고리명들을 담기위한 메소드
	 * @호용
	 */
	public List<Category> selectCategory(Connection conn){
		Category c = null;
		List<Category> cList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCategory");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				c = new Category();
				c.setCategoryNo(rset.getInt("CATEGORY_NO"));
				c.setCategoryName(rset.getString("CATEGORY_NAME"));
				c.setNoMovieCNo(rset.getInt("NM_GENRE_NO"));
				cList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return cList;
	}
	
	/**
	 * @param 호용
	 * @return 사용자가 신청한 없는영화 갯수를 구하기 위한 메소드, 페이징바에 활용됨
	 */
	public int selectListCount(Connection conn, int memNo) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("dao에서의 리스트카운트 : " + listCount);
		return listCount;

	}
	
	/**
	 * @author 호용
	 * 총 키워드에 맞는 없는영화신청 게시글 갯수를 구하기 위한 메소드, 페이징바에 활용됨
	 */
	public int keywordSelectListCount(Connection conn, String keyword, int memNo) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		keyword = '%' + keyword + '%';
		String sql = prop.getProperty("keywordSelectListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setString(2, keyword);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	/**
	 * @author 호용
	 * 키워드에 맞는 없는영화 신청현황에 담을 값을 구하기위한 메소드
	 */
	public List<NoMovie> selectKeywordList(Connection conn, PageInfo pi, String keyword, int memNo){
		List<NoMovie> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		keyword = '%' + keyword + '%';
		String sql = prop.getProperty("selectKeywordList");
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			pstmt.setInt(1, memNo);
			pstmt.setString(2, keyword);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new NoMovie(rset.getInt("NM_ENROLL_NO")
						           , rset.getString("NM_TITLE")
						           , rset.getString("NM_APPROVAL")
						           , rset.getString("NM_ENROLL_DATE")
						           , rset.getString("NM_REFUSE_REASON")
						           , rset.getInt("MEM_NO")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
}
