package com.demo.DemoProject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadNotepadFileDemo {

	public static void main(String args[]) {
		try {
			String expectedValue = new String(Files.readAllBytes(Paths.get(
					System.getProperty("user.dir") + File.separator + "data" + File.separator + "notepaddemo.txt")));
			System.out.println(expectedValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
