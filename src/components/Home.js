// src/components/Home.js
import React from 'react';
import { Link } from 'react-router-dom';
import './Home.css'; // For styling the page

const Home = () => {
    return (
        <div className="home-container">
            <div className="home-content">
                <h1>Welcome to Neo Bank</h1>
                <p>
                    At Neo Bank, we offer secure and reliable banking services to manage your finances. 
                    Join us today and experience the difference!
                </p>
                <div className="home-buttons">
                    <Link to="/login">
                        <button className="home-btn">Login</button>
                    </Link>
                    <Link to="/create-account">
                        <button className="home-btn register-btn">Create New Bank Account</button>
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default Home;
