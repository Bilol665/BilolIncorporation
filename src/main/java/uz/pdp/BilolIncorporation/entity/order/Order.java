package uz.pdp.BilolIncorporation.entity.order;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.Fetch;
import uz.pdp.BilolIncorporation.entity.BaseEntity;
import uz.pdp.BilolIncorporation.entity.furniture.Furniture;
import uz.pdp.BilolIncorporation.entity.user.UserEntity;

import java.util.List;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
@ToString
@Builder
public class Order extends BaseEntity {
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Furniture> furniture;
    @ManyToOne
    private UserEntity user;
}
