import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class EmailValidationTest {
    boolean expectedValue;
    String input;
    String inputPattern;
    EmailValidation obj;

    public EmailValidationTest(String input,boolean expectedValue){
        this.input=input;
        this.expectedValue=expectedValue;
    }

    @Before
    public void initializeObject(){
        obj=new EmailValidation();
        inputPattern="^[a-zA-Z0-9]+[\\.\\-\\+\\_]?[a-zA-Z0-9]+@[a-zA-Z0-9]+[.]?[a-zA-Z]{2,4}[\\.]?([a-z]{2,4})?$";
    }

    @Parameterized.Parameters
    public static Collection checkEmail(){
        return Arrays.asList(new Object[][] {{"abc@yahoo.com",true},
                {"abc-100@yahoo.com",true},
                {"abc.100@yahoo.com",true},
                {"abc111@abc.com",true},
                {"abc-100@abc.net",true},
                {"abc.100@abc.com.au",true},
                {"abc@1.com",true},
                {"abc@gmail.com.com",true},
                {"abc+100@gmail.com",true},
                {"abc",false},
                {"abc@.com.my",false},
                {"abc123@gmail.a",false},
                {"abc123@.com",false},
                {"abc123@.com.com",false},
                {".abc@abc.com",false},
                {"abc()*@gmail.com",false},
                {"abc@%*.com",false},
                {"abc..2002@gmail.com",false},
                {"abc.@gmail.com",false},
                {"abc@abc@gmail.com",false},
                {"abc@gmail.com.1a",false},
                {"abc@gmail.com.aa.au",false}
        });
    }

    @Test
    public void validateEmail(){
        Assert.assertEquals(expectedValue,obj.validateMails(inputPattern,input));
    }

}