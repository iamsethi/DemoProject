package com.demo.DemoProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFileDemo {

	public static void main(String[] args) throws Exception {

		String info = "PASS";
		try {
			FileWriter fr = new FileWriter("./data/txtdemo.txt");
			BufferedWriter br = new BufferedWriter(fr);

			br.write(info);
			br.newLine();
			br.write(info);
			br.newLine();

			br.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}