package entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Team {
    private Long id;
    private String name;
    private String shortName;
    private String crestUrl;
}
