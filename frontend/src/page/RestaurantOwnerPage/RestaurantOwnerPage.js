import { useEffect, useState } from "react";
import { fetchOrdersByRestaurantCode, fetchRestaurantByUsername } from "../../api/auth";
import OrderOfRestaurant from "./OrderOfRestaurant/OrderOfRestaurant";
import "./RestaurantOwnerPage.css"
function RestaurantOwnerPage(){
    const userInfo = localStorage.getItem("userInfo")?JSON.parse(localStorage.getItem("userInfo")):null
    const [restaurant,setRestaurant] = useState(null);
    const [orders,setOrders] = useState(null);

    useEffect(()=>{
        (async()=>{
            const res = await fetchRestaurantByUsername(userInfo.username);
            setRestaurant(res)
            const resOrder = await fetchOrdersByRestaurantCode(res.restaurantCode);
            setOrders(resOrder.reverse());
        })()
    },[setRestaurant])
    return(
        <div className="restaurant-owner-wrapper">
            <div className="restaurant-owner-top">
            <h3>{restaurant?.name}</h3>
                <div className="restaurant-statistics justify-content-md-center row">
                    <div className="statistics-item pending-order col-2">
                        <div className="item-title text-center">Bekleyen Siparişler</div>
                        <div style={{WebkitTextStrokeColor:"dodgerblue"}} className="text-center statistics-value">2</div>
                    </div>
                    <div className="statistics-item approved-order col-2">
                        <div className="item-title text-center">Onaylanan Siparişler</div>
                        <div style={{WebkitTextStrokeColor:"#0dee5f"}} className="text-center statistics-value">1</div>
                    </div>
                    <div className="statistics-item rejected-orders col-2">
                        <div className="item-title text-center">Reddedilen Siparişler</div>
                        <div style={{WebkitTextStrokeColor:"#e05f3f"}} className="text-center statistics-value">0</div>
                    </div>
                    <div className="statistics-item all-orders col-2">
                        <div className="item-title text-center">Tüm Siparişler</div>
                        <div style={{WebkitTextStrokeColor:"#ffbb00"}} className="text-center statistics-value">{orders?.length}</div>
                    </div>
                </div>                
            </div>
            <div className="restaurant-owner-center">
                 <p><b>Addres:</b> {restaurant?.address}</p>
                 <p><b>Açıklama:</b> {restaurant?.description}</p>
            </div>
            <div className="restaurant-owner-bottom">
                <h4>Güncel siparişleriniz</h4>
                <div className="orders-wrapper">
                    <div className="order-item">
                       {orders?.map(order => <OrderOfRestaurant order={order}/>)} 
                    </div>
                </div>
            </div>
        </div>
    )
}
export default RestaurantOwnerPage;