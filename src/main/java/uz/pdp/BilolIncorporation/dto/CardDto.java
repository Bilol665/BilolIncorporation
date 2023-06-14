package uz.pdp.BilolIncorporation.dto;

import lombok.*;
import uz.pdp.BilolIncorporation.entity.BaseEntity;
import uz.pdp.BilolIncorporation.entity.card.CardType;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class CardDto {
    private String number;
    private String password;
    private Double balance;
    private CardType type;
}