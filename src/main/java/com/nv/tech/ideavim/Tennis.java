package com.nv.tech.ideavim;

/**
 * @author luke
 */
public class Tennis {

	private long firstPlayerScoreTimes;

	public String score() {
		if (firstPlayerScoreTimes == 1) {
			return "fifteen love";
		}
		return "love all";
	}

	public void firstPlayerScore() {
		firstPlayerScoreTimes++;
	}
}
