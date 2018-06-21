package com.demo.DemoProject;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jDemo {

	public static void main(String args[]) {
		Logger log = Logger.getLogger(Log4jDemo.class);
		PropertyConfigurator.configure("log4j.properties");
		// DEBUG < INFO < WARN < ERROR < FATAL
		log.debug("Debug Message!");
		log.info("Info Message!");
		log.warn("Warn Message!");
		log.error("Error Message!");
		log.fatal("Fatal Message!");

	}

}
