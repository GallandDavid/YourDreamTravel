package frubordeaux.domain.value_object;

import java.util.Date;
//modification du value object pour permettre de savoir combien de ticket son restant
public class FlyDate {
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
}
