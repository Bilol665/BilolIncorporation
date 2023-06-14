package uz.pdp.BilolIncorporation.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class FurnitureDto {
    private String title;
    private Double width;
    private Double height;
    private Double length;
    private String baseMaterial;
    private String material;
    private String colors;
    private Double price;
    private String description;
}
