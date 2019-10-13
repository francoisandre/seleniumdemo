package fr.aeris.seleniumdemo.page;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NavigationConfiguration {

	@Value("${gmos.address}")
	private String rootAddress;

	public String getRootAddress() {
		return rootAddress;
	}

	public void setRootAddress(String rootAddress) {
		this.rootAddress = rootAddress;
	}

}
