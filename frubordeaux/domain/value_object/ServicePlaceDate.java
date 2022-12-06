package frubordeaux.domain.value_object;

import frubordeaux.domain.Displayable;

import java.util.UUID;

public class ServicePlaceDate  implements Displayable {
    public UUID getID() {
        return ID;
    }

    public UUID ID;

    public ServicePlaceDate(){
        ID = UUID.randomUUID();
    }

    @Override
    public String displayRead() {
        return null;
    }
}
