package uz.pdp.BilolIncorporation.repository.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import uz.pdp.BilolIncorporation.entity.user.UserEntity;

import java.util.List;
import java.util.UUID;

@Repository(value = "userRepository")
public class UserRepositoryImpl implements UserRepository  {
    @PersistenceContext
    private EntityManager entityManager;
    String getAll = "select u from users u";
    String delete = "delete from users where id = :user_id";
    String getByUsername = "select u from users u where u.username = :username";
    @Override
    @Transactional
    public UserEntity save(UserEntity userEntity) {
        entityManager.persist(userEntity);
        return userEntity;
    }

    @Override
    public List<UserEntity> getAll() {
        return entityManager.createQuery(getAll, UserEntity.class)
                .getResultList();
    }

    @Override
    public UserEntity getById(UUID id) {
        return entityManager.find(UserEntity.class, id);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        entityManager
                .createQuery(delete)
                .setParameter("user_id",id)
                .executeUpdate();
    }


    @Override
    public UserEntity getByUsername(String username) {
        return entityManager.createQuery(getByUsername, UserEntity.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
