package com.jpmc.sssmarket.service.impl;

import java.util.List;

import com.jpmc.sssmarket.bo.Stock;
import com.jpmc.sssmarket.bo.Trade;
import com.jpmc.sssmarket.exceptions.StockCalculationException;
import com.jpmc.sssmarket.helper.StockMarketHelper;
import com.jpmc.sssmarket.helper.impl.StockMarketHelperImpl;
import com.jpmc.sssmarket.service.StockCalculationService;

public class StockCalculationServiceImpl implements StockCalculationService {

	private StockMarketHelper stockMarketHelper = new StockMarketHelperImpl();

	/*
	 * @see
	 * com.jpmc.sssmarket.service.StockCalculationService.StockCalculatorService
	 * #calculateStockPrice(java.util.List)
	 */
	@Override
	public double calculateStockPrice(List<Trade> trades)
			throws StockCalculationException {
		if (trades == null) {
			return 0d;
		}

		double[] tradesPrices = new double[trades.size()];
		double[] tradesQuantities = new double[trades.size()];

		int i = 0;
		for (Trade trade : trades) {
			tradesPrices[i] = trade.getTradedPrice();
			tradesQuantities[i] = trade.getQuantity();
			i++;
		}

		return stockMarketHelper.calculateStockPrice(tradesPrices,
				tradesQuantities);
	}

	/*
	 * @see
	 * com.jpmc.sssmarket.service.StockCalculationService.StockCalculatorService
	 * #calculateGeometricMean(java.util.List)
	 */
	@Override
	public double calculateGeometricMean(List<Stock> stocks) {
		double[] tradePrices = new double[stocks.size()];
		double totalParValues = 0d;

		int i = 0;
		for (Stock stock : stocks) {
			totalParValues += stock.getParValue();
			tradePrices[i] = stock.getPrice();
			i++;
		}

		double geometricMean = stockMarketHelper
				.calculateGeometricMean(tradePrices);
		return geometricMean / totalParValues;
	}

	/*
	 * @see
	 * com.jpmc.sssmarket.service.StockCalculationService.StockCalculatorService
	 * #calculateSharesIndexes(java.util.List)
	 */
	@Override
	public double calculateSharesIndexes(List<Stock> stocks) {
		double[] tradesPrices = new double[stocks.size()];
		double totalParValues = 0d;

		int i = 0;
		for (Stock stock : stocks) {
			totalParValues += stock.getParValue();
			tradesPrices[i] = stock.getPrice();
			i++;
		}
		double geometricMean = stockMarketHelper
				.calculateGeometricMean(tradesPrices);
		return geometricMean / totalParValues;
	}

}
