package uz.pdp.BilolIncorporation.service.user;

import uz.pdp.BilolIncorporation.entity.card.Card;
import uz.pdp.BilolIncorporation.entity.user.UserEntity;
import uz.pdp.BilolIncorporation.service.BaseService;

import java.util.List;
import java.util.UUID;

public interface UserService extends BaseService<UserEntity> {
    UserEntity signIn(String username,String password);


}
