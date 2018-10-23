package ru.firsov.kirill.lesson7;

import ru.firsov.kirill.lesson3.Stack;

public class Graph {

    class Vertex {
        char label;
        boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }
    }

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackX theStack;
    private Queue theQueue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int [MAX_VERTS][MAX_VERTS];
        theStack =  new StackX(MAX_VERTS);
        theQueue = new Queue(MAX_VERTS);
        nVerts = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    // minimal spanning tree (breadth method)
    public void mstB() {
        vertexList[0].wasVisited = true;
        theQueue.insert(0);
        int v2;

        while (!theQueue.isEmpty()) {
            int currentVertex = theQueue.peek();
            int v1 = theQueue.remove();

            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                theQueue.insert(v2);

                displayVertex(currentVertex);
                displayVertex(v2);

                System.out.println(" ");
            }
        }

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    // breadth search
    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;

        while(!theQueue.isEmpty()) {
            int v1 = theQueue.remove();

            while( (v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    // minimal spanning tree (depth method)
    public void mstD() {
        vertexList[0].wasVisited = true;
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int currentVertex = theStack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1)
                theStack.pop();
            else {
                vertexList[v].wasVisited = true;
                theStack.push(v);

                displayVertex(currentVertex);
                displayVertex(v);
                System.out.println(" ");
            }
        }

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    // depth search
    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while(!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) theStack.pop();
            else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < MAX_VERTS; i++)
            if (adjMat[v][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        return -1;
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }
}
