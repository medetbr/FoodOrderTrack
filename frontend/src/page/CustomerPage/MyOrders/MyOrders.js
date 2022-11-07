import { useEffect, useState } from "react";
import { fetchOrdersByUsername } from "../../../api/auth";
import Order from "../../../component/Order/Order"

function MyOrders(){
    const [orders,setOrders]=useState([]);
    //const [user,setUser] = useState(null);

    useEffect(()=>{
        (async()=>{
            const user = JSON.parse(localStorage.getItem("userInfo"));
            //setUser(user);
            const res = await fetchOrdersByUsername(user?.username)
            setOrders(res)
        })()
    },[setOrders])
    return(
        <div className="content px-4">   
        <section>
        {orders?.map(order =>
            <Order order={order}/>
            )}
        </section>
       </div>
    )
}
export default MyOrders;