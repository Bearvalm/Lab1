import java.io.*;
import java.util.*;
import junit.framework.*;
import jdepend.framework.*;

/**
 * Created by redric on 08.12.17.
 */
public class tt extends TestCase{

        /**  Tests that a single package does not contain
         *  any package dependency cycles.
         */
        public void testOnePackageCycle() throws IOException {

            JDepend _jdepend = new JDepend();

            _jdepend.addDirectory("/home/redric/TarsosDSP-master/");

            _jdepend.analyze();

            JavaPackage p = _jdepend.getPackage("/android/be/tarsos/dsp/io/android/");

            assertNotNull(p);
            assertEquals("Cycle exists: " + p.getName(),
                    false, p.containsCycle());
        }
}
