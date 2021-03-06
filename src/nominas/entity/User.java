package nominas.entity;

import java.util.Objects;
public class User  implements java.io.Serializable {

     private String username;
     private String password;
     private int usertype;

    public User() {
    }

    public User(String username, String password, int usertype) {
       this.username = username;
       this.password = password;
       this.usertype = usertype;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public int getUsertype() {
        return this.usertype;
    }
    
    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + this.usertype;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
    
}


