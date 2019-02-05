package vote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VoteSort
 */
@WebServlet("/VoteSort")
public class VoteSort extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		/**
		 * 曲名のリストと得票数のリストをセッションスコープから取得
		 */
		HttpSession session = request.getSession();
		HashMap<String, Integer> votesList=(HashMap<String, Integer>) session.getAttribute("votesList");
		ArrayList<String> songNames =(ArrayList<String>) session.getAttribute("songNames");
		
		SortLogic.execute(songNames,votesList);
		
		
		
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/vote.jsp");
		rd.forward(request, response);

	}

}
