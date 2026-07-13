import React, { Component } from 'react';

class ComplaintRegister extends Component {
    constructor(props) {
        super(props);
        this.state = {
            employeeName: '',
            complaint: ''
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({ [event.target.name]: event.target.value });
    }

    handleSubmit(event) {
        event.preventDefault();
        const referenceNumber = 'REF-' + Math.floor(Math.random() * 100000);
        alert('Complaint submitted successfully!\nReference Number: ' + referenceNumber);
        this.setState({ employeeName: '', complaint: '' });
    }

    render() {
        return (
            <div>
                <h2>Complaint Register</h2>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <label>Employee Name: </label>
                        <input
                            type="text"
                            name="employeeName"
                            value={this.state.employeeName}
                            onChange={this.handleChange}
                        />
                    </div>
                    <br />
                    <div>
                        <label>Complaint: </label>
                        <textarea
                            name="complaint"
                            value={this.state.complaint}
                            onChange={this.handleChange}
                            rows="5"
                            cols="40"
                        />
                    </div>
                    <br />
                    <button type="submit">Submit Complaint</button>
                </form>
            </div>
        );
    }
}

export default ComplaintRegister;
