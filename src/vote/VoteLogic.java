package vote;

import java.util.ArrayList;
import java.util.HashMap;

public class VoteLogic {
	public static void execute(HashMap<String, Integer> votesList, int songNumber,ArrayList<String> songNames) {
		
		/**
		 * 一票追加する処理
		 */
		String songName=songNames.get(songNumber);//songNumberから曲名を取得、例えばsongNumberが1だったら勝手にシンドバッドが入る	
		
		int newVotes=votesList.get(songName);//選択された曲の得票数をnewVotesに代入
		
		newVotes++;//得票数をプラス1
		
		votesList.put(songName, newVotes);//プラスした得票数を再びセット
	}

}
