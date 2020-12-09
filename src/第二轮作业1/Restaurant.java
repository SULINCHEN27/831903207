package 第二轮作业1;

import java.util.Scanner;

public class Restaurant {

	Scanner sc = new Scanner(System.in);
	
	public void login() {
		
		int count=0;
		while(count<1) {
			System.out.println("********炸鸡店管理系统********");
			System.out.println("1.登录系统   2.退出系统");
			
			int n=sc.nextInt();//选项
			
			switch(n) {
			case 1:
				System.out.print("请输入管理员姓名：");
                 String Rname = sc.next();
                 System.out.print("请输入性别：");
                 String Rsex = sc.next();
                 System.out.print("请输入年龄：");
                 int Rage = sc.nextInt();
                 //构造管理员对象
                 Person p = new West2FriedChickenRestaurant(Rname,Rsex,Rage);
                 
                 System.out.println("\n登录成功！\n当前管理员："+"姓名：" + p.getName() 
                 + " "+"性别：" + p.getSex() + " "+"年龄" + p.getAge()
                 +"\n*******这是一条分界线*********");
                 while(true) {
				 p.FriedChickenRestaurant();
			      	 
                 }
			case 2:
				System.out.println("退出成功！");
				System.exit(0);
			default:
				System.out.println("输入错误，请重新输入！");
			}
		}
	
			
		}
				
	}

