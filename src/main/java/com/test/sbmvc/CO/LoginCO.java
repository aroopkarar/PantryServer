package com.test.sbmvc.CO;

import com.test.sbmvc.Enums.LoginType;

public class LoginCO {
    private String username;
    private String password;
    private LoginType loginType;
    private String token;
    private boolean isFirstTimeLogedIn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isFirstTimeLogedIn() {
        return isFirstTimeLogedIn;
    }

    public void setFirstTimeLogedIn(boolean firstTimeLogedIn) {
        isFirstTimeLogedIn = firstTimeLogedIn;
    }

    public void validate() {
        if (username == null || username.equals("")) {
            //throw new ApiGenericException(CustomExceptionEnum.INVALID_CREDENTIAL);
        } else if (password == null || password.equals("")) {
            //throw new ApiGenericException(CustomExceptionEnum.INVALID_CREDENTIAL);
        }
    }
}
