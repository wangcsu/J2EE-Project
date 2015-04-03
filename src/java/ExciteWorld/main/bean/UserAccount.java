
package ExciteWorld.main.bean;

import java.beans.*;
import java.io.Serializable;

public class UserAccount implements Serializable {
    
    private String Firstname;
    private String Lastname;
    private String Email;
    private String Username;
    private String Password;
    private String Month;
    private String Date;
    private String Year;

    public UserAccount(){
        Firstname = " ";
        Lastname = " ";
        Email = " ";
        Username = " ";
        Password = " ";
        Month = " ";
        Date = "";
        Year = "";
    }
    public UserAccount(String firstName, String lastName, 
            String Email, String userName, String passWord, String month, String date, String year) {
        this.Firstname = firstName;
        this.Lastname = lastName;
        this.Email = Email;
        this.Username = userName;
        this.Password = passWord;
        this.Month = month;
        this.Date = date;
        this.Year = year;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }
    
    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public void setBDay(String month, String date, String year){
        this.Month = month;
        this.Date = date;
        this.Year = year;
    }
    
    public String getBDay() {
        return Month + "-" + Date + "-" + Year;
    }
    
    public String getMonth() {
        return Month;
    }
    
    public String getDate() {
        return Date;
    }
    
    public String getYear() {
        return Year;
    }

}
