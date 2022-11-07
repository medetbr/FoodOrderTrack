import React from 'react';

function ErrorPage() {
    return (
        <div style={{height:"100vh"}}>
        <div style={{position:"absolute",top:"30%",left:"40%"}}>
            <div style={{fontSize:"60px"}}>Sayfa Bulunamadı</div>
            <h3>Page is not found | 404 Error </h3>
        </div></div>
    );
}

export default ErrorPage;