package bookmanaging;

import java.util.ArrayList;

public class bookShelf {
    private static int number=-1;//书架编号
    public ArrayList<book> shelf;

    {
        ArrayList<book> s = new ArrayList<>();
        this.shelf = s;
        number++;
    }

    public bookShelf() {
    }

    public bookShelf(int num,ArrayList<book> shelf) {
        this.number = num;
        this.shelf = shelf;
    }
}
