package uz.pdp.BilolIncorporation.repository.furniture;

import uz.pdp.BilolIncorporation.entity.furniture.Furniture;
import uz.pdp.BilolIncorporation.repository.BaseRepository;

import java.util.List;
import java.util.UUID;

public interface FurnitureRepository extends BaseRepository<Furniture> {
    Furniture update(Furniture update);
    List<Furniture> getUserPosts(UUID user_id);
}
