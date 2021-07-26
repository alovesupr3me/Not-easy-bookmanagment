package operate;

import java.util.HashMap;
import java.util.Scanner;
import bookmanaging.*;
public class menu {
    HashMap<String,user> UMap;//=======================
    HashMap<String,manager> MMap;//====================
    private boolean isContinue;
    {
        HashMap<String,user> UMap = new HashMap<>();
        HashMap<String,manager> MMap = new HashMap<>();
        this.UMap = UMap;
        this.MMap = MMap;
        isContinue = true;
    }
    public menu() {
    }

    public HashMap<String, user> getUMap() {
        return UMap;
    }

    public HashMap<String, manager> getMMap() {
        return MMap;
    }

    public manager register_manager(HashMap<String,manager> map) {//==================================
        System.out.println("*注册界面-管理员*");
        manager m = new manager();
        m.register();
        if (map.containsKey(m.getID())) {
            System.out.println("重复的ID！请重新输入注册命令");
            return null;
        }
       else{
           map.put(m.getID(),m);
           System.out.println("-注册完成-");
        return m;
       }
    }//*****************************************************

    public boolean isContinue() {
        return isContinue;
    }

    public void Change_isContinue() {
         this.isContinue = false;
    }

    public user register_user(HashMap<String,user> map) {
        System.out.println("*注册界面-用户*");
        user u = new user();
        u.register();
        if (map.containsKey(u.getID())) {
            System.out.println("重复的ID！请重新输入注册命令");
            return null;
        }
        else{   map.put(u.getID(),u);
            System.out.println("-注册完成-");
        return u;
        }

    }


    public manager M_login(HashMap<String,manager> MMap) {
        Scanner sc = new Scanner(System.in);
        System.out.println("登录界面-管理员");
        System.out.print("ID：");
        String ID = sc.next();
        if(MMap.containsKey(ID)){
            return MMap.get(ID);
        }
        else {System.out.print("用户不存在！输入Y再次登录，其余任意键退出");
            String ss = sc.next();
            if(ss.equals("Y")){
                return M_login(MMap);
            }
            else{
                return null;
            }
        }

    }

    public user U_login(HashMap<String,user> UMap) {
        Scanner sc = new Scanner(System.in);
        System.out.println("登录界面-用户");
        System.out.print("ID：");
        String ID = sc.next();
        if(UMap.containsKey(ID)){
            return UMap.get(ID);
        }
        else {System.out.print("用户不存在！输入Y再次登录，其余任意键退出");
            String ss = sc.next();
            if(ss.equals("Y")){
                return U_login(UMap);
            }
            else{
                return null;
            }
        }
    }

    public void os_manager(manager m, shelfSystem sys , HashMap<String,user> check) {
        if (m != null && m.login_then_check()) {
            System.out.println("欢迎!");
            System.out.println("现有书架 0 1 2三个");
            Scanner sc = new Scanner(System.in);
            boolean cont = true;
            while (cont) {
                System.out.println("tap:1-图书上架与下架 2-管理书本信息 3-设置黑名单 4-查看库中书 5-查看图书馆的书 6-退出");
                int judge = sc.nextInt();
                switch (judge) {
                    case 1 :
                        System.out.println("tap:1-上架 2-下架");
                        int i1 = sc.nextInt();
                        if(i1 == 1){
                            System.out.print("输入上新书架号：");
                            int temp = sc.nextInt();
                            m.bookUP(sys.shelfAll.get(temp).shelf, sys.SQL );
                        }
                        else if(i1 == 2){
                            System.out.print("输入下架书架号：");
                            int temp = sc.nextInt();
                            m.bookDOWN(sys.shelfAll.get(temp).shelf);
                        }
                        else{
                            System.out.println("ERROR");
                        };
                        break;

                    case 2 :
                        System.out.println("tap:1-在库中创建书 2-在库中删除书 3-修改库中书本的基本信息");
                        int i2 = sc.nextInt();
                        if(i2 == 1){
                            m.setBookInSQL(sys.SQL);
                        }
                        else if(i2 == 2){
                            m.deleteInSQL(sys.SQL);
                        }
                        else if(i2 == 3){
                            m.changeM(sys.SQL);
                        }
                        else{
                            System.out.println("ERROR");
                        };
                        break;

                    case 3 :
                        System.out.println("*黑名单*");
                        System.out.print("请输入想拉黑的ID：");
                        String ID = sc.next();
                        if(UMap.containsKey(ID)){
                            UMap.get(ID).setBlack();
                            System.out.println("已拉黑");
                        }
                        else{
                            System.out.println("用户不存在！");
                        }
                        break;
                    case 4 :for(String pos : sys.SQL.keySet()) {
                        System.out.println("pos："+pos);
                        sys.SQL.get(pos).printM();
                    }
                        break;
                    case 5 :
                        System.out.println("tap:1-查看所有的书 2-查看某一类 3-查看某一书架");
                        int i3 = sc.nextInt();
                        if(i3 == 1){
                            m.showAllBooks(sys);
                        }
                        else if(i3 == 2){
                            m.showAKind(sys);
                        }
                        else if(i3 == 3){
                            m.showANum(sys);
                        }
                        else{
                            System.out.println("ERROR");
                        };
                        break;
                    case 6 : cont = false;
                        System.out.println("管理员 "+m.getID()+" 退出。。。");
                        break;
                }
            }
        }
        else if(m != null){
            System.out.println("密码错误！");
                }

    }


    public void os_user(user u,shelfSystem sys){
        if (u !=null && u.login_then_check() && u.isCanvisit()) {
            System.out.println("欢迎!!记得关注书本的“流动序号”");
            System.out.println("现有书架 0 1 2三个");
            Scanner sc = new Scanner(System.in);
            boolean cont = true;
            while(cont){
            System.out.println("tap:1-借书 2-还书 3-查看自己的书 4-查看图书馆的书 5-退出");
            int judge = sc.nextInt();
            switch(judge){
                case 1 :
                    System.out.println("输入借书书架号：");
                    int num1 = sc.nextInt();
                          u.borrowFrom(sys.shelfAll.get(num1).shelf);
                          break;
                case 2 :
                    System.out.println("输入归还书架号：");
                    int num2 = sc.nextInt();
                    u.returnTo(sys.shelfAll.get(num2).shelf);
                    break;
                case 3 :
                    System.out.println("tap:1-查看自己所有的书 2-查看某一类");
                    int i1 = sc.nextInt();
                    if(i1 == 1){
                        u.showMyBooks(u.myList);
                    }
                    else if(i1 == 2){
                        u.showMyKind(u.myList);
                    }
                    else{
                        System.out.println("ERROR");
                    };
                    break;
                case 4 :
                    System.out.println("tap:1-查看所有的书 2-查看某一类 3-查看某一书架");
                    int i2 = sc.nextInt();
                    if(i2 == 1){
                        u.showAllBooks(sys);
                    }
                    else if(i2 == 2){
                        u.showAKind(sys);
                    }
                    else if(i2 == 3){
                        u.showANum(sys);
                    }
                    else{
                        System.out.println("ERROR");
                    };
                    break;
                case 5 :
                    cont = false;
                    System.out.println("用户 "+u.getID()+" 退出。。。");
            }
        }
        }
        else if(u !=null && !u.isCanvisit()){
            System.out.println("您已经被列入黑名单！");
        }
        else if(u != null){
            System.out.println("密码错误！");
        }
    }



}
