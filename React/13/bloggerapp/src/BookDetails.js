import React from 'react';

function BookDetails() {
    const books = [
        { id: 1, title: 'React in Action', author: 'Mark Thomas' },
        { id: 2, title: 'Learning JavaScript', author: 'Ethan Brown' },
        { id: 3, title: 'Node.js Design Patterns', author: 'Mario Casciaro' }
    ];

    return (
        <div>
            <h2>Book Details</h2>
            <ul>
                {books.map(book => (
                    <li key={book.id}>
                        <strong>{book.title}</strong> by {book.author}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default BookDetails;
