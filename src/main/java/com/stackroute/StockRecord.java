package com.stackroute;

import java.util.Date;

public class StockRecord {
    //Add any missing variables based on getter/setter

	private Date date;
    private double openingPrice;
    private double dayHighPrice;
    private double dayLowPrice;
    private double dayClosingPrice;
    private double adjustedDayClosingPrice;
    private long volume;

    public StockRecord() {

    }
    /**
     * Complete the constructor, getter/setter methods and toString
     * Provide appropriate parameter names for readability
     */
    public StockRecord(Date d, double op, double dhp, double dlp, double dcp, double acp, long v) {
    	this.date = d;
    	this.openingPrice = op;
    	this.dayHighPrice = dhp;
    	this.dayLowPrice = dlp;
    	this.dayClosingPrice = dcp;
    	this.adjustedDayClosingPrice = acp;
    	this.volume = v;
    	
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
    	this.date = date;
    }

    public double getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(double openingPrice) {
    	this.openingPrice = openingPrice;
    }

    public double getDayHighPrice() {
        return getDayHighPrice();
    }

    public void setDayHighPrice(double dayHighPrice) {
    	this.dayHighPrice = dayHighPrice;
    }

    public double getDayLowPrice() {
        return dayLowPrice;
    }

    public void setDayLowPrice(double dayLowPrice) {
    	this.dayLowPrice = dayLowPrice;
    }

    public double getDayClosingPrice() {
        return dayClosingPrice;
    }

    public void setDayClosingPrice(double dayClosingPrice) {
    	this.dayClosingPrice = dayClosingPrice;
    }

    public double getAdjustedDayClosingPrice() {
        return adjustedDayClosingPrice;
    }

    public void setAdjustedDayClosingPrice(double adjustedDayClosingPrice) {
    	this.adjustedDayClosingPrice = adjustedDayClosingPrice;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
    	this.volume = volume;
    }


}
