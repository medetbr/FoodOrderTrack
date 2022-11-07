import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import ProtectedRoute from './ProtectedRoute';
import PublicRoute from './PublicRoute';
import CustomerRoute from './CustomerRoute';
import RestaurantOwnerRoute from './RestaurantOwnerRoute';
import * as pages from './page';
function App() {
  const userInfo = localStorage.getItem("userInfo")?JSON.parse(localStorage.getItem("userInfo")):null
  return (
    <Router>
      <Routes>
        <Route element={<ProtectedRoute/>}>
            <Route path="/" element={<pages.Home/>}>
              <Route path='/' element={!userInfo.isCustomer?<pages.RestaurantOwnerPage/>:<pages.Restaurants/>}/>
              <Route element={<RestaurantOwnerRoute/>}>
                
              </Route>
              <Route element={<CustomerRoute/>}>
                <Route path='/my-orders' element={<pages.MyOrders />} />
                <Route path='/:restaurantCode' element={<pages.RestaurantPage />} />
              </Route>
            </Route>
        </Route>
        <Route element={<PublicRoute/>}>
          <Route path='/login' element={<pages.Login/>} />
          <Route path='/register' element={<pages.Register/>} />
          </Route>
        <Route path='*' element={<pages.ErrorPage/>}/>
      </Routes>
    </Router>
  );
}

export default App;
