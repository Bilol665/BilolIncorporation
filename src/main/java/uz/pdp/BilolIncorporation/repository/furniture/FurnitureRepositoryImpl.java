package uz.pdp.BilolIncorporation.repository.furniture;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import uz.pdp.BilolIncorporation.entity.furniture.Furniture;

import java.util.List;
import java.util.UUID;

@Repository
public class FurnitureRepositoryImpl implements FurnitureRepository {
    @PersistenceContext
    private EntityManager entityManager;

    String getAll = "select f from furniture f";
    String getById = "select f from furniture f where id = :id";
    String DELETE_BY_ID = "delete from furniture where id = :id";
    String getUserPosts = "select f from furniture f where owner_id = :user_id";
    @Override
    @Transactional
    public Furniture save(Furniture furniture) {
        entityManager.persist(furniture);
        return furniture;
    }

    @Override
    public List<Furniture> getAll() {
        return entityManager.createQuery(getAll, Furniture.class)
                .getResultList();
    }

    @Override
    public Furniture getById(UUID id) {
        return entityManager.createQuery(getById, Furniture.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        entityManager.createQuery(DELETE_BY_ID)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public Furniture update(Furniture update) {
        return entityManager.merge(update);
    }

    @Override
    public List<Furniture> getUserPosts(UUID user_id) {
        return entityManager.createQuery(getUserPosts, Furniture.class)
                .setParameter("user_id", user_id)
                .getResultList();
    }
}
