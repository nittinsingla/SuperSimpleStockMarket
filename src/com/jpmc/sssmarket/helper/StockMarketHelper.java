package com.jpmc.sssmarket.helper;

import com.jpmc.sssmarket.exceptions.StockCalculationException;

public interface StockMarketHelper {

	/**
	 * Calculates the dividend yield for a common stock type
	 * 
	 * @param lastDividend
	 *            the last dividend of the stock
	 * @param stockPrice
	 *            the stock price
	 * @return the stock dividend yield
	 */
	double calculateCommonDividendYield(double lastDividend, double stockPrice);

	/**
	 * Calculates the dividend yield for a preferred stock type
	 * 
	 * @param stockPrice
	 *            the stock value price
	 * @param parValue
	 *            the stock value per share
	 * @param fixedDividend
	 *            the fixed dividend of the stock
	 * @return the preferred stock dividend yield
	 */
	double calculatePreferredDividendYield(double fixedDividend,
			double parValue, double stockPrice);

	/**
	 * calculates the P/E ratio for a given stock price and last dividend,
	 * 
	 * @param dividend
	 *            the last dividend of the stock
	 * @param stockPrice
	 *            the stock value ticker price
	 * @return the stock P/E ratio
	 */
	double calculatePERatio(double stockPrice, double dividend);

	/**
	 * calculates the geometric mean for a given array of trades prices
	 * 
	 * @param tradePrices
	 *            the array of trade prices
	 * @return the geometric mean
	 */
	double calculateGeometricMean(double[] tradePrices);

	/**
	 * Calculates the stock price for a given array of trades prices and trades
	 * quantities
	 * 
	 * @param tradePrices
	 *            the array of trades prices
	 * @param tradeQuantities
	 *            the array of trades quantities
	 * @throws StockCalculationException
	 * @return the stock price
	 */
	double calculateStockPrice(double[] tradePrices, double[] tradeQuantities) 
			throws StockCalculationException;
}
