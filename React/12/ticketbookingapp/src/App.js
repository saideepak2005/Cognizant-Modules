import React, { Component } from 'react';
import './App.css';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoggedIn: false
        };
        this.handleLogin = this.handleLogin.bind(this);
        this.handleLogout = this.handleLogout.bind(this);
    }

    handleLogin() {
        this.setState({ isLoggedIn: true });
    }

    handleLogout() {
        this.setState({ isLoggedIn: false });
    }

    render() {
        const { isLoggedIn } = this.state;
        let button;

        if (isLoggedIn) {
            button = <button onClick={this.handleLogout}>Logout</button>;
        } else {
            button = <button onClick={this.handleLogin}>Login</button>;
        }

        return (
            <div className="App">
                <h1>Ticket Booking App</h1>
                {button}
                {isLoggedIn ? <UserPage /> : <GuestPage />}
            </div>
        );
    }
}

export default App;
