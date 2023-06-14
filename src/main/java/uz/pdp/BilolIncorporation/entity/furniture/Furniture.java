package uz.pdp.BilolIncorporation.entity.furniture;

import jakarta.persistence.Entity;
import lombok.*;
import uz.pdp.BilolIncorporation.entity.BaseEntity;

import java.util.UUID;

@Entity(name = "furniture")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Furniture extends BaseEntity {
    private String title;
    private String description;
    private Double price;
    private Double width;
    private Double height;
    private Double length;
    private String colors;
    private String material;
    private String baseMaterial;
    private UUID owner_id;
}
