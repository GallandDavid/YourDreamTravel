package frubordeaux.domain.value_object;

import frubordeaux.domain.Displayable;

import java.util.UUID;

public class Service implements Displayable {

    public UUID ID;

    public Service(){
        ID = UUID.randomUUID();
    }

    public UUID getID() {
        return ID;
    }

    @Override
    public String displayRead() {
        return null;
    }
}
