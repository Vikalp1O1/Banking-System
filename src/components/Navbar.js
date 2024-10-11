// src/components/Navbar.js
import React from 'react';
import { Link } from 'react-router-dom'; // Import Link from React Router
import './Navbar.css';

const Navbar = () => {
    return (
        <nav>
            <ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/account">Account</Link></li>
                <li><Link to="/create-account">Create Account</Link></li>
            </ul>
        </nav>
    );
};

export default Navbar;
