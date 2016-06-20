package com.jpmc.sssmarket.helper.impl;

import com.jpmc.sssmarket.exceptions.StockCalculationException;
import com.jpmc.sssmarket.helper.StockMarketHelper;

public class StockMarketHelperImpl implements StockMarketHelper {

	/*
	 * @see
	 * com.jpmc.sssmarket.helper.StockMarketHelper#calculateCommonDividendYield
	 * (double, double)
	 */
	@Override
	public double calculateCommonDividendYield(double lastDividend,
			double stockPrice) {
		return lastDividend / stockPrice;
	}

	/* 
	 * @see
	 * com.jpmc.sssmarket.helper.StockMarketHelper#calculatePreferredDividendYield
	 * (double, double, double)
	 */
	@Override
	public double calculatePreferredDividendYield(double fixedDividend,
			double parValue, double stockPrice) {
		return (fixedDividend * parValue) / stockPrice;
	}

	/*
	 * @see com.jpmc.sssmarket.helper.StockMarketHelper#calculatePERatio(double,
	 * double)
	 */
	@Override
	public double calculatePERatio(double stockPrice, double dividend) {
		return stockPrice / dividend;
	}

	/*
	 * @see
	 * com.jpmc.sssmarket.helper.StockMarketHelper#calculateGeometricMean(double
	 * [])
	 */
	@Override
	public double calculateGeometricMean(double[] tradePrices) {

		if (tradePrices == null || tradePrices.length == 0) {
			return 0d;
		}
		double geometricMean = 1.0d;

		for (int i = 0; i < tradePrices.length; i++) {

			geometricMean *= tradePrices[i];
		}

		Double n = new Double(tradePrices.length);

		return Math.pow(geometricMean, (1.0d / n));
	}

	/*
	 * @see
	 * com.jpmc.sssmarket.helper.StockMarketHelper#calculateStockPrice(double[],
	 * double[])
	 */
	@Override
	public double calculateStockPrice(double[] tradePrices,
			double[] tradeQuantities) throws StockCalculationException {
		if (tradePrices == null || tradePrices.length == 0) {

			return 0d;
		}

		if (tradeQuantities == null) {

			throw new StockCalculationException(
					"Trade quantities array cannot be blank");
		}

		if (tradePrices.length != tradeQuantities.length) {

			throw new StockCalculationException(
					"Trade quantity and price are of different length.");
		}

		double pricesPerQuantities = 0d;
		double quantities = 0d;

		for (int i = 0; i < tradePrices.length; i++) {

			pricesPerQuantities += tradePrices[i] * tradeQuantities[i];

			quantities += tradeQuantities[i];
		}

		return pricesPerQuantities / quantities;
	}

}
