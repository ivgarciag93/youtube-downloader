package org.ivione93;

import io.quarkus.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConverterFindPage extends ConverterPage {

  static By youtubeLinkValueById = By.id("url");
  WebElement youtubeLinkValue;

  static By convertButtonByXPath = By.xpath("/html/body/form/div[2]/input");
  WebElement convertButton;

  public ConverterFindPage(WebDriver driver) {
    super(driver);
  }

  public DownloadPage findLink(String url) {
    Log.info("=================");
    Log.info("============ FIND");
    Log.infof("Searching for: %s", url);

    youtubeLinkValue = wait.until(ExpectedConditions.visibilityOfElementLocated(youtubeLinkValueById));

    youtubeLinkValue.clear();
    youtubeLinkValue.sendKeys(url);

    convertButton = wait.until(ExpectedConditions.visibilityOfElementLocated(convertButtonByXPath));
    convertButton.click();

    waitABit.accept(driver);

    return PageFactory.initElements(driver, DownloadPage.class);
  }
}
