package bookmanaging;

public class programming extends book {
    private String planguage;
    private String blogLink;

    public programming() {
    }

    public programming(String kindOfBook, int page, String NorO, String nameOfBook,String planguage,String blogLink){
        this.kindOfBook = kindOfBook;
        this.page = page;
        this.nameOfBook = nameOfBook;
        this.NorO = NorO;
        this.planguage = planguage;
        this.blogLink = blogLink;
    }

    public void setProgramming(String kindOfBook, int page, String NorO, String nameOfBook,String planguage,String blogLink){
        this.kindOfBook = kindOfBook;
        this.page = page;
        this.nameOfBook = nameOfBook;
        this.NorO = NorO;
        this.planguage = planguage;
        this.blogLink = blogLink;
    }

    @Override
    public void printM() {
        System.out.println("书名：" + nameOfBook + " 分类：" + kindOfBook + " 页数：" + page + " 状态：" + NorO);
        System.out.println("编程语言：" + planguage + " 博客链接：" + blogLink);

    }


}
