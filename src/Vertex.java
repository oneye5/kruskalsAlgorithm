import java.util.Set;

public class Vertex
{
    public Set<Edge> edges;
    public String name;

    public Vertex(String name)
    {
        this.name = name;
    }
    @Override
    public String toString()
    {
        return name;
    }
}
