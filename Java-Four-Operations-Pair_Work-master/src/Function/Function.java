package Function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import Entity.Lists;
import Operation.GetExpression;
import Operation.ToolDemo;

public class Function {

	/*
	 * 获取用户设定的题目数
	 * */
	private int num;
	public int setNum(int num){
		this.num=num;
		return num;
	}
	
	public int getNum(){
		return num;
	}
	/*
	 * 题目中最多有多少个运算符
	 * */
	private int sybnum;
	public void setSybNum(int sybnum){
		this.sybnum = sybnum;
	}
	public int getSybNum(){
		return sybnum;
	}
	/*
	 * 算式数值范围
	    （包括原始题目与运算过程中所有中间结果的绝对值的数值范围）
	    */
	int max;
	public void setMax(int max){
		this.max = max;
	}
	public int getMax(){
		return max;
	}
	
	/*
	 * 题目中是否包含乘除法
	 * */
	public char isMulDiv(Boolean boolean1){
		char c;
		if(boolean1.booleanValue()){
			c = ToolDemo.getSign();
		}
		else{
			c = ToolDemo.getSign1();
		}
		return c;
	}
	
	
	/*
	 * 题目中是否包含括号
	 * */
	public static int flag =0;
	public static void isBrackets(Boolean bool){
		if(Boolean.FALSE){
			flag=0;
			/*
			 * GetResult类中toString方法会自动加括号
			 * 只需要把返回的str中的括号去除就可以了，并把处理后的字符串传入
			 * BTree.toString()去括号
			 * */
			//不能有括号
		}
		else{
			flag=1;//可以含有括号
		}
	}
	
	
	/*
	 * 获取文件传输的URL
	*/
	private String url;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	} 
	
	

	
	/*
	 * 得到算式
	        得到答案
	 * 这个方法是把所有的整个式子，算式和结果分别放入三个ArrayList中
	 * 新建树并产生用户获取到数目的算式，分别存放List中
	 * 实现了逐个遍历
	 * */
	
	//获取三个list
	public LinkedList<String> createList(int num,int symNum){
		GetExpression bTree;
		
    	for(int i=0;i<num;i++){
    		//构造树
    		bTree = new GetExpression(symNum);
    		bTree.buildBTree();
    		//设置list类里面的expression,result  		
    		String result = bTree.CalAndVal();
    		String expression = bTree.toString();
    		Lists l = new Lists(expression,result);
    		//把expression和result获取出来
    		Lists.expArr.add(expression);
    		Lists.resArr.add(result);
    		Lists.addArr.add(l.toString());
    	}
    	return Lists.expArr;
	}
	
    //读取文件
	//目前文件只能逐行读取……还没有实现把文件放入链表中
	public void ReadFile(String fromUrl,String toUrl){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(toUrl));
			BufferedReader br = new BufferedReader(new FileReader(fromUrl));
			String s = null;
			for(int i=1;i<=100;i++){
				s = String.valueOf(Math.random());
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			while((s=br.readLine())!=null){
				System.out.println((String)s);
				System.out.println("下一行");
			}
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
