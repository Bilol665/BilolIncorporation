package uz.pdp.BilolIncorporation.dto;


import jakarta.persistence.GeneratedValue;
import lombok.*;
import uz.pdp.BilolIncorporation.entity.user.UserEntity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserDto {
    private String username;
    private String email;
    private String fullName;
    private String password;

}
