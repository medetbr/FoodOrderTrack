import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { fetchRestaurantItemsByRestaurantCode, postOrder } from "../../../api/auth";
import "./RestaurantPage.css"
function RestaurantPage() {
  const [restaurant, setRestaurant] = useState(null);
  const [menuItems, setMenuItems] = useState(null);
  const [bill, setBill] = useState(null);
  const [address, setAddress] = useState(null);
  const [description, setDescription] = useState(null);
  const [user,setUser] = useState(null);
  let { restaurantCode } = useParams();
    useEffect(()=>{
      const user = JSON.parse(localStorage.getItem("userInfo"));
      setUser(user);
    },[setUser])
  useEffect(() => {
    (async () => {
      const res = await fetchRestaurantItemsByRestaurantCode(restaurantCode);
      setRestaurant(res);
      setMenuItems(res.foods[Object.keys(res?.foods).reverse()[0]])
    })()
  }, [setRestaurant])
  const changeItems = (category) => {
    setMenuItems(restaurant?.foods[category]);
  }
  const addToBill = (menuItem) => {
    if (bill) {
      let isHaveMenuItem = bill.find(billItem => billItem.name === menuItem.name)
      if (isHaveMenuItem) {
        let billList = bill.filter(billItem => billItem.name !== isHaveMenuItem.name);
        isHaveMenuItem.quantity++;
        isHaveMenuItem.totalPrice = isHaveMenuItem.price * isHaveMenuItem.quantity;
        setBill([...billList, isHaveMenuItem])
      }
      else setBill([...bill, { menuItemCode: menuItem.menuItemCode, name: menuItem.name, quantity: 1, price: menuItem.price, totalPrice: menuItem.price }])
    }
    else setBill([{ menuItemCode: menuItem.menuItemCode, name: menuItem.name, quantity: 1, price: menuItem.price, totalPrice: menuItem.price }])

  }
  const orderBtnHanlder = () => {
    postOrder({ username:user.username, menuItems: bill, restaurantCode, address, description});
  }
  return (
    <div className="content  px-4">
      <div className="restaurant-page-wrapper">
        <div className="restaurant-top row">
          <div className="restaurant-img col-6">
            <img src="assets/pizza.jpg" />
            <h3 className="restaurant-name">{restaurant?.restaurant.name}</h3>
            <p>{restaurant?.restaurant.address}</p>
            <p>{restaurant?.restaurant.description}</p>
          </div>
          <div className="order-bill col-6">
            <h3>Fatura</h3>
            <div className="bill-content">
              <div className="bill-table">
                <table className="table">
                  <th>Ad</th>
                  <th>Adet</th>
                  <th>Adet fiyat</th>
                  <th>Toplam tutar</th>
                  {bill?.map(billItem =>
                    <tr>
                      <td>{billItem.name}</td>
                      <td>{billItem.quantity}</td>
                      <td>₺{billItem.price}</td>
                      <td style={{ fontWeight: "600", color: "#ff6000" }}>₺{billItem.totalPrice}</td>
                    </tr>
                  )}
                </table>
              </div>
              
              <div className="order-addres-and-desc">
              Adres <div>
                <textarea onChange={(e)=>setAddress(e.target.value)}></textarea>
              </div>
              Not <div>
                <textarea onChange={(e)=>setDescription(e.target.value)}></textarea>
              </div>
              </div>
              <div className="d-flex my-3 justify-content-between bill-bottom">
                <div>Toplam <span style={{ paddingLeft: "5px", color: "#ff6000" }}>₺{bill ? bill.reduce((pre, cur) => pre + cur.totalPrice, 0) : 0}</span></div>
                <button onClick={orderBtnHanlder} className="order-btn">Siparişi ver</button>
              </div>
            </div>
          </div>
        </div>
        <div className="categories px-4 row">
          {restaurant && Object.keys(restaurant?.foods).reverse().map(category => <button onClick={() => changeItems(category)} className="category-btn btn col-2">{category}</button>)}
        </div>
        <div className="restaurant-menu-item row">
          {menuItems?.map(menuItem =>
            <div className="col-2 p-0 menu-item">
              <div className="d-flex title-and-price justify-content-between">
                <span className="title">{menuItem.name}</span>
                <span className="price">₺{menuItem.price}</span>
              </div>
              <button onClick={() => addToBill(menuItem)} className="add-food-btn">Ekle</button>
            </div>)}
        </div>
      </div>
    </div>
  )
}
export default RestaurantPage;