package com.example.springJwt.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String password;

    @Enumerated
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode( ) {
        return getClass().hashCode();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername( ) {
        return username;
    }

    @Override
    public Collection < ? extends GrantedAuthority > getAuthorities( ) {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired( ) {
        return true;
    }

    @Override
    public boolean isAccountNonLocked( ) {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired( ) {
        return true;
    }

    @Override
    public boolean isEnabled( ) {
        return true;
    }
}
