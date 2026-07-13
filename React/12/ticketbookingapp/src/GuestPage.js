import React from 'react';

function GuestPage() {
    return (
        <div>
            <h2>Welcome Guest</h2>
            <p>Flight Details:</p>
            <table border="1">
                <thead>
                    <tr>
                        <th>Flight</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Departure</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>AI-101</td>
                        <td>Mumbai</td>
                        <td>Delhi</td>
                        <td>10:00 AM</td>
                    </tr>
                    <tr>
                        <td>AI-202</td>
                        <td>Bangalore</td>
                        <td>Chennai</td>
                        <td>02:00 PM</td>
                    </tr>
                    <tr>
                        <td>AI-303</td>
                        <td>Kolkata</td>
                        <td>Hyderabad</td>
                        <td>06:00 PM</td>
                    </tr>
                </tbody>
            </table>
            <p>Please login to book tickets.</p>
        </div>
    );
}

export default GuestPage;
