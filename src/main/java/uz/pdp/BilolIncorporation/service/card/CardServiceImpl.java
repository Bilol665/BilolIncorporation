package uz.pdp.BilolIncorporation.service.card;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.BilolIncorporation.dto.CardDto;
import uz.pdp.BilolIncorporation.entity.card.Card;
import uz.pdp.BilolIncorporation.repository.card.CardRepository;
import uz.pdp.BilolIncorporation.service.user.UserService;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{
    private final CardRepository cardRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    @Override
    public int add(CardDto card, UUID owner_id) {
        Card map = modelMapper.map(card, Card.class);
        map.setOwner_id(owner_id);
        for(Card card1:getAll()) {
            if(Objects.equals(card1.getNumber(),map.getNumber()))
                return -1;
        }
        cardRepository.save(map);
        return 1;
    }

    @Override
    public Card update(CardDto cardDto, UUID cardId, UUID owner_id) {
        Card card = cardRepository.getById(cardId);
        if(card.getOwner_id().equals(owner_id)) {
            modelMapper.getConfiguration()
                    .setPropertyCondition(Objects::nonNull)
                    .setPropertyCondition(Conditions.isNotNull());
            modelMapper.map(cardDto,card);
            cardRepository.update(card);
        }
        return card;
    }

    @Override
    public int add(Card model) {
        for(Card card:getAll()) {
            if(Objects.equals(card.getNumber(),model.getNumber()))
                return -1;
        }
        cardRepository.save(model);
        return 1;
    }

    @Override
    public List<Card> getAll() {
        return cardRepository.getAll();
    }

    @Override
    public Card getById(UUID id) {
        return cardRepository.getById(id);
    }

    @Override
    public void deleteById(UUID id) {
        cardRepository.deleteById(id);
    }

    @Override
    public List<Card> getCardsByUserId(UUID userId) {
        return cardRepository.getCardsByUserId(userId);
    }
}
