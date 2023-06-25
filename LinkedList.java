public class LinkedList {

    public Node head;

    public static void main(String... args) {
        LinkedList seasons = new LinkedList();
        seasons.printList();
        seasons.addToHead("summer");
        seasons.addToHead("spring");
        seasons.printList();
        seasons.addToTail("fall");
        seasons.addToTail("winter");
        seasons.printList();
        seasons.removeHead();
        seasons.printList();
    }

    public LinkedList() {
        this.head = null;
    }

    public void addToHead(String data) {
        Node newHead = new Node(data);
        Node currentHead = this.head;
        this.head = newHead;
        if (currentHead != null) {
            this.head.setNextNode(currentHead);
        }
    }

    public void addToTail(String data) {
        Node tail = this.head;
        if (tail == null) {
            this.head = new Node(data);
        } else {
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(new Node(data));
        }
    }

    public String removeHead() {
        Node removedHead = this.head;
        if (removedHead == null) {
            return null;
        }
        this.head = removedHead.getNextNode();
        return removedHead.data;
    }

    public String printList() {
        StringBuilder sb = new StringBuilder("<head> ");
        Node currentNode = this.head;
        while (currentNode != null) {
            sb
                .append(currentNode.data)
                .append(" ");
            currentNode = currentNode.getNextNode();
        }
        sb.append("<tail>");
        System.out.println(sb.toString());
        return sb.toString();
    }

    public void swapNodes(String data1, String data2) {
        Node node1 = this.head;
        Node node2 = this.head;
        Node node1Prev = null;
        Node node2Prev = null;

        // Edge case - both nodes to be swapped are the same - so no need to execute the whole function
        if (data1 == data2) {
            System.out.println("Elements are the same - no swap needed.");
            return;
        }
        
        // Finding the matching and preceding nodes
        while (node1 != null) {
            if (node1.data == data1) {
                break;
            }
            node1Prev = node1;
            node1 = node1.getNextNode();
        }

        while (node2 != null){
            if(node2.data == data2) {
                break;
            }
            node2Prev = node2;
            node2 = node2.getNextNode();
        }

        // Edge Case - no matching node for one of the inputs
        if (node1 == null || node2 == null) {
            System.out.println("Swap not possible - one or more element is not in the list");
            return;
        }

        // Updating the preceding nodes' pointers
        if (node1Prev == null) {
            this.head = node2;
        } else {
            node1Prev.setNextNode(node2);
        }

        if (node2Prev == null) {
            this.head = node1;
        } else {
            node2Prev.setNextNode(node1);
        }

        // Updating the nodes' next pointers
        Node temp = node1.getNextNode();
        node1.setNextNode(node2.getNextNode());
        node2.setNextNode(temp);
    }
}
