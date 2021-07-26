package operate;

import bookmanaging.*;

import java.util.*;

public class user implements loading {
    public ArrayList<book> myList;
    private String ID;
    private String code;
    private boolean canvisit;
    {
        ArrayList<book> b = new ArrayList<>();
        this.myList = b ;
    }
    public void setMyList(ArrayList<book> myList) {//=========================
        this.myList = myList;
    }

    public String getID() {
        return ID;
    }

    public boolean isCanvisit() {
        return canvisit;
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
        this.canvisit = true;
    }

    @Override
    public boolean login_then_check() {
        Scanner sc = new Scanner(System.in);
        System.out.print("密码：");
        String code = sc.next();
       if(this.ID.equals(ID) && this.code.equals(code)){
           return true;
       }
        else return false;
    }


    void showMyBooks(ArrayList<book> myList){
        if(myList.size() == 0){
            System.out.println("-你的书单内没有书-");
        }
        for(int i = 0; i<myList.size();i++){
            System.out.print("流动序号"+i+" ");
            myList.get(i).printM();

            }

    }
    void showMyKind(ArrayList<book> myList){//待检==================
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入想查找的类型：");
        String ss = sc.next();
        for(int i = 0; i<myList.size();i++){
                if(myList.get(i).getKindOfBook().equals(ss) ){
                    System.out.print("流动序号"+i+" ");
                    myList.get(i).printM();
                }
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

    void borrowFrom( ArrayList<book> shelf){
        if(canvisit) {
            Scanner sc = new Scanner(System.in);
            System.out.print("输入目标书架上书的流动序号:");
            int index = sc.nextInt();
            myList.add(shelf.get(index));
            shelf.remove(index);
        }
        else System.out.println("已被列入黑名单");//已经不必要
    }

    void returnTo(ArrayList<book> shelf){
        Scanner sc = new Scanner(System.in);
        System.out.print("输入自己的书单中，想归还的书的流动序号:");
        int index = sc.nextInt();
        shelf.add(myList.get(index));
        myList.remove(index);
        }



    void setBlack(){
        this.canvisit = false;
        myList.clear();
    }
}
