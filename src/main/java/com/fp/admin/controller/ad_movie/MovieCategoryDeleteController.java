package com.fp.admin.controller.ad_movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fp.admin.model.service.CommunityService;
import com.fp.admin.model.service.MovieService;

/**
 * Servlet implementation class MovieCategoryDeleteController
 */
@WebServlet("/deleteCategory.admo")
public class MovieCategoryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieCategoryDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String categoryList = request.getParameter("cateList");
		String[] cateList = new String[1];
		int result = 0;
		System.out.println(categoryList);
		if(categoryList.indexOf(",") == -1) {
			cateList[0] = categoryList;
			result = new MovieService().deleteCategory(cateList);
		}else {
			cateList = categoryList.split(",");
			result = new MovieService().deleteCategory(cateList);
		}
		
		HttpSession session = request.getSession();
		if(result >0) {
			session.setAttribute("alertMsg", "해당 카테고리가 성공적으로 삭제되었습니다");
			response.sendRedirect(request.getContextPath()+"/movieCategoryForm.admo");
		}else {
			session.setAttribute("alertMsg", "카테고리 삭제 실패");
			response.sendRedirect(request.getContextPath()+"/movieCategoryForm.admo");
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
