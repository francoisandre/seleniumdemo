package fr.aeris.seleniumdemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class PageCatalogue extends AbstractPage {

	private static final String RESULT_SELECTOR = "section[aeris-catalog-summaries-bar] div";

	private static final String HELP_POPUP_OK_BUTTON_SELECTOR = ".help-popup .ok-button";

	private static final String SEARCH_BUTTON_SELECTOR = "button[title='Start a research']";

	private static final String KEYWORDS_INPUT_SELECTOR = "input[name='keywords']";

	@FindBy(css = HELP_POPUP_OK_BUTTON_SELECTOR)
	WebElement helpOkButton;

	@FindBy(css = SEARCH_BUTTON_SELECTOR)
	WebElement searchButton;

	@FindBy(css = RESULT_SELECTOR)
	WebElement resultText;

	@FindBy(css = "section[data-cart]")
	WebElement dataCart;

	@FindBy(css = KEYWORDS_INPUT_SELECTOR)
	WebElement keywordInput;

	// public void hideHelp() {
	// if (SeleniumUtils.isVisible(helpOkButton)) {
	// helpOkButton.click();
	// }
	// }

	public void launchSearch() {
		searchButton.click();
		WebDriverWait wait = new WebDriverWait(getPageFactory().getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(RESULT_SELECTOR)));
	}

	@Override
	public void waitLoadComplete() {
		WebDriverWait wait = new WebDriverWait(getPageFactory().getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SEARCH_BUTTON_SELECTOR)));
	}

	public int getSearchResultHits() {
		if (!SeleniumUtils.isVisible(resultText)) {
			return 0;
		} else {
			String content = resultText.getText();
			String[] split = content.split(":");
			return Integer.parseInt(split[1].trim());
		}
	}

	public void setTextualCriterion(String value) {
		keywordInput.clear();
		keywordInput.sendKeys(value);
		// TO LOOSE FOCUS
		dataCart.click();
		// keywordInput.sendKeys(Keys.RETURN);
		SeleniumUtils.attente(1);
	}

}
