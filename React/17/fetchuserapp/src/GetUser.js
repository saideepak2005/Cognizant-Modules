import React, { Component } from 'react';

class GetUser extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: null
        };
    }

    async componentDidMount() {
        const response = await fetch('https://api.randomuser.me/');
        const data = await response.json();
        this.setState({ user: data.results[0] });
    }

    render() {
        const { user } = this.state;

        if (!user) {
            return <p>Loading...</p>;
        }

        return (
            <div>
                <h2>User Details</h2>
                <img src={user.picture.large} alt="User" />
                <p><strong>Title:</strong> {user.name.title}</p>
                <p><strong>First Name:</strong> {user.name.first}</p>
                <p><strong>Last Name:</strong> {user.name.last}</p>
            </div>
        );
    }
}

export default GetUser;
