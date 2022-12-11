package frubordeaux.infrastructure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import frubordeaux.domain.LocalDateTimeDeserializer;
import frubordeaux.domain.LocalDateTimeSerializer;
import frubordeaux.domain.iRepository.FlyDateRepository;
import frubordeaux.domain.value_object.Flight;
import frubordeaux.domain.value_object.FlyDate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;
public class InMemoryFlyDateRepository implements FlyDateRepository {
    public String fileDB = "frubordeaux/database/FlyDateDB.json";

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
    public List<FlyDate> load(Flight flight) {
        List<FlyDate> res = new ArrayList<>();
        List<FlyDate> objects = loadAll();
        for(FlyDate obj : objects) {
            if(obj.getFly().equals(flight)) res.add(obj);
        }
        return res;
    }

    public int save2(FlyDate flyDate) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

            try (FileWriter writer = new FileWriter(fileDB)) {
                gson.toJson(flyDate, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return 0;
    }
    @Override
    public int save(FlyDate flyDate) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        List<FlyDate> objects = loadAll();
        boolean find = false;
        for(FlyDate obj : objects){
            if(obj.equals(flyDate)){
                find = true;
                return -1;
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
        return 0;
    }

    @Override
    public void update(FlyDate flyDate) {
        List<FlyDate> objects = loadAll();
        for(FlyDate obj : objects){
            if(obj.equals(flyDate)){
                objects.remove(obj);
                objects.add(flyDate);
                try (FileWriter writer = new FileWriter(fileDB)) {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
                    gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
                    Gson gson = gsonBuilder.setPrettyPrinting().create();
                    gson.toJson(objects, writer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }

    @Override
    public List<FlyDate> loadAll() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
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
