package uz.pdp.BilolIncorporation.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.BilolIncorporation.entity.card.Card;
import uz.pdp.BilolIncorporation.entity.user.UserEntity;
import uz.pdp.BilolIncorporation.repository.user.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public int add(UserEntity model) {
        for (UserEntity user : getAll()) {
            if (Objects.equals(model.getUsername(), user.getUsername())) {
                return -1;
            }
        }
        userRepository.save(model);
        return 0;
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.getAll();
    }

    @Override
    public UserEntity getById(UUID id) {
        return userRepository.getById(id);
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity signIn(String username, String password) {
        try {
            UserEntity user = userRepository.getByUsername(username);
            if (Objects.equals(user.getPassword(), password)) {
                return user;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
