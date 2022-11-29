package frubordeaux.domain.value_object;


public abstract class  Product {
    private final String ref;
    private final String name;
    private final String description;
    private final Double price;

    public Product(String ref, String name, String description, Double price) throws IllegalArgumentException{
        this.ref = ref;
        if( name.length() > 20 || description.length() > 220 || price == 0.0){throw new IllegalArgumentException();}
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getRef() {
        return ref;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public  int hashCode(){
        return ref.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        return ref.equals(product.ref);
    }
}
