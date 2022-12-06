package frubordeaux.infrastructure;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import frubordeaux.domain.entity.FlightTicket;
import frubordeaux.domain.iRepository.FlyTicketRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class InMemoryFlyTicketRepository implements FlyTicketRepository {
    public String fileDB = "../database/FlyTicketDB.json";

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
    public void save(FlightTicket flyTicket) {
        Gson gson = new Gson();
        List<FlightTicket> objects = loadAll();
        boolean find = false;
        for(FlightTicket obj : objects){
            if(obj.getID() == flyTicket.getID()){
                find = true;
                //update(flyDate);
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
    }

    @Override
    public void update(FlightTicket flyTicket) {
    }

    @Override
    public List<FlightTicket> loadAll() {
        Gson gson = new Gson();
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
