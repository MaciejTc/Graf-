package Pack;

import java.util.ArrayList;

public class Graph {
    ArrayList<Node> nodes = new ArrayList<>();
    ArrayList<Edge> edges = new ArrayList<>();

    public void print_graph() {
        for (Node node : nodes) {
            System.out.println("\nNode id: " + node.id+" Node name: "+node.name+"\nEdges: ");
            for (Edge edge : edges){
                int i = 0;
                if(node.id==edge.id1||node.id==edge.id2){
                    i++;
                    System.out.println("Edge "+i+". id1: " + edge.id1+" id2: "+ edge.id2);
                }
            }
        }
    }

    public Node add_node(String name) {
        Node node = new Node(name);
        nodes.add(node);
        return node;
    }


    public Node remove_node(int id) {
        if (nodes.size() == 0) {
            System.out.println("No nodes to remove");
        }
        ArrayList<Edge> edgesToRemove = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.id1 == id || edge.id2 == id) {
                edgesToRemove.add(edge);
            }
        }
        edges.removeAll(edgesToRemove);

        for (Node node : nodes) {
            if (node.id == id) {
                nodes.remove(node);
                return node;
            }
        }
        return null;
    }


    public Edge add_edge(int weight, int id1, int id2) {
        boolean isValidEdge = true;
        boolean node1Exists = false;
        boolean node2Exists = false;

        for (Node node : nodes) {
            if (node.id == id1) {
                node1Exists = true;
            }
            if (node.id == id2) {
                node2Exists = true;
            }
        }
        if (!node1Exists || !node2Exists || id1 == id2) {
            System.out.println("Error with adding edge");
            isValidEdge = false;
        }
        for (Edge edge : edges) {
            if ((edge.id1 == id1 && edge.id2 == id2) || (edge.id1 == id2 && edge.id2 == id1)) {
                System.out.println("Error with adding edge");
                isValidEdge = false;
                break;
            }
        }
        if (isValidEdge) {
            Edge edge = new Edge(weight, id1, id2);
            edges.add(edge);
            return edge;
        }
        return null;
    }

    public Edge remove_edge(int id1, int id2){
        Edge edgeToRemove = null;

        for(Edge edge : edges){
            if((edge.id1==id1 && edge.id2==id2) || (edge.id1==id2 && edge.id2==id1)){
                edgeToRemove = edge;
                break;
            }
        }
        if(edgeToRemove != null){
            edges.remove(edgeToRemove);
            return edgeToRemove;
        }
        else {
            System.out.println("Edge not found");
        }
        return null;
    }
}