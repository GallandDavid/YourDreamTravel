package frubordeaux.infrastructure;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import frubordeaux.domain.iRepository.ServicePlaceDateRepository;
import frubordeaux.domain.value_object.ServicePlaceDate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class InMemoryServicePlaceDateRepository implements ServicePlaceDateRepository {
    public String fileDB = "../database/ServicePlaceDateDB.json";

    @Override
    public ServicePlaceDate load(UUID ID) {
        List<ServicePlaceDate> objects = loadAll();
        for(ServicePlaceDate obj : objects) {
            if (obj.getID().equals(ID))
                return obj;
        }
        /*
         * Assert message not found
         * */
        return null;
    }

    @Override
    public void save(ServicePlaceDate servicePlaceDate) {
        Gson gson = new Gson();
        List<ServicePlaceDate> objects = loadAll();
        boolean find = false;
        for(ServicePlaceDate obj : objects){
            if(obj.getID() == servicePlaceDate.getID()){
                find = true;
                update(servicePlaceDate);
            }
        }
        if(!find) {
            objects.add(servicePlaceDate);
            try (FileWriter writer = new FileWriter(fileDB)) {
                gson.toJson(objects, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(ServicePlaceDate servicePlaceDate){

    }

    @Override
    public List<ServicePlaceDate> loadAll() {
        Gson gson = new Gson();
        // 1. JSON file to Java object
        List<ServicePlaceDate> objects = null;
        try {
            objects = gson.fromJson(new FileReader(fileDB), new TypeToken<List<ServicePlaceDate>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
