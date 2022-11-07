import { Navigate, Outlet} from "react-router-dom";
import { ErrorPage } from "./page";
function CustomerRoute() {
  
    const userInfo = localStorage.getItem("userInfo")?JSON.parse(localStorage.getItem("userInfo")):null
    
    return (    
            userInfo.isCustomer?
            <Outlet/>:            
            <ErrorPage/>                   
    );
}

export default CustomerRoute