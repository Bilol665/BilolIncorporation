package uz.pdp.BilolIncorporation.repository.card;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import uz.pdp.BilolIncorporation.dto.CardDto;
import uz.pdp.BilolIncorporation.entity.card.Card;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class CardRepositoryImpl implements CardRepository {
    String getAll = "select c from cards c";
    String deleteBYId = "delete from cards c where c.id = :id";
    String getCardsByUserId = "select c from cards c where owner_id = :id";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Card save(Card card) {
        entityManager.persist(card);
        return card;
    }

    @Override
    public List<Card> getAll() {
        return entityManager.createQuery(getAll,Card.class)
                .getResultList();
    }

    @Override
    public Card getById(UUID id) {
        return entityManager.find(Card.class,id);
    }

    @Override
    public void deleteById(UUID id) {
        entityManager.createQuery(deleteBYId)
                .setParameter("id",id)
                .executeUpdate();
    }


    @Override
    public List<Card> getCardsByUserId(UUID userId) {
        try{
            return entityManager.createQuery(getCardsByUserId,Card.class)
                    .setParameter("id",userId)
                    .getResultList();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Card update(Card card) {
        return entityManager.merge(card);
    }
}
