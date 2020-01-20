package com.yuanpeng.like;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class H12306Controller {
//http://npm.taobao.org/mirrors/chromedriver/
	//https://www.cnblogs.com/liyunfeng111/p/10283428.html

	public static void main(String[] args){



		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://kyfw.12306.cn/otn/leftTicket/init?linktypeid=dc");
		try {
			Thread.sleep(1000);
			WebElement button1 = driver.findElement(By.cssSelector("#J-header-login > a:nth-child(1)")); //登录按钮
			button1.click();
			Thread.sleep(1000);
			WebElement button2 = driver.findElement(By.cssSelector("body > div.login-panel > div.login-box > ul > li.login-hd-account > a")); //账号登录按钮
			button2.click();
			Thread.sleep(1000);
			WebElement box1 = driver.findElement(By.id("J-userName"));//账号文本框
			box1.sendKeys("16678529224");//这里输入账号
			WebElement box2 = driver.findElement(By.id("J-password")); //密码文本框
			box2.sendKeys("lzfyp0603");//这里输入密码
			Thread.sleep(10000);
			WebElement button3 = driver.findElement(By.id("J-login")); //立即登录按钮
			button3.click();
			Thread.sleep(1000);
			driver.get("https://kyfw.12306.cn/otn/leftTicket/init?linktypeid=dc");
			Thread.sleep(1000);
			WebElement box3 = driver.findElement(By.id("fromStationText")); //出发地文本框
			box3.click();
			box3.sendKeys("青岛");
			box3.sendKeys(Keys.ENTER);

			WebElement box4 = driver.findElement(By.id("toStationText")); //目的地文本框
			box4.click();
			box4.sendKeys("齐齐哈尔");
			box4.sendKeys(Keys.ENTER);

			WebElement box5 = driver.findElement(By.id("train_date")); //出发日期文本框
			box5.click();

			// Thread.sleep(2000);
			WebElement box6 = driver.findElement(By.cssSelector("body > div.cal-wrap > div.cal.cal-right > div.cal-cm > div:nth-child(2) > div"));//具体出发日期
			box6.click();

			WebElement button5 = driver.findElement(By.id("query_ticket"));//查询按钮
			button5.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		/*try {
			grabbing(driver);
		} catch (Exception e) {
			driver.navigate().refresh();
			grabbing(driver);
		}*/
	}


	public static void grabbing(WebDriver driver) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.cssSelector("#J-chepiao > a"))).perform();// 模式鼠标悬浮

			Thread.sleep(5000);
			WebElement button4 = driver.findElement(By.cssSelector("#J-chepiao > div > div:nth-child(1) > ul > li.nav_dan > a")); //单程按钮
			button4.click();

			WebElement box3 = driver.findElement(By.id("fromStationText")); //出发地文本框
			box3.click();
			box3.sendKeys("杭州东");
			box3.sendKeys(Keys.ENTER);

			WebElement box4 = driver.findElement(By.id("toStationText")); //目的地文本框
			box4.click();
			box4.sendKeys("抚州东");
			box4.sendKeys(Keys.ENTER);

			WebElement box5 = driver.findElement(By.id("train_date")); //出发日期文本框
			box5.click();

			// Thread.sleep(2000);
			WebElement box6 = driver.findElement(By.cssSelector("body > div.cal-wrap > div.cal.cal-right > div.cal-cm > div:nth-child(9) > div"));//具体出发日期
			box6.click();

			WebElement button5 = driver.findElement(By.id("query_ticket"));//查询按钮
			button5.click();

			WebElement button6 = driver.findElement(By.cssSelector("#ZE_5l000G479370 > div"));//第一班一等座元素
			boolean buttonVal = button6.getText().equals("无");
			int count = 1;
			while (buttonVal) {
				try {
					button5 = driver.findElement(By.id("query_ticket"));//查询按钮
					button5.click();
					count++;
					button6 = driver.findElement(By.cssSelector("#ZE_5l000G479370 > div"));
					buttonVal = button6.getText().equals("无");
					if (!buttonVal) {
						break;
					}
				} catch (Exception e) {
					driver.navigate().refresh();
					System.out.println("报错了。。。。");
				}
			}
			System.out.println("第 " + count + "次终于抢到了！！！");
			WebElement button7 = driver.findElement(By.cssSelector("#ticket_5l000G479370 > td.no-br > a")); //预订按钮
			button7.click();

			WebElement button8 = driver.findElement(By.cssSelector("#normal_passenger_id > li:nth-child(1) > label")); //选择买票人
			button8.click();

			WebElement button9 = driver.findElement(By.id("submitOrder_id"));//提交订单
			button9.click();

			Thread.sleep(3000);
			WebElement button10 = driver.findElement(By.cssSelector("#qr_submit_id")); //弹窗确认按钮
			button10.click();

			System.out.println("抢到票了！！！");

		} catch (Exception e) {
			System.out.println("错了：" + e.getLocalizedMessage());
		}
	}
}
/*
https://kyfw.12306.cn/otn/leftTicket/init?linktypeid=dc
passengerTicketStr: 3,0,1,袁鹏,1,2302***********615,16678529224,N,90f9ffac6a15977d6da01d99a78dd8311c18d0b5290ed622e2ec4521e32507939eafd7b3ec5f535623a74d3a13acc72b
oldPassengerStr: 袁鹏,1,2302***********615,1_
randCode:
purpose_codes: 00
key_check_isChange: B7F9B7E311FAC8ACCB025200C287FDE5236E1CBA362B4304452D8371
leftTicketStr: zCynh2QapExRLnbkevn9XNlCcRMnZvHnv9FkZPMhZfcVFJ6KpIndchfadD8%3D
train_location: W3
choose_seats:
seatDetailType: 000
whatsSelect: 1
roomType: 00
dwAll: N
_json_att:
REPEAT_SUBMIT_TOKEN: cd4f0ebda0d9d555e54e8be82d9e88ae

passengerTicketStr: 3,0,1,袁鹏,1,2302***********615,16678529224,N,90f9ffac6a15977d6da01d99a78dd8311c18d0b5290ed622e2ec4521e32507939eafd7b3ec5f535623a74d3a13acc72b
oldPassengerStr: 袁鹏,1,2302***********615,1_
randCode:
purpose_codes: 00
key_check_isChange: 9AEE3785C94CDA53D08F4A8D4D807D13A05625F76D922DFBC000DAA3
leftTicketStr: Z0NLDn7uRESSegHqXZk7fWv%2BidJ7%2BcjVSCV2qaC4xIni78umhvkCPHwaOwM%3D
train_location: W3
choose_seats:
seatDetailType: 000
whatsSelect: 1
roomType: 00
dwAll: N
_json_att:
REPEAT_SUBMIT_TOKEN: 158c5f1e1d00fa6373c7aa53abd5f474
		*/
