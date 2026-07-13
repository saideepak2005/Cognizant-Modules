import React, { Component } from 'react';

class IndianPlayers extends Component {
    render() {
        const players = ['Player1', 'Player2', 'Player3', 'Player4', 'Player5', 'Player6', 'Player7', 'Player8', 'Player9', 'Player10', 'Player11'];

        const [first, second, ...rest] = players;
        const oddTeam = players.filter((_, index) => index % 2 === 0);
        const evenTeam = players.filter((_, index) => index % 2 !== 0);

        const t20Players = ['Virat Kohli', 'Rohit Sharma', 'KL Rahul', 'Suryakumar Yadav', 'Hardik Pandya'];
        const ranjiTrophyPlayers = ['Cheteshwar Pujara', 'Ajinkya Rahane', 'Hanuma Vihari', 'Mayank Agarwal', 'Prithvi Shaw'];

        const mergedPlayers = [...t20Players, ...ranjiTrophyPlayers];

        return (
            <div>
                <h2>Odd Team Players</h2>
                <ul>
                    {oddTeam.map((player, index) => (
                        <li key={index}>{player}</li>
                    ))}
                </ul>
                <h2>Even Team Players</h2>
                <ul>
                    {evenTeam.map((player, index) => (
                        <li key={index}>{player}</li>
                    ))}
                </ul>
                <h2>T20 Players</h2>
                <ul>
                    {t20Players.map((player, index) => (
                        <li key={index}>{player}</li>
                    ))}
                </ul>
                <h2>Ranji Trophy Players</h2>
                <ul>
                    {ranjiTrophyPlayers.map((player, index) => (
                        <li key={index}>{player}</li>
                    ))}
                </ul>
                <h2>Merged Players</h2>
                <ul>
                    {mergedPlayers.map((player, index) => (
                        <li key={index}>{player}</li>
                    ))}
                </ul>
            </div>
        );
    }
}

export default IndianPlayers;
