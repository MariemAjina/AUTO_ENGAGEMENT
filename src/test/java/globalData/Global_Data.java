package globalData;

import java.util.ArrayList;
import java.util.List;

public class Global_Data {
    public static final String PflegePackage = "com.mobelite.pflegedevandroid";
    public static final String EMEEUKPackage = "com.mobelite.emeeApp";
   // public static final String InfirmierPackage = "com.mobelite.infirmier";

    public static List<String> getAppPackagePrefixes() {
        List<String> NamePackage = new ArrayList<>();
   //    NamePackage.add(PflegePackage);
       NamePackage.add(EMEEUKPackage);
      //   NamePackage.add(InfirmierPackage);
        // Ajoutez d'autres préfixes de package si nécessaire
        return NamePackage;
    }

}
