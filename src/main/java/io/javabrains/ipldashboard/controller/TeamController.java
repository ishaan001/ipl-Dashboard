package io.javabrains.ipldashboard.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ipldashboard.model.Match;
import io.javabrains.ipldashboard.model.Team;
import io.javabrains.ipldashboard.repository.MatchRepository;
import io.javabrains.ipldashboard.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {
  // below are the 2 ways to create object
  private TeamRepository teamRepository;
  @Autowired
  private MatchRepository matchRepository;

  public TeamController(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  @GetMapping("/team/{teamName}")
  public Team getTeam(@PathVariable String teamName) {
    Team team = this.teamRepository.findByTeamName(teamName);
    // Pageable pageable = PageRequest.of(0, 4);
    // team.setMatches(this.matchRepository.getByTeam1OrTeam2OrderByDateDesc(teamName,
    // teamName, pageable));
    team.setMatches(this.matchRepository.findLatestMatchesByTeam(teamName, 4));
    return team;
  }

  @GetMapping("/team/{teamName}/matches")
  public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
    LocalDate startDate = LocalDate.of(year, 1, 1);
    LocalDate endDate = LocalDate.of(year + 1, 1, 1);
    return this.matchRepository.getByTeamBetweenDates(
      teamName, startDate, endDate);

  }
}
