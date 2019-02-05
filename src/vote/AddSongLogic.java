package vote;

import java.util.ArrayList;
import java.util.HashMap;

public class AddSongLogic {
	
	public static void execute(HashMap<String, Integer> votesList,ArrayList<String> songNames,String songName){
		/**
		 * 曲目を追加する処理
		 */
		songNames.add(songName);	//songNamesにsongNameを新しく追加
		votesList.put(songName, 1);//votesListにsongNameを新しく追加、票も1票追加
		
	}
}
