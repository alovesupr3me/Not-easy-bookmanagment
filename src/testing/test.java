package testing;

import bookmanaging.*;
import com.sun.java_cup.internal.runtime.Symbol;
import operate.*;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        shelfSystem lib = new shelfSystem();

        bookShelf sll0= new bookShelf();
        bookShelf sll1= new bookShelf();
        bookShelf sll2= new bookShelf();
        lib.addShelf(sll0);
        lib.addShelf(sll1);
        lib.addShelf(sll2);
      //建立3个书架，这里管理员不能创建书架

        comic b = new comic("漫画书",60,"新","新世纪福音战士","庵野秀明","真心为你");
        comic c = new comic("漫画书",50,"旧","海贼王","尾田荣一郎","海贼王，我当定了！");
        novel d = new novel("小说",350,"旧","百年孤独","加西亚·马尔克斯","过去都是假的","奥雷里亚诺","乌尔苏拉");
        programming e = new programming("编程书",600,"新","JAVA核心技术","JAVA","不知道");
        novel f = new novel("小说",150,"新","麦田里的守望者","约翰·F·塞林格","你要是在麦田抓到了我","霍尔顿","无");
        lib.addToSQL("15",b);
        lib.addToSQL("8",c);
        lib.addToSQL("66",d);
        lib.addToSQL("31",e);
        lib.addToSQL("2",f);
        //提前放入一些书

        //这里算是开始
        menu m = new menu();
        System.out.println("***欢迎进入图书管理系统***");
        System.out.println("输入“帮助”以获得帮助");
        Scanner sc = new Scanner(System.in);
        while(m.isContinue()) {
            System.out.print("请输入命令：");
            String a = sc.next();
            switch (a){
                case "帮助" :
                    System.out.println("-输入：注册 登录 退出 作为命令-");
                    break;
                case "注册" :
                    System.out.println("请选择身份");
                    System.out.println("tap:1-管理员 2-用户");
                    int zhu = sc.nextInt();
                   if(zhu == 1){
                       m.register_manager(m.getMMap());
                   }
                   else if(zhu == 2){
                       m.register_user(m.getUMap());
                   }
                   else{
                       System.out.println("这个是无效输入");
                   }
                    break;
                case "登录" :
                    System.out.println("请选择身份");
                    System.out.println("tap:1-管理员 2-用户");
                    int deng = sc.nextInt();
                   if(deng == 1){
                       m.os_manager(m.M_login(m.getMMap()), lib, m.getUMap());
                   }
                    else if(deng == 2) {
                       m.os_user(m.U_login(m.getUMap()), lib);
                   }
                   else{
                       System.out.println("这个是无效输入");
                   }
                    break;
                case "退出" :
                    System.out.println("噔噔噔噔噔噔");
                    System.out.println("再见！");
                    m.Change_isContinue();
                    break;
               }
            }

        }
        
    }

