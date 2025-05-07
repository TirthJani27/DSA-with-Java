import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void printGraph(Node head) {
        Queue<Node> q = new ArrayDeque<>();
        HashSet<Node> vis = new HashSet<>();
        q.add(head);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (!vis.contains(curr)) {
                System.out.println(curr.val + " ");
                vis.add(curr);
                for (Node node : curr.neighbors) {
                    q.add(node);
                }
            }
        }
    }

    public static Node cloneGraph(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        HashMap<Node, Node> map = new HashMap<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (!map.containsKey(temp)) {
                Node curr = new Node(temp.val);
                map.put(temp, curr);
                for (Node node2 : temp.neighbors) {
                    q.add(node2);
                }
            }
        }
        for (Node originalNode : map.keySet()) {
            Node clonedNode = map.get(originalNode);
            for (Node neighbor : originalNode.neighbors) {
                clonedNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node head2 = new Node(2);
        Node head3 = new Node(3);
        Node head4 = new Node(4);
        head.neighbors = new ArrayList<>(List.of(head4, head3));
        head3.neighbors = new ArrayList<>(List.of(head2));
        head4.neighbors = new ArrayList<>(List.of(head2));
        Node newHead = cloneGraph(head);
        printGraph(newHead);
    }
}
