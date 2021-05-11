package io.javabrains.ipldashboard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String teamame;
    private long totalMatches;
    private long totalWins;
    
    public long getId() {
      return id;
    }
    public void setId(long id) {
      this.id = id;
    }
    public String getTeamame() {
      return teamame;
    }
    public void setTeamame(String teamame) {
      this.teamame = teamame;
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
      this.teamame = teamame;
      this.totalMatches = totalMatches;
    }
    @Override
    public String toString() {
      return "Team [teamame=" + teamame + ", totalMatches=" + totalMatches + ", totalWins=" + totalWins + "]";
    }

    
    
    
}
