package com.yiqiandewo.tree;

import java.util.*;

/**
 * 计算每个字符出现的次数 区分大小写 以及空格
 */
public class HuffmanCode {

    public static Map<Byte, String> huffmanCode = new HashMap<>();
    public static Map<Byte, Integer> NodeMap = new HashMap<>();;

    public static void main(String[] args) {
        String str = "yiqiandewo like rookie, jay, anime and guitar";

        HuffmanCode h = new HuffmanCode();
        String huffmanCodeStr = h.setHuffmanCode(str);

        System.out.println(huffmanCodeStr);

    }

    public String setHuffmanCode(String str) {
        //创建Node结点
        List<HuffmanNode> nodes = getNodes(str);
        //构建哈夫曼树
        HuffmanNode huffmanTree = createHuffmanTree(nodes);
        //得到哈夫曼编码Map
        getCodes(huffmanTree);

        String huffmanCodeStr = getHuffmanCodeStr(str);

        return huffmanCodeStr;
    }


    private String getHuffmanCodeStr(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            stringBuffer.append(huffmanCode.get(b));
        }
        String huffmanCodeStr = stringBuffer.toString();
        return huffmanCodeStr;
    }

    private void getCodes(HuffmanNode root) {
        if (root != null) {
            getCodes(root.left, "0", new StringBuffer());
            getCodes(root.right, "1", new StringBuffer());
        }
    }

    private void getCodes(HuffmanNode node, String code, StringBuffer stringBuffer) {
        StringBuffer s = new StringBuffer(stringBuffer).append(code);
        if (node != null) {
            if (node.b == null) {
                getCodes(node.left, "0", s);
                getCodes(node.right, "1", s);
            } else {
                huffmanCode.put(node.b, s.toString());
            }
        }

    }

    private HuffmanNode createHuffmanTree(List<HuffmanNode> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            HuffmanNode left = nodes.get(0);
            HuffmanNode right = nodes.get(1);
            HuffmanNode parent = new HuffmanNode(left.count + right.count);

            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);

            nodes.add(parent);
        }
        return nodes.get(0);
    }

    private List<HuffmanNode> getNodes(String str) {
        setNodeMap(str);
        List<HuffmanNode> list = new ArrayList<>();
        Set<Byte> bytes = NodeMap.keySet();

        for (Byte b : bytes) {
            list.add(new HuffmanNode(NodeMap.get(b), b));
        }
        return list;
    }

    private void setNodeMap(String str) {
        for (Byte b : str.getBytes()) {
            Integer count = NodeMap.get(b);
            if (count == null) {
                NodeMap.put(b, 1);
            } else {
                NodeMap.put(b, count+1);
            }
        }
    }

}

class HuffmanNode implements Comparable<HuffmanNode> {
    Integer count;
    Byte b;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(Integer count) {
        this.count = count;
        left = null;
        right = null;
    }

    public HuffmanNode(Integer count, Byte b) {
        this(count);
        this.b = b;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.count - o.count;
    }
}