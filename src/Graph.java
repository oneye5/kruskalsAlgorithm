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
        vertexList.add(new Vertex("E"));

        edgeList.add(new Edge(vertexList.get(0),vertexList.get(1),1.0f));
        edgeList.add(new Edge(vertexList.get(1),vertexList.get(2),2.0f));
        edgeList.add(new Edge(vertexList.get(2),vertexList.get(3),3.0f));
        edgeList.add(new Edge(vertexList.get(3),vertexList.get(1),4.0f));

        var result = new Kruskals().evaluate(this);
        System.out.println(result);
    }
    public static void main(String args[]) {new Graph().start();}
}
