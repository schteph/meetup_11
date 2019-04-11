package hr.pravila.presentation.old.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author stjep
 */
public class User {

    private Long id;

    private String name;
    
    private String identificationNumber;
    
  //of Address
    private List addresses = new LinkedList(); 
    
    public User() {
        super();
    }
    
    public User(Long id, String name, String identificationNumber, List addresses) {
        super();
        this.id = id;
        this.name = name;
        this.identificationNumber = identificationNumber;
        this.addresses = addresses;
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

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public List getAddresses() {
        return addresses;
    }

    public void setAddresses(List addresses) {
        this.addresses = addresses;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((identificationNumber == null) ? 0 : identificationNumber.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (identificationNumber == null) {
            if (other.identificationNumber != null)
                return false;
        } else if (!identificationNumber.equals(other.identificationNumber))
            return false;
        return true;
    }

    public String toString() {
        return "User [id=" + id + ", name=" + name + ", identificationNumber=" + identificationNumber + "]";
    }
}
