# Problem Statement - The Stock Analyzer

This Challenge is related to the Stock Market where shares/stocks are traded on a daily basis by buyers and sellers. **Stock Analysis** is a method for investors and traders to make buying and selling decisions for a stock. By studying and 
evaluating past and current data, investors and traders attempt to gain an edge in the markets by making informed decisions.

In this challenge, you need to build a Stock Analyzer - that will attempt to analyze the historical data of a given stock. The stocks historical data is available as a CSV(Comma Separated Value) file named `CIPLA.NS.CSV` in the folder named `files`.

The file contains the following data for a given stock
  - Date    - Date of trading
  - High    - the highest price of the stock on given date
  - Low     - the lowest price of the stock on given date
  - Close   - Closing price of the stock on given date
  - Adj close - Adjusted Closing price of the stock on given date
  - Volume  - Number of stocks traded(bought/sold) on given date


Following are the key objectives for this challenge:

 - The stock prices of Cipla, a pharmaceutical company for last 5 years listed in NSE are given in the file(refer the data file CIPLA.NS.CSV provided as sample)


 - Find the number of valid records in the file. Headers must not be counted as a record.

 - Load the valid records from the file.     

 - Following functionalities assume that the data is read from file and already loaded in the program.
   Provide a solution to the following requirements, your solution should be able to:
    - Find the net return percentage for the stock
    - Find closing stock price for the given date
    - Find net return percentage between two dates given
    - Provide the value of one's investment on a particular date. 
      For instance - if a person has invested some amount on the stock on a particular date, the application should be able to provide an answer on what is the value of one's investment on another date which is specified by the user
    - Find the highest price for the stock for the available range of dates
    - Find the daily average return of the stock. 

**Note**
 - Return is the rate of profit/loss made on Investment that can be realised, if the stock is sold
 - For all return calculations, the stock close price should be used(not Adjusted close price)
 - You need take care of all exceptional situation that might occur during reading the file, parsing the values etc.
 - Do not change the content of provided files
