import React from 'react';

function UserPage() {
    return (
        <div>
            <h2>Welcome User</h2>
            <p>You can now book tickets!</p>
            <table border="1">
                <thead>
                    <tr>
                        <th>Flight</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Departure</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>AI-101</td>
                        <td>Mumbai</td>
                        <td>Delhi</td>
                        <td>10:00 AM</td>
                        <td><button>Book</button></td>
                    </tr>
                    <tr>
                        <td>AI-202</td>
                        <td>Bangalore</td>
                        <td>Chennai</td>
                        <td>02:00 PM</td>
                        <td><button>Book</button></td>
                    </tr>
                    <tr>
                        <td>AI-303</td>
                        <td>Kolkata</td>
                        <td>Hyderabad</td>
                        <td>06:00 PM</td>
                        <td><button>Book</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}

export default UserPage;
