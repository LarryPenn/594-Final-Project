package edu.upenn.cit594.logging;

import java.io.File;
import java.io.PrintWriter;

/*
 * Parts of this code are taken from Week 11 lecture
 * 
 */
public class Logger {
	private PrintWriter out;
	
	private Logger(String filename) {
		try { out = new PrintWriter(new File(filename)); }
		catch (Exception e) { } 
	}
	
	// default logger is src/log.txt, but will be reestablished if necessary
	private static Logger instance = new Logger("src/log.txt");
	
	public static Logger getInstance() {
		return instance;
	}
	// logs tweet
	public void log(String msg) {
		out.println(msg);
		out.flush();
	}
	//will create a new log file with the desired name;
	public void renameLog(String name) {
		if (name != "log.txt") {
			instance = new Logger(name);
		}
	}
	
	
}
