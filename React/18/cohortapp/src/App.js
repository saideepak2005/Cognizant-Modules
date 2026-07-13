import './App.css';
import CohortDetails from './CohortDetails';
import cohortData from './Cohort';

function App() {
    return (
        <div className="App">
            <h1>Cohort Dashboard</h1>
            {cohortData.map((cohort, index) => (
                <CohortDetails key={index} cohort={cohort} />
            ))}
        </div>
    );
}

export default App;
