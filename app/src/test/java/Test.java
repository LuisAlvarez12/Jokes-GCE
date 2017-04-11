/**
 * Created by luisalvarez on 4/5/17.
 */

import android.util.Log;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class Test {
    static <T> T test(T o) {
        String line = (String)o;
        if(((String) o).length()>0 && line!=null) {
            return o;
        }
        return null;
    }

    static <T> T test(T o, boolean log) {
        if (log) Log.i(Test.class.getName(), o.toString());
        return o;
    }


    public void testConvertCelsiusToFahrenheit() {
        float actual = 1.01f;
        // expected value is 100
        float expected = 100;
        // use this method because float is not precise
        assertEquals("Conversion from celsius to fahrenheit failed", expected, actual, 0.001);
    }

    public void testJokeStringLength_Exceeds(String joke){
        int length = joke.length();
        assertTrue(length>100);
    }

    static <T> T testJokeStringNotNullOrError(T o) {
        String line = (String)o;
        if(((String) o).length()>0 && line!=null) {
            testJokeStringNotNullOrError(line);
            test(line);
            return o;
        }
        return null;
    }



}
