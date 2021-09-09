package planetnoobs.stringcalculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;

@RunWith(JUnit4.class)
public class StringValidator {

    StringCalculator stringCalculator = new StringCalculator();

    private String randomInt() {
        return String.valueOf(new Random().nextInt(10 - 1 + 1) + 1);
    }

    @Test
    public void assetStringCalculator() {
        String randomInput = randomInt()+";"+randomInt()+"."+randomInt()+"*"+randomInt();
        int validateInput = stringCalculator.calculateString(randomInput);
        Assert.assertTrue(validateInput < 0);
    }
}
