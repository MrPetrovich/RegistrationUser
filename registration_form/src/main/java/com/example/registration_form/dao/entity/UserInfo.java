package com.example.registration_form.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users_info")
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;

    private String login;

    private String password;

    private String email;

    @Column(name = "full_name")
    private String fullName;

}
