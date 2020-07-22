package tests;
import java.io.IOException;
import java.util.List;

 

import org.junit.Assert;
import org.testng.annotations.Test;

 

import bases.baseMethods;
public class TC008_Verify_Version_of_the_Cluster extends baseMethods {

 

    @Test
    public void verifyVersionofCluster() throws IOException {
        String Phase = baseMethods.Phase;
        String Version = baseMethods.Version;
        Assert.assertEquals("Phase is Ready", "Ready",Phase.trim());
        Assert.assertEquals("Version is "+ (String) Version ,"7.7.0",Version.trim());
        
    }
}