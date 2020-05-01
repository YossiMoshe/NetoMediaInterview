package unit.infra.data_providers;

import infrastructure.data_readers.ConfigPropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static infrastructure.data_readers.DataReader.getData;

public class DataProvidersHealthCheckTests {

    @Test
    public void urlTest() {
        Assert.assertEquals(getData("URL"),"https://www.google.com/");
    }

    @Test
    public void browserTypeTest() {
        ConfigPropertiesReader reader = new ConfigPropertiesReader();
        Assert.assertEquals(reader.getBrowserType(),"chrome");
    }


}
