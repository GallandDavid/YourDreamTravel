package frubordeaux.infrastructure;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import frubordeaux.domain.agregate.Reservation;
import frubordeaux.domain.iRepository.ServiceRepository;
import frubordeaux.domain.value_object.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class InMemoryServiceRepository implements ServiceRepository {
    public String fileDB = "../database/ServiceDB.json";

    @Override
    public Service load(UUID ID) {
        List<Service> objects = loadAll();
        for(Service obj : objects) {
            if (obj.getID().equals(ID))
                return obj;
        }
        /*
         * Assert message not found
         * */
        return null;
    }

    @Override
    public void save(Service service) {
        Gson gson = new Gson();
        List<Service> objects = loadAll();
        boolean find = false;
        for(Service obj : objects){
            if(obj.getID() == service.getID()){
                find = true;
                update(service);
            }
        }
        if(!find) {
            objects.add(service);
            try (FileWriter writer = new FileWriter(fileDB)) {
                gson.toJson(objects, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Reservation service){

    }

    @Override
    public List<Service> loadAll() {
        Gson gson = new Gson();
        // 1. JSON file to Java object
        List<Service> objects = null;
        try {
            objects = gson.fromJson(new FileReader(fileDB), new TypeToken<List<Service>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
