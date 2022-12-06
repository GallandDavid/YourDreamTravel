package frubordeaux.domain.value_object;

import java.util.Date;
import java.util.UUID;

//modification du value object pour permettre de savoir combien de ticket son restant
public class FlyDate {
    private final UUID ID = UUID.randomUUID();
    private final Fly ref;
    private final Date date;
    private final Integer nbTickets;
    private Integer nbFirstTickets;
    private Integer nbReducedTickets;

    public FlyDate(Fly ref, Date date, Integer nbTickets, Integer nbFirstTickets, Integer nbReducedTickets){
        this.ref = ref;
        this.date = date;
        this.nbTickets = nbTickets;
        this.nbFirstTickets = nbFirstTickets;
        this.nbReducedTickets = nbReducedTickets;
    }

    public Fly getFly() {
        return ref;
    }

    public Date getDate() {
        return date;
    }

    public Integer getNbTickets() {
        return nbTickets;
    }

    public Integer getNbFirstTickets() {
        return nbFirstTickets;
    }

    public Integer getNbReducedTickets() {
        return nbReducedTickets;
    }
    public UUID getID() {
        return ID;
    }
}
