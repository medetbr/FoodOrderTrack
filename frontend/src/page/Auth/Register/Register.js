import { useState } from 'react';
import { registerApi } from '../../../api/auth';
import { Link } from "react-router-dom"
import { useNavigate } from "react-router-dom";
import './Register.css'
function Register() {
    const [name,setName] = useState("");
    const [surname,setSurname] = useState("");
    const [username,setUsername] = useState("");
    const [email,setEmail] = useState("");
    const [password,setPassword] = useState("");
    const [isCustomer,setCustomer] = useState(false);
    const [error,setError] = useState(null);
    const navigate = useNavigate();
    const registerSubmitHandler = async(e)=>{
        e.preventDefault();
        const userObje = {name,surname,username,email,password,isCustomer};
        try {
         await registerApi(userObje);
            navigate("/login")
        } catch (error) {
            error.response.data.status===500?setError(error.response.data.message): 
            setError(error.response.data.errors[0].defaultMessage);
           
        }
    }
    return (
        <>
            <div className='bg'></div>
            <div className="register-photo">
                {/* <div className="form-container"> */}
                <div className="image-holder"></div>
                <form onSubmit={registerSubmitHandler}>
                    <h2 className="text-center">Yeni bir<strong> hesap </strong>oluştur. </h2>
                    {<div className='register-error'>{error&&error}</div>}
                    <div className="form-group"><input onChange={e => setName(e.target.value)} className="form-control" type="text" required name="firstname" placeholder="Ad" /></div>
                    <div className="form-group"><input onChange={e => setSurname(e.target.value)} className="form-control" type="text" required name="surname" placeholder="Soyad" /></div>
                    <div className="form-group"><input onChange={e => setUsername(e.target.value)} className="form-control" type="text" required name="username" placeholder="Kullanıcı adı" /></div>
                    <div className="form-group"><input onChange={e => setEmail(e.target.value)} className="form-control" type="email" required name="email" placeholder="Email" /></div>
                    <div className="form-group"><input onChange={e => setPassword(e.target.value)} className="form-control" type="password" required name="password" placeholder="Şifre" /></div>
                    <div className="form-group">
                        <b>Kayıt Türü?</b>
                        <div className="form-radio">
                            <input onChange={e => setCustomer(true)} required className="form-check-radio" type="radio" name="user-type" />Müşteri
                        </div>
                        <div className="form-radio">
                            <input onChange={e => setCustomer(false)} required className="form-check-radio" type="radio" name="user-type" />Restoran Sahibi
                        </div>

                    </div>


                    {/* <div className="form-group"><input className="form-control" type="password" name="password-repeat" placeholder="Password (repeat)"/></div> */}
                    {/* <div className="form-group">
                           <div className="form-check"><label className="form-check-label"><input className="form-check-input" type="checkbox"/>I agree to the license terms.</label></div> 
                      </div> */}
                    <div  className="form-group"><button className="btn btn-primary btn-block" type="submit">Kaydol</button></div><Link to={"/login"} className="already">Zaten bir hesabınız var mı? <strong>Giriş yap.</strong></Link></form>
                {/* </div> */}
            </div>
        </>
    );
}
export default Register;