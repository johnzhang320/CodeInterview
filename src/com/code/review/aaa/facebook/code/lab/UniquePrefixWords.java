package com.code.review.aaa.facebook.code.lab;

import java.util.ArrayList;
import java.util.List;

public class UniquePrefixWords {
/**
 * There are String array
 * Input {"zebra", "dog", "duck", "dove"};
 * find unique prefix from each words, that's word which is not other prefix 
 * output {"z", "dog", "du", "dov"}
 * My approach, using substring, from first shortest string , check each word, if repeat, count++;
 */
	public static List<String> findUniquePrefix(String str[]) {
		List<String> result = new ArrayList<String>();
		int wordNum = str.length;
		for (int i=0;i<wordNum;i++) {
			String curr = str[i];
			int max = Integer.MIN_VALUE;
			for (int j=0; j<wordNum; j++) {
				if (i!=j) {
					int k = getNonPrefix(curr, str[j]);
					if (k!=-1) {
						max = Math.max(max, k);
					}
				}
			}
			if (max!=Integer.MIN_VALUE) {
				result.add(curr.substring(0, max));
			}
		}
		return result;
	}
	public static int getNonPrefix(String s, String str) {
		char sc[] = s.toCharArray();
		char strc[] = str.toCharArray();
		int j = 0;
		
		if (s.equals(str)) {
			return -1;
		}
		
		while (j<sc.length & j<strc.length) {
			if (sc[j]==strc[j]) {
				j++;
			} else {
				j++; // 
				break;
			}
		}
		return j;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="how";
		System.out.println(getNonPrefix("z","document"));
		System.out.println(getNonPrefix("dog","document"));
		
		System.out.println(getNonPrefix("document","document"));
		System.out.println(getNonPrefix("documext","document"));
		String str[] = {"zebra", "dog", "duck", "dove"};
		List<String> result = findUniquePrefix(str);
		for (String ss: result) {
			System.out.println(ss);
		}
	}
	

}
