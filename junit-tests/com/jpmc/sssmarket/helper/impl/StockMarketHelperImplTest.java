package com.jpmc.sssmarket.helper.impl;

import com.jpmc.sssmarket.exceptions.StockCalculationException;
import com.jpmc.sssmarket.helper.StockMarketHelper;

import org.junit.Test;
import org.junit.Assert;

public class StockMarketHelperImplTest {
	private StockMarketHelper stockMarketHelper = new StockMarketHelperImpl();

	/**
	 * Test method for @see
	 * StockMarketHelperImpl.calculateDividendYieldCommon(double, double)
	 */
	@Test
	public void testcalculateCommonDividendYield() {
		Assert.assertEquals(0.06d,
				stockMarketHelper.calculateCommonDividendYield(1.5d, 25d), 0d);

		Assert.assertEquals(0d,
				stockMarketHelper.calculateCommonDividendYield(0d, 25d), 0d);

		double result = stockMarketHelper
				.calculateCommonDividendYield(1.5d, 0d);

		Assert.assertTrue(result == Double.POSITIVE_INFINITY
				|| result == Double.NEGATIVE_INFINITY);
	}

	/**
	 * Test method for @see
	 * StockCalculatorHelperImpl.calculatePreferredDividendYield(double, double,
	 * double)
	 */
	@Test
	public void testCalculatePreferredDividendYield() {
		Assert.assertEquals(0.4d, stockMarketHelper
				.calculatePreferredDividendYield(0.5d, 20d, 25d), 0d);

		Assert.assertEquals(0d, stockMarketHelper
				.calculatePreferredDividendYield(0.5d, 0d, 25d), 0d);

		Assert.assertEquals(
				0d,
				stockMarketHelper.calculatePreferredDividendYield(0d, 20d, 25d),
				0d);

		double result = stockMarketHelper.calculatePreferredDividendYield(0.5d,
				20d, 0d);

		Assert.assertTrue(result == Double.POSITIVE_INFINITY
				|| result == Double.NEGATIVE_INFINITY);
	}

	/**
	 * Test method for @see StockCalculatorHelper.calculatePeRatio(double,
	 * double)
	 */
	@Test
	public void testCalculatePERatio() {
		Assert.assertEquals(22.05128205128205d,
				stockMarketHelper.calculatePERatio(43d, 1.95d), 0d);

		Assert.assertEquals(0d, stockMarketHelper.calculatePERatio(0d, 1.95d),
				0d);

		double result = stockMarketHelper.calculatePERatio(43d, 0d);

		Assert.assertTrue(result == Double.POSITIVE_INFINITY
				|| result == Double.NEGATIVE_INFINITY);
	}

	/**
	 * Test method for @see
	 * StockCalculatorHelper.calculateGeometricMean(double...)
	 */
	@Test
	public void testCalculateGeometricMean() {
		Assert.assertEquals(0d,
				stockMarketHelper.calculateGeometricMean(new double[] { 0d }),
				0d);

		Assert.assertEquals(
				23.321576831999096,
				stockMarketHelper.calculateGeometricMean(new double[] { 43d,
						1.95d, 56d, 63d }), 0d);

		Assert.assertEquals(
				0d,
				stockMarketHelper.calculateGeometricMean(new double[] { 0d,
						1.95d }), 0d);
	}

	/**
	 * Test method for @see StockCalculatorHelper.calculateStockPrice(double,
	 * double)
	 */
	@Test
	public void testCalculateStockPrice() throws StockCalculationException {

		Assert.assertEquals(0d,
				stockMarketHelper.calculateStockPrice(null, null), 0d);

		try {

			stockMarketHelper.calculateStockPrice(
					new double[] { 24d, 13d, 2.5d }, null);

			Assert.fail("A StockCalculatorException must have been thrown");

		} catch (StockCalculationException sce) {
		}

		try {

			this.stockMarketHelper.calculateStockPrice(new double[] { 24d, 13d,
					2.5d }, new double[] { 4d, 8d, 10d, 12d });

			Assert.fail("A StockCalculatorException must have been thrown");

		} catch (StockCalculationException sce) {
		}

		Assert.assertEquals(
				10.22727272727272727,
				stockMarketHelper.calculateStockPrice(new double[] { 24d, 13d,
						2.5d }, new double[] { 4d, 8d, 10d }), 0d);
	}
}
