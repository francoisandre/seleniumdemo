package fr.aeris.seleniumdemo.scenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.aeris.seleniumdemo.page.GmosPageFactory;
import fr.aeris.seleniumdemo.page.PageAccueilPortailGmos;
import fr.aeris.seleniumdemo.page.PageCatalogue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogueConsultationScenario {

	private WebDriver driver;

	@Autowired
	GmosPageFactory factory;

	private static final Logger logger = LoggerFactory.getLogger(CatalogueConsultationScenario.class);

	@Test
	public void basicSearch() throws Exception {
		if (driver == null) {
			driver = getFirefoxDriver();
		}
		factory.setDriver(driver);

		try {
			PageAccueilPortailGmos pageAccueil = factory.naviguePageAccueil();
			if (!pageAccueil.hasContent()) {
				throw new Exception("La page d'acceuil semble vide");
			}
			PageCatalogue pageCatalogue = pageAccueil.goToCatalogue();
			pageCatalogue.setTextualCriterion("mercury");
			pageCatalogue.launchSearch();
			int hits = pageCatalogue.getSearchResultHits();
			if (hits == 0) {
				throw new Exception("Aucun jeu de données trouve par la recherche");
			}
			if (hits < 6) {
				throw new Exception("Uniquement " + hits + " jeux de donnees trouves par la recherche");
			}

		} catch (

		RuntimeException e) {
			throw new Exception(e);
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}

	public WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "/home/fandrelocal/geckodriver");
		FirefoxOptions options = new FirefoxOptions();
		// options.setHeadless(true);
		return new FirefoxDriver(options);
	}
}
