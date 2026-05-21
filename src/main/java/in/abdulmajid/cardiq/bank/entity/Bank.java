package in.abdulmajid.cardiq.bank.entity;

import in.abdulmajid.cardiq.common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Bank extends BaseEntity {

    private String name;

    private String logoUrl;

    private String websiteUrl;
}