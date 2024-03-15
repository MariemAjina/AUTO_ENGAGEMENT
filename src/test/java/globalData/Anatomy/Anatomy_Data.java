package globalData.Anatomy;

import java.util.ArrayList;
import java.util.List;

public class Anatomy_Data {
    public String TitlePicture_ANATOMY_BARE_BONES = "Figure 1.1:  Anatomical planes and terms.";
    public String ErrorMsg = "Content does not match expected value.";
    public List<String> getTitlesToVerify() {
        List<String> titles = new ArrayList<>();
        titles.add("Anatomical Position and Planes");
        titles.add("Movement");
        titles.add("Dermatomes");
        titles.add("Nervous System");
        return titles;
    }

}
