package uz.pdp.BilolIncorporation.service.order;

import uz.pdp.BilolIncorporation.entity.order.Order;
import uz.pdp.BilolIncorporation.service.BaseService;

import java.util.UUID;

public interface OrderService extends BaseService<Order> {
    Order getByUserId (UUID id);
    boolean checkLength();
    Order justUpdate(Order order);
}
