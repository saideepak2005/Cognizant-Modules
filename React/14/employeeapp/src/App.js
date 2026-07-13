import React, { Component } from 'react';
import './App.css';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            theme: 'light',
            employees: [
                { id: 1, name: 'John Doe', department: 'Engineering' },
                { id: 2, name: 'Jane Smith', department: 'Marketing' },
                { id: 3, name: 'Mike Johnson', department: 'Sales' },
                { id: 4, name: 'Sarah Williams', department: 'HR' }
            ]
        };
        this.toggleTheme = this.toggleTheme.bind(this);
    }

    toggleTheme() {
        this.setState(prevState => ({
            theme: prevState.theme === 'light' ? 'dark' : 'light'
        }));
    }

    render() {
        return (
            <ThemeContext.Provider value={this.state.theme}>
                <div className={`App ${this.state.theme}`}>
                    <h1>Employee Management</h1>
                    <button onClick={this.toggleTheme}>
                        Toggle Theme ({this.state.theme})
                    </button>
                    <EmployeesList employees={this.state.employees} />
                </div>
            </ThemeContext.Provider>
        );
    }
}

export default App;
