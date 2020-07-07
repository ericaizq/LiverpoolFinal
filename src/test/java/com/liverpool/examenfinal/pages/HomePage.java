package com.liverpool.examenfinal.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.liverpool.examenfinal.utils.Utils;

public class HomePage extends BasePage {

	@FindBy(css = ".a-header__logo")
	private WebElement logoLiverpool;
	
	@FindBy(css = ".icon-zoom")
	private WebElement iconoBusqueda;
	
	@FindBy(css = ".form-control")
	private WebElement campoBusqueda;
	
	@FindBy(css =".a-header__strongLink[href='https://assetspwa.liverpool.com.mx/ayuda/#/']")
	private WebElement linkAyuda;
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void navegarSitio() {
		driver.manage().window().maximize();
	    driver.get(Utils.URL);
	}

	public void verificarInicio() {
		Assert.assertTrue(logoLiverpool.isDisplayed() && campoBusqueda.isDisplayed() && iconoBusqueda.isDisplayed());
	}
	
	public ResultsPage buscarArticulo(String articulo) {
		campoBusqueda.sendKeys(articulo);
		iconoBusqueda.click();
		return new ResultsPage(driver);
	}

	public void irAAyuda() {
		linkAyuda.click();
	}
}
