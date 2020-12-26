package com.nv.tech.ideavim;

import java.util.HashMap;

/**
 * @author luke
 */
public class Tennis {

	private final HashMap<Integer, String> map = new HashMap<Integer, String>() {{
		put(1, "fifteen");
		put(2, "thirty");
	}};
	private int firstPlayerScoreTimes;

	public String score() {
		if (firstPlayerScoreTimes > 0) {
			return map.get(firstPlayerScoreTimes) + " love";
		}
		return "love all";
	}

	public void firstPlayerScore() {
		firstPlayerScoreTimes++;
	}
}
