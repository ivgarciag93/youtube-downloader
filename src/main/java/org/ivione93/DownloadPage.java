package org.ivione93;

import io.quarkus.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class DownloadPage extends ConverterPage {

  static By downloadButtonById =
    By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div[2]/div[1]/table/tbody[1]/tr/td[3]/button");
  WebElement downloadButton;

  static By downloadNowButtonByXpath =
    By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[2]/div/div/button");
  WebElement downloadNowButton;

  static By convertNextButtonById = By.xpath("/html/body/form/div[2]/button[2]");
  WebElement convertNextButton;

  public DownloadPage(WebDriver driver) {
    super(driver);
  }

  protected void downloadSong() {
    Log.info("============ DOWNLOADING");
    downloadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(downloadButtonById));
    downloadButton.click();
    closeIfSecondTab();
    downloadNowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(downloadNowButtonByXpath));
    downloadNowButton.click();
    Log.info("Start download");
    downloadButton.click();
    Log.info("Downloaded!");

    closeIfSecondTab();

    //convertNextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(convertNextButtonById));
    //convertNextButton.click();

    waitABit.accept(driver);
  }

  private void closeIfSecondTab() {
    // Se cambia el enfoque a la segunda pestaña y se cierra
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    if (tabs.size() > 1) {
      driver.switchTo().window(tabs.get(1));
      driver.close();
      driver.switchTo().window(tabs.get(0));
    }
  }
}
