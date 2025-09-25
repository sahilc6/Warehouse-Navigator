import React from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import HomePage from "./components/Home";
import PathFinder from "./components/PathFinder";
import PathMap from "./components/PathMap";
import AddList from "./components/AddList";

function App() {
  return (
    <BrowserRouter>
      {/* ✅ Navigation Bar */}
      <nav style={{ marginBottom: "20px" }}>
        <Link to="/">Home</Link> |{" "}
        <Link to="/add-list">Add List</Link> |{" "}
        <Link to="/map">Rack Map</Link> |{" "}
        <Link to="/path">Path Finder</Link>
      </nav>

      {/* ✅ All routes go inside <Routes> */}
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/add-list" element={<AddList />} />
        <Route path="/map" element={<PathMap />} />
        <Route path="/path" element={<PathFinder />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
