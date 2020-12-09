package 第二轮作业1;

class SetMeal{
		protected String setMealName;//套餐名
		protected double price;//价格
		protected String fried_chicken;//炸鸡名
		protected Drinks beverages;//饮料类
		
		//构造器
		public SetMeal() {
			this.setMealName="";
			this.price=0.0;
			this.fried_chicken="";
			this.beverages=null;
		}
		
		public SetMeal(String setMealName,double price,String fried_chicken,Drinks beverages) {
			this.setMealName=setMealName;
			this.price=price;
			this.fried_chicken=fried_chicken;
			this.beverages=beverages;
		}
		
		public void setBeverages(Drinks drinks) {
			this.beverages=drinks;
			System.out.println(beverages);
		}
		
		
		public Drinks getBeverages() {
			return this.beverages;
		}
		
		public String getSetMealName() {
			return setMealName;
		}

		public void setSnName(String setMealName) {
			this.setMealName = setMealName;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getFried_chicken() {
			return fried_chicken;
		}

		public void setFried_chicken(String fried_chicken) {
			this.fried_chicken = fried_chicken;
		}
		
		//重写toString 方法
		public String toString() {
			String m = "\n*******这是套餐*********"+"\n套餐名: "+this.getSetMealName()
						+"\n价格: "+this.getPrice()+
						"\n炸鸡名: "+this.getFried_chicken()+"\n饮料名："+this.beverages.name;
			return m;
		}
		
		public void FriedChickenRestaurant() {
		}
	}
