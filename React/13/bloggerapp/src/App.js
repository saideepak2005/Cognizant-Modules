import React, { Component } from 'react';
import './App.css';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedView: 'books'
        };
    }

    renderContent() {
        const { selectedView } = this.state;

        switch (selectedView) {
            case 'books':
                return <BookDetails />;
            case 'blogs':
                return <BlogDetails />;
            case 'courses':
                return <CourseDetails />;
            default:
                return <BookDetails />;
        }
    }

    render() {
        const { selectedView } = this.state;

        return (
            <div className="App">
                <h1>Blogger App</h1>
                <button onClick={() => this.setState({ selectedView: 'books' })}>Books</button>
                <button onClick={() => this.setState({ selectedView: 'blogs' })}>Blogs</button>
                <button onClick={() => this.setState({ selectedView: 'courses' })}>Courses</button>

                {selectedView === 'books' && <BookDetails />}
                {selectedView === 'blogs' && <BlogDetails />}
                {selectedView === 'courses' && <CourseDetails />}

                <hr />
                <h3>Using Ternary Operator</h3>
                {selectedView === 'books' ? <p>Showing Books</p> : <p>Not showing Books</p>}

                <hr />
                <h3>Using Switch Statement</h3>
                {this.renderContent()}
            </div>
        );
    }
}

export default App;
