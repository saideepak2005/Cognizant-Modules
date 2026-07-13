import React, { Component } from 'react';

class CurrencyConvertor extends Component {
    constructor(props) {
        super(props);
        this.state = {
            rupees: '',
            euro: ''
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({ rupees: event.target.value });
    }

    handleSubmit(event) {
        event.preventDefault();
        const euroValue = (parseFloat(this.state.rupees) / 89.5).toFixed(2);
        this.setState({ euro: euroValue });
    }

    render() {
        return (
            <div>
                <h2>Currency Convertor</h2>
                <form onSubmit={this.handleSubmit}>
                    <label>Indian Rupees: </label>
                    <input type="number" value={this.state.rupees} onChange={this.handleChange} />
                    <button type="submit">Convert</button>
                </form>
                {this.state.euro && <p>Euro: {this.state.euro}</p>}
            </div>
        );
    }
}

export default CurrencyConvertor;
