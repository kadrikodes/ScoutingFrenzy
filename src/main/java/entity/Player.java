package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Personal Information
    private String name;
    private int age;
    private String position;
    private int height;
    private int weight;
    private String nationality;
    private String club;
    private String dominantFoot;
    private double marketValue;

    // General Statistics
    private int matchesPlayed;
    private int minutesPlayed;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
    private int appearancesAsSubstitute;
    private int wins;
    private int draws;
    private int losses;

    // Defensive Statistics
    private int tackles;
    private double tacklesPerGame;
    private int interceptions;
    private int clearances;
    private int blocks;
    private int aerialDuelsWon;
    private int groundDuelsWon;
    private int foulsCommitted;
    private int foulsWon;
    private double tackleSuccessRate;
    private int errorsLeadingToGoal;
    private int penaltiesConceded;

    // Offensive Statistics
    private int shots;
    private int shotsOnTarget;
    private int dribblesCompleted;
    private int chancesCreated;
    private int crosses;
    private double crossAccuracy;
    private int bigChancesMissed;
    private double goalsPerShot;
    private double goalConversionRate;
    private double successfulDribblesPercentage;
    private int timesOffside;

    // Passing Statistics
    private double passAccuracy;
    private int keyPasses;
    private int passesCompleted;
    private int longBallsCompleted;
    private int throughBallsCompleted;
    private int forwardPasses;
    private int backwardPasses;
    private int passesIntoFinalThird;
    private int passesIntoPenaltyArea;
    private double throughPassAccuracy;

    // Physical Statistics
    private int sprints;
    private double distanceCovered;
    private double topSpeed;
    private int accelerations;
    private String heatmap;
    private String playingStyle;

    // Advanced Metrics
    private double expectedGoals;
    private double expectedAssists;
    private double expectedGoalsOnTarget;
    private double expectedGoalsConceded;
    private double expectedGoalsPer90;
    private double expectedAssistsPer90;
    private double expectedGoalsChain;
    private int ballRecoveries;
    private int possessionLost;
}