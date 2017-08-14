package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.Test;

public class Adb {
  @Test
public static void testADB() throws IOException{
//	  final Process exec = Runtime.getRuntime().exec("adb shell ls /sdcard/DCIM/Camera");
	  String p = "cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p  4723\"";
//	  System.out.println(p);
        final Process exec = Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p  4723\"");
    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
    String s;
    while((s = bufferedReader.readLine()) != null) {
        System.out.println(s);
    }
  }
}
