import { React, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { MatchDetailCard } from "../components/MatchDetailCard";
import { MatchSmallCard } from "../components/MatchSmallCard";
import { PieChart } from "react-minimal-pie-chart";
import "./TeamPage.scss";

export const TeamPage = () => {
  const [team, setTeam] = useState({ matches: [] });
  const { teamName } = useParams();
  useEffect(() => {
    const fetchMatches = async () => {
      const response = await fetch(`http://localhost:8080/team/${teamName}`);
      const data = await response.json();
      console.log(data);
      setTeam(data);
    };
    fetchMatches();
  }, [teamName]);

  if (!team || !team.teamame) {
    return <h1>Team Not Found</h1>;
  }
  return (
    <div className="TeamPage">
      <div className="team-name-section">
        <h1 className="team-name">{team.teamame}</h1>
      </div>
      <div className="win-loss-section">
        Wins Vs Losses
        <PieChart
          data={[
            { title: "Losses", value: team.totalMatches - team.totalWins, color: "#a34d5d" },
            { title: "Wins", value: team.totalWins, color: "#4da375" },
          ]}
        />
      </div>
      <div className="match-detail-section">
        <MatchDetailCard teamName={team.teamame} match={team.matches[0]} />
      </div>
      {team.matches.slice(1).map((match) => (
        <MatchSmallCard teamName={team.teamame} match={match} />
      ))}
      <div className="more-link">
        <a href="#">More </a>
      </div>
    </div>
  );
};
