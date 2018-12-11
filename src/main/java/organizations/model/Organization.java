package organizations.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Organization {


    private Integer id;
    private String name;
    private String info;
    private String address;
    private String telephone;
    private int countEmployees;

    public Organization() {
    }

    public Organization(Integer id, String name, String info, String address, String telephone, int countEmployees) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.address = address;
        this.telephone = telephone;
        this.countEmployees = countEmployees;
    }

    @Id @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getCountEmployees() {
        return countEmployees;
    }

    public void setCountEmployees(int countEmployees) {
        this.countEmployees = countEmployees;
    }
}
