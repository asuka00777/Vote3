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
 * Servlet implementation class AddSong
 */
@WebServlet("/AddSongServlet")
public class AddSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		/**
		 * 曲名のリストと得票数のリストをセッションスコープから取得
		 */
		HttpSession session = request.getSession();
		HashMap<String, Integer> votesList = (HashMap<String, Integer>) session.getAttribute("votesList");
		ArrayList<String> songNames = (ArrayList<String>) session.getAttribute("songNames");

		/**
		 * アンケートフォームから送られてきた曲名を取得 
		 * AddSongLogicでsongNamesとvotesListに曲目を追加
		 */
		String songName = request.getParameter("songName");
		if(songName!=""){		//何も入力していない場合を除き、処理を実行
		AddSongLogic.execute(votesList, songNames, songName);
		}
		
		/**
		 * フォワード処理
		 */
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/vote.jsp");
		rd.forward(request, response);
	}

}
