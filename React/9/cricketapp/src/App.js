import './App.css';
import ListOfPlayers from './ListOfPlayers';
import IndianPlayers from './IndianPlayers';

function App() {
    const flag = true;

    return (
        <div className="App">
            {flag ? <ListOfPlayers /> : <IndianPlayers />}
        </div>
    );
}

export default App;
