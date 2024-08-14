package entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Standings {
    private List<TeamStanding> standings;

    public static class TeamStanding {
        private Team team;
        private int position;
        private int points;
    }
}
