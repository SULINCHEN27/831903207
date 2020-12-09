package 第二轮作业1;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;


class West2FriedChickenRestaurant extends Person implements FriedChickenRestaurant{
	protected String Rname; 
	protected String Rsex;
	protected int Rage;
	protected boolean isSearch;
	
	//管理员构造方法
	public West2FriedChickenRestaurant(String name, String sex, int age) {
		super(name, sex, age);
		
	}
	//餐厅账目余额
	protected double balance=100.0;
	
	/*
	 为什么使用LinkedList:LinkedList更加灵活，并且部分方法的效率更高
	此题数据频繁出入，顾要求操作要足够灵活
	 */
	
	LinkedList <Beer> beerList = new LinkedList<Beer>();//啤酒列表
	LinkedList<Juice> juiceList = new LinkedList<Juice>();//果汁列表
	static LinkedList<SetMeal> mealList;//套餐列表
	Scanner sc = new Scanner(System.in);
	
	//对套餐列表进行初始化	
	static{ 
		mealList = new LinkedList<SetMeal>();
		
		}
		
	public void use(Beer beer,SetMeal newSetMeal) {
		IngredientSortOutException isFind = new IngredientSortOutException();
		
		//捕获异常
		try {
			isSearch = false;
		for(int i = 0; i < beerList.size(); i++) {
			
			Beer beer1 = beerList.get(i);
			if(beer.name.equals(beer1.name)) {
				//如果啤酒存在，则查找值设为true。
				isSearch=true;
				
				newSetMeal.beverages=beerList.get(i);
				//删除对应列表
				beerList.remove(i);
				System.out.println("啤酒已从库存调出！"+newSetMeal.toString());
				System.out.println("*******这是一条分界线*********");
				break;
			}
		}
		isFind.find(isSearch);
		}catch(IngredientSortOutException e) {
			System.out.println(e.getMessage());
		}
	}
	//重载use方法
	public void use(Juice juice,SetMeal newSetMeal) {
		IngredientSortOutException isFind = new IngredientSortOutException();
		//捕获异常
		try {
			isSearch = false;
		for(int i = 0; i < juiceList.size(); i++) {
			Juice juice1 = juiceList.get(i);
			if(juice.name.equals(juice1.name)) {
				//如果果汁存在，则查找值设为true。
				isSearch=true;
				newSetMeal.beverages=juiceList.get(i);
				System.out.println("果汁已从库存调出！"+newSetMeal.toString());
				System.out.println("*******这是一条分界线*********");
				//删除该果汁列表
				juiceList.remove(i--);
				break;
			}
		}
		isFind.find(isSearch);
		}catch(IngredientSortOutException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void FriedChickenRestaurant(){
		//啤酒列表初始化
		Beer[] beer = new Beer[]{  
	            new Beer()
	    };
		for(int i=0;i<beer.length;i++) {
			beerList.add(beer[i]);
		}
		
		//果汁列表初始化
		
		Juice[] juice = new Juice[] {
				new Juice()
		};
		
		for(int i=0;i<juice.length;i++) {
			juiceList.add(juice[i]);
		}
		

		
		 System.out.println("1.出售套餐  2.批量进货 3.退出");
		int i = sc.nextInt();
		switch(i) {
		case 1:
			sell(mealList);//出售套餐
			break;
		case 2:
			purchase();//批量进货
			break;
		case 3:
			System.out.println("退出成功！");
			System.exit(0);
		default:
            System.out.println("输入错误，请重新输入！");
            break;
		}
	}

		//批量进货
		public void purchase() {
		System.out.print("请输入（啤酒/果汁）名称：");
		String bName = sc.next();
		System.out.print("请输入（啤酒/果汁）价格：");
		double bPrice = sc.nextDouble();
		//捕获异常OverdraftBalanceException
		OverdraftBalanceException check = new OverdraftBalanceException(); 
		
		try {
			balance=balance-bPrice;
			check.check(balance);
		}catch(OverdraftBalanceException e){
			System.out.println(e.getMessage()+", 进货差："+(0-balance));
			return;
		}
		System.out.print("请输入生产日期（'XXXX-XX-XX'）：");
		String date = sc.next();
		LocalDate bDate;
		//捕获异常（日期格式不对）
		try {
			bDate = LocalDate.parse(date);
		}catch(Exception e) {
			System.out.println("输入格式错误！请重新输入");
			return;
		}
		
		
		System.out.print("是否有酒精度数？(true/false):");
		boolean p =sc.nextBoolean();
		Drinks drink;
		if(p==true) {
			System.out.print("请输入酒精度数：");
			float bPoof = sc.nextFloat();
			drink = new Beer(bName,bPrice,bDate,bPoof);
		}else {
			drink = new Juice(bName,bPrice,bDate);
		}
		//用instanceof来判断是啤酒还是果汁
		if(drink instanceof Beer) {
			
		
		if(drink.isLate(bDate)==false) {
			System.out.println("已过期，无法进货！");
			return;
		};
		beerList.add((Beer) drink);
		System.out.println("啤酒已进货成功！"+drink.toString());
		System.out.println("*******这是一条分界线*********");
	}
		if(drink instanceof Juice) {
			if(drink.isLate(bDate)==false) {
				System.out.println("已过期，无法进货！");
				return;
			};
			juiceList.add((Juice)drink);
			System.out.println("果汁已进货成功！"+drink.toString());	
			System.out.println("*******这是一条分界线*********");
		}
		}
	
		//出售套餐
	@Override
	public void sell(LinkedList<SetMeal> mealList) {
		System.out.println("请选择  \n 1.套餐一：招牌炸鸡（50.0元 ） "
								+ "\n 2. 套餐二：香辣炸鸡（45.0元）"
								+ "\n 3. 套餐三：酱香炸鸡（45.0元）"
								+ "\n Hint:请输入数字");
		
		int num = sc.nextInt();
		SetMeal newSetMeal = new SetMeal();
		switch(num) {
			case 1:
				newSetMeal.setSnName("套餐一");
				newSetMeal.setPrice(50.0);
				newSetMeal.setFried_chicken("招牌炸鸡");
				break;
			case 2:
				newSetMeal.setSnName("套餐二");
				newSetMeal.setPrice(45.0);
				newSetMeal.setFried_chicken("香辣炸鸡");
				break;
			case 3:
				newSetMeal.setSnName("套餐三");
				newSetMeal.setPrice(45.0);
				newSetMeal.setFried_chicken("酱香炸鸡");
				break;
			default:
	            System.out.println("输入错误，请重新输入！");
	            return;
		}
		
		System.out.println("请选择饮料 1.啤酒 2.果汁 ：");
		int count = sc.nextInt();
		switch(count) {
		case 1:
			System.out.print("请输入啤酒名称：");
			String wName = sc.next();
			
			Beer beer = new Beer();
			beer.name=wName;
			use(beer,newSetMeal);
			//添加套餐
			mealList.add(newSetMeal);
			break;
		case 2:
			System.out.print("请输入果汁名称：");
			String wName1 = sc.next();
			Juice juice = new Juice();
			juice.name=wName1;
			use(juice,newSetMeal);
			//添加套餐
			mealList.add(newSetMeal);
			break;
		default:
            System.out.println("输入错误，请重新输入！");
            break;
			
		
	}
		
	}

	

}
