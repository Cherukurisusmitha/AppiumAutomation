package Utils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import javax.swing.text.View;
import org.testng.IAnnotationTransformer;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;
import Utils.Helper;
import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import io.appium.java_client.android.AndroidDriver;
import test.StartApplication;

public class Listener implements ITestListener {
	public static Helper helper;

	
	@Override
	public void onTestStart(ITestResult result)   {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Result status.."+result.getStatus());
		System.out.println("The name of the testcase Passed is :"+result.getName());
		String methodName = result.getName();
		try {
			Helper.takeScreenShot(methodName);
			System.out.println("SCreenshot of success method "+result.getName()+" is captured");

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase failed is :"+result.getName());
		System.out.println("Result status.."+result.getStatus());
		try {
			Helper.takeScreenShot(result.getName());
			System.out.println("SCreenshot of failed method "+result.getName()+" is captured");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Result status.."+result.getStatus());
		System.out.println("The name of the testcase skipped is :"+result.getName());
		System.out.println("Result status of Skipped test is.."+result.getStatus());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	/*
		try {
			System.out.println("ppppppppppppppp");
			Helper.allowPermissions();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
	}