package uz.pdp.BilolIncorporation.entity.user;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.BilolIncorporation.entity.BaseEntity;
import uz.pdp.BilolIncorporation.entity.card.Card;

import java.util.List;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
@Builder
@ToString
public class UserEntity extends BaseEntity {
    private String username;
    private String email;
    private String fullName;
    private String password;
    private UserEntityRole role;
    @OneToOne
    private Card cards;

}
