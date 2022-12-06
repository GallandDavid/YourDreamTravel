package frubordeaux.infrastructure;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import frubordeaux.domain.iRepository.PlaceRepository;
import frubordeaux.domain.value_object.Location;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class InMemoryPlaceRepository implements PlaceRepository {

    public String fileDB = "frubordeaux/database/PlaceDB.json";
    public InMemoryPlaceRepository(){

    }

    @Override
    public Location load(UUID ID) {
        List<Location> objects = loadAll();
        for(Location obj : objects) {
            System.out.println(obj.getName());
            if (obj.getID().equals(ID))
                return obj;
        }
        /*
        * Assert message not found
        * */
        return null;
    }

    @Override
    public void save(Location location) {
        Gson gson = new Gson();
        List<Location> objects = loadAll();
        boolean find = false;
        for(Location obj : objects){
            if(obj.getID() == location.getID()){
                find = true;
                //update(place)
            }
        }
        if(!find) {
            objects.add(location);
            try (FileWriter writer = new FileWriter(fileDB)) {
                gson.toJson(objects, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Location> loadAll() {
        Gson gson = new Gson();
        // 1. JSON file to Java object
        List<Location> objects = null;
        try {
            objects = gson.fromJson(new FileReader(fileDB), new TypeToken<List<Location>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
