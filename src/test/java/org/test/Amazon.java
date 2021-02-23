package org.test;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Amazon extends BaseClass {
	@BeforeClass
	public static void beforeClass() {
		launchBrowser();
		System.out.println("Before class.....");
	}

	@AfterClass
	public static void afterClass() {
		closeBrowser();
		System.out.println("After class...");
	}

	@Before
	public void before() {
		Date d = new Date();
		System.out.println("Test starts..." + d);
	}

	@After
	public void after() {
		System.out.println("Test Ends..." + new Date());

	}

	@Test
	public void test1() {
		launchUrl("https://www.amazon.in/");
		loginPage l = new loginPage();
		fillTextBox(l.getTxtSearch(), "iphones 7");
		btnClick(l.getBtnClick());

	}

	@Test
	public void test2() {
		List<WebElement> product = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		int size = product.size();
		System.out.println(size);
		for (WebElement eachproduct : product) {
			String text = eachproduct.getText();
			System.out.println(text);
		}
	}

	@Test
	public void test3() 
	{
		List<WebElement> prize = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<String> li=new LinkedList<String>();
		int size = prize.size();
		System.out.println(size);
		for (WebElement eachPrize : prize) {
			String text = eachPrize.getText();
			String s = text.replaceAll(",", "");
			int i = Integer.parseInt(s);
			System.out.println(i);
		}
Collections.sort(li,Collections.reverseOrder());
	}
	@Test
	public void test4() 
	{
	List<WebElement> listPrize = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	for (WebElement eachPrize : listPrize)
	{
		String text = eachPrize.getText();
		String s = text.replaceAll(",", "");
		int it = Integer.parseInt(s);	
	if(it>=25000)
	{
		System.out.println(it);
	}
	}
	}
}
