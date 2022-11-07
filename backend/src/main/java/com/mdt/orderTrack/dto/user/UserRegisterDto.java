package com.mdt.orderTrack.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class UserRegisterDto {
    @Size(min = 3,message = "Ad en az 3 karakterden oluşmalıdır")
    private String name;
    @Size(min = 2,message = "Soyad en az 2 karakterden oluşmalıdır")
    private String surname;
    private String username;
    @Email
    private String email;
    private String password;
    private Boolean isCustomer;
}
