package frubordeaux.infrastructure;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import frubordeaux.domain.agregate.Reservation;
import frubordeaux.domain.iRepository.ReservationRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class InMemoryReservationRepository implements ReservationRepository {

    public String fileDB = "frubordeaux/database/ReservationDB.json";

    @Override
    public Reservation load(UUID ID) {
        List<Reservation> objects = loadAll();
        for(Reservation obj : objects) {
            if (obj.getID().equals(ID))
                return obj;
        }
        /*
         * Assert message not found
         * */
        return null;
    }

    @Override
    public void save(Reservation reservation) {
        Gson gson = new Gson();
        List<Reservation> objects = loadAll();
        boolean find = false;
        for(Reservation obj : objects){
            if(obj.getID() == reservation.getID()){
                find = true;
                update(reservation);
            }
        }
        if(!find) {
            objects.add(reservation);
            try (FileWriter writer = new FileWriter(fileDB)) {
                gson.toJson(objects, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Reservation reservation){

    }

    @Override
    public List<Reservation> loadAll() {
        Gson gson = new Gson();
        // 1. JSON file to Java object
        List<Reservation> objects = null;
        try {
            objects = gson.fromJson(new FileReader(fileDB), new TypeToken<List<Reservation>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
