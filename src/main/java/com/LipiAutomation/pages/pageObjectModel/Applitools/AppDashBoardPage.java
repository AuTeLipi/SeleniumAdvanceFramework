package com.LipiAutomation.pages.pageObjectModel.Applitools;

import com.LipiAutomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppDashBoardPage extends CommonToAllPage {

    WebDriver driver;

    public AppDashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By AmountElements = By.xpath("//td[@class='text-right bolder nowrap']");

    public double ADashBoardPage() {

        List <WebElement> spanElements = findElements(AmountElements);

        double TotalAmount = 0.0;

        for (WebElement span : spanElements) {
            String text = span.getText().trim();
            if (text.isEmpty()) {
                throw new IllegalArgumentException("Span is empty");
            }

            String [] parts = text.split("\\s+");

            if (parts.length < 2) {
                throw new IllegalArgumentException("Invalid span format: " + text);
            }

            String sign = parts[0];
            String amountStr = parts[1];

            amountStr = amountStr.replace(",", "");

            double amount;
            try {
                amount = Double.parseDouble(amountStr);
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException("Invalid Amount: " + amountStr);
            }

            if(sign.equals("+")) {
                TotalAmount += amount;
            } else if(sign.equals("-")) {
                TotalAmount -= amount;
            } else {
                throw new IllegalArgumentException("Invalid sign: " + sign);
            }
        }

        System.out.println("Total Amount spent = " +TotalAmount+ " USD");
        return TotalAmount;
    }

}
