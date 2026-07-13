import React, { Component } from 'react';

class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            email: '',
            password: '',
            errors: {
                name: '',
                email: '',
                password: ''
            }
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    validate(name, value) {
        let error = '';

        switch (name) {
            case 'name':
                if (value.length < 5) {
                    error = 'Name should have at least 5 characters';
                }
                break;
            case 'email':
                if (!value.includes('@') || !value.includes('.')) {
                    error = 'Email should contain @ and .';
                }
                break;
            case 'password':
                if (value.length < 8) {
                    error = 'Password should have at least 8 characters';
                }
                break;
            default:
                break;
        }

        return error;
    }

    handleChange(event) {
        const { name, value } = event.target;
        const error = this.validate(name, value);

        this.setState(prevState => ({
            [name]: value,
            errors: {
                ...prevState.errors,
                [name]: error
            }
        }));
    }

    handleSubmit(event) {
        event.preventDefault();
        const { name, email, password } = this.state;
        const errors = {
            name: this.validate('name', name),
            email: this.validate('email', email),
            password: this.validate('password', password)
        };

        this.setState({ errors });

        if (!errors.name && !errors.email && !errors.password) {
            alert('Registration Successful!');
        }
    }

    render() {
        const { name, email, password, errors } = this.state;

        return (
            <div>
                <h2>Registration Form</h2>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <label>Name: </label>
                        <input
                            type="text"
                            name="name"
                            value={name}
                            onChange={this.handleChange}
                        />
                        {errors.name && <p style={{ color: 'red' }}>{errors.name}</p>}
                    </div>
                    <br />
                    <div>
                        <label>Email: </label>
                        <input
                            type="text"
                            name="email"
                            value={email}
                            onChange={this.handleChange}
                        />
                        {errors.email && <p style={{ color: 'red' }}>{errors.email}</p>}
                    </div>
                    <br />
                    <div>
                        <label>Password: </label>
                        <input
                            type="password"
                            name="password"
                            value={password}
                            onChange={this.handleChange}
                        />
                        {errors.password && <p style={{ color: 'red' }}>{errors.password}</p>}
                    </div>
                    <br />
                    <button type="submit">Register</button>
                </form>
            </div>
        );
    }
}

export default Register;
