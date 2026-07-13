import React from 'react';
import EmployeeCard from './EmployeeCard';

function EmployeesList({ employees }) {
    return (
        <div>
            <h2>Employees List</h2>
            <div>
                {employees.map(employee => (
                    <EmployeeCard key={employee.id} employee={employee} />
                ))}
            </div>
        </div>
    );
}

export default EmployeesList;
