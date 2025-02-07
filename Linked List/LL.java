import java.util.*;

public class LL {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node head = null;

    public static int size = 0;

    public static void insertFirst(int data) {
        size++;
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public static void insertLast(int data) {
        size++;
        Node node = new Node(data);
        if (head == null) {
            node.next = head;
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public static void insertAtPosition(int data, int k) {
        if (k < 1) {
            System.out.println("Invalid Position");
            return;
        }

        if (k == 1) {
            Node node = new Node(data);
            size++;
            node.next = head;
            head = node;
            return;
        }

        Node temp = head;
        for (int i = 1; i < k - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
        size++;

    }

    public static void insertBeforeValue(int data, int x) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        if (head.data == x) {
            Node node = new Node(data);
            size++;
            node.next = head;
            head = node;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == x) {
                Node node = new Node(data);
                size++;
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Value not found");
    }

    public static void deleteFirst() {
        if (head == null) {
            System.out.println("Linked list is empty, nothing to delete");
            return;
        }
        System.out.println("Data deleted is: " + head.data);
        head = head.next;
        size--;
    }

    public static void deleteLast() {
        if (head == null) {
            System.out.println("Linked list is empty, nothing to delete");
            return;
        }
        if (head.next == null) {
            System.out.println("Data deleted is: " + head.data);
            head = null;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println("Data deleted is: " + temp.next.data);
        temp.next = null;
        size--;
    }

    public static void deleteFromPosition(int k) {
        if (head == null) {
            System.out.println("Linked list is empty, nothing to delete");
            return;
        }
        if (k < 1) {
            System.out.println("Invalid position");
            return;
        }
        if (k == 1) {
            System.out.println("Data deleted is: " + head.data);
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        for (int i = 1; i < k - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Invalid position");
            return;
        }

        System.out.println("Data deleted is: " + temp.next.data);
        temp.next = temp.next.next;
        size--;
    }

    public static void deleteValue(int data) {
        if (head == null) {
            System.out.println("Linked list is empty, nothing to delete");
            return;
        }
        if (head.data == data) {
            System.out.println("Data deleted is: " + head.data);
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                System.out.println("Data deleted is: " + temp.next.data);
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Value not found");
    }

    public static void search(int data) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node curr = head;
        int idx = 1;
        while (curr != null) {
            if (curr.data == data) {
                System.out.println("Found at position: " + idx);
                return;
            }
            curr = curr.next;
            idx++;
        }
        System.out.println("Data not found");
    }

    public static void display() {
        int count = 0;
        if (head == null) {
            System.out.println("Linked List is empty, nothing to display");
            return;
        }
        System.out.println("Displaying the elements of the Linked List: ");
        Node curr = head;
        while (curr != null) {
            count++;
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("END");
        System.out.println("Total items is: " + count);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int data, k;

        while (true) {
            System.out.println(
                    "1: Insert First\n2: Insert Last\n3: Insert At Position K\n4: Insert before a value\n5: Delete First\n6: Delete Last\n7: Delete At Position K\n8: Delete before a value\n9: Search element\n10: Display \n0: Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Program terminated");
                    sc.close();
                    System.exit(0);
                case 1:
                    System.out.println("Enter data to be inserted first: ");
                    data = sc.nextInt();
                    insertFirst(data);
                    break;
                case 2:
                    System.out.println("Enter data to be inserted last: ");
                    data = sc.nextInt();
                    insertLast(data);
                    break;
                case 3:
                    System.out.println("Enter data to be inserted: ");
                    data = sc.nextInt();
                    System.out.println("Enter the position: ");
                    k = sc.nextInt();
                    insertAtPosition(data, k);
                    break;
                case 4:
                    System.out.println("Enter data to be inserted: ");
                    data = sc.nextInt();
                    System.out.println("Enter the value before which insertion is to be done: ");
                    int x = sc.nextInt();
                    insertBeforeValue(data, x);
                    break;
                case 5:
                    deleteFirst();
                    break;
                case 6:
                    deleteLast();
                    break;
                case 7:
                    System.out.println("Enter the position: ");
                    k = sc.nextInt();
                    deleteFromPosition(k);
                    break;
                case 8:
                    System.out.println("Enter the value to be deleted: ");
                    data = sc.nextInt();
                    deleteValue(data);
                    break;
                case 9:
                    System.out.println("Enter data to be searched: ");
                    data = sc.nextInt();
                    search(data);
                    break;
                case 10:
                    display();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}