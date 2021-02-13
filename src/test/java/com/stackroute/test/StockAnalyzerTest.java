package com.stackroute.test;

import com.stackroute.StockAnalyzer;
import com.stackroute.StockRecord;
import com.stackroute.exception.InvalidDateException;
import com.stackroute.exception.NoRecordFoundException;
import com.stackroute.exception.StockRecordNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

public class StockAnalyzerTest {
    private StockAnalyzer stockAnalyzer;
    private StockRecord[] stockRecords;
    private SimpleDateFormat formatter;

    @BeforeEach
    public void setUp() throws ParseException {
        stockAnalyzer = new StockAnalyzer("files/CIPLA_SAMPLE.csv");

        formatter = new SimpleDateFormat("yyyy-MM-dd");

        stockRecords = new StockRecord[6];
        stockRecords[0] = new StockRecord(formatter.parse("2015-08-03"), 713.799988, 716.950012,
                705.000000, 712.299988, 696.087708, 916688);
        stockRecords[1] = new StockRecord(formatter.parse("2015-08-04"), 717.950012, 717.950012,
                703.099976, 709.650024, 709.650024, 1237267);
        stockRecords[2] = new StockRecord(formatter.parse("2015-08-05"), 710.950012, 721.900024,
                709.000000, 718.599976, 702.244202, 1274983);
        stockRecords[3] = new StockRecord(formatter.parse("2015-08-06"), 724.700012, 728.849976,
                713.500000, 715.150024, 698.872803, 980254);
        stockRecords[4] = new StockRecord(formatter.parse("2015-08-07"), 717.400024, 723.500000,
                710.750000, 715.250000, 698.970642, 914543);
        stockRecords[5] = new StockRecord(formatter.parse("2015-08-08"), 719.000000, 729.000000,
                713.950012, 719.200012, 704.801392, 1636795);
        stockAnalyzer.setStockRecordList(stockRecords);

    }

    @AfterEach
    public void tearDown() {
        stockAnalyzer = null;
    }

    @Test
    public void givenValidFilePathShouldReadNoOfLinesFromFile() throws FileNotFoundException, NoRecordFoundException {
        int count = stockAnalyzer.validStockRecordCount();
        assertEquals(10, count, "Check the logic for counting valid records");
    }

    @Test
    public void givenInvalidFilePathShouldThrowException() {
        stockAnalyzer.setFilePath("files/CIPLA2_SAMPLE.csv");
        assertThrows(FileNotFoundException.class, () -> {
            stockAnalyzer.validStockRecordCount();
        });
    }

    @Test
    public void givenValidFilePathWhenNoValidRecordsThenThrowException() {
        stockAnalyzer.setFilePath("files/CIPLA_SAMPLE2.csv");
        assertThrows(NoRecordFoundException.class, () -> {
            stockAnalyzer.validStockRecordCount();
        });
    }

    @Test
    public void givenValidFilePathThenPopulateValidRecordsFromFile() throws ParseException, NoRecordFoundException, IOException {
        stockAnalyzer.setStockRecordList(null);
        stockAnalyzer.loadRecordsFromFile();
        final StockRecord[] stockRecordList = stockAnalyzer.getStockRecordList();
        assertNotNull(stockRecordList, "The stockRecordList should be populated with valid records from the file and should not be null");
        assertEquals(10, stockRecordList.length, "The stockRecordList should be populated with valid records from the file and should not be null");
    }

    @Test
    public void givenValidRecordsThenReturnNetReturnPercentageBetweenFirstAndLastRecord() throws StockRecordNotFoundException {
        assertEquals(0.96, stockAnalyzer.findNetReturn(), 0.01);
    }

    @Test
    public void givenValidDateShouldReturnClosingStockPrice() throws InvalidDateException, StockRecordNotFoundException {
        assertEquals(719.200012, stockAnalyzer.findClosingStockPrice("2015-08-08"));
    }

    @Test
    public void givenInvalidDateFormatShouldThrowException() throws IOException, ParseException, NoRecordFoundException {
        assertThrows(InvalidDateException.class, () -> {
            stockAnalyzer.findClosingStockPrice("04/09/15");
        }, "Should throw exception if input date is invalid");
    }

    @Test
    public void givenValidRecordsThenReturnNetReturnPercentageBetweenTwoDates() throws StockRecordNotFoundException, InvalidDateException {
        assertEquals(0.78911, stockAnalyzer.findNetReturn("2015-08-04", "2015-08-07"), 0.01);
    }

    @Test
    public void givenValidFileAndDatesShouldReturnInvestmentValue() throws StockRecordNotFoundException, InvalidDateException {
        assertEquals(10088.445, stockAnalyzer.findInvestmentValue(10000,
                "2015-08-03", "2015-08-05"), 0.01);
    }


    @Test
    public void givenValidRecordsShouldReturnHighestClosingPrice() {
        assertEquals(719.200012, stockAnalyzer.findHighestClosingStockPrice());
    }

    @Test
    public void givenValidArrayShouldReturnSortedArrayByDate() throws ParseException {
        StockRecord record1 = new StockRecord(formatter.parse("2015-08-02"), 713.799988, 716.950012,
                705.000000, 712.299988, 696.087708, 916688);
        StockRecord record2 = new StockRecord(formatter.parse("2015-08-29"), 713.799988, 716.950012,
                705.000000, 712.299988, 696.087708, 916688);
        stockRecords[5] = record1;
        stockRecords[0] = record2;
        StockRecord[] sortedStockRecords = stockAnalyzer.sortByDate(stockRecords);
        assertEquals(sortedStockRecords[0], record1);
        assertEquals(sortedStockRecords[5], record2);
    }

    @Test
    public void givenValidRecordsShouldReturnAvgDailyReturn() throws IOException, ParseException {
        assertEquals(0.00195, stockAnalyzer.findAvgDailyReturn(),0.01);
    }
}