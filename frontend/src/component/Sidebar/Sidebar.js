import { Link } from "react-router-dom";

function Sidebar() {
  const userInfo = localStorage.getItem("userInfo")?JSON.parse(localStorage.getItem("userInfo")):null
  const exitHandler = ()=>{
    localStorage.clear();
  }

  return (
    < >    
         <div className="sidebar">
          <div className="p-4">
            <div className="profile">
              <h3 style={{textTransform:"capitalize"}}>{userInfo?.name+" "+userInfo?.surname}</h3>
              <span><b>Kullanıcı tipi:</b>{userInfo?.isCustomer?" Müşteri":" Restoran sahibi"}</span>
            </div>            
            <ul className="list-unstyled components mb-5">
              <li><Link to={"/"}><i className="fa-solid sidebar-list-icon fa-house"></i>Anasayfa</Link></li>
              {userInfo.isCustomer&&<li><Link to={"/"}><i className="fa-solid sidebar-list-icon fa-burger"></i>Restoranlar</Link></li>}
              {userInfo.isCustomer&&<li><Link to={"/my-orders"}><i className="fa-solid sidebar-list-icon fa-bag-shopping"></i>Siparişlerim</Link></li>}
              <li><Link to={"/"}><i className="fa-solid sidebar-list-icon fa-gear"></i>Ayarlar</Link></li>
              <li><Link onClick={exitHandler} to={"/login"}><i className="fa-solid sidebar-list-icon fa-right-from-bracket"></i>Çıkış</Link></li>
            </ul>
          </div>
        </div>
    </>
  );
}

export default Sidebar;
