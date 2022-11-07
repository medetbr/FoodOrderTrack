import { useState } from 'react';
import { loginApi } from '../../../api/auth';
import { Link } from "react-router-dom"
import './Login.css'
function Login() {  
    
    const [username,setUsername] = useState("");
    const [password,setPassword] = useState("");
    const [error,setError] = useState(null);
    
    const registerSubmitHandler = async(e)=>{
        e.preventDefault();
        const userObje = {username,password};
        try {
            await loginApi(userObje);
            window.location.reload();
        } catch (error) {
            setError(error.response.data.message)
        }
    }
    return (
        <>
            <div className='bg'></div>
            <div className="login-photo">
                <div className="image-holder"></div>
                <form style={{paddingTop:"15%"}} onSubmit={registerSubmitHandler}>
                    <h2 className="text-center"><strong> Giris </strong>yap. </h2>
                    {error&&<div className="login-error"> {error}</div>}
                    <div className="form-group"><input onChange={e => setUsername(e.target.value)} className="form-control" type="text" required name="username" placeholder="Kullanıcı adı" /></div>
                    <div className="form-group"><input onChange={e => setPassword(e.target.value)} className="form-control" type="password" required name="password" placeholder="Şifre" /></div>
                    
                    {/* <div className="form-group"><input className="form-control" type="password" name="password-repeat" placeholder="Password (repeat)"/></div> */}
                    {/* <div className="form-group">
                           <div className="form-check"><label className="form-check-label"><input className="form-check-input" type="checkbox"/>I agree to the license terms.</label></div> 
                      </div> */}
                    <div  className="form-group"><button className="btn btn-primary btn-block" type="submit">Giriş</button></div><Link to={"/register"} className="already">Bir hesaba sahip değil misin? <strong>Kaydol.</strong></Link></form>
            </div>
        </>
    );
}
export default Login;