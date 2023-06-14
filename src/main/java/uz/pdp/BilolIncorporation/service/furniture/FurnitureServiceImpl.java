package uz.pdp.BilolIncorporation.service.furniture;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.BilolIncorporation.dto.FurnitureDto;
import uz.pdp.BilolIncorporation.entity.furniture.Furniture;
import uz.pdp.BilolIncorporation.repository.furniture.FurnitureRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FurnitureServiceImpl implements FurnitureService {
    private final FurnitureRepository furnitureRepository;
    private final ModelMapper modelMapper;
    @Override
    public int add(FurnitureDto model,UUID owner_id) {
        Furniture map = modelMapper.map(model, Furniture.class);
        map.setOwner_id(owner_id);
        for(Furniture furniture:getAll()) {
            if(Objects.equals(map.getTitle(),furniture.getTitle())) {
                return -1;
            }
        }
        furnitureRepository.save(map);
        return 0;
    }

    @Override
    public void update(FurnitureDto update, UUID id, UUID user_id) {
        Furniture furniture = furnitureRepository.getById(id);
        if (furniture.getOwner_id().equals(user_id)) {
            modelMapper.getConfiguration()
                    .setPropertyCondition(Objects::nonNull)
                    .setPropertyCondition(Conditions.isNotNull());
            modelMapper.map(update,furniture);
            furnitureRepository.update(furniture);
        }
    }

    @Override
    public List<Furniture> getUserPost(UUID user_id) {
        return furnitureRepository.getUserPosts(user_id);
    }


    @Override
    public int add(Furniture model) {
        return 0;
    }

    @Override
    public List<Furniture> getAll() {
        return furnitureRepository.getAll();
    }

    @Override
    public Furniture getById(UUID id) {
        return furnitureRepository.getById(id);
    }

    @Override
    public void deleteById(UUID id) {
        furnitureRepository.deleteById(id);
    }
}
