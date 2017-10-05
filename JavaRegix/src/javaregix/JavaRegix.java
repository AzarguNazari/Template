
package javaregix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegix {
    public static void main(String[] args) {
       
        
        // This is just a test cause
        String test = "Ahmad has an email and his email is ahmad.john@yahoo.com and his phone number is 097812213 and he was born at 19/09/1998";
        
        
        // there are different ways of finding the the regix of an string 
        
        // first way
        
        System.out.println(test.matches("(\\d{1,2}\\/\\d{1,2}\\/\\d{4})"));
        
        
        
        
        Pattern pattern = Pattern.compile("([\\w\\d_\\.]+@[\\w\\d_]+\\.([\\w\\d_]+)?\\.?([\\w\\d_]+)?)");
        
        Matcher match = pattern.matcher(test);
        
        
        while(match.find()){
            System.out.println(match.group());
        }
        
        
        
        
        
        
    }
    
    public static boolean match(String text, String regix){
        return Pattern.matches(text, regix);
    }
    
    public static 
    
}
