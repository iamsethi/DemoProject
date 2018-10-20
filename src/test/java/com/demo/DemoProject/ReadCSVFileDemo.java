package com.demo.DemoProject;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class ReadCSVFileDemo {

	public static void main(String[] args) throws Exception {

		// This will load csv file 
		CSVReader reader = new CSVReader(new FileReader("./data/csvdemo.csv"));
		// this will load content into list
		List<String[]> li = reader.readAll();
		System.out.println("Total rows which we have is " + li.size());
		// create Iterator reference
		Iterator<String[]> i1 = li.iterator();
		// Iterate all values 
		while (i1.hasNext()) {
			String[] str = i1.next();
			System.out.println(" Values are ");
			for (int i = 0; i < str.length; i++)
				System.out.println(" " + str[i]);

		}
	}

}