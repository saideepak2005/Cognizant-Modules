import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [
                { itemName: 'Laptop', price: 75000 },
                { itemName: 'Mobile', price: 25000 },
                { itemName: 'Headphones', price: 3000 },
                { itemName: 'Keyboard', price: 1500 },
                { itemName: 'Mouse', price: 800 }
            ]
        };
    }

    render() {
        return (
            <div>
                <h2>Online Shopping</h2>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Item Name</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.items.map((item, index) => (
                            <Cart key={index} itemName={item.itemName} price={item.price} />
                        ))}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default OnlineShopping;
