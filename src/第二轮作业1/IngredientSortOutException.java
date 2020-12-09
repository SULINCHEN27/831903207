package 第二轮作业1;
	//自定义异常
public class IngredientSortOutException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	boolean isSearch;
	public IngredientSortOutException() {
		super();
	}
	
	public IngredientSortOutException(String message){
		super(message);
	}
	//判断饮料是否售空
	public void find(boolean isSearch)throws IngredientSortOutException{
		if(isSearch==false) {
			System.out.println("已售空！");
		}
	}
}
