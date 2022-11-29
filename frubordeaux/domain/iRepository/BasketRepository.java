package frubordeaux.domain.iRepository;

import frubordeaux.domain.agregate.Basket;

import java.util.UUID;

public interface BasketRepository {

    public Basket load(UUID ID);

    public void save(Basket basket);

    public Basket update()
}
