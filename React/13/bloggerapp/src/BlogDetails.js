import React from 'react';

function BlogDetails() {
    const blogs = [
        { id: 1, title: 'Getting Started with React', content: 'React is a JavaScript library for building user interfaces.' },
        { id: 2, title: 'Understanding Hooks', content: 'Hooks let you use state and other React features without writing a class.' },
        { id: 3, title: 'React Router Basics', content: 'React Router is a standard library for routing in React.' }
    ];

    return (
        <div>
            <h2>Blog Details</h2>
            {blogs.map(blog => (
                <div key={blog.id}>
                    <h3>{blog.title}</h3>
                    <p>{blog.content}</p>
                </div>
            ))}
        </div>
    );
}

export default BlogDetails;
