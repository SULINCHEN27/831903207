package 第二轮作业1;

import java.time.LocalDate;

	//啤酒类继承饮料类
class Beer extends Drinks {
	protected float proof;//酒精度数
	protected int shelfLife=30;//保质期
	
	//构造器
	public Beer() {
		this.proof=0.0f;
		
	}

	public Beer(String name,double cost,LocalDate startDate,float proof) {
		super(name,cost,startDate);
		this.setProof(proof);
	}
	
	public float getProof() {
		return proof;
	}
	public void setProof(float proof) {
		this.proof = proof;
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
		String m = "\n*******这是啤酒*********"
				+"\n名字："+this.getName()+"\n价格： "+this.getShelfLife()
				+"\n生产日期： "+this.getStartDate()
				   +"\n保质日期： "+this.shelfLife+"\n酒精度数："+this.getProof();
		return m;
	}
	
	@Override
	public void FriedChickenRestaurant() {
	}
}