
import styles from "./OrderOfRestaurant.module.css";
function OrderOfRestaurant({order}) {
    console.log(order);
    return(
        <div className="order-wrapper">
        <div className="order">
            <div className="mx-3">
                <div className="row">
                    <div className="col-4">
                        <div className="order-image-wrapper">
                            <img src="assets/pizza.jpg" />
                        </div>
                    </div>

                    <div className="col-3">
                        <div className="user-of-order ">
                        <b>Kullanıcı: </b> <span>{order?.user.name+" "+order?.user.surname}</span>
                        </div>
                        <div className="order-address">
                            <b>Adres: </b><p>{order?.address} </p>
                        </div>
                        <div className="order-description">
                            <b>Açıklama: </b><p>{order?.description}</p>
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
                                         {order?.foodItems.map(item =>  
                                        <tr>
                                            <td>{item.menuItem.name}</td>
                                            <td>{item.quantity}</td>
                                            <td>₺{item.menuItem.price}</td>
                                            <td style={{ fontWeight: "bold" }}>₺{item.menuItem.price*item.quantity}</td>
                                        </tr>
                                     )} 
                                    </tbody>
                                </table>
                            </div>

                        </div>
                        <div className="order-bill-bottom mt-3 align-items-center d-flex justify-content-between">
                            <div className="order-bill-total ">
                                <i className="fa-solid fa-wallet"></i> Toplam ₺{order?.total}
                            </div>
                            <div >
                              <button  className={`btn mr-2 ${styles.order_cancel_btn}`}>Reddet</button>
                              <button  className={`btn ${styles.order_approv_btn}`}>Onayla</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    )
}
export default OrderOfRestaurant;