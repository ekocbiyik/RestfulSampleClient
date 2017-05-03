import com.google.gson.GsonBuilder;
import model.Araba;
import model.Personel;
import remote.RemoteUtils;

import java.util.Arrays;

/**
 * Created by enbiya on 03.05.2017.
 */
public class MainApp {


    public static void main(String[] args) {

        /** Tüm verileri listeleyelim */
        System.out.println("*************** Önceki Kayıtlar ******************");
        RemoteUtils.getAllPersonels();


        /** yeni personel oluşturalım */
        Personel p = new Personel("Client", "uygulama", Arrays.asList(new Araba("DOGAN", "BORDO")));

        /** personel bilgisini json formtaına çevirelim */
        String jsonPersonel = new GsonBuilder().create().toJson(p, Personel.class);
        RemoteUtils.savePersonel(jsonPersonel);

        System.out.println("*************** Sonraki Kayıtlar ******************");


        /** Tüm verileri tekrar listeleyelim */
        RemoteUtils.getAllPersonels();

    }
}
