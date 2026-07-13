import React, { Component } from 'react';

class ListOfPlayers extends Component {
    render() {
        const players = [
            { name: 'Virat Kohli', score: 82 },
            { name: 'Rohit Sharma', score: 95 },
            { name: 'KL Rahul', score: 65 },
            { name: 'Shikhar Dhawan', score: 58 },
            { name: 'Rishabh Pant', score: 72 },
            { name: 'Hardik Pandya', score: 45 },
            { name: 'Ravindra Jadeja', score: 78 },
            { name: 'Jasprit Bumrah', score: 30 },
            { name: 'Mohammed Shami', score: 42 },
            { name: 'Yuzvendra Chahal', score: 55 },
            { name: 'Shreyas Iyer', score: 88 }
        ];

        const playerList = players.map((player, index) => (
            <li key={index}>{player.name} - Score: {player.score}</li>
        ));

        const filteredPlayers = players.filter(player => player.score < 70);
        const filteredList = filteredPlayers.map((player, index) => (
            <li key={index}>{player.name} - Score: {player.score}</li>
        ));

        return (
            <div>
                <h2>All Players</h2>
                <ul>{playerList}</ul>
                <h2>Players with Score Below 70</h2>
                <ul>{filteredList}</ul>
            </div>
        );
    }
}

export default ListOfPlayers;
