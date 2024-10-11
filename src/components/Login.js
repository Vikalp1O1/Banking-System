import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom'; // Import useNavigate

import './Login.css'; // Import CSS

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate(); // Hook for navigation

    const handleLogin = async (e) => {
        e.preventDefault();
        console.log('Attempting to log in with:', { username, password }); 
        try {
            const response = await axios.post('http://localhost:8080/api/users/login', {
                username,
                password,
            });
            console.log('Login successful:', response.data);
             // Redirect to account page on success
             navigate('/account', { state: { username } });
            // Handle successful login (e.g., redirect or store token)
        } catch (err) {
            const errorMessage = err.response?.data?.message || 'Invalid username or password';
            setError(errorMessage);
            console.error('Login error details:', err);
        }
    };

    return (
        <div className="login-container">
            <div className="login-box">
                <h2>Please sign in</h2>
                {error && <div className="error-message">{error}</div>}
                <form onSubmit={handleLogin}>
                    <div>
                        <input
                            type="text"
                            placeholder="Username"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            required
                        />
                    </div>
                    <div>
                        <input
                            type="password"
                            placeholder="Password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </div>
                    <button type="submit">Sign in</button>
                </form>
                <div>
                    <p>Don't have an account?</p>
                    <Link to="/create-account" className="register-link">Register here</Link>
                </div>
            </div>
        </div>
    );
};

export default Login;
   