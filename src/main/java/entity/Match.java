package entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Match {
    private Long id;
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private Date matchDate;
}
