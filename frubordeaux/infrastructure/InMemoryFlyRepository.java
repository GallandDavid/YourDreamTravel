package frubordeaux.infrastructure;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import frubordeaux.domain.iRepository.FlyReposittory;
import frubordeaux.domain.value_object.Flight;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class InMemoryFlyRepository implements FlyReposittory {

    public String fileDB = "frubordeaux/database/FlyDB.json";

    @Override
    public Flight load(UUID ID) {
        List<Flight> objects = loadAll();
        for(Flight obj : objects) {
            if (obj.getID().equals(ID))
                return obj;
        }
        /*
         * Assert message not found
         * */
        return null;
    }

    @Override
    public Integer save(Flight flight) {
        Gson gson = new Gson();
        List<Flight> objects = loadAll();
        boolean find = false;
        for(Flight obj : objects){
            if(obj.equals(flight)){
                find = true;
                return -1;
            }
        }
        if(!find) {
            objects.add(flight);
            try (FileWriter writer = new FileWriter(fileDB)) {
                gson.toJson(objects, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }


    @Override
    public List<Flight> loadAll() {
        Gson gson = new Gson();
        // 1. JSON file to Java object
        List<Flight> objects = null;
        try {
            objects = gson.fromJson(new FileReader(fileDB), new TypeToken<List<Flight>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
