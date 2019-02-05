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


@WebServlet("/StartVoteServlet")
public class StartVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		/**
		 * 曲名リスト
		 * 
		 */
		ArrayList<String> songNames = new ArrayList<String>();
		songNames.add("勝手にシンドバッド");
		songNames.add("いとしのエリー");
		songNames.add("希望の轍");
		songNames.add("真夏の果実");
		songNames.add("涙のキッス");
		songNames.add("TSUNAMI");
		songNames.add("東京VICTORY");

		
		
		/**
		 * 投票用のリスト作成
		 * 曲名と票数を格納
		 * keyを曲名、valueを得票数とする
		 */
		HashMap<String, Integer> votesList=new HashMap<>();
		for (int i = 0; i < songNames.size(); i++) {
			votesList.put(songNames.get(i), 0);	//songNames.get(i)で曲名をセット、得票数の初期値は0
		}
		

		/**
		 * セッションスコープに格納
		 * 
		 */
		session.setAttribute("songNames", songNames);	//曲名が入ったリストをsongNamesという名前でセッションスコープに格納
		session.setAttribute("votesList", votesList);	//曲名と得票数が入ったリストをvotesListという名前でセッションスコープに格納

		/**
		 * フォワード処理
		 */
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/vote.jsp");
		rd.forward(request, response);

	}

}
