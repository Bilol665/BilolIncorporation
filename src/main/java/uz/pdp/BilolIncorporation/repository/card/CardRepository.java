package uz.pdp.BilolIncorporation.repository.card;

import uz.pdp.BilolIncorporation.dto.CardDto;
import uz.pdp.BilolIncorporation.entity.card.Card;
import uz.pdp.BilolIncorporation.repository.BaseRepository;

import java.util.List;
import java.util.UUID;

public interface CardRepository extends BaseRepository<Card> {
    List<Card> getCardsByUserId(UUID userId);
    Card update(Card card);
}
