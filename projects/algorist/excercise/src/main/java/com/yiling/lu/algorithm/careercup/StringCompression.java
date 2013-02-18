package com.yiling.lu.algorithm.careercup;

public class StringCompression {

	public static StringBuilder buildOutput(StringBuilder bdr, char target,
			int rep) {
		bdr.append(target);
		if (rep > 0) {
			bdr.append(Integer.toString(rep + 1));
		}
		return bdr;
	}

	public static String compressString(String s) {
		StringBuilder buf = new StringBuilder();
		if (s == null || s.length() < 2) {
			return s;
		}

		char cur = s.charAt(0);
		char pre = cur;
		int rep = 0;

		for (int i = 1; i < s.length(); i++) {
			cur = s.charAt(i);
			if (cur == pre) {
				rep++;
			} else {
				buf = buildOutput(buf, pre, rep);
				pre = cur;
				rep = 0;
			}
		}
		buf = buildOutput(buf, pre, rep);
		return buf.toString();
	}
}
