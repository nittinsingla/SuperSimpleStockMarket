package com.jpmc.sssmarket.bo;

import com.jpmc.sssmarket.enums.StockType;

/**
 * Class representing the stock
 */
public class Stock {
	/* The symbol of the stock */
	private String stockSymbol;

	/* represents the stock type whether it is common or preferred */
	private StockType stockType;

	/* The last dividend for the stock */
	private Double lastDividend;

	/* The fixed dividend for the stock */
	private Double fixedDividend;

	/* The last par value for the stock */
	private Double parValue;

	/* The price of the stock */
	private Double price;

	public Stock(String stockSymbol, StockType stockType, Double lastDividend,
			Double fixedDividend, Double parValue, Double price) {
		super();
		this.stockSymbol = stockSymbol;
		this.stockType = stockType;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
		this.price = price;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public StockType getStockType() {
		return stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public Double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public Double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public Double getParValue() {
		return parValue;
	}

	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Stock [stockSymbol=" + stockSymbol + ", stockType=" + stockType
				+ ", lastDividend=" + lastDividend + ", fixedDividend="
				+ fixedDividend + ", parValue=" + parValue + ", price=" + price
				+ "]";
	}

}
