package entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Scorer {
    private Player player;
    private Team team;
    private int goals;
    private int assists;
}
