package dataaccess;

import entity.Player;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long>, JpaSpecificationExecutor<Player> {

    // Find players by specific attributes
    List<Player> findByPosition(String position);

    List<Player> findByNationality(String nationality);

    List<Player> findByDominantFoot(String dominantFoot);

    // Performance metrics filtering
    List<Player> findByGoalsGreaterThanEqual(int minGoals);

    List<Player> findByAssistsGreaterThanEqual(int minAssists);

    List<Player> findByPassAccuracyGreaterThanEqual(double minPassAccuracy);

    List<Player> findByRatingGreaterThanEqual(double minRating);

    // Defensive metrics filtering
    List<Player> findByTacklesGreaterThanEqual(int minTackles);

    List<Player> findByInterceptionsGreaterThanEqual(int minInterceptions);

    List<Player> findByClearancesGreaterThanEqual(int minClearances);

    List<Player> findByAerialDuelsWonGreaterThanEqual(int minAerialDuelsWon);

    List<Player> findByFoulsCommittedLessThanEqual(int maxFoulsCommitted);

    // Physical attributes filtering
    List<Player> findByHeightBetween(int minHeight, int maxHeight);

    List<Player> findByWeightBetween(int minWeight, int maxWeight);

    List<Player> findByAgeBetween(int minAge, int maxAge);

    List<Player> findByDistanceCoveredGreaterThanEqual(double minDistanceCovered);

    List<Player> findByTopSpeedGreaterThanEqual(double minTopSpeed);

    // Advanced metrics filtering
    List<Player> findByExpectedGoalsGreaterThanEqual(double minExpectedGoals);

    List<Player> findByExpectedAssistsGreaterThanEqual(double minExpectedAssists);

    // Custom queries for complex analysis
    @Query("SELECT p FROM Player p WHERE p.shotsOnTarget / p.shots >= :minShotAccuracy")
    List<Player> findPlayersWithHighShotAccuracy(@Param("minShotAccuracy") double minShotAccuracy);

    @Query("SELECT p FROM Player p WHERE p.successfulDribblesPercentage >= :minDribbleSuccess")
    List<Player> findPlayersWithHighDribbleSuccess(@Param("minDribbleSuccess") double minDribbleSuccess);

    @Query("SELECT p FROM Player p WHERE p.crossAccuracy >= :minCrossAccuracy")
    List<Player> findPlayersWithHighCrossAccuracy(@Param("minCrossAccuracy") double minCrossAccuracy);

    @Query("SELECT p FROM Player p WHERE p.bigChancesMissed <= :maxBigChancesMissed")
    List<Player> findPlayersWithFewBigChancesMissed(@Param("maxBigChancesMissed") int maxBigChancesMissed);

    @Query("SELECT p FROM Player p WHERE p.yellowCards <= :maxYellowCards AND p.redCards <= :maxRedCards")
    List<Player> findPlayersWithFewCards(@Param("maxYellowCards") int maxYellowCards, @Param("maxRedCards") int maxRedCards);

    // Dynamic querying using Specification
    List<Player> findAll(Specification<Player> specification);
}
