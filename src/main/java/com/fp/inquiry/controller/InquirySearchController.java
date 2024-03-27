package com.fp.inquiry.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fp.common.model.vo.PageInfo;
import com.fp.inquiry.model.service.InquiryService;
import com.fp.inquiry.model.vo.Inquiry;

/**
 * Servlet implementation class InquirySearchController
 */
@WebServlet("/searchInquiry.in")
public class InquirySearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquirySearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// --------------- 페이징처리 ---------------
		int listCount;		// 현재 게시글 총 갯수
		int currentPage;	// 현재 페이지 (즉, 사용자가 요청한 페이지)
		int pageLimit;		// 페이징바의 페이지 최대갯수 (몇개 단위씩 표현할지) 우리는 5개로 하기로 함
		int boardLimit;		// 한 페이지에 보여질 공지사항 최대갯수 (몇개 단위씩 게시글 보여질지) 우리는 10개 단위로 보여지게끔 하기로 함
		// 위의 4개를 가지고 페이징바의 시작수, 끝수, 가장마지막페이지(총 페이지수)를 구해야만 페이징바 처리 가능
		int startPage;		// 사용자가 요청한 페이지 하단에 보여질 페이징바의 시작수
		int endPage;		// 사용자가 요청한 페이지 하단에 보여질 페지징바의  끝수
		int maxPage;		// 가장 마지막 페이지(총 페이지수)
		String keyword = request.getParameter("searchKeyword");
		
		// listCount : 총 키워드에 맞는 공지사항 갯수 (db로부터 조회)
		listCount = new InquiryService().keywordSelectListCount(keyword);
		// currentPage : 사용자가 요청한(클릭) 페이지 수 (현재 띄워줄 페이지 번호)
		currentPage = Integer.parseInt(request.getParameter("page"));
		// pageLimit : 페이징바의 페이지 최대 갯수 (페이징바의 목록수  단위)
		pageLimit = 5;
		// boardLimit : 공지사항의 최대 갯수(게시글 노출 단위)
		boardLimit = 10;
		//  ↑↑↑↑위 4개를 가지고 start, end, max 페이지 구하면 페이징바 구현 가능
		
		// Math.ceil은 올림처리 메소드
		// maxPage : 제일 마지막 페이지 수 (총 페이지 수)
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		// startPage : 페이징바의 시작수
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		
		// endPage : 페이징바의 끝수
		endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 페이징바를 만들기 위한 데이터 (PageInfo객체)
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		List<Inquiry> list = new InquiryService().selectKeywordList(pi, keyword);
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/serviceCenter/searchInquiryList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}