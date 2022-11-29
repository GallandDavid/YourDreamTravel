package frubordeaux.domain.agregate;

import frubordeaux.domain.entity.CommandeLine;
import frubordeaux.domain.value_object.Product;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Basket{
    private final UUID ID = UUID.randomUUID();
    private Map<Product, CommandeLine> products = new HashMap<>();
    private Double price = 0.0;

    public Basket(){}

    public Double getPrice(){
        double price = 0;
        for (Map.Entry<Product, CommandeLine> entry : products.entrySet() ) {
            price += entry.getValue().getPrice();
        }
        return price;
    }

    public UUID getID() {
        return ID;
    }

    public void addCommandeLine(CommandeLine cmdL){
        if(products.containsKey(cmdL.getReference())){
            boolean find = false;
            for (CommandeLine cmdL_products : products.values()) {
                if(cmdL_products.equals(cmdL)){
                    cmdL_products.addQuantity(cmdL.getQuantity());
                    price = getPrice();
                }
            }
            if(!find){
                products.put(cmdL.getReference(),cmdL);
                price = getPrice();
            }
        }
    }

    public void deleteCommandeLine(Product ref){ if(products.containsValue(ref)) products.remove(products.get(ref)); }

    public void addCommandeLineQuantity(Product ref, Integer quantity){
        if(products.containsValue(ref)) products.get(ref).addQuantity(quantity);
    }

    public void removeCommandeLineQuantity(Product ref, Integer quantity){
        if(products.containsValue(ref)) products.get(ref).removeQuantity(quantity);
    }
}
