package frubordeaux.infrastructure;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import frubordeaux.domain.iRepository.FlyDateRepository;
import frubordeaux.domain.value_object.FlyDate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class InMemoryFlyDateRepository implements FlyDateRepository {
    public String fileDB = "../database/FlyDateDB.json";

    @Override
    public FlyDate load(UUID ID) {
        List<FlyDate> objects = loadAll();
        for(FlyDate obj : objects) {
            if (obj.getID().equals(ID))
                return obj;
        }
        /*
         * Assert message not found
         * */
        return null;
    }

    @Override
    public void save(FlyDate flyDate) {
        Gson gson = new Gson();
        List<FlyDate> objects = loadAll();
        boolean find = false;
        for(FlyDate obj : objects){
            if(obj.getID() == flyDate.getID()){
                find = true;
                //update(flyDate);
            }
        }
        if(!find) {
            objects.add(flyDate);
            try (FileWriter writer = new FileWriter(fileDB)) {
                gson.toJson(objects, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(FlyDate flyDate) {
    }

    @Override
    public List<FlyDate> loadAll() {
        Gson gson = new Gson();
        // 1. JSON file to Java object
        List<FlyDate> objects = null;
        try {
            objects = gson.fromJson(new FileReader(fileDB), new TypeToken<List<FlyDate>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
