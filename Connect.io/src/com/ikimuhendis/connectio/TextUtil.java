package com.ikimuhendis.connectio;

public class TextUtil {

	public static boolean isEmpty(String text) {
		if (text != null && text.length() > 0) {
			return false;
		}
		return true;
	}
}
