import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
    const theme = useContext(ThemeContext);

    return (
        <div style={{ border: '1px solid #ccc', padding: '10px', margin: '10px', display: 'inline-block', width: '200px' }}>
            <h3>{employee.name}</h3>
            <p>ID: {employee.id}</p>
            <p>Department: {employee.department}</p>
            <button className={theme === 'dark' ? 'btn-dark' : 'btn-light'}>
                View Details
            </button>
            <button className={theme === 'dark' ? 'btn-dark' : 'btn-light'}>
                Edit
            </button>
        </div>
    );
}

export default EmployeeCard;
