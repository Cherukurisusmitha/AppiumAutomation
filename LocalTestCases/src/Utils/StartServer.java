package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.Test;

public class StartServer {
 public static Process process;
 public static String nodePath = "C:\\Users\\Admin\\AppData\\Local\\Programs\\appium-desktop\\nodejs\\node.exe";
 public static String appiumPath = "C:\\Users\\Admin\\AppData\\Local\\Programs\\appium-desktop\\resources\\app\\node_modules\\appium\\build\\lib\\appium.js";
 public static String appiumServerStart = appiumPath+" "+nodePath;
@Test
 public void initializeServer() throws IOException, InterruptedException {
	 System.out.println(appiumServerStart);
	 System.out.println(nodePath);
	 process =Runtime.getRuntime().exec(appiumServerStart);
	 System.out.println("Starting server......");
	 Thread.sleep(10000);
	 if(process!=null){
		 System.out.println("Initiated server");
	 }
	 else{
		 System.out.println("Failed to start server");
	 }
  }
}
