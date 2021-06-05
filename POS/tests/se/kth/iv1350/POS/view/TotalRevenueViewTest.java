package se.kth.iv1350.POS.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TotalRevenueViewTest {
    private ByteArrayOutputStream printBuffer;
    private PrintStream originalPrint;
    TotalRevenueView totalRevenueView;

    @AfterEach
    void tearDown() {
        restoreStreamOutput();
        totalRevenueView = null;
    }

    @BeforeEach
    void setUp()  {
        changeStreamOut();
        totalRevenueView = new TotalRevenueView();
    }

    @Test
    void saleRevenue(){
        totalRevenueView.executeShowTotalIncome(100);
        String printOut = this.printBuffer.toString();
        String expected = "Current revenue:";
        assertTrue(printOut.contains(expected),"Printout failed");
    }
    private void changeStreamOut(){
        printBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printBuffer);
        originalPrint = System.out;
        System.setOut(inMemSysOut);
    }
    private void restoreStreamOutput(){
        printBuffer = null;
        System.setOut(originalPrint);
    }
}