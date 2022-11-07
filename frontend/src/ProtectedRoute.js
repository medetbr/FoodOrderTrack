import { Navigate, Outlet} from "react-router-dom";
function ProtectedRoute() {
  
    const userInfo = localStorage.getItem("userInfo")?JSON.parse(localStorage.getItem("userInfo")):null
    
    return (    
            userInfo?
            <Outlet/>:            
            <Navigate to="/login" />                    
    );
}

export default ProtectedRoute