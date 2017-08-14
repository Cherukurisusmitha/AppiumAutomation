package Utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.testng.annotations.Test;

public class Log4j {
	   /* Get actual class name to be printed on */
	   Logger log = Logger.getLogger(Log4j.class.getName());
  @Test
  public void log4jExample()throws IOException,SQLException{
//	      log.debug("Hello this is a debug message");
	      log.info("Hello this is an info message");
	      
	   }
	}
