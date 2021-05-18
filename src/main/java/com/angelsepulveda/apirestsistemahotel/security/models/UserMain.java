package com.angelsepulveda.apirestsistemahotel.security.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserMain implements UserDetails {

    private String name;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String email;
    private String password;
    private Boolean state;
    private Collection<? extends GrantedAuthority> authorities;

    public UserMain(String name, String lastName, String phoneNumber, String address, String email, String password,
                    Boolean state, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.password = password;
        this.state = state;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getState() {
        return state;
    }

    public static UserMain build(User user){
        /*
              obtenemos los roles del usuario
         */
        List<GrantedAuthority> authorities =
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role
                        .getRoleName().name())).collect(Collectors.toList());

        return new UserMain(user.getName(),user.getLastName(),user.getPhoneNumber(),user.getAddress(),
                user.getEmail(),user.getPassoword(),user.getState(),authorities);
    }
}
