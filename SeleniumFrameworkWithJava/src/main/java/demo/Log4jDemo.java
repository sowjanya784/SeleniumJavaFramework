package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	public static void main(String[] args) {
		
		Logger log = LogManager.getLogger(Log4jDemo.class);
		
		log.info("Information message");
		log.warn("Warning message");
		log.error("Error message");
		log.fatal("Fatal message");
		log.trace("Trace messaage");
		log.debug("Debugging message");
		
		System.out.println("Done logging");
	}

}
