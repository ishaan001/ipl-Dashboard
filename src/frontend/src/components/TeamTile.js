import { React } from "react";
import "./TeamTile.scss";
import { Link } from "react-router-dom";

export const TeamTile = ({ teamName }) => {
  const otherTeam = teamName;
  const otherTeamRoute = `/teams/${otherTeam}`;
  return (
    <div className="TeamTile">
      <h1>
        <Link to={otherTeamRoute}>{otherTeam}</Link>
      </h1>
    </div>
  );
};
