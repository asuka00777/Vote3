package vote;

import java.util.ArrayList;
import java.util.HashMap;

public class SortLogic {

	public static void execute(ArrayList<String> songNames, HashMap<String, Integer> votesList) {

		/**
		 * songNamesの要素を得票数で昇順に並び替える処理
		 * 
		 */
		for (int i = 0; i < songNames.size() - 1; i++) {
			for (int j = i + 1; j < songNames.size(); j++) {
				if (votesList.get(songNames.get(j)) > votesList.get(songNames.get(i))) { // 0番目と1番目の得票数を比較して1番目の方が多かったら
					String temp=songNames.get(i);		//小さかった方の曲名をtempに代入
					songNames.set(i, songNames.get(j));		//songNamesのi番目に多かった方の曲名をセット
					songNames.set(j, temp);		//songNamesのj番目に少なかった方の曲名をセット
				}
			}
		}
	}

}
