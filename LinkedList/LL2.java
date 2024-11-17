public class LL2 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // step1 - create new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step2 - newNode next = head
        newNode.next = head; // link

        // step3 - head = new Node
        head = newNode;
    }

    public void addLast(int data) {
        // step 1
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2
        tail.next = newNode;

        // step 3
        tail = newNode;
    }

    public void print() {// O(n)
        // if(head==null) {
        // System.out.println("LL is Empty");
        // return;
        // }
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2

            if (slow == fast) {
                return true; // cycle exists
            }
        }

        return false; // cycle doesn't exist
    }

    public static void removeCyle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycleExists = false;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2

            if (slow == fast) {
                cycleExists = true; // cycle exists
                break;
            }
        }

        if (cycleExists == false) {
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle --> lastNode.next = null;
        prev.next = null;
    }

    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        // 1-->2-->3-->2

        System.out.println(isCycle());
        removeCyle();
        System.out.println(isCycle());
    }
}