package bookmanaging;

public abstract class book {
    String kindOfBook;
    int page;
    String NorO;//新旧
    String nameOfBook;
    String pos;//在SQL中的位置,默认无改动它的操作
    public book() {
    }

    public abstract void printM();

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getPos() {
        return pos;
    }

    public String getKindOfBook() {
        return kindOfBook;
    }

    public void setKindOfBook(String kindOfBook) {
        this.kindOfBook = kindOfBook;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getNorO() {
        return NorO;
    }

    public void setNorO(String norO) {
        NorO = norO;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }
}

