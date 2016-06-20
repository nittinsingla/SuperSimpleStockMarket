package com.jpmc.sssmarket.bo;

import java.util.Date;

import com.jpmc.sssmarket.enums.TradeType;

/**
 * Class representing the trade
 */
public class Trade {

	/* The time stamp when the trade happened */
	private Date timestamp;

	/* The quantity of stocks traded */
	private Double quantity;

	/* The type of the trade i.e. buy or sell */
	private TradeType tradeType;

	/* The price at which the stock was traded */
	private Double tradedPrice;

	/* The name of the stock for which the trade happened */
	private Stock stock;

	public Trade(Date timestamp, Double quantity, TradeType tradeType,
			Double tradedPrice, Stock stock) {
		this.timestamp = timestamp;
		this.quantity = quantity;
		this.tradeType = tradeType;
		this.tradedPrice = tradedPrice;
		this.stock = stock;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}

	public Double getTradedPrice() {
		return tradedPrice;
	}

	public void setTradedPrice(Double tradedPrice) {
		this.tradedPrice = tradedPrice;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Trade [timestamp=" + timestamp + ", quantity=" + quantity
				+ ", tradeType=" + tradeType + ", tradedPrice=" + tradedPrice
				+ ", stock=" + stock + "]";
	}

}
