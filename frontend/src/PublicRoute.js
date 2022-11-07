import { Navigate, Outlet} from "react-router-dom";
function PublicRoute() {
  
    const userInfo = localStorage.getItem("userInfo")?JSON.parse(localStorage.getItem("userInfo")):null
    
    return (    
            !userInfo?
            <Outlet/>:            
            <Navigate to="/" />                    
    );
}

export default PublicRoute