package com.demo.DemoProject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class WriteHTMLFile {
	public static void main(String[] args) {
		try {
			// define a HTML String Builder
			StringBuilder htmlStringBuilder = new StringBuilder();
			htmlStringBuilder.append("<body>");
			htmlStringBuilder.append("<table border=\"1\" bordercolor=\"#000000\">");
			htmlStringBuilder.append("<tr><td>TestId</td><td>TestName</td><td>TestResult</td></tr>");
			htmlStringBuilder.append("<tr><td>001</td><td>Login</td><td>Passed</td></tr>");
			htmlStringBuilder.append("<tr><td>002</td><td>Logout</td><td>Passed</td></tr>");
			htmlStringBuilder.append("</table></body></html>");
			WriteToFile(htmlStringBuilder.toString(), "testfile.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void WriteToFile(String fileContent, String fileName) throws IOException {
		String projectPath = System.getProperty("user.dir");
		String tempFile = projectPath + File.separator + fileName;
		File file = new File(tempFile);

		// write to file with OutputStreamWriter
		OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
		Writer writer = new OutputStreamWriter(outputStream);
		writer.write(fileContent);
		writer.close();

	}
}
