import axios from "axios";
export async function registerApi(object){   
         await axios.post("http://localhost:8080/api/auth/register/",object);  
     
}
export async function loginApi(object){   
        const {data} = await axios.post("http://localhost:8080/api/auth/login/",object);
        data&&localStorage.setItem("userInfo",JSON.stringify(data));
}
export async function fetchAllShopList(){   
        const {data} = await axios.get("http://localhost:8080/api/restaurants/");
        return data;
}
export  function postOrder(orderObject){   
          axios.post("http://localhost:8080/api/orders/",orderObject);
}
export async function fetchOrdersByUsername(username){  
        const {data} = await axios.get(`http://localhost:8080/api/orders?username=${username}`);
        return data;
}
export async function fetchRestaurantItemsByRestaurantCode(restaurantCode) {
        const {data} = await axios.get(`http://localhost:8080/api/menu-items/${restaurantCode}`);
        return data;
}
export async function fetchRestaurantByUsername(username) {
        const {data} = await axios.get(`http://localhost:8080/api/restaurants/${username}`);
        return data;
}
export async function fetchOrdersByRestaurantCode(restaurantCode) {
        const {data} = await axios.get(`http://localhost:8080/api/orders/${restaurantCode}`);
        return data;
}
export async function orderDeleteByOrderCode(orderCode) {
        await axios.delete(`http://localhost:8080/api/orders/${orderCode}`);
}