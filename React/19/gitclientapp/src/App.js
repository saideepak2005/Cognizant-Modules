import React, { Component } from 'react';
import './App.css';
import GitClient from './GitClient';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            repositories: [],
            username: 'techiesyed'
        };
    }

    async componentDidMount() {
        const gitClient = new GitClient();
        try {
            const repos = await gitClient.getRepositories(this.state.username);
            this.setState({ repositories: repos });
        } catch (error) {
            console.error('Error fetching repositories:', error);
        }
    }

    render() {
        return (
            <div className="App">
                <h1>GitHub Repositories</h1>
                <h2>Repositories for: {this.state.username}</h2>
                <ul>
                    {this.state.repositories.map((repo, index) => (
                        <li key={index}>{repo}</li>
                    ))}
                </ul>
            </div>
        );
    }
}

export default App;
