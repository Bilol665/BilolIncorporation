package uz.pdp.BilolIncorporation.entity.card;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import uz.pdp.BilolIncorporation.entity.BaseEntity;
import uz.pdp.BilolIncorporation.entity.user.UserEntity;

import java.util.UUID;

@Entity(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Card extends BaseEntity {
    private String number;
    private String password;
    private Double balance;
    private CardType type;
    private UUID owner_id;
}
