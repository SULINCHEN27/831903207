package 第二轮作业1;

import java.time.LocalDate;

	//果汁类继承饮料类
	class Juice extends Drinks {
		protected int shelfLife=2;//保质期
	
	   //构造器
		public Juice() {
		
		}
		public Juice(String name,double cost,LocalDate startDate) {
			super(name,cost,startDate);
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
		
		//重写toString 方法
		@Override
		public String toString() {
			String m = "\n*******这是果汁*********"+"\n名字： "+this.getName()+"\n价格："
					+this.getShelfLife()+"\n生产日期： "+this.getStartDate()
			   +"\n保质日期： "+this.shelfLife;
			return m;
		}
		
		@Override
		public void FriedChickenRestaurant() {
		}
		
	}