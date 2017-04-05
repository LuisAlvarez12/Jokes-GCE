/**
 * Created by luisalvarez on 4/5/17.
 */

import android.util.Log;

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
}
