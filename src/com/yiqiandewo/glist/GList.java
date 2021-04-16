package com.yiqiandewo.glist;

//广义表的建立  采用的是将广义表划分为"头"和"尾"的模式
//这些操作以"(((a,b),(c,d)),(e,(f,g),h),z)"形式的字符串为基础.一对括号代表一个表.

public class GList {
    //节点类型
    public static int ATOM = 0;
    public static int LIST = 1;

    public int tag;//用于区分节点

    public Object atom;//原子类型
    public GList hp, tp;//指向表头和表尾

    //建立广义表"(((a,b),(c,d)),(e,(f,g),h),z)"这样形式的字符串为内通建立广义表
    //同样采用递归方式。结束条件是空表和原子。
    //递归建立表头和表尾
    public static GList createGList(GList L, String s) {
        System.out.println(s);
        GList p = null;  //头
        GList q = null;  //尾

        if (s.equals("()")) {
            L = null;//空表
        } else {
            L = new GList();
            if (s.length() == 1) { //原子结点
                L.tag = ATOM;
                L.atom = s.charAt(0);
            } else {
                //长度不等于1 说明不是原子结点
                L.tag = LIST;
                p = L;
                String sub = s.substring(1, s.length() - 1); //去掉最外面的()
                while (!sub.isEmpty()) {
                    Temp temp = new Temp(sub);
                    String hSub = sever(temp);  //得到表头
                    sub = temp.str;             //得到表尾

                    p.hp = createGList(p.hp, hSub); //createGList(p.hp, hSub)的返回值就是表头的广义表 然后构建头的对应关系
                    q = p;
                    //表尾不是()的时候
                    if (!sub.isEmpty()) {
                        p = new GList();
                        p.tag = LIST;
                        q.tp = p;  //构建尾的对应关系
                    }
                }
                //每当构建完一个广义表时，就会执行到这
                //我不知道这句话什么意思，把它注释掉的话没有变化
                q.tp = null;
            }
        }
        return L;
    }

    /*
     * 该函数处理(((a,b),(c,d)),(e,(f,g),h),z)后，hStr = ((a,b),(c,d)) str = (e,(f,g),h),z
     * 分离表头和表尾
     * 返回表头 并且把表尾赋给Temp类型的t.str
     */
    public static String sever(Temp t) {
        String str = t.str;
        int n = str.length();
        int i = 0, k = 0;
        char ch;
        String hStr = null;
        do {
            ch = str.charAt(i);
            i++;

            if(ch == '(') {
                k++;
            } else if(ch == ')') {
                k--;
            }
        } while (i < n && (ch !=',' || k!=0));

        if (i < n) {
            hStr = str.substring(0,i-1);
            str = str.substring(i);
        } else {
            hStr = str;
            str = "";
        }
        t.str = str;
        return hStr;
    }

    public static void main(String[] args){
        GList L = null;
        String s = "(((a,b),(c,d)),(e,(f,g),h),z)";
        //建表
        L = GList.createGList(L, s);
    }

}

//为了应对值传递，只能传递引用拷贝，无法传递“地址”的问题
//不理解的话 就把Temp当作字符串类就行了
class Temp {
    String str = "";
    public Temp(String s){
        str = s;
    }
}