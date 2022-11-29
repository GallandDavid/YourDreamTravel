package frubordeaux.domain.entity;

import frubordeaux.domain.value_object.Product;

public class CommandeLine {
    private final Product reference;
    private Integer quantity;
    private Double price = 0.0;

    public CommandeLine(Product reference, Integer quantity){
        this.reference = reference;
        this.quantity = quantity;
        this.price = reference.getPrice() * quantity.doubleValue();
    }

    public Product getReference() {
        return reference;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void changeQuantity(Integer quantity){
        this.quantity = quantity;
        this.price = getReference().getPrice() * getQuantity().doubleValue();
    }

    public void addQuantity(Integer quantity){
        this.quantity = this.quantity + quantity;
        this.price = getReference().getPrice() * getQuantity().doubleValue();
    }

    public void removeQuantity(Integer quantity){
        this.quantity = this.quantity - quantity;
        if(this.quantity < 0) this.quantity = 0;
        this.price = getReference().getPrice() * getQuantity().doubleValue();
    }

    @Override
    public boolean equals(Object o){
        CommandeLine commandeLine = (CommandeLine) o;
        return this.getReference().equals(commandeLine.getReference()) && getQuantity().equals(commandeLine.getQuantity());
    }

}
