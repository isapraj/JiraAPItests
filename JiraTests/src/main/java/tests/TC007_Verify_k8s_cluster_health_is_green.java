package tests;

 

import java.io.IOException;

 


import org.junit.Assert;
import org.testng.annotations.Test;

 

import bases.baseMethods;

 

public class TC007_Verify_k8s_cluster_health_is_green extends baseMethods {
    
    @Test
    public void verifyKubernetesClusterHealthTobeGreen() throws IOException {
        String Health = baseMethods.Health;
        Assert.assertEquals("K8S Cluster Status is green", "green",Health.trim());

 

}
}