package uz.pdp.BilolIncorporation.repository.order;

import uz.pdp.BilolIncorporation.entity.order.Order;
import uz.pdp.BilolIncorporation.repository.BaseRepository;

import java.util.UUID;

public interface OrderRepository extends BaseRepository<Order> {
    Order getByUserId(UUID id);
    Order update(Order order);
}
