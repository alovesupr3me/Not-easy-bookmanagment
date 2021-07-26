package bookmanaging;

import java.util.ArrayList;
import java.util.HashMap;

public class shelfSystem {
    public ArrayList<bookShelf> shelfAll;
    public HashMap<String,book> SQL;//后台
    {  ArrayList<bookShelf> All = new ArrayList<>();
        this.shelfAll = All;
        HashMap<String,book> SQL = new HashMap<>();
        this.SQL = SQL;
    }

    public shelfSystem() {
    }

    //便于测试，本不应存在
    public void addToSQL(String pos, book b){
        this.SQL.put(pos, b);
    }

    public shelfSystem(ArrayList<bookShelf> shelfAll) {

        this.shelfAll = shelfAll;
    }
    public void addShelf(bookShelf shelf){

        shelfAll.add(shelf);
    }
}
