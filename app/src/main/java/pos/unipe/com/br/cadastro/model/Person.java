package pos.unipe.com.br.cadastro.model;

import java.io.Serializable;

public class Person implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String site;

    public Person(){
        this.name = new String();
        this.email = new String();
        this.phone = new String();
        this.address = new String();
        this.site = new String();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
