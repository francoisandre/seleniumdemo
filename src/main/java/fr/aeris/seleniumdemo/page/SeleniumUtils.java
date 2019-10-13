package fr.aeris.seleniumdemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumUtils {
	
	private static Logger logger = LoggerFactory.getLogger(SeleniumUtils.class);
			
	public static void attente(final float dureeEnSeconde) {
		try {
			Float aux = new Float(1000 * dureeEnSeconde);
			Thread.sleep(aux.longValue());
		} catch (InterruptedException e) {

		}
	}

	public static void displayContent(WebDriver driver) {
		WebElement aux = driver.findElement(By.cssSelector("body"));
		logger.info(aux.getText());
	}
	
	public static boolean isVisible(final WebElement element) {
		if (element == null) {
			return false;
		}
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
