import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';  // Import the Navbar component
import Login from './components/Login';
import AccountPage from './components/AccountPage'; // Make sure to create this component
import Home from './components/Home'; // Import the new Home component
import CreateAccountPage from './components/CreateAccountPage'; // Create account component

const App = () => {
    return (
        <Router>
            <div>
                <h1>Online Banking System</h1>
                <Navbar /> {/* Add the Navbar component here */}
                <Routes>
                    <Route path="/" element={<Home />} /> {/* Home Page */}
                    <Route path="/login" element={<Login />} />
                    <Route path="/account" element={<AccountPage />} />
                    <Route path="/create-account" element={<CreateAccountPage />} /> {/* New route */}
                </Routes>
            </div>
        </Router>
    );
};

export default App;
