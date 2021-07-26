package bookmanaging;

public class comic extends book {
  private String author;
  private String intro;

  public comic() {
   }

   public comic(String kindOfBook, int page, String NorO, String nameOfBook, String author,String intro) {
       this.kindOfBook = kindOfBook;
       this.page = page;
       this.NorO = NorO;
       this.nameOfBook = nameOfBook;
       this.author = author;
       this.intro = intro;
   }
    public void setComic(String kindOfBook, int page, String NorO, String nameOfBook, String author, String intro) {
        this.kindOfBook = kindOfBook;
        this.page = page;
        this.NorO = NorO;
        this.nameOfBook = nameOfBook;
        this.author = author;
        this.intro = intro;
    }
    @Override
   public void printM() {
       System.out.println("书名："+nameOfBook+" 分类："+kindOfBook+" 页数："+page+" 状态："+NorO);
       System.out.println("作者："+author+" 简介："+intro);

   }

}
