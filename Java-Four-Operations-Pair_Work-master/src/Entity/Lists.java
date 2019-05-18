package Entity;

import java.util.LinkedList;


/*
 * 此类用于处理算式，批量得到算式和答案
 * */
public class Lists {
	
	/*
	 * 对expression和result的操作
	 * */
	private String expression;
	private String result;
	public static LinkedList<Object> addArr = new LinkedList<Object>();//整个式子
	public static LinkedList<String> expArr = new LinkedList<String>();//每个字符串
	public static LinkedList<String> resArr = new LinkedList<String>();//结果
	 
	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Lists(String expression, String result) {
		super();
		this.expression = expression;
		this.result = result;
	}

	public Lists() {

	}
	@Override
	public String toString() {
		return  expression + " = " + result;
	}
	
	//对list们的getters and setters操作
	public LinkedList<Object> getAddArr() {
		return addArr;
	}

	public void setAddArr(LinkedList<Object> addArr) {
		Lists.addArr = addArr;
	}

	public LinkedList<String> getExpArr() {
		return expArr;
	}

	public void setExpArr(LinkedList<String> expArr) {
		Lists.expArr = expArr;
	}

	public LinkedList<String> getResArr() {
		return resArr;
	}

	public void setResArr(LinkedList<String> resArr) {
		Lists.resArr = resArr;
	}


}

