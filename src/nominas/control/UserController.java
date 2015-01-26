package nominas.control;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import nominas.entity.User;
import nominas.util.Cipher;
import nominas.util.HibernateUtil;

public class UserController {
    public UserController(){
        
    }
    
    public boolean isValidUser(User guess) throws NoSuchAlgorithmException {
        //Se obtiene si existe el usuario con el username deseado
        User user = getUserById(guess.getUsername());
        if(user == null) return false;
        //Se cifra la contraseña ingresada
        Cipher cipher = new Cipher();
        String key = cipher.sha(guess.getPassword());
        //Se remplaza la contraseña plana por la cifrada
        guess.setPassword(key);
        //Se realiza la comparacion (username, password)
        return guess.equals(user);
    }
    
    public User getUserById(String username){
        String hql = "FROM User WHERE username='" + username + "'";
        List<User> result = HibernateUtil.executeHQLQuery(hql);
        if(result == null) return null;
        if(result.size() == 0) return null;
        return result.get(0);
    }
}
