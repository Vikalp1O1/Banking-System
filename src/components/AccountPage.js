import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';
import './AccountPage.css';

const AccountPage = () => {
    const location = useLocation();
    const navigate = useNavigate();
    const { username } = location.state || { username: 'Guest' };
    const [account, setAccount] = useState(null);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(true); // Added loading state

    useEffect(() => {
        const fetchAccountDetails = async () => {
            try {
                console.log(`Fetching account details for username: ${username}`);
                const response = await axios.get(`/api/users/account/${username}`);
                console.log('Response from API:', response);

                if (response.status === 200) {
                    setAccount(response.data);
                } else {
                    setError('Could not fetch account details. Please try again.');
                }
            } catch (error) {
                console.error('Error fetching account details:', error);
                setError('Could not fetch account details. Please check your username and try again.'); // More descriptive error message
            } finally {
                setLoading(false); // Stop loading state
            }
        };

        if (username && username !== 'Guest') {
            fetchAccountDetails();
        } else {
            setLoading(false); // Stop loading if username is guest
        }
    }, [username]);

    const handleLogout = () => {
        navigate('/'); // Redirect to the home page or login page on logout
    };

    return (
        <div className="account-container">
            <div className="account-header">
                <h1>Online Banking System</h1>
                <button className="logout-btn" onClick={handleLogout}>Logout</button>
            </div>
            <div className="account-content">
                <h2>Welcome to your account, {username}!</h2>
                {loading && <p>Loading account details...</p>} {/* Display loading message */}
                {error && <p className="error">{error}</p>}
                {account && (
                    <div>
                        <p><strong>Account Number:</strong> {account.accountNumber}</p>
                        <p><strong>Balance:</strong> ${account.balance}</p>
                    </div>
                )}
            </div>
        </div>
    );
};

export default AccountPage;
