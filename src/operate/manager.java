package operate;

import bookmanaging.*;

import java.util.*;


public class manager implements loading {
    private String ID;
    private String code;

    public String getID() {
        return ID;
    }

    @Override
    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("注册界面");
        System.out.print("注册ID：");
        String ID = sc.next();
        this.ID = ID;
        System.out.print("密码：");
        String code = sc.next();
        this.code = code;
    }

    @Override
    public boolean login_then_check() {
        Scanner sc = new Scanner(System.in);
        System.out.print("密码：");
        String code = sc.next();
        if (this.ID.equals(ID) && this.code.equals(code)) {
            return true;
        } else return false;
    }

    public void bookUP(ArrayList<book> shelf, HashMap<String, book> SQL) {//上到那个书架上
        Scanner sc = new Scanner(System.in);
        System.out.print("输入书的pos：");
        String pos = sc.next();
        shelf.add(SQL.get(pos));
    }

    public void bookDOWN(ArrayList<book> shelf) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入书名：");
        String s = sc.next();
        for (int j = 0; j < shelf.size(); j++) {
            if (shelf.get(j).getKindOfBook().equals(s)) {
                shelf.remove(shelf.get(j));
            }
        }
    }

    public void setBookInSQL(HashMap<String,book> SQL) {
        System.out.print("说明创建书的类型：");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(s.equals("漫画书")){
            System.out.print("输入key(pos)");
            String pos = sc.next();
            book b = new comic();
            b.setPos(pos);
            if(!SQL.containsKey(pos)){
            String kindOfBook = "漫画书";
            System.out.print("输入页数：");
            int page = sc.nextInt();
            System.out.print("输入新旧：");
            String NorO = sc.next();
            System.out.print("输入书名：");
            String nameOfBook = sc.next();
            System.out.print("输入作者：");
            String author = sc.next();
            System.out.print("输入简介：");
            String intro = sc.next();
            b = new comic(kindOfBook, page, NorO, nameOfBook, author, intro);
            SQL.put(pos,b);
            }
            else{
                System.out.println("位置已存在！");
            }
        }
        else if(s.equals("编程书")){
            System.out.print("输入key(pos)");
            String pos = sc.next();
            book b = new programming();
            b.setPos(pos);
            if(!SQL.containsKey(pos)){
            String kindOfBook = "编程书";
            System.out.print("输入页数：");
            int page = sc.nextInt();
            System.out.print("输入新旧：");
            String NorO = sc.next();
            System.out.print("输入书名：");
            String nameOfBook = sc.next();
            System.out.print("输入编程语言：");
            String planguage = sc.next();
            System.out.print("输入链接：");
            String blogLink = sc.next();
            b = new programming(kindOfBook, page, NorO, nameOfBook, planguage, blogLink);
            SQL.put(pos,b);
            }
            else{
                System.out.println("位置已存在！");
            }
        }
        else if(s.equals("小说")){
            System.out.print("输入key(pos)");
            String pos = sc.next();
            book b = new novel();
            b.setPos(pos);
            if(SQL.containsKey(pos)){
            String kindOfBook = "小说";
            System.out.print("输入页数：");
            int page = sc.nextInt();
            System.out.print("输入新旧：");
            String NorO = sc.next();
            System.out.print("输入书名：");
            String nameOfBook = sc.next();
            System.out.print("输入作者：");
            String author = sc.next();
            System.out.print("输入简介：");
            String intro = sc.next();
            System.out.print("输入男主：");
            String man1 = sc.next();
            System.out.print("输入女主：");
            String woman1 = sc.next();
            b = new novel(kindOfBook, page, NorO, nameOfBook, author, intro, man1, woman1);

            SQL.put(pos,b);}
            else{
                System.out.println("位置已存在！");
            }
            }
        else{
            System.out.println("再想一下");
        }
    }

    void deleteInSQL(HashMap<String,book> SQL){
             Scanner sc = new Scanner(System.in);
             System.out.print("输入key(pos)");
             String  pos = sc.next();
             SQL.remove(pos);
         }

    void changeM(HashMap<String,book> SQL) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入key(pos)");
        String  position = sc.next();
        if(SQL.containsKey(position)){
            System.out.println("这是一本"+SQL.get(position).getKindOfBook());
            System.out.print("输入页数：");
            int page = sc.nextInt();
            System.out.print("输入新旧：");
            String NorO = sc.next();
            System.out.print("输入书名：");
            String nameOfBook = sc.next();
            SQL.get(position).setPage(page);
            SQL.get(position).setNorO(NorO);
            SQL.get(position).setNameOfBook(nameOfBook);
        }
        else{
            System.out.println("再想一下");
        }

    }
    void showAllBooks(shelfSystem lib){
        for(int i = 0; i<lib.shelfAll.size();i++){
            if(lib.shelfAll.get(i).shelf.size() == 0){
                System.out.println("-书架"+i+"没有书-");
            }
            for (int j = 0;j<lib.shelfAll.get(i).shelf.size();j++){
                System.out.println("书架号"+i+" 流动序号"+j+" ");
                lib.shelfAll.get(i).shelf.get(j).printM();

            }
        }
    }
    void showAKind(shelfSystem lib){//待检==================
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入想查找的类型：");
        String ss = sc.next();
        for(int i = 0; i<lib.shelfAll.size();i++){
            for (int j = 0;j<lib.shelfAll.get(i).shelf.size();j++){
                if(lib.shelfAll.get(i).shelf.get(j).getKindOfBook().equals(ss) ){
                    System.out.print("书架号"+i+" 流动序号"+j+" ");
                    lib.shelfAll.get(i).shelf.get(j).printM();
                }
            }
        }
    }
    void showANum(shelfSystem lib){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入想查找的书架号：");
        int se = sc.nextInt();
        if(lib.shelfAll.get(se).shelf.size() == 0){
            System.out.println("-书架"+se+"没有书-");
        }
        for(int i = 0; i<lib.shelfAll.get(se).shelf.size();i++){
            lib.shelfAll.get(se).shelf.get(i).printM();
        }

    }

}
