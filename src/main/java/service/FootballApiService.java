package service;

import entity.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class FootballApiService {

    @Value("${api.football.url}")
    private String apiUrl;

    @Value("${api.football.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public FootballApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Utility method to create headers
    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", apiKey);
        return headers;
    }

    // Generic method to make GET requests
    private <T> T makeGetRequest(String endpoint, Class<T> responseType) {
        String url = apiUrl + endpoint;
        HttpEntity<String> entity = new HttpEntity<>(createHeaders());

        try {
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Error fetching data from Football API: " + e.getMessage(), e);
        }
    }

    public Player getPlayerStats(Long playerId) {
        String endpoint = "/players/" + playerId;
        return makeGetRequest(endpoint, Player.class);
    }

    public Team getTeamDetails(Long teamId) {
        String endpoint = "/teams/" + teamId;
        return makeGetRequest(endpoint, Team.class);
    }

    public Match getMatchDetails(Long matchId) {
        String endpoint = "/matches/" + matchId;
        return makeGetRequest(endpoint, Match.class);
    }

    public Player[] searchPlayersByName(String playerName) {
        String endpoint = "/players?name=" + playerName;
        return makeGetRequest(endpoint, Player[].class);
    }

    public Team[] searchTeamsByName(String teamName) {
        String endpoint = "/teams?name=" + teamName;
        return makeGetRequest(endpoint, Team[].class);
    }

    // Fetch league details by league ID
    public League getLeagueDetails(Long leagueId) {
        String endpoint = "/competitions/" + leagueId;
        return makeGetRequest(endpoint, League.class);
    }

    // Fetch standings for a specific league
    public Standings getLeagueStandings(Long leagueId) {
        String endpoint = "/competitions/" + leagueId + "/standings";
        return makeGetRequest(endpoint, Standings.class);
    }

    // Fetch upcoming fixtures for a team
    public Match[] getUpcomingFixtures(Long teamId) {
        String endpoint = "/teams/" + teamId + "/matches?status=SCHEDULED";
        return makeGetRequest(endpoint, Match[].class);
    }

    // Fetch results of recent matches for a team
    public Match[] getRecentResults(Long teamId) {
        String endpoint = "/teams/" + teamId + "/matches?status=FINISHED";
        return makeGetRequest(endpoint, Match[].class);
    }

    // Fetch list of all available leagues
    public League[] getAllLeagues() {
        String endpoint = "/competitions";
        return makeGetRequest(endpoint, League[].class);
    }

    // Fetch top scorers of a specific league
    public Scorer[] getTopScorers(Long leagueId) {
        String endpoint = "/competitions/" + leagueId + "/scorers";
        return makeGetRequest(endpoint, Scorer[].class);
    }

    // Additional methods can be added as necessary...
}
