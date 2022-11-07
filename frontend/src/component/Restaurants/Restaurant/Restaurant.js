import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "./Restaurant.css"
function Restaurant({restaurant}){
    const [user,setUser] = useState(null);
    useEffect(()=>{
      const user = JSON.parse(localStorage.getItem("userInfo"));
      setUser(user);
    },[setUser])
   
    return(
        <div className="restaurant-wrapper">
           <div className="restaurant">
             <div className="container">
                <div className="row">
                  <div className="col-4">
                    <div className="restaurant-image-wrapper">
                        <img src="assets/pizza.jpg"/>
                    </div>
                    </div>  
                
                  <div className="col-8">
                    <div className="restaurant-name d-flex  justify-content-between">
                        <h5 className="">{restaurant?.name}</h5>
                        <div className="restaurant-rating d-flex align-items-center">
                            <span><i className="fa-solid fa-star"></i>{restaurant?.rating==null?"değerlendirilmedi ":<b>{restaurant?.rating}</b>}<b style={{color:"black",fontWeight:"500"}}>(0)</b></span>
                        </div>
                        
                    </div>
                    <div className="restaurant-address">
                        <p>{restaurant?.address} </p>
                    </div>
                    <div className="restaurant-card-bottom align-items-center d-flex justify-content-between">
                         <span></span> 
                        <Link to={`/${restaurant?.restaurantCode}`} className="btn restaurant-btn">Sipariş ver</Link>
                    </div>
                    </div> 
                </div>
             </div>
            </div> 
        </div>
    )
}
export default Restaurant;