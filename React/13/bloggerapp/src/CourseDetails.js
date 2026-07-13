import React from 'react';

function CourseDetails() {
    const courses = [
        { id: 1, name: 'React Fundamentals', duration: '30 hours' },
        { id: 2, name: 'Advanced JavaScript', duration: '25 hours' },
        { id: 3, name: 'Node.js Backend', duration: '40 hours' }
    ];

    return (
        <div>
            <h2>Course Details</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>Course Name</th>
                        <th>Duration</th>
                    </tr>
                </thead>
                <tbody>
                    {courses.map(course => (
                        <tr key={course.id}>
                            <td>{course.name}</td>
                            <td>{course.duration}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default CourseDetails;
