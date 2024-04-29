// Example using React Router
import React from 'react';
import { useLocation } from 'react-router-dom';

export function AuthSuccess() {
    const location = useLocation();

    React.useEffect(() => {
        const queryParams = new URLSearchParams(location.search);
        const token = queryParams.get('token');
        if (token) {
            localStorage.setItem('accessToken', token);
            window.location.href = '/'; // Redirect to home or dashboard
        }
    }, [location]);

    return <div>Authenticating...</div>;
}
