import { useEffect, useState } from "react";
import { fetchAllShopList } from "../../api/auth";
import Restaurant from "./Restaurant/Restaurant";
function Restaurants() {

  const [restaurants,setRestaurants] = useState([]);
  useEffect(()=>{
    (async()=>{
      const res = await fetchAllShopList(); 
      setRestaurants(res)
    })()
      
     
  },[setRestaurants])
    return (
        <div className="content row px-4">   
          <div className="col-3 restaurant-filter"><div>This div is for filter</div></div>
          <section className="col-9">
            {restaurants?.map(restaurant=><Restaurant restaurant={restaurant}/>)}
          </section>
          </div>
          
    );
  }
  
  export default Restaurants;