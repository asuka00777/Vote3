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
 * Servlet implementation class VoteServlet
 */
@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");

		/**
		 * 曲名のリストと得票数のリストをセッションスコープから取得
		 */
		HttpSession session = request.getSession();
		ArrayList<String> songNames = (ArrayList<String>) session.getAttribute("songNames");
		HashMap<String, Integer> votesList = (HashMap<String, Integer>) session.getAttribute("votesList");

		/**
		 * アンケートフォームから送られてきた曲番号を取得 
		 * VoteLogicで取得した曲番号に該当する曲の得票数を1票増やす
		 */
		String songNumStr = request.getParameter("songNumber");
		try {
			int songNumber = Integer.parseInt(songNumStr);
			VoteLogic.execute(votesList, songNumber, songNames);
		} catch (NumberFormatException e) {
		}
		
		/**
		 * フォワード処理
		 */
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/vote.jsp");
		rd.forward(request, response);

	}

}
