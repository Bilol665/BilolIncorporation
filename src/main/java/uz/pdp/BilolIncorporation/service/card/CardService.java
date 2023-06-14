package uz.pdp.BilolIncorporation.service.card;

import uz.pdp.BilolIncorporation.dto.CardDto;
import uz.pdp.BilolIncorporation.entity.card.Card;
import uz.pdp.BilolIncorporation.service.BaseService;

import java.util.List;
import java.util.UUID;

public interface CardService extends BaseService<Card> {
    List<Card> getCardsByUserId(UUID userId);
    int add(CardDto card, UUID owner_id);
    Card update(CardDto cardDto,UUID cardId,UUID owner_id);
}
