

public record Edge(Vertex from,Vertex to, float cost)
{

    @Override
    public String toString()
    {
       return from.toString() + ":" + to.toString()+" cost: " + cost;
    }
}
