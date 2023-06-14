package uz.pdp.BilolIncorporation.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.BilolIncorporation.entity.order.Order;
import uz.pdp.BilolIncorporation.repository.order.OrderRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public int add(Order model) {
        Order save = orderRepository.save(model);
        if(save == null) return -1;
        else return 1;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order getById(UUID id) {
        return orderRepository.getById(id);
    }

    @Override
    public void deleteById(UUID id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getByUserId(UUID id) {
        return orderRepository.getByUserId(id);
    }

    @Override
    public boolean checkLength() {
        return getAll().size() == 0;
    }

    @Override
    public Order justUpdate(Order order) {
        return orderRepository.update(order);
    }

}
