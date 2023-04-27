/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekAkhir;

/**
 *
 * @author ASUS
 */
public abstract class Akun {
    protected String username;
    protected String password;
    
    public Akun(String User,String Pass){
        this.username = User;
        this.password = Pass;
    }

    public abstract String getUsername();
    public abstract void setUsername(String username);
    public abstract String getPassword();
    public abstract void setPassword(String password);
}
