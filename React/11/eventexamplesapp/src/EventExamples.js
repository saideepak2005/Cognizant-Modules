import React, { Component } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class EventExamples extends Component {
    constructor(props) {
        super(props);
        this.state = {
            counter: 0
        };
        this.increment = this.increment.bind(this);
        this.decrement = this.decrement.bind(this);
        this.sayHello = this.sayHello.bind(this);
        this.sayWelcome = this.sayWelcome.bind(this);
        this.onPress = this.onPress.bind(this);
    }

    increment() {
        this.setState({ counter: this.state.counter + 1 });
        this.sayHello();
    }

    decrement() {
        this.setState({ counter: this.state.counter - 1 });
    }

    sayHello() {
        alert('Hello! The counter has been updated.');
    }

    sayWelcome(message) {
        alert(message);
    }

    onPress(event) {
        alert('I was clicked');
    }

    render() {
        return (
            <div>
                <h2>Event Handling Examples</h2>
                <h3>Counter: {this.state.counter}</h3>
                <button onClick={this.increment}>Increment</button>
                <button onClick={this.decrement}>Decrement</button>

                <hr />
                <button onClick={() => this.sayWelcome('Welcome')}>Say Welcome</button>

                <hr />
                <button onClick={this.onPress}>Click Me</button>

                <hr />
                <CurrencyConvertor />
            </div>
        );
    }
}

export default EventExamples;
