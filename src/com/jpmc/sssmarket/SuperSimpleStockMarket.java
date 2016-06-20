package com.jpmc.sssmarket;

import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.jpmc.sssmarket.bo.Stock;
import com.jpmc.sssmarket.bo.Trade;
import com.jpmc.sssmarket.enums.StockType;
import com.jpmc.sssmarket.enums.TradeType;
import com.jpmc.sssmarket.exceptions.StockCalculationException;
import com.jpmc.sssmarket.helper.StockMarketHelper;
import com.jpmc.sssmarket.helper.impl.StockMarketHelperImpl;
import com.jpmc.sssmarket.service.StockCalculationService;
import com.jpmc.sssmarket.service.impl.StockCalculationServiceImpl;

/**
 * Main class for running the super simple stock market
 */
public class SuperSimpleStockMarket {
	public static void main(String[] args) throws StockCalculationException {
		StockMarketHelper stockMarketHelper = new StockMarketHelperImpl();
		StockCalculationService stockCalculationService = new StockCalculationServiceImpl();

		List<Stock> stocks = getInputStocks();
		Stock stock = null;
		Trade trade = null;
		List<Trade> trades = null;
		Random random = new Random();
		int nbTrades = random.nextInt(100 - 10 + 1) + 10;
		Map<Stock, List<Trade>> map = new HashMap<Stock, List<Trade>>();
		for (int i = 0; i < nbTrades; i++) {
			stock = stocks.get(random.nextInt(stocks.size() - 1));
			trades = map.get(stock);
			if (trades == null) {
				trades = new ArrayList<Trade>();
				map.put(stock, trades);
			}
			trade = new Trade(new Date(), (random.nextDouble() * 1000d + 50d),
					random.nextBoolean() ? TradeType.BUY : TradeType.SELL,
					(random.nextDouble() * 1000d + 50d), stock);
			trades.add(trade);
		}
		printOutput(stockMarketHelper, stockCalculationService, stocks, map);
	}

	/**
	 * Method to print the desired output
	 * @param stockMarketHelper
	 * @param stockCalculationService
	 * @param stocks
	 * @param map
	 * @throws StockCalculationException
	 */
	private static void printOutput(StockMarketHelper stockMarketHelper,
			StockCalculationService stockCalculationService,
			List<Stock> stocks, Map<Stock, List<Trade>> map)
			throws StockCalculationException {
		List<Trade> trades;
		StringBuffer buff = null;

		System.out
				.println("+--------+----------------+-----------+-------------+");
		System.out
				.println("| Symbol | Dividend yield | P/E ratio | Stock price |");
		System.out
				.println("+--------+----------------+-----------+-------------+");

		for (Stock stock : stocks) {
			Formatter formatter = null;
			try {
				trades = map.get(stock);
				buff = new StringBuffer();
				formatter = new java.util.Formatter(buff);
				String stockSymbol = stock.getStockSymbol();
				formatter.format("| %6s | %14.2f | %9.2f | %11.2f |",
						stockSymbol,
						getDividendYield(stockMarketHelper, stock),
						getPERatio(stockMarketHelper, stock),
						stockCalculationService.calculateStockPrice(trades));
				System.out.println(buff);
				System.out
						.println("+--------+----------------+-----------+-------------+");
			} finally {
				formatter.close();
			}

		}
		Formatter formatter = null;
		try {
			System.out.println("+----------------+");
			System.out.println("| GBCE All share |");
			System.out.println("+----------------+");

			buff = new StringBuffer();
			formatter = new java.util.Formatter(buff);

			formatter.format("| %14.2f |",
					stockCalculationService.calculateSharesIndexes(stocks));
			System.out.println(buff);
			System.out.println("+----------------+");
		} finally {
			formatter.close();
		}

	}

	/** method to calculate the PE ratio
	 * @param stockMarketHelper
	 * @param stock
	 * @return
	 */
	private static double getPERatio(StockMarketHelper stockMarketHelper,
			Stock stock) {
		return stockMarketHelper.calculatePERatio(stock.getParValue(),
				stock.getLastDividend());
	}

	/**
	 * Method to get the dividend yield
	 * @param stockMarketHelper
	 * @param stock
	 * @return
	 */
	private static double getDividendYield(StockMarketHelper stockMarketHelper,
			Stock stock) {
		StockType stockType = stock.getStockType();

		if (stockType.equals(StockType.COMMON)) {
			return stockMarketHelper.calculateCommonDividendYield(
					stock.getParValue(), stock.getLastDividend());
		} else {
			return stockMarketHelper.calculatePreferredDividendYield(
					stock.getParValue(), stock.getParValue(),
					stock.getFixedDividend());
		}

	}

	/**
	 * Method to get the input stocks
	 */
	private static List<Stock> getInputStocks() {
		Stock tea = new Stock("TEA", StockType.COMMON, 0d, null, 100d, 110d);
		Stock pop = new Stock("POP", StockType.COMMON, 8d, null, 100d, 120d);
		Stock ale = new Stock("ALE", StockType.COMMON, 23d, null, 60d, 55d);
		Stock gin = new Stock("GIN", StockType.PREFERRED, 8d, 2d, 100d, 100d);
		Stock joe = new Stock("JOE", StockType.COMMON, 13d, null, 250d, 216.12d);

		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(tea);
		stocks.add(pop);
		stocks.add(ale);
		stocks.add(gin);
		stocks.add(joe);
		return stocks;
	}
}
