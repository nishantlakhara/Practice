package com.exceptions;

public class ExceptionTest {
	public static void main(String[] args) throws MyException {
		throw new MyException("An exception occured:");
	}
}
