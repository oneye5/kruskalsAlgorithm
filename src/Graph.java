import java.util.ArrayList;
import java.util.List;

public class Graph
{
    List<Edge> edgeList = new ArrayList<>();
    List<Vertex> vertexList = new ArrayList<>();
    public Graph(){}
    public void start()
    {
        vertexList.add(new Vertex("A"));
        vertexList.add(new Vertex("B"));
        vertexList.add(new Vertex("C"));
        vertexList.add(new Vertex("D"));
        vertexList.add(new Vertex("E"));
        vertexList.add(new Vertex("F"));

        edgeList.add(new Edge(vertexList.get(0), vertexList.get(1), 2.0f)); // (A)-(B)
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(2), 4.0f)); // (A)-(C)
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(2), 1.0f)); // (B)-(C)
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(3), 5.0f)); // (B)-(D)
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(4), 3.0f)); // (B)-(E)
        edgeList.add(new Edge(vertexList.get(2), vertexList.get(3), 2.0f)); // (C)-(D)
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(4), 6.0f)); // (D)-(E)
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(5), 4.0f)); // (D)-(F)
        edgeList.add(new Edge(vertexList.get(4), vertexList.get(5), 1.0f)); // (E)-(F)


        var result = new Kruskals().evaluate(this);
        System.out.println(result);
    }
    public static void main(String args[]) {new Graph().start();}
}
