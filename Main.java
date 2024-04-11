package Pack;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.add_node("ASD");
        graph.add_node("DSA");
        graph.add_edge(6, 0, 1);
        graph.print_graph();
    }
}