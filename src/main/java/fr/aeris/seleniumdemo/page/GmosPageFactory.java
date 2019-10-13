package fr.aeris.seleniumdemo.page;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GmosPageFactory {

	@Autowired
	PageAccueilPortailGmos pageAccueil;

	@Autowired
	PageCatalogue pageCatalogue;

	@Autowired
	NavigationConfiguration configuration;

	WebDriver driver;

	public PageAccueilPortailGmos naviguePageAccueil() {
		driver.get(configuration.getRootAddress());
		pageAccueil.waitLoadComplete();
		return pageAccueil;
	}

	public PageCatalogue getPageCatalogue() {
		pageCatalogue.waitLoadComplete();
		return pageCatalogue;
	}

	@PostConstruct
	public void injectPageFactory() {
		pageAccueil.setPageFactory(this);
		pageCatalogue.setPageFactory(this);
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
		pageAccueil.initPage();
		pageCatalogue.initPage();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
