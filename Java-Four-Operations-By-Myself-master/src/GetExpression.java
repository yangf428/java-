import java.util.ArrayList;

public class GetExpression {

    //本类主要用于生成运算表达式
    private GetResult root;
    private int num;
    private ArrayList<GetResult> opeList = new ArrayList<GetResult>();

    public GetExpression(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setTreeNode(GetResult root) {
        this.root = root;
    }

    @Override
    public String toString() {
        String str = root.toString();
        str = str.substring(1, str.length() - 1);
        return str;
    }

    // 验证表达式
    public String CalAndVal() {
        return root.getResult();
    }


    //计算二叉树的深度
    public int getDeepth() {
        int i = this.num;
        int deep = 2;
        while (i / 2 > 0) {
            deep++;
            i /= 2;
        }
        return deep;
    }


    //生成二叉树
    public void buildBTree() {
        GetResult lchild, rchild, lnode, rnode;

        if (num == 1) {
            lchild = new GetResult(String.valueOf(ToolDemo.getNumber(10)), null, null);
            rchild = new GetResult(String.valueOf(ToolDemo.getNumber(10)), null, null);
            root = new GetResult(String.valueOf(ToolDemo.getSign()), lchild, rchild);
        } else {
            int num1 = 0;
            int n = getDeepth() - 3;
            boolean[] place = ToolDemo.getChildPlace(num);
            root = new GetResult(String.valueOf(ToolDemo.getSign()), null, null);
            opeList.add(root);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < (int) Math.pow(2, i); j++, num1++) {
                    lchild = new GetResult(String.valueOf(ToolDemo.getSign()), null, null);
                    rchild = new GetResult(String.valueOf(ToolDemo.getSign()), null, null);
                    opeList.get(j + num1).setChild(lchild, rchild);
                    opeList.add(lchild);
                    opeList.add(rchild);
                }
            }

            for (int i = 0; i < place.length; i++) {
                if (place[i]) {
                    lnode = new GetResult(String.valueOf(ToolDemo.getNumber(10)), null, null);
                    rnode = new GetResult(String.valueOf(ToolDemo.getNumber(10)), null, null);
                    if (i % 2 == 0) {
                        lchild = new GetResult(String.valueOf(ToolDemo.getSign()), lnode, rnode);
                        opeList.add(lchild);
                        opeList.get(num1).setLchild(lchild);
                    } else {
                        rchild = new GetResult(String.valueOf(ToolDemo.getSign()), lnode, rnode);
                        opeList.add(rchild);
                        opeList.get(num1).setRchild(rchild);
                    }
                } else {
                    if (i % 2 == 0) {
                        lchild = new GetResult(String.valueOf(ToolDemo.getNumber(10)), null, null);
                        opeList.get(num1).setLchild(lchild);
                    } else {

                        rchild = new GetResult(String.valueOf(ToolDemo.getNumber(10)), null, null);
                        opeList.get(num1).setRchild(rchild);
                    }
                }
                num1 = num1 + i % 2;
            }
        }
    }

}