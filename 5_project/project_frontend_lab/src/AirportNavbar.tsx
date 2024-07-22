import React from "react";
import { Link, Route, Routes } from "react-router-dom";
import { Home } from "./UI/home/home";
import { Search } from "./UI/search/search";

function AirportNavbar() {
  return (
    <div>
      <div>
        <Link to="">Home</Link>
        <Link to="search">Search Airport</Link>
      </div>
      <div>
  
        <Routes>
          <Route path="/" element={<Home></Home>}></Route>
          <Route path="search" element={<Search></Search>}></Route>
        </Routes>
      </div>
    </div>
  );
}

export default AirportNavbar;
