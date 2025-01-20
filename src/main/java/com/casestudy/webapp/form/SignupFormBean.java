package com.casestudy.webapp.form;

import com.casestudy.webapp.validation.EmailUnique;
import com.casestudy.webapp.validation.UsernameUnique;
import com.casestudy.webapp.validation.TwoFieldsAreEqual;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@TwoFieldsAreEqual(fieldOneName = "confirmPassword", fieldTwoName = "password", message = "Password and Conform Password must be the same.")
public class SignupFormBean {

    @UsernameUnique(message = "Username already exists.")

    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty(message = "Password is required")
    private String password;
}
