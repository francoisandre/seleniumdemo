package fr.aeris.seleniumdemo.page;

import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

	public abstract void waitLoadComplete();

	protected GmosPageFactory pageFactory;
	private boolean initialised = false;

	public void initPage() {
		if (!isInitialised()) {
			PageFactory.initElements(pageFactory.getDriver(), this);
			setInitialised(true);
		}
	}

	public void setPageFactory(GmosPageFactory pageFactory) {
		this.pageFactory = pageFactory;
	}

	public GmosPageFactory getPageFactory() {
		return pageFactory;
	}

	public boolean isInitialised() {
		return initialised;
	}

	public void setInitialised(boolean initialised) {
		this.initialised = initialised;
	}

}
