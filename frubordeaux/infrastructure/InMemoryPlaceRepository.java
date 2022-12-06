package frubordeaux.infrastructure;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import frubordeaux.domain.iRepository.PlaceRepository;
import frubordeaux.domain.value_object.Place;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.google.gson.reflect.TypeToken;

public class InMemoryPlaceRepository implements PlaceRepository {

    public String fileDB = "../database/PlaceDB.json";
    public InMemoryPlaceRepository(){

    }

    @Override
    public Place load(UUID ID) {
        List<Place> objects = loadAll();
        for(Place obj : objects) {
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
    public void save(Place place) {
        Gson gson = new Gson();
        List<Place> objects = loadAll();
        boolean find = false;
        for(Place obj : objects){
            if(obj.getID() == place.getID()){
                find = true;
                //update(place)
            }
        }
        if(!find) {
            objects.add(place);
            try (FileWriter writer = new FileWriter(fileDB)) {
                gson.toJson(objects, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Place> loadAll() {
        Gson gson = new Gson();
        // 1. JSON file to Java object
        List<Place> objects = null;
        try {
            objects = gson.fromJson(new FileReader(fileDB), new TypeToken<List<Place>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
