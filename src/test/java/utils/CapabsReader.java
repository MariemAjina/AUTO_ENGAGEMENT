package utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CapabsReader {
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(ConfigFileReader.getConfigPropertyVal("CAPABS_FILE_PATH")));
            String line = reader.readLine();
            while (line != null) {
                // System.out.println(line);
                String[] cap = line.split("=");
                if (cap.length == 2) {
                    capabilities.setCapability(cap[0], cap[1]);
                } else {
                    System.err.println("Invalid capability format: " + line);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return capabilities;
    }
}



