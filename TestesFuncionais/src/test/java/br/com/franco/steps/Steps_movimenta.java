package br.com.franco.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.franco.driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps_movimenta {
	
	@Given("seleciono criar movimentação")
	public void selecionoCriarMovimentação() {
	    
		Driver.getDriver().findElement(By.linkText("Criar Movimentação")).click();
	}
	
	@Given("preencho o tipo de movimentacao {string}")
	public void preenchoOTipoDeMovimentacao(String string) {
	    
		WebElement selectElement = Driver.getDriver().findElement(By.xpath("//select[@id='tipo']"));
		Select select = new Select(selectElement);
	    List<WebElement> options = select.getOptions();
	    select.selectByVisibleText(string);
		
	}
	
	
	@Given("preencho a data da movimentacao {string}")
	public void preenchoADataDaMovimentacao(CharSequence dataMovimentacao) {
	   
		Driver.getDriver().findElement(By.id("data_transacao")).sendKeys(dataMovimentacao);
		
		assertEquals(Driver.getDriver().findElement(By.id("data_transacao")).getAttribute("value"), dataMovimentacao);
		
	
		
		
		
	}
	@Given("preencho a data do pagamento  {string}")
	public void preenchoADataDoPagamento(CharSequence dataPagamento) {
	    
		Driver.getDriver().findElement(By.id("data_pagamento")).sendKeys(dataPagamento);
		assertEquals(Driver.getDriver().findElement(By.id("data_pagamento")).getAttribute("value"), dataPagamento);
		
		
	}
	
	@Given("preencho a descrição {string}")
	public void preenchoADescrição(String string) {
	    
		Driver.getDriver().findElement(By.id("descricao")).sendKeys(string);
	}
	
	
	@Given("preencho o interessado {string}")
	public void preenchoOInteressado(String string) {
	   
		Driver.getDriver().findElement(By.id("interessado")).sendKeys(string);
		assertEquals(string, Driver.getDriver().findElement(By.id("interessado")).getAttribute("value"));
	}
	@Given("preencho o valor {string}")
	public void preenchoOValor(CharSequence valor) {
	    
		Driver.getDriver().findElement(By.id("valor")).sendKeys(valor);
		assertEquals(valor, Driver.getDriver().findElement(By.id("valor")).getAttribute("value"));
		
	}
	@Given("seleciono a conta {string}")
	public void selecionoAConta(String string) {
	    
		WebElement selectElement = Driver.getDriver().findElement(By.id("conta"));
		Select select = new Select(selectElement);
		List<WebElement> options = select.getOptions();
		select.selectByVisibleText(string);
		assertTrue(select.getFirstSelectedOption().getText().equals(string));
	}
	
	@Given("seleciono a situação Pago")
	public void selecionoASituaçãoPago() {
	    
		WebElement radiobutton = Driver.getDriver().findElement(By.id("status_pago"));
		radiobutton.click();
		assertTrue(radiobutton.isSelected());
	}
	
	
	@When("clico em salvar")
	public void clicoEmSalvar() {
	    
		Driver.getDriver().findElement(By.tagName("button")).click();
	}
	
	@Then("será exibida a mensagem de alerta {string}")
	public void seráExibidaAMensagemDeAlerta(String textoEsperado) {
	    
		String textoObtido = Driver.getDriver().findElement(By.xpath("//div[starts-with(@class, 'alert')]")).getText();
		assertEquals(textoObtido, textoEsperado);
		
	}




}
