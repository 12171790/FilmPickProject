package com.fp.admin.controller.ad_member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fp.admin.model.service.MemberService;
import com.fp.admin.model.vo.ReportedMember;
import com.fp.common.model.vo.PageInfo;

/**
 * Servlet implementation class RestrictedMemberListController
 */
@WebServlet("/rslist.me")
public class RestrictedMemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestrictedMemberListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount; 
		int currentPage;
		int pageLimit; 
		int boardLimit; 
		int maxPage; 
		int startPage; 
		int endPage; 
		
		listCount = new MemberService().selectRestrictedMemberListCount();
		
		currentPage = Integer.parseInt(request.getParameter("page"));
		
		pageLimit = 5;
		
		boardLimit = 10;
		
		maxPage = (int) Math.ceil((double) listCount / boardLimit);

		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		List<ReportedMember> pageList = new MemberService().selectRestrictedMemberList(pi);
		System.out.println(pageList);
		
		request.setAttribute("pi", pi);
		request.setAttribute("pageList", pageList);
		
		request.getRequestDispatcher("/views/admin/ad_member/restrictedMemberList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
