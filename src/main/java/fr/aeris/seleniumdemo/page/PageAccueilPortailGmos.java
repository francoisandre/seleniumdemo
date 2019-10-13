package fr.aeris.seleniumdemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class PageAccueilPortailGmos extends AbstractPage {

	private static final String CONTENT_AREA_SELECTOR = "#page #content-area";

	private static final String CATALOGUE_SELECTOR = "//*/a[contains(text(),'Catalogue')]";

	private static final String DATA_ACCESS_SELECTOR = "//*/a[contains(text(),'Data access')]";

	@FindBy(css = CONTENT_AREA_SELECTOR)
	private WebElement mainContent;

	@FindBy(xpath = DATA_ACCESS_SELECTOR)
	private WebElement dataAccessMenu;

	@FindBy(xpath = CATALOGUE_SELECTOR)
	private WebElement catalogueMenu;

	public boolean hasContent() {
		String content = mainContent.getText();
		if (content.length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public PageCatalogue goToCatalogue() {
		dataAccessMenu.click();
		WebDriverWait wait = new WebDriverWait(getPageFactory().getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CATALOGUE_SELECTOR)));
		catalogueMenu.click();
		PageCatalogue pageCatalogue = pageFactory.getPageCatalogue();
		pageCatalogue.waitLoadComplete();
		return pageCatalogue;

	}

	@Override
	public void waitLoadComplete() {
		WebDriverWait wait = new WebDriverWait(getPageFactory().getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CONTENT_AREA_SELECTOR)));

	}

}
