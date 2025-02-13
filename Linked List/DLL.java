import java.util.*;

public class DLL {
    public static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    public static Node head = null;

    public static int size = 0;

    public static void insertFirst(int data) {
        size++;
        Node node = new Node(data);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public static void insertLast(int data) {
        size++;
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
    }

    public static void insertAfterNode(int data, int k) {
        if (head == null) {
            System.out.println("Linked List is empty, no nodes present");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == k)
                break;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("The given node is not present in the linked list");
        } else {
            size++;
            Node node = new Node(data);
            node.prev = temp;
            node.next = temp.next;
            temp.next = node;
            if (node.next != null) {
                node.next.prev = node;
            }
        }
    }

    public static void insertBeforeNode(int data, int k) {
        if (head == null) {
            System.out.println("Linked List is empty, no nodes present");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == k)
                break;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("The given node is not present in the linked list");
        } else {
            size++;
            Node node = new Node(data);
            node.next = temp;
            node.prev = temp.prev;
            temp.prev = node;
            if (node.prev != null) {
                node.prev.next = node;
            } else {
                head = node;
            }
        }
    }

    public static void insertAtPosition(int data, int k) {
        if (k < 1) {
            System.out.println("Invalid position");
            return;
        }
        if (k == 1) {
            size++;
            Node node = new Node(data);
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
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

        size++;
        Node node = new Node(data);
        node.prev = temp;
        node.next = temp.next;
        temp.next = node;
        if (node.next != null)
            node.next.prev = node;
    }

    public static void deleteFirst() {
        if (head == null) {
            System.out.println("Linked list is empty, nothing to delete");
            return;
        }

        System.out.println("Data deleted is: " + head.data);
        size--;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
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
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.println("Data deleted is: " + temp.data);
        temp.prev.next = null;
        size--;
    }

    public static void deleteAfterNode(int k) {
        if (head == null) {
            System.out.println("Linked list is empty, nothing to delete");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == k)
                break;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Node is not present");
        } else if (temp.next == null) {
            System.out.println("No node after this node");
        } else {
            size--;
            System.out.println("Data deleted is: " + temp.next.data);
            temp.next = temp.next.next;
            if (temp.next != null)
                temp.next.prev = temp;
        }
    }

    public static void deleteBeforeNode(int k) {
        if (head == null) {
            System.out.println("Linked list is empty, nothing to delete");
            return;
        }
        if (head.data == k) {
            System.out.println("No node before this node");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == k)
                break;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Node not found");
            return;
        }
        size--;
        System.out.println("Data deleted is: " + temp.prev.data);
        temp.prev = temp.prev.prev;
        if (temp.prev != null)
            temp.prev.next = temp;
        else
            head = temp;
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
            if (head != null)
                head.prev = null;
            size--;
            return;
        }

        Node temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        System.out.println("Data deleted is: " + temp.data);
        if (temp.next != null)
            temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        size--;
    }

    public static void reverse() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        } else if (head.next == null) {
            System.out.println("Reversed list is: ");
            display();
        } else {
            Node last = null, curr = head;
            while (curr != null) {
                last = curr.prev;
                curr.prev = curr.next;
                curr.next = last;
                curr = curr.prev;
            }
            head = last.prev;
            System.out.println("Reversed list is: ");
            display();
        }
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
            System.out.print(curr.data + "<->");
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
                    "1: Insert First\n2: Insert Last\n3: Insert After Node N\n4: Insert Before Node N\n5: Insert At Position K\n6: Delete First\n7: Delete Last\n8: Delete After Node N\n9: Delete Before Node N \n10: Delete From Position K\n11: Reverse\n12: Display\n0: Exit");
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
                    System.out.println("Enter the node value after which insertion is to be done: ");
                    k = sc.nextInt();
                    insertAfterNode(data, k);
                    break;
                case 4:
                    System.out.println("Enter data to be inserted: ");
                    data = sc.nextInt();
                    System.out.println("Enter the node value before which insertion is to be done: ");
                    k = sc.nextInt();
                    insertBeforeNode(data, k);
                    break;
                case 5:
                    System.out.println("Enter data to be inserted: ");
                    data = sc.nextInt();
                    System.out.println("Enter the position at which insertion is to be done: ");
                    k = sc.nextInt();
                    insertAtPosition(data, k);
                    break;
                case 6:
                    deleteFirst();
                    break;
                case 7:
                    deleteLast();
                    break;
                case 8:
                    System.out.println("Enter the node value after which deletion is to be done: ");
                    k = sc.nextInt();
                    deleteAfterNode(k);
                    break;
                case 9:
                    System.out.println("Enter the node value before which deletion is to be done: ");
                    k = sc.nextInt();
                    deleteBeforeNode(k);
                    break;
                case 10:
                    System.out.println("Enter the position from which deletion is to be done: ");
                    k = sc.nextInt();
                    deleteFromPosition(k);
                    break;
                case 11:
                    reverse();
                    break;
                case 12:
                    display();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
