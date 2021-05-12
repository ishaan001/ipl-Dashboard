package io.javabrains.ipldashboard.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import io.javabrains.ipldashboard.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {
  
    /*get me all the matches where team1 = 1st args(teamName1) OR team2 = 1st args(teamName2)
    OrderByDateDesc part in method name is sorting the data
    Top4 part is limit the data

    other way to limit is 

    Pageable pageable - using this interface
    */
    List<Match> getTop4ByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2);
    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2,Pageable pageable);

    default List<Match> findLatestMatchesByTeam(String teamName, int count){
      return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
