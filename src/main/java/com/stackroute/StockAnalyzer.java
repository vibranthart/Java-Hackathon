package com.stackroute;


import com.stackroute.exception.InvalidDateException;
import com.stackroute.exception.NoRecordFoundException;
import com.stackroute.exception.StockRecordNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class StockAnalyzer {
    private StockRecord[] stockRecordList;
    private String filePath;

    /**
     * Complete the constructor
     */
    public StockAnalyzer(String filePath) {
    	this.filePath = filePath;
    }

    /**
     * Complete the Setters and Getters
     */
    public StockRecord[] getStockRecordList() {
        return stockRecordList;
    }

    public void setStockRecordList(StockRecord[] stockRecordList) {
    	this.stockRecordList = stockRecordList;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
    	this.filePath = filePath;
    }
    

    /**
     * This method is used to find the number of records from the file excluding the header
     * If any record, doesn't have all the fields, it should be skipped and not counted.
     * If no valid records are found in the file, then NoRecordFoundException should be thrown
     * Assume that every file will have a valid header
     */
    public int validStockRecordCount() throws FileNotFoundException, NoRecordFoundException {
        
    	int num = 0;
        for(int i=0; i<stockRecordList.length;i++ )
        {
        	if(stockRecordList != null)
        	{
        		num++;
        	}
        }
        
    	return num;
    }

    /* This method is responsible to read from the file and load the array stockRecordList with valid Records*/
    public void loadRecordsFromFile() throws IOException, ParseException, NoRecordFoundException {
    	
    	 for(int i=0; i<stockRecordList.length;i++ )
         {
         	if(stockRecordList != null)
         	{
         		return -1;
         	}
         }
         
    }

    /* This method is used to find Net return percentage between the first and last record.
       The return should be based on the closing price */
    public double findNetReturn() throws StockRecordNotFoundException {
    	int lastVal = stockRecordList.length;
    	return (stockRecordList[0].getOpeningPrice() - stockRecordList[lastVal-1].getDayClosingPrice()) / stockRecordList[1].getOpeningPrice()*100;
   
    }

    /* This method is used to find the closing stock price on a given date.
     * Appropriate exceptions should be thrown*/
    public double findClosingStockPrice(String date) throws StockRecordNotFoundException, InvalidDateException {
        for(int i=0; i<stockRecordList.length;i++)
        {
	    	if(stockRecordList[i].getDate() == date)
	    	{
	    		return stockRecordList[i].getDayClosingPrice();
	    	}
        }
    }

    /* This method is used to find Net return percentage between the two dates.
       The return should be based on the closing price */
    public double findNetReturn(String fromDate, String toDate) throws StockRecordNotFoundException, InvalidDateException {
        return -1;
    }

    /**
     * this method is responsible for calculating the current investment value on a given evaluation date by specifying the
     * investment date and invested amount.
     * Hint: If an investor purchases x amount of stocks by investing an amount on a given date, What would be his value of his investment
     * If he sells it on an evaluation date. (Consider closing prices of stocks and assume investor can buy fractional number of stocks also)
     */
    public double findInvestmentValue(double investmentAmount, String investmentDate, String evaluationDate) throws InvalidDateException, StockRecordNotFoundException {
        return -1;
    }

    /* this is used to find the lowest closing price for the stock */
    public double findHighestClosingStockPrice() {
    	double temp = MAX_VALUE; //max value
    	for(int i=0;i<stockRecordList.length;i++)
    	{
    		if(stockRecordList[i].getDayClosingPrice() < temp)
    		{
    			temp = stockRecordList[i].getAdjustedDayClosingPrice();
    		}
    	}
        return temp;
    }

    /* this method takes an Array of Stock Records as input and returns that Array with records sorted in ascending order by date */
    public StockRecord[] sortByDate(StockRecord[] stockRecords) {
        return null;
    }

    /* this is used to find the daily avg return of the stock
    *  hint:
    *  If we have to find the daily return between 2020-03-01(d1)
    * and 2020-03-02(d2), the formula is:
	      daily return = (d2-d1)/d1*/
    public double findAvgDailyReturn() {
        return -1;

    }
}
