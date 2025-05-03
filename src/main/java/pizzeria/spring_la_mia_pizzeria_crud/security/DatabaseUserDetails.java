package pizzeria.spring_la_mia_pizzeria_crud.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pizzeria.spring_la_mia_pizzeria_crud.model.Role;
import pizzeria.spring_la_mia_pizzeria_crud.model.User;

public class DatabaseUserDetails implements UserDetails {

    private final Long id;
    private final String nome;
    private final String cognome;
    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorities;
    private final Long shopId;

    public DatabaseUserDetails(User user) {
        this.shopId = user.getShop().getId();
        this.id = user.getId();
        this.nome = user.getNome();
        this.username = user.getUsername();
        this.cognome = user.getCognome();
        this.password = user.getPassword();
        this.authorities = new ArrayList<>();
        for (Role ruolo : user.getRoles()) {
            this.authorities.add(new SimpleGrantedAuthority(ruolo.getName()));
        }

    }
    

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    
    public Long getShopId() {
        return shopId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }



}
