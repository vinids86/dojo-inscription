package br.com.infracommerce.inscription;

import org.springframework.data.annotation.Id;

/**
 * Created by ifc.vinicius.saraiva on 20/08/17.
 */
public class Inscription {

    @Id private String id;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
