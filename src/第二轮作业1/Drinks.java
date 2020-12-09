package 第二轮作业1;

import java.time.LocalDate;
import java.time.Month;

	//饮料类（抽象）
abstract class Drinks {
	protected String name;//饮料名
	protected double cost;//价格
	protected LocalDate startDate;//生产日期
	protected int shelfLife;//保质日期
	
	
		//构造器
	public Drinks(){
		this.name="";
		this.cost=0.0;
		this.startDate=LocalDate.of(2020, Month.DECEMBER, 5);
		this.shelfLife=0;
	}
	
	public Drinks(String name,double cost,LocalDate startDate){
		this.name=name;
		this.cost=cost;
		this.startDate=startDate;
		
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCost(double cost) {
		this.cost=cost;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate=startDate;
	}
	
	public LocalDate getStartDate() {
		return this.startDate;
	}
	
	public void setShelfLife(int shelfLife) {
		this.shelfLife=shelfLife;
	}
	
	public int getShelfLife() {
		return this.shelfLife;
	}
	
	//构造方法判断是否过期
	public boolean isLate(LocalDate startDate) {
		LocalDate date = LocalDate.now().minusDays(shelfLife);
		boolean isLate = startDate.isAfter(date);
		return isLate;
		
	}
	
	//抽象toString 方法
	public abstract String toString();

	protected abstract void FriedChickenRestaurant();

	
	
	
}
	
   
   
   


