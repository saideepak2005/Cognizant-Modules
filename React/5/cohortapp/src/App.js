import './App.css';
import CohortDetails from './CohortDetails';
import cohortData from './CohortData';

function App() {
    return (
        <div className="App">
            <h1>Cohort Dashboard</h1>
            <div>
                {cohortData.map((cohort, index) => (
                    <CohortDetails key={index} cohort={cohort} />
                ))}
            </div>
        </div>
    );
}

export default App;
