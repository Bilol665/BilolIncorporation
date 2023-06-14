package uz.pdp.BilolIncorporation.repository.order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import uz.pdp.BilolIncorporation.entity.order.Order;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;
    String getAll = "select o from orders o";
    String delete = "delete from orders where id = :id";
    String getByUserId = "select o from orders o where o.user.id = :id";
    @Override
    public Order save(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    public List<Order> getAll() {
        return entityManager.createQuery(getAll,Order.class)
                .getResultList();
    }

    @Override
    public Order getById(UUID id) {
        return entityManager.find(Order.class,id);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        entityManager.createQuery(delete)
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    public Order getByUserId(UUID id) {
        return entityManager.createQuery(getByUserId, Order.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Order update(Order order) {
        entityManager.merge(order);
        return order;
    }

}
