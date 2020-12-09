public class User {

    private String username;
    private String password;


    public User (String username, String password){
        this.username = username;
        this.password = password;
    }

    public boolean canLogin (String username2 , String password2){
        return username2.equals(username) && password2.equals(password);
    }

    public void setPassword (String newPassword){
        password = newPassword;
    }

    public void setUsername (String newUsername){
        username = newUsername;
    }

}
