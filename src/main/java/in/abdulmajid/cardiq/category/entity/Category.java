package in.abdulmajid.cardiq.category.entity;

import in.abdulmajid.cardiq.common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseEntity {

    private String name;

    private String description;
}