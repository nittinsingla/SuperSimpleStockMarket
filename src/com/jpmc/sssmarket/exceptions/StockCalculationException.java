package com.jpmc.sssmarket.exceptions;

/**
 * Generic exception class for any exception while calculating the formulas on
 * stocks
 */
public class StockCalculationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1827070467573537705L;

	/* 
	 * Exception with message string
	 * 
	 */
	public StockCalculationException(String message) {
		super(message);
	}
}
