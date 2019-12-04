package kpu.book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpu.book.domain.BookVO;
import kpu.book.persistence.BookDAO;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		String cmd = "";
		cmd = request.getParameter("key");
		
		if(cmd.equals("join")) {
			response.sendRedirect("register.html");
		}
		else if(cmd.equals("list")) {
			BookDAO dao=new BookDAO();
			ArrayList<BookVO>bookList=dao.getBookList();
			request.setAttribute("bookList", bookList);
			RequestDispatcher view=request.getRequestDispatcher("book_list.jsp");
			view.forward(request, response);
		}
		else if(cmd.equals("update")) {
			BookDAO dao=new BookDAO();
			BookVO book=dao.read(request.getParameter("id"));
			request.setAttribute("book",book);
			RequestDispatcher view=request.getRequestDispatcher("update.jsp");
			view.forward(request, response);
		}
		else if (cmd.equals("delete")) {
			BookVO bookVO = new BookVO();

			bookVO.setBookNo(request.getParameter("id"));

			BookDAO bookDao = new BookDAO();
			
			String message="";
			
			if(bookDao.delete(bookVO))message="삭제 완료";
			else message="삭제 실패";

			request.setAttribute("message", message);
			request.setAttribute("book", bookVO);

			RequestDispatcher view = request.getRequestDispatcher("result_del.jsp");
			view.forward(request, response);
		}
		else if (cmd.equals("memoAdd")) {
			response.sendRedirect("memo.html");
		}
		else if (cmd.equals("memoList")) {
			BookDAO bookDao = new BookDAO();
			
			ArrayList<BookVO>memoList=bookDao.getMemoList();
			request.setAttribute("memoList", memoList);
 
			RequestDispatcher view = request.getRequestDispatcher("result_mem.jsp");
			view.forward(request, response);
		}
		else if (cmd.equals("memoDel")) {
			BookVO bookVO = new BookVO();

			bookVO.setMemo(request.getParameter("id"));

			BookDAO bookDao = new BookDAO();
			
			String message="";

			if(bookDao.memDelete(bookVO))message="삭제 완료";
			else message="삭제 실패";
			
			request.setAttribute("message", message);

			RequestDispatcher view = request.getRequestDispatcher("result_mem_del.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String cmd = "";
		cmd = request.getParameter("key");

		if (cmd.contentEquals("join")) {
			BookVO bookVO = new BookVO();

			bookVO.setBookNo(request.getParameter("bookNo"));
			bookVO.setBookName(request.getParameter("bookname"));
			bookVO.setAuthor(request.getParameter("author"));
			bookVO.setIsCheck(request.getParameter("ischeck"));
			bookVO.setCheckDay(request.getParameter("checkDay"));

			BookDAO bookDao = new BookDAO();
			
			String message="";
			
			if(bookDao.add(bookVO))message="추가 완료";
			else message="추가 실패";

			request.setAttribute("message", message);
			request.setAttribute("book", bookVO);

			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}
		else if (cmd.contentEquals("update")) {
			BookVO bookVO = new BookVO();

			bookVO.setBookNo(request.getParameter("bookNo"));
			bookVO.setBookName(request.getParameter("bookname"));
			bookVO.setAuthor(request.getParameter("author"));
			bookVO.setIsCheck(request.getParameter("ischeck"));
			bookVO.setCheckDay(request.getParameter("checkDay"));

			BookDAO bookDao = new BookDAO();
			
			String message="";
			
			if(bookDao.update(bookVO))message="수정 완료";
			else message="수정 실패";

			request.setAttribute("message", message);
			request.setAttribute("book", bookVO);

			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}
		else if (cmd.equals("memoAdd")) {
			BookVO bookVO = new BookVO();

			bookVO.setMemo(request.getParameter("mem"));

			BookDAO bookDao = new BookDAO();
			
			bookDao.addMemo(bookVO);
			
			ArrayList<BookVO>memoList=bookDao.getMemoList();
			request.setAttribute("memoList", memoList);
 
			RequestDispatcher view = request.getRequestDispatcher("result_mem.jsp");
			view.forward(request, response);
		}
	}
}
