import java.io.Serializable;
import java.util.ArrayList;

public class Admin extends User implements Serializable {

    public Admin(String username, String password) {
        super(username, password);

    }

    public boolean addFood (String foodName){
        if (UniSystem.getFoods().size() == 7)
            return false;
        UniSystem.getFoods().add(foodName);
        return true;
    }

    public void resetFoods (){
        UniSystem.getFoods().clear();
    }

    public void addStudent (){

    }

    public boolean equals (Object o){
        return super.equals(o);
    }


}
