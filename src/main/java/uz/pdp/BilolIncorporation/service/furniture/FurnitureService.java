package uz.pdp.BilolIncorporation.service.furniture;

import uz.pdp.BilolIncorporation.dto.FurnitureDto;
import uz.pdp.BilolIncorporation.entity.furniture.Furniture;
import uz.pdp.BilolIncorporation.service.BaseService;

import java.util.List;
import java.util.UUID;

public interface FurnitureService extends BaseService<Furniture>  {
    List<Furniture> getAll();
    Furniture getById(UUID id);
    int add(FurnitureDto model,UUID owner_id);
    void update(FurnitureDto update,UUID id,UUID user_id);
    List<Furniture> getUserPost(UUID user_id);

}
