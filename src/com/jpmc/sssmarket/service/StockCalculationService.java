package com.jpmc.sssmarket.service;

import java.util.List;

import com.jpmc.sssmarket.bo.Stock;
import com.jpmc.sssmarket.bo.Trade;
import com.jpmc.sssmarket.exceptions.StockCalculationException;

public interface StockCalculationService {

	/**
	 * Calculates the stock price for a given list of trades.
	 * 
	 * @param trades
	 *            the list of trades
	 * @throws StockCalculatorException
	 */
	public double calculateStockPrice(List<Trade> trades)
			throws StockCalculationException;

	/**
	 * Calculates geometric mean
	 * 
	 * @param stocks
	 *            the geometric mean
	 */
	public double calculateGeometricMean(List<Stock> stocks);

	/**
	 * Calculates the shares indexes for a given list of stocks.
	 * 
	 * @param stocks
	 *            the list of stocks
	 */
	public double calculateSharesIndexes(List<Stock> stocks);
}
