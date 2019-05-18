package Operation;


import java.util.Random;

public class ToolDemo {


	public static char getSign() {
		char sign = 0;
		Random num = new Random();
		int i = num.nextInt(4);
		switch (i) {
		case 0:
			sign = '+';
			break;
		case 1:
			sign = '-';
			break;
		case 2:
			sign = '*';
			break;
		case 3:
			sign = '÷';
			break;
		}
		return sign;
	}//获取随机的符号（四则）
	
	public static char getSign1() {
		char sign = 0;
		Random num = new Random();
		int i = num.nextInt(4);
		switch (i) {
		case 0:
			sign = '+';
			break;
		case 1:
			sign = '-';
			break;
		}
		return sign;
	}//获取随机的符号（二则）
	
	
	
	
	public static int getNumber(int max) {
		int number = 0;
		Random num = new Random();
		number = num.nextInt(max + 1);
		return number;
	}//根据输入的范围获取随机数



	public static boolean[] getChildPlace(int num) {
		int d = 0;
		int size = 0, j = 1;
		while (num >= (int) Math.pow(2, j)) {
			j++;
		}
		d = (int) Math.pow(2, j) - 1 - num;
		size = (int) Math.pow(2, j - 1);
		boolean[] k = new boolean[size];
		for (int i = 0; i < size; i++) {
			k[i] = true;
		}
		for (int i = 0; i < d; i++) {
			Random ran = new Random();
			int f = ran.nextInt(size);
			while (k[f] == false) {
				f = ran.nextInt(size);
			}
			k[f] = false;
		}
		return k;
	}//随机产生子节点
}
