package com.code.questionnaireSystem.pojo;

import lombok.Data;

@Data
public class User {
    private Integer user_id;

    private String user_name;

    private String user_password;

    private String user_phone;

    private String user_email;

    private Integer role_id;

    public User(Integer user_id, String user_name, String user_password, String user_phone, String user_email, Integer role_id) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_phone = user_phone;
        this.user_email = user_email;
        this.role_id = role_id;
    }
}
