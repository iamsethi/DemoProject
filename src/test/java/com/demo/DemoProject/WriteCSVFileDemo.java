package com.demo.DemoProject;

import java.io.FileWriter;

import com.opencsv.CSVWriter;

public class WriteCSVFileDemo {

	public static void main(String[] args) throws Exception {

		CSVWriter writecsv = new CSVWriter(new FileWriter("./data/csvdemo.csv"));
		String[] testStatus = "URL,Search Term,Expected Results,Actual Results".split(",");
		writecsv.writeNext(testStatus);

		String[] testCase1 = "https://www.google.com/	,selenium	,selenium - Google Search,	selenium - Google Search"
				.split(",");
		writecsv.writeNext(testCase1);
		writecsv.close();
	}

}