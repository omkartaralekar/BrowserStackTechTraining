package utils;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Uttilities {

    static String userName =""; //BrowserStack UserName
    static String accesskey ="";//BrowserStack AccessKey

    public void localAppUpload() throws IOException, URISyntaxException {
        String urlS = "https://"+userName+":"+accesskey+"@api.browserstack.com/app-automate/upload";

        HttpClient client = (HttpClient) new DefaultHttpClient();
        URI url = new URI(urlS);
        HttpPost post = new HttpPost(url);

        MultipartEntity nameValuePairs = new MultipartEntity();
        //Select the file you want to upload .ipa or .apk and pass the path accordingly.
        nameValuePairs.addPart("file",new FileBody(new File("/Users/omkartaralekar/Downloads/WikipediaSample.apk")));//Path to the file
        post.setEntity(nameValuePairs);
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity,"UTF-8");
        System.out.println(responseString);

    }
    public void uploadAppFromURL() throws IOException {
        String command = "curl -u \"omkart_kJ1gzD:GzgXZ5kgunjxMqUaqcNA\" \\\n" +
                "-X POST \"https://api-cloud.browserstack.com/app-automate/upload\" \\\n" +
                "-F \"url=https://www.browserstack.com/app-automate/sample-apps/android/WikipediaSample.apk\"\n";
        Process process = Runtime.getRuntime().exec(command);
    }
    public void statusUpdate() throws URISyntaxException, IOException {
        URI uri = new URI("https://omkartaralekar_exYuMj:8chzwMYzg8eHf8LWQUdF@api.browserstack.com/app-automate/sessions/4c185b332222c28406042a44e0015613d19e3085.json");
        HttpPut putRequest = new HttpPut(uri);

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add((new BasicNameValuePair("status", "Passesd")));
        nameValuePairs.add((new BasicNameValuePair("reason", "Successful")));
        putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        HttpClientBuilder.create().build().execute(putRequest);
    }
    public static JSONObject parse(String file) {
        InputStream is = Uttilities.class.getClassLoader().getResourceAsStream(file);
        assert is != null;
        return new JSONObject(new JSONTokener(is));
    }
}