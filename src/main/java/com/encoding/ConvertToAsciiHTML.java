package com.encoding;

public class ConvertToAsciiHTML {
	public static void main(String[] args) {
		String input = "<script>alert('hello world');</script>";
		char[] chars = input.toCharArray();

		StringBuilder output = new StringBuilder();

		for (char c : chars)
		{
		    output.append("&#").append((int) c).append(";");
		}
		System.out.println("Output : " + output.toString());
	}
}
