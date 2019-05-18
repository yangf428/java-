public class GetResult {
	private String str;
	private GetResult rchild = null;
	private GetResult lchild = null;

	public GetResult(String str) {
		this.str = str;
	}

	public GetResult(String str, GetResult lchild, GetResult rchild) {
		this.str = str;
		this.rchild = rchild;
		this.lchild = lchild;
	}

	public void setChild(GetResult lchild, GetResult rchild) {
		this.lchild = lchild;
		this.rchild = rchild;
	}

	public GetResult getRchild() {
		return rchild;
	}

	public void setRchild(GetResult rchild) {
		this.rchild = rchild;
	}

	public GetResult getLchild() {
		return lchild;
	}

	public void setLchild(GetResult lchild) {
		this.lchild = lchild;
	}

	public String getStr() {
		return str;
	}

	//获取每个节点的运算结果
	public String getResult() {
		if (hasChild()) {
			switch (str) {
			case "+":
				return String.valueOf(Integer.parseInt(getLchild().getResult()) + Integer.parseInt(getRchild().getResult()));
			case "-":
				if (Integer.parseInt(getLchild().getResult()) - Integer.parseInt(getRchild().getResult()) < 0) {
					while (str.equals("-")) {
						str = String.valueOf(ToolDemo.getSign());
					}
					return this.getResult();
				} else {
					return String.valueOf(Integer.parseInt(getLchild().getResult()) - Integer.parseInt(getRchild().getResult()));
				}
			case "*":
				return String.valueOf(Integer.parseInt(getLchild().getResult()) * Integer.parseInt(getRchild().getResult()));
			case "÷":
				if (getRchild().getResult().equals("0")) {
					while (str.equals("÷")) {
						str = String.valueOf(ToolDemo.getSign());
					}
					return this.getResult();
				} else if (Integer.parseInt(getLchild().getResult()) % Integer.parseInt(getRchild().getResult()) != 0) {
					while (str.equals("÷")) {
						str = String.valueOf(ToolDemo.getSign());
					}
					return this.getResult();
				} else
					return String.valueOf(Integer.parseInt(getLchild().getResult()) / Integer.parseInt(getRchild().getResult()));
			}
		}
		return str;
	}

	//根据左右子数是否有孩子以及符号来判断
	@Override
	public String toString() {
		String Lstr = "", Rstr = "", Str = "";
		if (hasChild()) {
			// 右子树
			if (getRchild().hasChild()) {
				if (str.equals("/")) {
					Rstr = getRchild().toString();
				} else if (str.equals("*") || str.equals("-")) {
					if (getRchild().str.equals("+") || getRchild().str.equals("-")) {
						Rstr = getRchild().toString();
					} else {
						Rstr = getRchild().toString().substring(1, getRchild().toString().length() - 1);
					}
				} else {
					Rstr = getRchild().toString().substring(1, getRchild().toString().length() - 1);
				}
			} else {
				Rstr = getRchild().str;
			}
			// 左子树
			if (getLchild().hasChild()) {
				if (str.equals("*") || str.equals("/")) {
					if (getLchild().str.equals("+") || getLchild().str.equals("-")) {
						Lstr = getLchild().toString();
					} else {
						Lstr = getLchild().toString().substring(1, getLchild().toString().length() - 1);
					}
				} else {
					Lstr = getLchild().toString().substring(1, getLchild().toString().length() - 1);
				}
			} else {
				Lstr = getLchild().str;
			}
			// 获取当前的运算式，并加上括号
			Str = "(" + Lstr + str + Rstr + ")";
		} else {
			// 若没有孩子，直接返回数字
			Str = str;
		}
		return Str;
	}

	public boolean hasChild() {
		if (lchild == null && rchild == null)
			return false;
		else
			return true;
	}

}
