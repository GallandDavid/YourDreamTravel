package frubordeaux.ui;

public enum MenuIndice {
    HOME(0),
    RESERVATION(1),
    DATA(2),
    RESERVATION_CHOICE(11),
    RESERVATION_CREATION(12),
    DATA_READ(21),
    DATA_WRITE(22);

    public final int value;

    MenuIndice(int value){
        this.value = value;
    }
}
