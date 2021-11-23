import java.util.*;
public class Library {

    static ArrayList<Books> list = new ArrayList<Books>();
    public static int count(){
        return list.size();
    }
    public static Books read(int index){
        return list.get(index);
    }


}
