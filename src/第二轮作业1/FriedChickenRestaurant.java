package 第二轮作业1;

import java.util.LinkedList;
//炸鸡店接口
public interface FriedChickenRestaurant {
	void sell(LinkedList<SetMeal> mealList);//出售套餐
	void purchase();//批量进货
	
}
