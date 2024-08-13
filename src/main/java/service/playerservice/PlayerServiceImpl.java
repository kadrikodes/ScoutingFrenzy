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

    @Override
    public double calculateMatchPercentage(Player player, MatchCriteria criteria) {
        double matchScore = 0;
        double totalWeight = 0;

        // Calculate score based on passing accuracy and goals
        if (criteria.getMinPassAccuracy() > 0) {
            totalWeight += 1.0;
            matchScore += (player.getPassAccuracy() / criteria.getMinPassAccuracy()) * 1.0;
        }

        if (criteria.getMinGoals() > 0) {
            totalWeight += 0.8; // Example weight for goals
            matchScore += (player.getGoals() / criteria.getMinGoals()) * 0.8;
        }

        // Add more criteria checks as needed

        return (totalWeight > 0) ? (matchScore / totalWeight) * 100 : 0;
    }

    @Override
    public Map<String, Map<String, Double>> comparePlayers(Player player1, Player player2) {
        Map<String, Map<String, Double>> comparison = new HashMap<>();

        comparison.put("Goals", Map.of(player1.getName(), (double) player1.getGoals(), player2.getName(), (double) player2.getGoals()));
        comparison.put("Assists", Map.of(player1.getName(), (double) player1.getAssists(), player2.getName(), (double) player2.getAssists()));
        comparison.put("Pass Accuracy", Map.of(player1.getName(), player1.getPassAccuracy(), player2.getName(), player2.getPassAccuracy()));

        // Add more metrics as needed

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
            case "goals":
                return Comparator.comparing(Player::getGoals);
            case "assists":
                return Comparator.comparing(Player::getAssists);
            case "pass accuracy":
                return Comparator.comparing(Player::getPassAccuracy);
            // Add additional cases for other criteria
            default:
                throw new IllegalArgumentException("Unknown criterion: " + criterion);
        }
    }
}
