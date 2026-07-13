import './App.css';

function App() {
    const heading = <h1>Office Space Rental</h1>;

    const officeImage = (
        <img
            src="https://images.unsplash.com/photo-1497366216548-37526070297c?w=600"
            alt="Office Space"
            style={{ width: '600px', height: '400px', objectFit: 'cover' }}
        />
    );

    const office = {
        name: 'TechHub Coworking',
        rent: 55000,
        address: '123, MG Road, Bangalore'
    };

    const officeSpaces = [
        { name: 'TechHub Coworking', rent: 55000, address: '123, MG Road, Bangalore' },
        { name: 'Innovation Center', rent: 75000, address: '456, Whitefield, Bangalore' },
        { name: 'StartUp Garage', rent: 40000, address: '789, HSR Layout, Bangalore' },
        { name: 'Corporate Tower', rent: 95000, address: '321, Electronic City, Bangalore' }
    ];

    return (
        <div className="App">
            {heading}
            {officeImage}

            <h2>Featured Office</h2>
            <p><strong>Name:</strong> {office.name}</p>
            <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
                <strong>Rent:</strong> Rs. {office.rent}
            </p>
            <p><strong>Address:</strong> {office.address}</p>

            <h2>All Office Spaces</h2>
            <table border="1" style={{ margin: '0 auto' }}>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Rent</th>
                        <th>Address</th>
                    </tr>
                </thead>
                <tbody>
                    {officeSpaces.map((space, index) => (
                        <tr key={index}>
                            <td>{space.name}</td>
                            <td style={{ color: space.rent < 60000 ? 'red' : 'green' }}>
                                Rs. {space.rent}
                            </td>
                            <td>{space.address}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default App;
