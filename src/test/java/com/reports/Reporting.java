package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
/**
 * 
 * @author Deepan
 *@description Used to generate an jvm report
 *@Date 28/08/22
 */

public class Reporting {

	public static void generateJVMReport(String jsonFile) {
		
		//1. Mention the path of JVM report to store 
		File file = new File(System.getProperty("user.dir")+"\\target\\output.jvm");
		
		//2. Create obj for configuration 
		Configuration config = new Configuration(file, "AdactinAutomation");
		
		//3. Add classification OS, Chrome, version ,sprint
		config.addClassifications("Browser", "Chrome");
		config.addClassifications("Browser Version", "104");
		config.addClassifications("OS", "WIN10");
		config.addClassifications("Sprint", "13");
		
		//4. Create the obj for Report Builder & Pass the json file to fetch result passed , failed , skipped
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder  = new ReportBuilder(jsonFiles, config);
		
		//5.Build JVM Report
		builder.generateReports();
			
	}
}
