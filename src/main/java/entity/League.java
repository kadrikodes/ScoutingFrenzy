package entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class League {
    private Long id;
    private String name;
    private String code;
}
