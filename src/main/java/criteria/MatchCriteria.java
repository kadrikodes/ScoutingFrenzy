package criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchCriteria {
    // Personal Information Criteria
    private String position;
    private Integer minAge;
    private Integer maxAge;
    private Integer minHeight;
    private Integer maxHeight;
    private Integer minWeight;
    private Integer maxWeight;
    private String nationality;
    private String club;
    private String dominantFoot;
    private Double minMarketValue;

    // General Statistics Criteria
    private Integer minMatchesPlayed;
    private Integer minMinutesPlayed;
    private Integer minGoals;
    private Integer minAssists;
    private Integer maxYellowCards;
    private Integer maxRedCards;
    private Integer minAppearancesAsSubstitute;
    private Integer minWins;
    private Integer minDraws;
    private Integer minLosses;

    // Defensive Statistics Criteria
    private Integer minTackles;
    private Double minTacklesPerGame;
    private Integer minInterceptions;
    private Integer minClearances;
    private Integer minBlocks;
    private Integer minAerialDuelsWon;
    private Integer minGroundDuelsWon;
    private Integer maxFoulsCommitted;
    private Integer minFoulsWon;
    private Double minTackleSuccessRate;
    private Integer maxErrorsLeadingToGoal;
    private Integer maxPenaltiesConceded;

    // Offensive Statistics Criteria
    private Integer minShots;
    private Integer minShotsOnTarget;
    private Integer minDribblesCompleted;
    private Integer minChancesCreated;
    private Integer minCrosses;
    private Double minCrossAccuracy;
    private Integer maxBigChancesMissed;
    private Double minGoalsPerShot;
    private Double minGoalConversionRate;
    private Double minSuccessfulDribblesPercentage;
    private Integer maxTimesOffside;

    // Passing Statistics Criteria
    private Double minPassAccuracy;
    private Integer minKeyPasses;
    private Integer minPassesCompleted;
    private Integer minLongBallsCompleted;
    private Integer minThroughBallsCompleted;
    private Integer minForwardPasses;
    private Integer minBackwardPasses;
    private Integer minPassesIntoFinalThird;
    private Integer minPassesIntoPenaltyArea;
    private Double minThroughPassAccuracy;

    // Physical Statistics Criteria
    private Integer minSprints;
    private Double minDistanceCovered;
    private Double minTopSpeed;
    private Integer minAccelerations;

    // Advanced Metrics Criteria
    private Double minExpectedGoals;
    private Double minExpectedAssists;
    private Double minExpectedGoalsOnTarget;
    private Double maxExpectedGoalsConceded;
    private Double minExpectedGoalsPer90;
    private Double minExpectedAssistsPer90;
    private Double minExpectedGoalsChain;
    private Integer minBallRecoveries;
    private Integer maxPossessionLost;

    private String playerName;
    private Boolean searchFromApi;
}