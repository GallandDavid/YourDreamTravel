package frubordeaux.infrastructure;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import frubordeaux.domain.entity.ServicePlace;
import frubordeaux.domain.iRepository.ServicePlaceRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class InMemoryServicePlaceRepository implements ServicePlaceRepository {
    public String fileDB = "frubordeaux/database/ServicePlaceDB.json";

    @Override
    public ServicePlace load(UUID ID) {
        List<ServicePlace> objects = loadAll();
        for(ServicePlace obj : objects) {
            if (obj.getID().equals(ID))
                return obj;
        }
        /*
         * Assert message not found
         * */
        return null;
    }

    @Override
    public void save(ServicePlace servicePlace) {
        Gson gson = new Gson();
        List<ServicePlace> objects = loadAll();
        boolean find = false;
        for(ServicePlace obj : objects){
            if(obj.getID() == servicePlace.getID()){
                find = true;
                update(servicePlace);
            }
        }
        if(!find) {
            objects.add(servicePlace);
            try (FileWriter writer = new FileWriter(fileDB)) {
                gson.toJson(objects, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(ServicePlace servicePlace){

    }

    @Override
    public List<ServicePlace> loadAll() {
        Gson gson = new Gson();
        // 1. JSON file to Java object
        List<ServicePlace> objects = null;
        try {
            objects = gson.fromJson(new FileReader(fileDB), new TypeToken<List<ServicePlace>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
