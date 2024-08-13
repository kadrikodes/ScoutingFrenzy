package controller;

import entity.Player;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.playerservice.PlayerService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    /**
     * Retrieve all players.
     *
     * @return A list of all players.
     */
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.findAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    /**
     * Retrieve a player by ID.
     *
     * @param id The ID of the player to retrieve.
     * @return The player with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = playerService.findById(id);
        return player.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));
    }

    /**
     * Add a new player.
     *
     * @param player The player to add.
     * @return The added player.
     */
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player newPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    /**
     * Update an existing player.
     *
     * @param id     The ID of the player to update.
     * @param player The updated player information.
     * @return The updated player.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        player.setId(id);
        Player updatedPlayer = playerService.updatePlayerStats(player);
        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    /**
     * Delete a player by ID.
     *
     * @param id The ID of the player to delete.
     * @return A response indicating the outcome of the operation.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Search for players matching specific criteria.
     *
     * @param criteria The criteria to match players against.
     * @return A list of players matching the criteria.
     */
    @PostMapping("/search")
    public ResponseEntity<List<Player>> searchPlayers(@RequestBody MatchCriteria criteria) {
        List<Player> matchingPlayers = playerService.getPlayersMatchingCriteria(criteria);
        return new ResponseEntity<>(matchingPlayers, HttpStatus.OK);
    }

    /**
     * Retrieve top N players based on a specific criterion.
     *
     * @param criterion The criterion to rank players by.
     * @param topN      The number of top players to retrieve.
     * @return A list of top N players based on the criterion.
     */
    @GetMapping("/top")
    public ResponseEntity<List<Player>> getTopPlayers(
            @RequestParam String criterion,
            @RequestParam int topN) {
        List<Player> topPlayers = playerService.getTopPlayers(criterion, topN);
        return new ResponseEntity<>(topPlayers, HttpStatus.OK);
    }

    /**
     * Compare two players and return a detailed comparison of their statistics.
     *
     * @param playerId1 The ID of the first player to compare.
     * @param playerId2 The ID of the second player to compare.
     * @return A map containing the comparison results of their statistics.
     */
    @GetMapping("/compare")
    public ResponseEntity<Map<String, Map<String, Double>>> comparePlayers(
            @RequestParam Long playerId1,
            @RequestParam Long playerId2) {
        Player player1 = playerService.findById(playerId1)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + playerId1));
        Player player2 = playerService.findById(playerId2)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + playerId2));
        Map<String, Map<String, Double>> comparison = playerService.comparePlayers(player1, player2);
        return new ResponseEntity<>(comparison, HttpStatus.OK);
    }
}
