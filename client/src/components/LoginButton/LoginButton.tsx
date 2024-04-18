import React from 'react';

interface LoginButtonProps {
    onClick: () => void;
}

const LoginButton: React.FC<LoginButtonProps> = ({ onClick }) => {
    return (
        <button onClick={onClick}>
            Login
        </button>
    );
}

export default LoginButton;