package remote;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by enbiya on 03.05.2017.
 */
public class RemoteUtils {

    public static void getAllPersonels() {

        try {

            String url = "http://localhost:8061/wsapi/personelresource/getallpersonels";
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("Content-Type", "application/json");

            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpGet);

            /** Hatırlarsanız getAllPersonels servisimizin dönüş değeri 202 idi
             *  return Response.status(Status.ACCEPTED).entity(entity).build();
             *  bu yüzden tanımlayacağımız status kodları client tarafından da bilinmelidir
             *  standardın dışına çıkmamak en iyisi
             * */
            if (response.getStatusLine().getStatusCode() == 202) {

                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                List<String> responseList = IOUtils.readLines(rd);

                // dönen cevap Json formatında ve tek satır olduğunu biliyoruz
                System.out.println(responseList.get(0));

                /** buradan sonraki işlemde Json'u Personel modeline göre parse edebiliriz */
            }

            response.close();
            httpClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePersonel(String jsonPersonel) {

        try {

            String url = "http://localhost:8061/wsapi/personelresource/savePersonel";
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json");

            HttpEntity entity = new StringEntity(jsonPersonel);
            httpPost.setEntity(entity);

            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println("Kayıt ekleme başarılı!");
            }

            response.close();
            httpClient.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
