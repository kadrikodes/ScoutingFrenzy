package service.playerservice;

import criteria.MatchCriteria;
import dataaccess.PlayerRepository;
import entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getPlayersMatchingCriteria(MatchCriteria criteria) {
        return playerRepository.findAll().stream()
                .filter(player -> calculateMatchPercentage(player, criteria) >= 70.0) // Example threshold
                .collect(Collectors.toList());
    }

    private boolean matchesCriteria(Player player, MatchCriteria criteria) {
        return (criteria.getPosition() == null || player.getPosition().equals(criteria.getPosition())) &&
                (criteria.getMinAge() == null || player.getAge() >= criteria.getMinAge()) &&
                (criteria.getMaxAge() == null || player.getAge() <= criteria.getMaxAge()) &&
                (criteria.getMinHeight() == null || player.getHeight() >= criteria.getMinHeight()) &&
                (criteria.getMaxHeight() == null || player.getHeight() <= criteria.getMaxHeight()) &&
                (criteria.getMinWeight() == null || player.getWeight() >= criteria.getMinWeight()) &&
                (criteria.getMaxWeight() == null || player.getWeight() <= criteria.getMaxWeight()) &&
                (criteria.getNationality() == null || player.getNationality().equals(criteria.getNationality())) &&
                (criteria.getClub() == null || player.getClub().equals(criteria.getClub())) &&
                (criteria.getDominantFoot() == null || player.getDominantFoot().equals(criteria.getDominantFoot())) &&
                (criteria.getMinMarketValue() == null || player.getMarketValue() >= criteria.getMinMarketValue()) &&
                (criteria.getMinMatchesPlayed() == null || player.getMatchesPlayed() >= criteria.getMinMatchesPlayed()) &&
                (criteria.getMinMinutesPlayed() == null || player.getMinutesPlayed() >= criteria.getMinMinutesPlayed()) &&
                (criteria.getMinGoals() == null || player.getGoals() >= criteria.getMinGoals()) &&
                (criteria.getMinAssists() == null || player.getAssists() >= criteria.getMinAssists()) &&
                (criteria.getMaxYellowCards() == null || player.getYellowCards() <= criteria.getMaxYellowCards()) &&
                (criteria.getMaxRedCards() == null || player.getRedCards() <= criteria.getMaxRedCards()) &&
                (criteria.getMinAppearancesAsSubstitute() == null || player.getAppearancesAsSubstitute() >= criteria.getMinAppearancesAsSubstitute()) &&
                (criteria.getMinWins() == null || player.getWins() >= criteria.getMinWins()) &&
                (criteria.getMinDraws() == null || player.getDraws() >= criteria.getMinDraws()) &&
                (criteria.getMinLosses() == null || player.getLosses() >= criteria.getMinLosses()) &&
                (criteria.getMinTackles() == null || player.getTackles() >= criteria.getMinTackles()) &&
                (criteria.getMinTacklesPerGame() == null || player.getTacklesPerGame() >= criteria.getMinTacklesPerGame()) &&
                (criteria.getMinInterceptions() == null || player.getInterceptions() >= criteria.getMinInterceptions()) &&
                (criteria.getMinClearances() == null || player.getClearances() >= criteria.getMinClearances()) &&
                (criteria.getMinBlocks() == null || player.getBlocks() >= criteria.getMinBlocks()) &&
                (criteria.getMinAerialDuelsWon() == null || player.getAerialDuelsWon() >= criteria.getMinAerialDuelsWon()) &&
                (criteria.getMinGroundDuelsWon() == null || player.getGroundDuelsWon() >= criteria.getMinGroundDuelsWon()) &&
                (criteria.getMaxFoulsCommitted() == null || player.getFoulsCommitted() <= criteria.getMaxFoulsCommitted()) &&
                (criteria.getMinFoulsWon() == null || player.getFoulsWon() >= criteria.getMinFoulsWon()) &&
                (criteria.getMinTackleSuccessRate() == null || player.getTackleSuccessRate() >= criteria.getMinTackleSuccessRate()) &&
                (criteria.getMaxErrorsLeadingToGoal() == null || player.getErrorsLeadingToGoal() <= criteria.getMaxErrorsLeadingToGoal()) &&
                (criteria.getMaxPenaltiesConceded() == null || player.getPenaltiesConceded() <= criteria.getMaxPenaltiesConceded()) &&
                (criteria.getMinShots() == null || player.getShots() >= criteria.getMinShots()) &&
                (criteria.getMinShotsOnTarget() == null || player.getShotsOnTarget() >= criteria.getMinShotsOnTarget()) &&
                (criteria.getMinDribblesCompleted() == null || player.getDribblesCompleted() >= criteria.getMinDribblesCompleted()) &&
                (criteria.getMinChancesCreated() == null || player.getChancesCreated() >= criteria.getMinChancesCreated()) &&
                (criteria.getMinCrosses() == null || player.getCrosses() >= criteria.getMinCrosses()) &&
                (criteria.getMinCrossAccuracy() == null || player.getCrossAccuracy() >= criteria.getMinCrossAccuracy()) &&
                (criteria.getMaxBigChancesMissed() == null || player.getBigChancesMissed() <= criteria.getMaxBigChancesMissed()) &&
                (criteria.getMinGoalsPerShot() == null || player.getGoalsPerShot() >= criteria.getMinGoalsPerShot()) &&
                (criteria.getMinGoalConversionRate() == null || player.getGoalConversionRate() >= criteria.getMinGoalConversionRate()) &&
                (criteria.getMinSuccessfulDribblesPercentage() == null || player.getSuccessfulDribblesPercentage() >= criteria.getMinSuccessfulDribblesPercentage()) &&
                (criteria.getMaxTimesOffside() == null || player.getTimesOffside() <= criteria.getMaxTimesOffside()) &&
                (criteria.getMinPassAccuracy() == null || player.getPassAccuracy() >= criteria.getMinPassAccuracy()) &&
                (criteria.getMinKeyPasses() == null || player.getKeyPasses() >= criteria.getMinKeyPasses()) &&
                (criteria.getMinPassesCompleted() == null || player.getPassesCompleted() >= criteria.getMinPassesCompleted()) &&
                (criteria.getMinLongBallsCompleted() == null || player.getLongBallsCompleted() >= criteria.getMinLongBallsCompleted()) &&
                (criteria.getMinThroughBallsCompleted() == null || player.getThroughBallsCompleted() >= criteria.getMinThroughBallsCompleted()) &&
                (criteria.getMinForwardPasses() == null || player.getForwardPasses() >= criteria.getMinForwardPasses()) &&
                (criteria.getMinBackwardPasses() == null || player.getBackwardPasses() >= criteria.getMinBackwardPasses()) &&
                (criteria.getMinPassesIntoFinalThird() == null || player.getPassesIntoFinalThird() >= criteria.getMinPassesIntoFinalThird()) &&
                (criteria.getMinPassesIntoPenaltyArea() == null || player.getPassesIntoPenaltyArea() >= criteria.getMinPassesIntoPenaltyArea()) &&
                (criteria.getMinThroughPassAccuracy() == null || player.getThroughPassAccuracy() >= criteria.getMinThroughPassAccuracy()) &&
                (criteria.getMinSprints() == null || player.getSprints() >= criteria.getMinSprints()) &&
                (criteria.getMinDistanceCovered() == null || player.getDistanceCovered() >= criteria.getMinDistanceCovered()) &&
                (criteria.getMinTopSpeed() == null || player.getTopSpeed() >= criteria.getMinTopSpeed()) &&
                (criteria.getMinAccelerations() == null || player.getAccelerations() >= criteria.getMinAccelerations()) &&
                (criteria.getMinExpectedGoals() == null || player.getExpectedGoals() >= criteria.getMinExpectedGoals()) &&
                (criteria.getMinExpectedAssists() == null || player.getExpectedAssists() >= criteria.getMinExpectedAssists()) &&
                (criteria.getMinExpectedGoalsOnTarget() == null || player.getExpectedGoalsOnTarget() >= criteria.getMinExpectedGoalsOnTarget()) &&
                (criteria.getMaxExpectedGoalsConceded() == null || player.getExpectedGoalsConceded() <= criteria.getMaxExpectedGoalsConceded()) &&
                (criteria.getMinExpectedGoalsPer90() == null || player.getExpectedGoalsPer90() >= criteria.getMinExpectedGoalsPer90()) &&
                (criteria.getMinExpectedAssistsPer90() == null || player.getExpectedAssistsPer90() >= criteria.getMinExpectedAssistsPer90()) &&
                (criteria.getMinExpectedGoalsChain() == null || player.getExpectedGoalsChain() >= criteria.getMinExpectedGoalsChain()) &&
                (criteria.getMinBallRecoveries() == null || player.getBallRecoveries() >= criteria.getMinBallRecoveries()) &&
                (criteria.getMaxPossessionLost() == null || player.getPossessionLost() <= criteria.getMaxPossessionLost());
    }

    @Override
    public List<Player> findBestMatches(MatchCriteria stats) {
        return playerRepository.findAll().stream()
                .sorted(Comparator.comparingDouble(player -> calculateMatchPercentage(player, stats)))
                .limit(5) // Limit to top 5 best matches
                .collect(Collectors.toList());
    }

    @Override
    public double calculateMatchPercentage(Player player, MatchCriteria stats) {
        double score = 0.0;

        if (stats.getMinGoals() != null) {
            score += Math.abs(player.getGoals() - stats.getMinGoals());
        }
        if (stats.getMinAssists() != null) {
            score += Math.abs(player.getAssists() - stats.getMinAssists());
        }
        if (stats.getMinPassAccuracy() != null) {
            score += Math.abs(player.getPassAccuracy() - stats.getMinPassAccuracy());
        }
        if (stats.getMinMatchesPlayed() != null) {
            score += Math.abs(player.getMatchesPlayed() - stats.getMinMatchesPlayed());
        }
        if (stats.getMinMinutesPlayed() != null) {
            score += Math.abs(player.getMinutesPlayed() - stats.getMinMinutesPlayed());
        }
        if (stats.getMaxYellowCards() != null) {
            score += Math.abs(player.getYellowCards() - stats.getMaxYellowCards());
        }
        if (stats.getMaxRedCards() != null) {
            score += Math.abs(player.getRedCards() - stats.getMaxRedCards());
        }
        if (stats.getMinTackles() != null) {
            score += Math.abs(player.getTackles() - stats.getMinTackles());
        }
        if (stats.getMinTacklesPerGame() != null) {
            score += Math.abs(player.getTacklesPerGame() - stats.getMinTacklesPerGame());
        }
        if (stats.getMinInterceptions() != null) {
            score += Math.abs(player.getInterceptions() - stats.getMinInterceptions());
        }
        if (stats.getMinClearances() != null) {
            score += Math.abs(player.getClearances() - stats.getMinClearances());
        }
        if (stats.getMinBlocks() != null) {
            score += Math.abs(player.getBlocks() - stats.getMinBlocks());
        }
        if (stats.getMinAerialDuelsWon() != null) {
            score += Math.abs(player.getAerialDuelsWon() - stats.getMinAerialDuelsWon());
        }
        if (stats.getMinGroundDuelsWon() != null) {
            score += Math.abs(player.getGroundDuelsWon() - stats.getMinGroundDuelsWon());
        }
        if (stats.getMaxFoulsCommitted() != null) {
            score += Math.abs(player.getFoulsCommitted() - stats.getMaxFoulsCommitted());
        }
        if (stats.getMinFoulsWon() != null) {
            score += Math.abs(player.getFoulsWon() - stats.getMinFoulsWon());
        }
        if (stats.getMinTackleSuccessRate() != null) {
            score += Math.abs(player.getTackleSuccessRate() - stats.getMinTackleSuccessRate());
        }
        if (stats.getMaxErrorsLeadingToGoal() != null) {
            score += Math.abs(player.getErrorsLeadingToGoal() - stats.getMaxErrorsLeadingToGoal());
        }
        if (stats.getMaxPenaltiesConceded() != null) {
            score += Math.abs(player.getPenaltiesConceded() - stats.getMaxPenaltiesConceded());
        }
        if (stats.getMinShots() != null) {
            score += Math.abs(player.getShots() - stats.getMinShots());
        }
        if (stats.getMinShotsOnTarget() != null) {
            score += Math.abs(player.getShotsOnTarget() - stats.getMinShotsOnTarget());
        }
        if (stats.getMinDribblesCompleted() != null) {
            score += Math.abs(player.getDribblesCompleted() - stats.getMinDribblesCompleted());
        }
        if (stats.getMinChancesCreated() != null) {
            score += Math.abs(player.getChancesCreated() - stats.getMinChancesCreated());
        }
        if (stats.getMinCrosses() != null) {
            score += Math.abs(player.getCrosses() - stats.getMinCrosses());
        }
        if (stats.getMinCrossAccuracy() != null) {
            score += Math.abs(player.getCrossAccuracy() - stats.getMinCrossAccuracy());
        }
        if (stats.getMaxBigChancesMissed() != null) {
            score += Math.abs(player.getBigChancesMissed() - stats.getMaxBigChancesMissed());
        }
        if (stats.getMinGoalsPerShot() != null) {
            score += Math.abs(player.getGoalsPerShot() - stats.getMinGoalsPerShot());
        }
        if (stats.getMinGoalConversionRate() != null) {
            score += Math.abs(player.getGoalConversionRate() - stats.getMinGoalConversionRate());
        }
        if (stats.getMinSuccessfulDribblesPercentage() != null) {
            score += Math.abs(player.getSuccessfulDribblesPercentage() - stats.getMinSuccessfulDribblesPercentage());
        }
        if (stats.getMaxTimesOffside() != null) {
            score += Math.abs(player.getTimesOffside() - stats.getMaxTimesOffside());
        }
        if (stats.getMinKeyPasses() != null) {
            score += Math.abs(player.getKeyPasses() - stats.getMinKeyPasses());
        }
        if (stats.getMinPassesCompleted() != null) {
            score += Math.abs(player.getPassesCompleted() - stats.getMinPassesCompleted());
        }
        if (stats.getMinLongBallsCompleted() != null) {
            score += Math.abs(player.getLongBallsCompleted() - stats.getMinLongBallsCompleted());
        }
        if (stats.getMinThroughBallsCompleted() != null) {
            score += Math.abs(player.getThroughBallsCompleted() - stats.getMinThroughBallsCompleted());
        }
        if (stats.getMinForwardPasses() != null) {
            score += Math.abs(player.getForwardPasses() - stats.getMinForwardPasses());
        }
        if (stats.getMinBackwardPasses() != null) {
            score += Math.abs(player.getBackwardPasses() - stats.getMinBackwardPasses());
        }
        if (stats.getMinPassesIntoFinalThird() != null) {
            score += Math.abs(player.getPassesIntoFinalThird() - stats.getMinPassesIntoFinalThird());
        }
        if (stats.getMinPassesIntoPenaltyArea() != null) {
            score += Math.abs(player.getPassesIntoPenaltyArea() - stats.getMinPassesIntoPenaltyArea());
        }
        if (stats.getMinThroughPassAccuracy() != null) {
            score += Math.abs(player.getThroughPassAccuracy() - stats.getMinThroughPassAccuracy());
        }
        if (stats.getMinSprints() != null) {
            score += Math.abs(player.getSprints() - stats.getMinSprints());
        }
        if (stats.getMinDistanceCovered() != null) {
            score += Math.abs(player.getDistanceCovered() - stats.getMinDistanceCovered());
        }
        if (stats.getMinTopSpeed() != null) {
            score += Math.abs(player.getTopSpeed() - stats.getMinTopSpeed());
        }
        if (stats.getMinAccelerations() != null) {
            score += Math.abs(player.getAccelerations() - stats.getMinAccelerations());
        }
        if (stats.getMinExpectedGoals() != null) {
            score += Math.abs(player.getExpectedGoals() - stats.getMinExpectedGoals());
        }
        if (stats.getMinExpectedAssists() != null) {
            score += Math.abs(player.getExpectedAssists() - stats.getMinExpectedAssists());
        }
        if (stats.getMinExpectedGoalsOnTarget() != null) {
            score += Math.abs(player.getExpectedGoalsOnTarget() - stats.getMinExpectedGoalsOnTarget());
        }
        if (stats.getMaxExpectedGoalsConceded() != null) {
            score += Math.abs(player.getExpectedGoalsConceded() - stats.getMaxExpectedGoalsConceded());
        }
        if (stats.getMinExpectedGoalsPer90() != null) {
            score += Math.abs(player.getExpectedGoalsPer90() - stats.getMinExpectedGoalsPer90());
        }
        if (stats.getMinExpectedAssistsPer90() != null) {
            score += Math.abs(player.getExpectedAssistsPer90() - stats.getMinExpectedAssistsPer90());
        }
        if (stats.getMinExpectedGoalsChain() != null) {
            score += Math.abs(player.getExpectedGoalsChain() - stats.getMinExpectedGoalsChain());
        }
        if (stats.getMinBallRecoveries() != null) {
            score += Math.abs(player.getBallRecoveries() - stats.getMinBallRecoveries());
        }
        if (stats.getMaxPossessionLost() != null) {
            score += Math.abs(player.getPossessionLost() - stats.getMaxPossessionLost());
        }

        return score;
    }

    @Override
    public Map<String, Map<String, Double>> comparePlayers(Player player1, Player player2, String category) {
        Map<String, Map<String, Double>> comparison = new HashMap<>();

        switch (category.toLowerCase()) {
            case "attacking":
                comparison.put("Goals", Map.of(player1.getName(), (double) player1.getGoals(), player2.getName(), (double) player2.getGoals()));
                comparison.put("Assists", Map.of(player1.getName(), (double) player1.getAssists(), player2.getName(), (double) player2.getAssists()));
                comparison.put("Shots", Map.of(player1.getName(), (double) player1.getShots(), player2.getName(), (double) player2.getShots()));
                comparison.put("Shots on Target", Map.of(player1.getName(), (double) player1.getShotsOnTarget(), player2.getName(), (double) player2.getShotsOnTarget()));
                comparison.put("Dribbles Completed", Map.of(player1.getName(), (double) player1.getDribblesCompleted(), player2.getName(), (double) player2.getDribblesCompleted()));
                comparison.put("Chances Created", Map.of(player1.getName(), (double) player1.getChancesCreated(), player2.getName(), (double) player2.getChancesCreated()));
                comparison.put("Crosses", Map.of(player1.getName(), (double) player1.getCrosses(), player2.getName(), (double) player2.getCrosses()));
                comparison.put("Big Chances Missed", Map.of(player1.getName(), (double) player1.getBigChancesMissed(), player2.getName(), (double) player2.getBigChancesMissed()));
                comparison.put("Goals per Shot", Map.of(player1.getName(), player1.getGoalsPerShot(), player2.getName(), player2.getGoalsPerShot()));
                comparison.put("Goal Conversion Rate", Map.of(player1.getName(), player1.getGoalConversionRate(), player2.getName(), player2.getGoalConversionRate()));
                comparison.put("Successful Dribbles Percentage", Map.of(player1.getName(), player1.getSuccessfulDribblesPercentage(), player2.getName(), player2.getSuccessfulDribblesPercentage()));
                comparison.put("Times Offside", Map.of(player1.getName(), (double) player1.getTimesOffside(), player2.getName(), (double) player2.getTimesOffside()));
                break;

            case "defensive":
                comparison.put("Tackles", Map.of(player1.getName(), (double) player1.getTackles(), player2.getName(), (double) player2.getTackles()));
                comparison.put("Interceptions", Map.of(player1.getName(), (double) player1.getInterceptions(), player2.getName(), (double) player2.getInterceptions()));
                comparison.put("Clearances", Map.of(player1.getName(), (double) player1.getClearances(), player2.getName(), (double) player2.getClearances()));
                comparison.put("Blocks", Map.of(player1.getName(), (double) player1.getBlocks(), player2.getName(), (double) player2.getBlocks()));
                comparison.put("Aerial Duels Won", Map.of(player1.getName(), (double) player1.getAerialDuelsWon(), player2.getName(), (double) player2.getAerialDuelsWon()));
                comparison.put("Ground Duels Won", Map.of(player1.getName(), (double) player1.getGroundDuelsWon(), player2.getName(), (double) player2.getGroundDuelsWon()));
                comparison.put("Fouls Committed", Map.of(player1.getName(), (double) player1.getFoulsCommitted(), player2.getName(), (double) player2.getFoulsCommitted()));
                comparison.put("Fouls Won", Map.of(player1.getName(), (double) player1.getFoulsWon(), player2.getName(), (double) player2.getFoulsWon()));
                comparison.put("Tackle Success Rate", Map.of(player1.getName(), player1.getTackleSuccessRate(), player2.getName(), player2.getTackleSuccessRate()));
                comparison.put("Errors Leading to Goal", Map.of(player1.getName(), (double) player1.getErrorsLeadingToGoal(), player2.getName(), (double) player2.getErrorsLeadingToGoal()));
                comparison.put("Penalties Conceded", Map.of(player1.getName(), (double) player1.getPenaltiesConceded(), player2.getName(), (double) player2.getPenaltiesConceded()));
                break;

            case "passing":
                comparison.put("Pass Accuracy", Map.of(player1.getName(), player1.getPassAccuracy(), player2.getName(), player2.getPassAccuracy()));
                comparison.put("Key Passes", Map.of(player1.getName(), (double) player1.getKeyPasses(), player2.getName(), (double) player2.getKeyPasses()));
                comparison.put("Passes Completed", Map.of(player1.getName(), (double) player1.getPassesCompleted(), player2.getName(), (double) player2.getPassesCompleted()));
                comparison.put("Long Balls Completed", Map.of(player1.getName(), (double) player1.getLongBallsCompleted(), player2.getName(), (double) player2.getLongBallsCompleted()));
                comparison.put("Through Balls Completed", Map.of(player1.getName(), (double) player1.getThroughBallsCompleted(), player2.getName(), (double) player2.getThroughBallsCompleted()));
                comparison.put("Forward Passes", Map.of(player1.getName(), (double) player1.getForwardPasses(), player2.getName(), (double) player2.getForwardPasses()));
                comparison.put("Backward Passes", Map.of(player1.getName(), (double) player1.getBackwardPasses(), player2.getName(), (double) player2.getBackwardPasses()));
                comparison.put("Passes Into Final Third", Map.of(player1.getName(), (double) player1.getPassesIntoFinalThird(), player2.getName(), (double) player2.getPassesIntoFinalThird()));
                comparison.put("Passes Into Penalty Area", Map.of(player1.getName(), (double) player1.getPassesIntoPenaltyArea(), player2.getName(), (double) player2.getPassesIntoPenaltyArea()));
                comparison.put("Through Pass Accuracy", Map.of(player1.getName(), player1.getThroughPassAccuracy(), player2.getName(), player2.getThroughPassAccuracy()));
                comparison.put("Cross Accuracy", Map.of(player1.getName(), player1.getCrossAccuracy(), player2.getName(), player2.getCrossAccuracy()));
                break;

            case "physical":
                comparison.put("Sprints", Map.of(player1.getName(), (double) player1.getSprints(), player2.getName(), (double) player2.getSprints()));
                comparison.put("Distance Covered", Map.of(player1.getName(), player1.getDistanceCovered(), player2.getName(), player2.getDistanceCovered()));
                comparison.put("Top Speed", Map.of(player1.getName(), player1.getTopSpeed(), player2.getName(), player2.getTopSpeed()));
                comparison.put("Accelerations", Map.of(player1.getName(), (double) player1.getAccelerations(), player2.getName(), (double) player2.getAccelerations()));
                break;

            case "advanced":
                comparison.put("Expected Goals", Map.of(player1.getName(), player1.getExpectedGoals(), player2.getName(), player2.getExpectedGoals()));
                comparison.put("Expected Assists", Map.of(player1.getName(), player1.getExpectedAssists(), player2.getName(), player2.getExpectedAssists()));
                comparison.put("Expected Goals on Target", Map.of(player1.getName(), player1.getExpectedGoalsOnTarget(), player2.getName(), player2.getExpectedGoalsOnTarget()));
                comparison.put("Expected Goals Conceded", Map.of(player1.getName(), player1.getExpectedGoalsConceded(), player2.getName(), player2.getExpectedGoalsConceded()));
                comparison.put("Expected Goals per 90", Map.of(player1.getName(), player1.getExpectedGoalsPer90(), player2.getName(), player2.getExpectedGoalsPer90()));
                comparison.put("Expected Assists per 90", Map.of(player1.getName(), player1.getExpectedAssistsPer90(), player2.getName(), player2.getExpectedAssistsPer90()));
                comparison.put("Expected Goals Chain", Map.of(player1.getName(), player1.getExpectedGoalsChain(), player2.getName(), player2.getExpectedGoalsChain()));
                comparison.put("Ball Recoveries", Map.of(player1.getName(), (double) player1.getBallRecoveries(), player2.getName(), (double) player2.getBallRecoveries()));
                comparison.put("Possession Lost", Map.of(player1.getName(), (double) player1.getPossessionLost(), player2.getName(), (double) player2.getPossessionLost()));
                break;

            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }

        return comparison;
    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getTopPlayers(String criterion, int topN) {
        Comparator<Player> comparator = getComparatorForCriterion(criterion);
        return playerRepository.findAll().stream()
                .sorted(comparator.reversed())
                .limit(topN)
                .collect(Collectors.toList());
    }

    @Override
    public Player updatePlayerStats(Player player) {
        // Ensure the player exists and update their stats
        return playerRepository.save(player);
    }

    @Override
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    private Comparator<Player> getComparatorForCriterion(String criterion) {
        switch (criterion.toLowerCase()) {
            // Personal Information
            case "age":
                return Comparator.comparing(Player::getAge);
            case "height":
                return Comparator.comparing(Player::getHeight);
            case "weight":
                return Comparator.comparing(Player::getWeight);
            case "market value":
                return Comparator.comparing(Player::getMarketValue);

            // General Statistics
            case "goals":
                return Comparator.comparing(Player::getGoals);
            case "assists":
                return Comparator.comparing(Player::getAssists);
            case "matches played":
                return Comparator.comparing(Player::getMatchesPlayed);
            case "minutes played":
                return Comparator.comparing(Player::getMinutesPlayed);
            case "yellow cards":
                return Comparator.comparing(Player::getYellowCards);
            case "red cards":
                return Comparator.comparing(Player::getRedCards);
            case "appearances as substitute":
                return Comparator.comparing(Player::getAppearancesAsSubstitute);
            case "wins":
                return Comparator.comparing(Player::getWins);
            case "draws":
                return Comparator.comparing(Player::getDraws);
            case "losses":
                return Comparator.comparing(Player::getLosses);

            // Defensive Statistics
            case "tackles":
                return Comparator.comparing(Player::getTackles);
            case "tackles per game":
                return Comparator.comparing(Player::getTacklesPerGame);
            case "interceptions":
                return Comparator.comparing(Player::getInterceptions);
            case "clearances":
                return Comparator.comparing(Player::getClearances);
            case "blocks":
                return Comparator.comparing(Player::getBlocks);
            case "aerial duels won":
                return Comparator.comparing(Player::getAerialDuelsWon);
            case "ground duels won":
                return Comparator.comparing(Player::getGroundDuelsWon);
            case "fouls committed":
                return Comparator.comparing(Player::getFoulsCommitted);
            case "fouls won":
                return Comparator.comparing(Player::getFoulsWon);
            case "tackle success rate":
                return Comparator.comparing(Player::getTackleSuccessRate);
            case "errors leading to goal":
                return Comparator.comparing(Player::getErrorsLeadingToGoal);
            case "penalties conceded":
                return Comparator.comparing(Player::getPenaltiesConceded);

            // Offensive Statistics
            case "shots":
                return Comparator.comparing(Player::getShots);
            case "shots on target":
                return Comparator.comparing(Player::getShotsOnTarget);
            case "dribbles completed":
                return Comparator.comparing(Player::getDribblesCompleted);
            case "chances created":
                return Comparator.comparing(Player::getChancesCreated);
            case "crosses":
                return Comparator.comparing(Player::getCrosses);
            case "cross accuracy":
                return Comparator.comparing(Player::getCrossAccuracy);
            case "big chances missed":
                return Comparator.comparing(Player::getBigChancesMissed);
            case "goals per shot":
                return Comparator.comparing(Player::getGoalsPerShot);
            case "goal conversion rate":
                return Comparator.comparing(Player::getGoalConversionRate);
            case "successful dribbles percentage":
                return Comparator.comparing(Player::getSuccessfulDribblesPercentage);
            case "times offside":
                return Comparator.comparing(Player::getTimesOffside);

            // Passing Statistics
            case "pass accuracy":
                return Comparator.comparing(Player::getPassAccuracy);
            case "key passes":
                return Comparator.comparing(Player::getKeyPasses);
            case "passes completed":
                return Comparator.comparing(Player::getPassesCompleted);
            case "long balls completed":
                return Comparator.comparing(Player::getLongBallsCompleted);
            case "through balls completed":
                return Comparator.comparing(Player::getThroughBallsCompleted);
            case "forward passes":
                return Comparator.comparing(Player::getForwardPasses);
            case "backward passes":
                return Comparator.comparing(Player::getBackwardPasses);
            case "passes into final third":
                return Comparator.comparing(Player::getPassesIntoFinalThird);
            case "passes into penalty area":
                return Comparator.comparing(Player::getPassesIntoPenaltyArea);
            case "through pass accuracy":
                return Comparator.comparing(Player::getThroughPassAccuracy);

            // Physical Statistics
            case "sprints":
                return Comparator.comparing(Player::getSprints);
            case "distance covered":
                return Comparator.comparing(Player::getDistanceCovered);
            case "top speed":
                return Comparator.comparing(Player::getTopSpeed);
            case "accelerations":
                return Comparator.comparing(Player::getAccelerations);

            // Advanced Metrics
            case "expected goals":
                return Comparator.comparing(Player::getExpectedGoals);
            case "expected assists":
                return Comparator.comparing(Player::getExpectedAssists);
            case "expected goals on target":
                return Comparator.comparing(Player::getExpectedGoalsOnTarget);
            case "expected goals conceded":
                return Comparator.comparing(Player::getExpectedGoalsConceded);
            case "expected goals per 90":
                return Comparator.comparing(Player::getExpectedGoalsPer90);
            case "expected assists per 90":
                return Comparator.comparing(Player::getExpectedAssistsPer90);
            case "expected goals chain":
                return Comparator.comparing(Player::getExpectedGoalsChain);
            case "ball recoveries":
                return Comparator.comparing(Player::getBallRecoveries);
            case "possession lost":
                return Comparator.comparing(Player::getPossessionLost);

            default:
                throw new IllegalArgumentException("Unknown criterion: " + criterion);
        }
    }
}
