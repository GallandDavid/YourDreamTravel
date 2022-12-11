package frubordeaux.infrastructure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import frubordeaux.domain.LocalDateTimeDeserializer;
import frubordeaux.domain.LocalDateTimeSerializer;
import frubordeaux.domain.entity.FlightTicket;
import frubordeaux.domain.iRepository.FlyTicketRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class InMemoryFlyTicketRepository implements FlyTicketRepository {
    public String fileDB = "frubordeaux/database/FlyTicketDB.json";

    @Override
    public FlightTicket load(UUID ID) {
        List<FlightTicket> objects = loadAll();
        for(FlightTicket obj : objects) {
            if (obj.getID().equals(ID))
                return obj;
        }
        /*
         * Assert message not found
         * */
        return null;
    }

    @Override
    public int save(FlightTicket flyTicket) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        List<FlightTicket> objects = loadAll();
        boolean find = false;
        for(FlightTicket obj : objects){
            if(obj.getID() == flyTicket.getID()){
                find = true;
                return -1;
            }
        }
        if(!find) {
            objects.add(flyTicket);
            try (FileWriter writer = new FileWriter(fileDB)) {
                gson.toJson(objects, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public void update(FlightTicket flyTicket) {
    }

    @Override
    public List<FlightTicket> loadAll() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        // 1. JSON file to Java object
        List<FlightTicket> objects = null;
        try {
            objects = gson.fromJson(new FileReader(fileDB), new TypeToken<List<FlightTicket>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
