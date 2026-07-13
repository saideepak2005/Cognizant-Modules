import './App.css';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainersList';
import TrainerDetail from './TrainerDetails';
import trainersMock from './TrainersMock';

function App() {
    return (
        <BrowserRouter>
            <div className="App">
                <nav>
                    <Link to="/">Home</Link> | <Link to="/trainers">Trainers</Link>
                </nav>
                <hr />
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/trainers" element={<TrainersList trainers={trainersMock} />} />
                    <Route path="/trainers/:id" element={<TrainerDetail />} />
                </Routes>
            </div>
        </BrowserRouter>
    );
}

export default App;
