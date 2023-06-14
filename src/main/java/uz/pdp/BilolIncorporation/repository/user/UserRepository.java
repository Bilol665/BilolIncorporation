package uz.pdp.BilolIncorporation.repository.user;

import uz.pdp.BilolIncorporation.entity.user.UserEntity;
import uz.pdp.BilolIncorporation.repository.BaseRepository;

public interface UserRepository extends BaseRepository<UserEntity> {
    UserEntity getByUsername(String username);

}
