package service.playerservice;

import criteria.MatchCriteria;
import entity.Player;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PlayerService {

    /**
     * Find players that match a given set of criteria.
     *
     * @param criteria The criteria to match players against.
     * @return A list of players matching the criteria.
     */
    List<Player> getPlayersMatchingCriteria(MatchCriteria criteria);

    List<Player> findBestMatches(MatchCriteria stats);

    /**
     * Calculate the match percentage of a player against given criteria.
     *
     * @param player The player to evaluate.
     * @param criteria The criteria to compare against.
     * @return The match percentage as a double.
     */
    double calculateMatchPercentage(Player player, MatchCriteria criteria);

    /**
     * Compare two players and return a detailed comparison of their statistics.
     *
     * @param player1 The first player to compare.
     * @param player2 The second player to compare.
     * @return A map containing the comparison results of their statistics.
     */

    Map<String, Map<String, Double>> comparePlayers(Player player1, Player player2, String category);

    /**
     * Find a player by their unique ID.
     *
     * @param id The ID of the player.
     * @return An Optional containing the player if found.
     */
    Optional<Player> findById(Long id);

    /**
     * Retrieve all players from the repository.
     *
     * @return A list of all players.
     */
    List<Player> findAllPlayers();

    /**
     * Retrieve top N players based on a specific criterion.
     *
     * @param criterion The criterion to rank players by.
     * @param topN The number of top players to retrieve.
     * @return A list of top N players based on the criterion.
     */
    List<Player> getTopPlayers(String criterion, int topN);

    /**
     * Update player statistics in the database.
     *
     * @param player The player with updated statistics.
     * @return The updated player entity.
     */
    Player updatePlayerStats(Player player);

    /**
     * Add a new player to the repository.
     *
     * @param player The player to add.
     * @return The added player entity.
     */
    Player addPlayer(Player player);

    /**
     * Delete a player from the repository by their ID.
     *
     * @param id The ID of the player to delete.
     */
    void deletePlayer(Long id);
}
