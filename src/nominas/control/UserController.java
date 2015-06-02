package nominas.control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import nominas.entity.User;
import nominas.util.Cipher;
import nominas.util.HibernateUtil;

public class UserController {
    public UserController(){
        
    }
    
    public void updateUser(User usr) {
        usr.setPassword(this.toSHA1(usr.getPassword().getBytes()));
        HibernateUtil.updateObject(usr);
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
    
    private String toSHA1(byte[] convertme) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        }
        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        return byteArrayToHexString(md.digest(convertme));
    }
    
    private String byteArrayToHexString(byte[] b) {
        String result = "";
        for (int i=0; i < b.length; i++) {
          result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }
}
