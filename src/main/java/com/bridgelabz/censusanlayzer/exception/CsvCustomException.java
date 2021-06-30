package com.bridgelabz.censusanlayzer.exception;

import com.bridgelabz.censusanlayzer.type.ExceptionType;

public class CsvCustomException extends Exception {

	private static final long serialVersionUID = 7810372375104735029L;

	ExceptionType type;

	public CsvCustomException(String message) {
		super(message);
	}

	public CsvCustomException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}

	public CsvCustomException(ExceptionType type, String message, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
}
