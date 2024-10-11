import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './CreateAccountPage.css';

const CreateAccountPage = () => {
    const [formData, setFormData] = useState({
        username: '',
        password: '',
        email: '',
        accountNumber: '',
        balance: 0.0
    });
    const navigate = useNavigate();
    const [errorMessage, setErrorMessage] = useState('');

    // Handle form input changes
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    // Submit form data to backend
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.post('/api/users/register', formData);
            navigate('/account', { state: { username: formData.username } });
        } catch (error) {
            console.error('Error creating account:', error);
            setErrorMessage('Failed to create account. Try again.');
        }
    };

    return (
        <div className="create-account-container">
            <h2>Create New Bank Account</h2>
            {errorMessage && <p className="error">{errorMessage}</p>}
            <form onSubmit={handleSubmit}>
                <label>Username:</label>
                <input 
                    type="text" 
                    name="username" 
                    value={formData.username} 
                    onChange={handleChange} 
                    required 
                />

                <label>Password:</label>
                <input 
                    type="password" 
                    name="password" 
                    value={formData.password} 
                    onChange={handleChange} 
                    required 
                />

                <label>Email:</label>
                <input 
                    type="email" 
                    name="email" 
                    value={formData.email} 
                    onChange={handleChange} 
                    required 
                />

                <label>Account Number:</label>
                <input 
                    type="text" 
                    name="accountNumber" 
                    value={formData.accountNumber} 
                    onChange={handleChange} 
                    required 
                />

                <label>Balance:</label>
                <input 
                    type="number" 
                    name="balance" 
                    value={formData.balance} 
                    onChange={handleChange} 
                    required 
                />

                <button type="submit">Create Account</button>
            </form>
        </div>
    );
};

export default CreateAccountPage;
