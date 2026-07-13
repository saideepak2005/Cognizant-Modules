import React from 'react';

function CohortDetails({ cohort }) {
    return (
        <div className="cohort-card">
            <h3>{cohort.code}</h3>
            <dl>
                <dt>Name</dt>
                <dd>{cohort.name}</dd>
                <dt>Status</dt>
                <dd>{cohort.status}</dd>
                <dt>Start Date</dt>
                <dd>{cohort.startDate}</dd>
                <dt>End Date</dt>
                <dd>{cohort.endDate}</dd>
            </dl>
        </div>
    );
}

export default CohortDetails;
