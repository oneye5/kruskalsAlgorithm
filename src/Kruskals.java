import java.util.*;
import java.util.stream.Collectors;

public class Kruskals {
    List<Edge> edges = new ArrayList<>();
    List<Set<Edge>> mst = new ArrayList<>();

    public Set<Edge> evaluate(Graph g) {
        edges = new ArrayList<>(g.edgeList);
        edges = edges.stream().sorted(Comparator.comparingDouble(Edge::cost)).collect(Collectors.toList());
        System.out.println("edges after sorting = " + edges.toString());

        for (int i = 0; i < edges.size(); i++) {

            System.out.println("iteration no:" + i + "\nmst:" + mst.toString());
            Edge current = edges.get(i);
            int fromGroupIndex = -1;
            int toGroupIndex = -1;

            for (int ii = 0; ii < mst.size(); ii++) {
                var group = mst.get(ii);
                for (var edge : group) {
                    if (edge.from().equals(current.from()) || edge.to().equals(current.from()))
                        fromGroupIndex = ii;

                    if (edge.from().equals(current.to()) || edge.to().equals(current.to()))
                        toGroupIndex = ii;
                }
            }



            if (toGroupIndex == -1 && fromGroupIndex == -1)
            {
                Set<Edge> s = new HashSet<>();
                s.add(current);
                mst.add(s);
                continue;
            }

            if (fromGroupIndex != -1 && toGroupIndex != -1)
            {
                if(fromGroupIndex == toGroupIndex)
                    continue;
                // Merge groups
                mst.get(fromGroupIndex).add(current);
                mst.get(fromGroupIndex).addAll(mst.get(toGroupIndex));
                mst.remove(toGroupIndex);
                continue;
            }

            if (fromGroupIndex != -1)
                mst.get(fromGroupIndex).add(current);

            if (toGroupIndex != -1)
                mst.get(toGroupIndex).add(current);
        }

        // Combine sets into a single set
        Set<Edge> result = new HashSet<>();
        for (Set<Edge> set : mst) {
            result.addAll(set);
        }

        System.out.println(mst);
        return result;
    }
}
