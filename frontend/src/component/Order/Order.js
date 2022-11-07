import { orderDeleteByOrderCode } from "../../api/auth";
import "./Order.css"
function Order({ order }) {
   const orderDeleteHandler = ()=>{
    orderDeleteByOrderCode(order.orderCode)
   }
    return (
        <div className="order-wrapper">
            <div className="order">
                <div className="container">
                    <div className="row">
                        <div className="col-4">
                            <div className="order-image-wrapper">
                                <img src="assets/pizza.jpg" />
                            </div>
                        </div>

                        <div className="col-3">
                            <div className="restaurant-name d-flex  justify-content-between">
                                <h5 style={{textTransform:"capitalize"}} >{order?.restaurant.name}</h5>
 
                            </div>
                            <div className="order-description">
                                <b>Not: </b><p>{order?.description} </p>
                            </div>
                            <div className="order-description">
                                <b>Adres: </b> <p>{order?.address} </p>
                            </div>
                        </div>
                        <div className="col-5 order-bill d-flex flex-column">
                            <div className="order-bill-top d-flex">
                                <div className="order-bill-foods">
                                    <table className="table ml-3">
                                        <thead>
                                            <th>Ad</th>
                                            <th>Miktar</th>
                                            <th>Adet fiyatı</th>
                                            <th>Toplam fiyat</th></thead>
                                        <tbody>
                                            {order?.foodItems.map(item => <tr>
                                                <td>{item.menuItem.foodItem.name}</td>
                                                <td>{item.quantity}</td>
                                                <td>₺{item.menuItem.price}</td>
                                                <td style={{ fontWeight: "bold" }}>₺{item.menuItem.price * item.quantity}</td>
                                            </tr>)}
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                            <div className="order-bill-bottom mt-3 align-items-center d-flex justify-content-between">
                                <div className="order-bill-total ">
                                    <i className="fa-solid fa-wallet"></i> Toplam ₺{order?.total}
                                </div>
                                <button onClick={orderDeleteHandler} className="btn order-cancel-btn">İptal et</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    )
}
export default Order;