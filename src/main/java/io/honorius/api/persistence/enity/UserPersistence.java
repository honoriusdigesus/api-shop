package io.honorius.api.persistence.enity;

import java.math.BigInteger;


public class UserPersistence {

    private Integer id;
    private BigInteger cc;
    private String name;
    private String lastname;

    public UserPersistence() {
    }

    public UserPersistence(BigInteger cc, String name, String lastname) {
        this.cc = cc;
        this.name = name;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getCc() {
        return cc;
    }

    public void setCc(BigInteger cc) {
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "UserDomain{" +
                "id=" + id +
                ", cc=" + cc +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
