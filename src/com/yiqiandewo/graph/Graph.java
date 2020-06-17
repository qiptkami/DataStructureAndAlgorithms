package com.yiqiandewo.graph;

import sun.security.provider.certpath.Vertex;

import java.util.*;

/**
 * 邻接矩阵无向图
 */
public class Graph {
    private String[] vertex;  //顶点数组
    private int vertexNum; //顶点个数
    private int[][] adjacencyMatrix;  //邻接矩阵
    private boolean[] visited; //是否访问过

    public Graph(int n, Edge[] e) {
        this.vertexNum = n;
        setAdjacencyMatrix(e);
        setVertex();
        setVisited();
    }

    public static void main(String[] args) {
        Edge[] e = new Edge[5];
        e[0] = new Edge(0, 1, 5);
        e[1] = new Edge(0, 2, 4);
        e[2] = new Edge(1, 3, 2);
        e[3] = new Edge(2, 3, 6);
        e[4] = new Edge(2, 4, 5);
        Graph g = new Graph(5, e);
        int[][] adjacencyMatrix = g.getAdjacencyMatrix();

        for (int[] a : adjacencyMatrix) {
            System.out.println(Arrays.toString(a));
        }

        g.DFS();

        System.out.println();

        g.BFS();

    }

    public void setVisited() {
        visited = new boolean[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            visited[i] = false;
        }
    }

    public void setVertex() {
        vertex = new String[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            char c = (char) (i + (int) 'A');
            vertex[i] = "" + c;
        }
    }

    public String[] getVertex() {
        return vertex;
    }

    public void setAdjacencyMatrix(Edge[] e) {
        adjacencyMatrix = new int[vertexNum][vertexNum];
        for (int i = 0; i < e.length; i++) {
            adjacencyMatrix[e[i].start][e[i].end] = e[i].val;
            adjacencyMatrix[e[i].end][e[i].start] = e[i].val;
        }
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void DFS() {
        Deque<String > stack = new ArrayDeque<>();
        stack.addFirst(vertex[0]);
        visited[0] = true;
        while (!stack.isEmpty()) {
            String cur = stack.removeFirst();
            System.out.print(cur + " ");
            //找到全部邻接点
            while (true) {
                String next = getAdjacency(cur);
                if (next == null) {
                    break;
                }
                stack.addFirst(next);
                visited[getIndex(next)] = true;
            }
        }
        //将结点全部置为未访问状态
        setVisited();
    }

    public void BFS() {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(vertex[0]);
        visited[0] = true;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            System.out.print(cur + " ");
            while (true) {
                String next = getAdjacency(cur);
                if (next == null) {
                    break;
                }
                queue.offer(next);
                visited[getIndex(next)] = true;
            }
        }
        //将结点全部置为未访问状态
        setVisited();
    }

    //返回邻接点
    private String getAdjacency(String ver) {
        int v = getIndex(ver);
        for (int i = 0; i < vertexNum; i++) {
            if (adjacencyMatrix[v][i] > 0 && !visited[i]) {
                return vertex[i];
            }
        }
        return null;
    }

    private int getIndex(String v) {
        for (int i = 0; i < vertexNum; i++) {
            if (vertex[i].equals(v)) {
                return i;
            }
        }
        return -1;
    }
}

class Edge {
    int start;
    int end;
    int val;

    public Edge(int start, int end, int val) {
        this.start = start;
        this.end = end;
        this.val = val;
    }
}