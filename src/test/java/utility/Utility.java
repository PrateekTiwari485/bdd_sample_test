package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.*;
import java.util.Random;

public class Utility {
    public WebDriver ldriver;

    public Utility(WebDriver rdriver){
        ldriver=rdriver;
    }

    public void TakeScreenshot(WebElement Element,String FileName){
        JavascriptExecutor js = (JavascriptExecutor)ldriver;
        js.executeScript("arguments[0].style.border = '3px solid red'", Element);
        try {
            File File = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(File, new File("C:\\Users\\prateek.tiwari\\IdeaProjects\\bdd_sample_test\\src\\test\\Screenshots\\" + FileName +new Random().nextInt(10000) + ".jpeg"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
