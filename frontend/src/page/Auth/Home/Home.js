import { useEffect, useState } from "react";
import { Outlet } from "react-router-dom";
import Sidebar from "../../../component/Sidebar/Sidebar";
import "./Home.css"
function Home() {
    return (
     <div className="wrapper-container d-flex align-items-stretch">
        <Sidebar/>
        <Outlet/>          
     </div>
    );
  }
  
  export default Home;