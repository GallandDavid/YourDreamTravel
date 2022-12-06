package frubordeaux.domain.entity;

import frubordeaux.domain.value_object.Fly;
import frubordeaux.domain.value_object.FlyDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlyListDate {
    public Map<Fly, ArrayList<FlyDate>> flys = new HashMap();

    public FlyListDate(){
        /*
        * Get all the flys on the repository
        * */
    }
}
