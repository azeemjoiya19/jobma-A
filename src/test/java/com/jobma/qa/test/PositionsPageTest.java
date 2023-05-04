package com.jobma.qa.test;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jobma.qa.base.TestBase;
import com.jobma.qa.pages.JobConfigurationPage;
import com.jobma.qa.pages.JobmaDashboard;
import com.jobma.qa.pages.LoginPage;
import com.jobma.qa.pages.PositionsPage;

public class PositionsPageTest  extends TestBase{

	public PositionsPageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		TestBase.intialize();
		lp= new LoginPage();
		lp.login(prop.getProperty("username"),prop.getProperty("password"));
		jd= new JobmaDashboard();
		pp = new PositionsPage();
		pp =jd.clickOnPositions();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test
	public void createJobTest() throws InterruptedException
	{
		pp.createJob();
	}
	@Test
	public void quickInviteTest() throws InterruptedException, IOException
	{
		pp.quickInvite();
	}



	@Test
	public void setConfigurationTest() throws IOException, InterruptedException
	{ 

		jcp =pp.clickOnJobConfiguration();
		Thread.sleep(5000);
		jcp = new JobConfigurationPage();
		jcp.setConfiguration();
	}

	@Test
	public void addQuestionBtnTest1() throws IOException, InterruptedException
	{
		pp = new PositionsPage();
		jcp =pp.clickOnJobConfiguration();

		jcp.addQuestionBtnTest();
	}

	@Test
	public void clickOnCancelBtnOnJobConfigurationPageTest() throws IOException, InterruptedException
	{
		pp = new PositionsPage();
		jcp =pp.clickOnJobConfiguration();
		jcp.clickOnCancelBtnOnJobConfigurationPage();
	}

	@Test
	public void clickOnAddNewInterviewKitBtnTest() throws IOException, InterruptedException
	{
		pp = new PositionsPage();
		jcp =pp.clickOnJobConfiguration();
		jcp.clickOnAddInterviewKitBtn();
	}

	@Test
	public void clickOnAddMoreAboutPositionTest() throws IOException, InterruptedException, AWTException
	{
		pp = new PositionsPage();
		jcp =pp.clickOnJobConfiguration();
		jcp.clickOnAddMoreAboutPosition();
	}

	@Test
	public void copyLinkTest()
	{
		pp.copyLink();
	}
	
	@Test
	public void bulkInviteTest() throws IOException, InterruptedException
	{
		pp.bulkInvite();
	}

	@AfterMethod
	public void Close()
	{
		TestBase.closeBrowser();

	} 




}
