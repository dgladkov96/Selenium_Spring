import java.lang.reflect.Array;
import java.nio.file.ClosedWatchServiceException;
import java.util.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import Helper.MIsc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class codeTestMay {

    //method to return factorial

    public static long factorialNum(int num){
        long Factorial = 0;  //use long because we dont know how large the value can be right away
        for (int i = 1; i <=num; i++){
            Factorial *= i;
        }
        return Factorial;
    }


    //return Common Strings from 2 inputed string arrays
    public static HashSet<String> Common (String[] array1, String[] array2){
        //create new hashset to store common values in
        HashSet<String> mySet = new HashSet<String>();

        //loop thru both arrays to check for common values ignoring the case
        for (int i = 0; i <array1.length; i++){
            for (int j = 0; j < array2.length; j++) {
                if (array1[i].equalsIgnoreCase(array2[j])){
                    mySet.add(array1[i]);
                    break;
                }
            }
        }
        System.out.println("Common Elements from input arrays are " + mySet);
        return mySet;
    }

    //return smallest missing positive integer from given array

    public int missingPositive(int[] nums){

        int n = nums.length; //check for how many values in array
        if (nums == null || nums.length == 0) return 1;

        int containsOne = 0;

        //check if val in arr[i] is negative or is greater than the length of the array
        for (int i = 0; i < n; i++){
            if (nums[i] == 1){
                containsOne = 1;
            } else if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        //check if containsOne is 0 -> no 1 has been seen, return 1
        if (containsOne == 0) return 1;


        //flip numbers to negative if not already negative
        //if number is negative at nums[i] that number was present in the array as a positive value
        //if the number is positive after flipping nums to negative

        for (int i = 0; i < n; i++){
            int index = Math.abs(nums[i]) - 1; //use int index as a key
            if (nums[index] > 0) {
                nums[index] = -1 * nums[index];  //flip num at index position to index if it is not negative yet
            }
        }

        //check for the first positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        //return n + 1 if number is not found bc array will look something lik --> {1, 2, 3}
        //so answer will be the length of array + 1

        return n + 1;


    }
    /**
     * Verify feelsLike-temp value is in between the low-temp value and high-temp value
     * Web: https://www.darksky.net/
     * points: 20
     */
    @Test

    public void feelslikeTemp() {
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net");
        By LowTempLocator = By.xpath("//span[@class='low-temp-text']");
        By HighTempLocator = By.xpath("//span[@class='high-temp-text']");
        By FeelsLikeTempLocator = By.xpath("//span[@class='feels-like-text']");
        WebElement LowTemp = MyDriver.getDriver().findElement(LowTempLocator);
        WebElement HighTemp = MyDriver.getDriver().findElement(HighTempLocator);
        WebElement FeelsLike = MyDriver.getDriver().findElement(FeelsLikeTempLocator);

       String Low = LowTemp.getText();
       String High = HighTemp.getText();
       String FeelsLiketemp = FeelsLike.getText();
       Double LowTemperature = Double.valueOf(Low);
       Double HighTemperature = Double.valueOf(High);
       Double FeelsLikeTemperature = Double.valueOf(FeelsLiketemp);

       boolean Tempisinbetween;

       if (FeelsLikeTemperature <= LowTemperature || FeelsLikeTemperature >= HighTemperature) {
           Tempisinbetween = false;
       } else {
           Tempisinbetween = true;
       }
       Assert.assertTrue(Tempisinbetween, "The displayed feels like temperature is not between the High & Low Temperatures");

       MyDriver.quitWindows();

    }









}
