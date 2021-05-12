package io.javabrains.ipldashboard.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Team {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String teamName;
    private long totalMatches;
    private long totalWins;
    @Transient
    private List<Match> matches;

    public long getId() {
      return id;
    }
    public void setId(long id) {
      this.id = id;
    }
    public String getTeamame() {
      return teamName;
    }
    public void setTeamame(String teamame) {
      this.teamName = teamame;
    }
    public long getTotalMatches() {
      return totalMatches;
    }
    public void setTotalMatches(long totalMatches) {
      this.totalMatches = totalMatches;
    }
    public long getTotalWins() {
      return totalWins;
    }
    public void setTotalWins(long totalWins) {
      this.totalWins = totalWins;
    }
    public Team(String teamame, long totalMatches) {
      this.teamName = teamame;
      this.totalMatches = totalMatches;
    }
    @Override
    public String toString() {
      return "Team [teamame=" + teamName + ", totalMatches=" + totalMatches + ", totalWins=" + totalWins + "]";
    }
    public Team() {
    }
    public List<Match> getMatches() {
      return matches;
    }
    public void setMatches(List<Match> matches) {
      this.matches = matches;
    }

    
    
    
}
