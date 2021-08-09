package com.qa.tdl.acceptanceTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class homePage {
	
	public final String URL = "http://127.0.0.1:5500/TDL-Project/index.html";
	
	@FindBy(xpath = "//*[@id=\"flex\"]/div[3]/p[1]")
	public WebElement deleteDummy;
	@FindBy(xpath = "//*[@id=\"prompt\"]")
	private WebElement prompt;    
	
	@FindBy(xpath = "/html/body/h1")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//*[@id=\"createBtn\"]")
	private WebElement createButton;
	@FindBy(xpath = "//*[@id=\"task\"]")          // CREATE
	private WebElement textField;
	@FindBy(xpath = "//*[@id=\"createSubmit\"]")
	private WebElement createSubmit;
	@FindBy(xpath = "//*[@id=\"flex\"]/div[4]/p[2]")
	private WebElement createResult;
	
	@FindBy(xpath = "//*[@id=\"flex\"]/div[2]/p[2]")
	private WebElement updateResult;
	@FindBy(xpath = "//*[@id=\"updateBtn\"]")
	private WebElement updateButton;
	@FindBy(xpath = "//*[@id=\"itemID\"]")         // UPDATE
	private WebElement idField;
	@FindBy(xpath = "//*[@id=\"task-update\"]")         
	private WebElement updateItemField;
	@FindBy(xpath = "//*[@id=\"status-update\"]")         
	private WebElement updateStatusField;
	@FindBy(xpath = "//*[@id=\"updateSubmit\"]")
	private WebElement updateSubmit;
	
	
	@FindBy(xpath = "//*[@id=\"deleteBtn\"]")
	private WebElement deleteButton;             // DELETE
	@FindBy(xpath = "//*[@id=\"itemIDdel\"]")         
	private WebElement delIdField;
	@FindBy(xpath = "//*[@id=\"deleteSubmit\"]")
	private WebElement deleteSubmit;
	

	
	
	public String pageTitleResult() {
		return pageTitle.getText();
	}
	
	public String createItem(String item) {
		createButton.click();
		textField.sendKeys(item);
		createSubmit.click();
		
		return prompt.getText();
	}
	
	public void updateItem(String item, String id, String status) {
		updateButton.click();
		idField.sendKeys(id);
		updateItemField.sendKeys(item);
		updateStatusField.sendKeys(status);
		updateSubmit.click();

	}
	
	public String updateItemReturn() {
		return prompt.getText();
	}
	
	public String deleteItem(String id) {
		deleteButton.click();
		delIdField.sendKeys(id);
		deleteSubmit.click();
		return prompt.getText();
		
	}
	

}
