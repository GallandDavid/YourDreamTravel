package frubordeaux.infrastructure;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import frubordeaux.domain.iRepository.FlyReposittory;
import frubordeaux.domain.value_object.Fly;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class InMemoryFlyRepository implements FlyReposittory {

    public String fileDB = "../database/FlyDB.json";

    @Override
    public Fly load(UUID ID) {
        List<Fly> objects = loadAll();
        for(Fly obj : objects) {
            if (obj.getID().equals(ID))
                return obj;
        }
        /*
         * Assert message not found
         * */
        return null;
    }

    @Override
    public void save(Fly fly) {
        Gson gson = new Gson();
        List<Fly> objects = loadAll();
        boolean find = false;
        for(Fly obj : objects){
            if(obj.getID() == fly.getID()){
                find = true;
                //update(flyDate);
            }
        }
        if(!find) {
            objects.add(fly);
            try (FileWriter writer = new FileWriter(fileDB)) {
                gson.toJson(objects, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Fly fly) {
    }

    @Override
    public List<Fly> loadAll() {
        Gson gson = new Gson();
        // 1. JSON file to Java object
        List<Fly> objects = null;
        try {
            objects = gson.fromJson(new FileReader(fileDB), new TypeToken<List<Fly>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
