package io.javabrains.ipldashboard.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.javabrains.ipldashboard.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {

  /*
   * get me all the matches where team1 = 1st args(teamName1) OR team2 = 1st
   * args(teamName2) OrderByDateDesc part in method name is sorting the data Top4
   * part is limit the data
   * 
   * other way to limit is
   * 
   * Pageable pageable - using this interface
   */
  List<Match> getTop4ByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2);

  List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

  @Query("select m from Match m where (m.team1 = :teamName or m.team2 =:teamName) and m.date between :dateStart and :dateEnd order by date desc")
  List<Match> getByTeamBetweenDates(@Param("teamName") String teamName, @Param("dateStart") LocalDate dateStart,
      @Param("dateEnd") LocalDate dateEnd);
  // List<Match> getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(
  // String teamName1, LocalDate date1, LocalDate date2,
  // String teamName2, LocalDate date3, LocalDate date4);

  default List<Match> findLatestMatchesByTeam(String teamName, int count) {
    return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
  }
}
