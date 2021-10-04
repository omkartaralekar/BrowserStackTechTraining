package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class DriverManager {
    AppiumDriver driver;
    private String sessionId;
    JSONObject deviceObj;

    public AppiumDriver initializeDriver(String deviceName) throws Exception {
        deviceObj = new JSONObject(Uttilities.parse("loginUsers.json").getJSONObject("validUser").toString());
        String userName = deviceObj.getString("username");
        String accessKey = deviceObj.getString("password");
        String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
        deviceObj = new JSONObject(Uttilities.parse("Devices.json").getJSONObject(deviceName).toString());
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", deviceObj.getString("device"));
        caps.setCapability("os_version", deviceObj.getString("os_version"));
        caps.setCapability("project", "My First Project");
        caps.setCapability("build", buildName);
        caps.setCapability("name", "Wikipedia Test Mobile");
//        caps.setCapability("app", deviceObj.getString("app_url"));
            caps.setCapability("browser", "firefox");
        caps.setCapability("browser_version", "latest");
        URL url = new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub");
        switch (deviceName) {
            case "google":
                driver = new AndroidDriver(url, caps);
                break;
            case "samsung":
                driver = new AndroidDriver(url, caps);
                break;
            case "oneplus":
                driver = new AndroidDriver(url, caps);
                break;
            case "apple":
                driver = new IOSDriver(url, caps);
                break;
            default:
                throw new IllegalStateException("invalid device id" + deviceName);
        }
        return driver;
    }

    public void statusMarkMethod(String sessionId) throws URISyntaxException, IOException {
        this.sessionId = sessionId;
        System.out.println("Inside Status" + sessionId);
        URI uri = new URI("https://omkartaralekar_exYuMj:8chzwMYzg8eHf8LWQUdF@api.browserstack.com/app-automate/sessions/" + sessionId + ".json");
        HttpPut putRequest = new HttpPut(uri);

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add((new BasicNameValuePair("status", "Passed")));
        nameValuePairs.add((new BasicNameValuePair("reason", "Successful")));
        putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        HttpClientBuilder.create().build().execute(putRequest);
        /*String command =
                "curl -u \"omkartaralekar_exYuMj:8chzwMYzg8eHf8LWQUdF\" -X PUT -H \"Content-Type: application/json\" \\\n" +
                        "-d \"{\\\"status\\\":\\\"passed\\\", \\\"reason\\\":\\\"Marking using API\\\"}\" \\\n" +
                        " https://api.browserstack.com/automate/sessions/"+sessionId+".json";
        Process process =Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(process.getInputStream()));

        StringBuilder builder = new StringBuilder();
        String line = null;
        while ( (line = reader.readLine()) != null) {
            builder.append(line);
            builder.append(System.getProperty("line.separator"));
        }
        String result = builder.toString();
        System.out.print(result);*/
    }
}