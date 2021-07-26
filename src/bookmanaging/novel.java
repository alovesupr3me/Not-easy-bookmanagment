package bookmanaging;

public class novel extends book {
    private String author;
    private String intro;
    private String man1;
    private String woman1;

    public novel() {
    }

    public novel(String kindOfBook, int page, String NorO, String nameOfBook, String author, String intro, String man1, String woman1) {
        this.kindOfBook = kindOfBook;
        this.page = page;
        this.nameOfBook = nameOfBook;
        this.NorO = NorO;
        this.author = author;
        this.intro = intro;
        this.man1 = man1;
        this.woman1 = woman1;
    }

    public void setNovel(String kindOfBook, int page, String NorO, String nameOfBook, String author, String intro, String man1, String woman1) {
        this.kindOfBook = kindOfBook;
        this.page = page;
        this.nameOfBook = nameOfBook;
        this.NorO = NorO;
        this.author = author;
        this.intro = intro;
        this.man1 = man1;
        this.woman1 = woman1;
    }

    public void printM() {
        System.out.println("书名：" + nameOfBook + " 分类：" + kindOfBook + " 页数：" + page + " 状态：" + NorO);
        System.out.println("作者：" + author + " 男主：" + man1 + " 女主：" + woman1 + " 简介：" + intro);

    }
}
