package com.jpmc.sssmarket.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jpmc.sssmarket.bo.Stock;
import com.jpmc.sssmarket.bo.Trade;
import com.jpmc.sssmarket.enums.StockType;
import com.jpmc.sssmarket.enums.TradeType;
import com.jpmc.sssmarket.exceptions.StockCalculationException;
import com.jpmc.sssmarket.service.StockCalculationService;

public class StockCalculationServiceImplTest {

	  
    private StockCalculationService stockCalculationService = new StockCalculationServiceImpl();

    /**
     * Test of @see StockCalculatorServiceImpl.calculateStockPrice(List<Trade>)
     */
    @Test
    public void testCalculateStockPrice() throws StockCalculationException {
      
        Stock tea = new Stock("TEA", StockType.COMMON, 0d, null, 100d, 110d);

        Trade trade1 = new Trade(new Date(),1000d, TradeType.BUY, 110d,tea);
        Trade trade2 = new Trade(new Date(),300d, TradeType.SELL, 102d,tea);
      
        List<Trade> trades = new ArrayList<Trade>();
        trades.add(trade1);
        trades.add(trade2);
      
		  Assert.assertEquals(108.15,
                           stockCalculationService.calculateStockPrice(trades), 0.1d);
    }
  
    /**
     * Test of @see StockCalculatorServiceImpl.calculateSharesIndexes(List<Stock>)
     */
    @Test
    public void testCalculateSharesIndexes() {
        
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

		  Assert.assertEquals(0.17938927757244394d,
                           stockCalculationService.calculateSharesIndexes(stocks), 0d);
    }
}
