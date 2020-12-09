package 第二轮作业1;
	//自定义异常
public class OverdraftBalanceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	double balance;
	public OverdraftBalanceException() {
		super();
	}
	
	public OverdraftBalanceException(String message){
		super(message);
	}
	//判断余额是否可以进货
	public void check(double balance) throws OverdraftBalanceException {
		if (balance < 0.0) { 
		   throw new OverdraftBalanceException("余额不足！"); 
		    }
		  }
		  

}
