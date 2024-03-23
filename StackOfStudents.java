public class StackOfStudents {
    Node head;

    public StackOfStudents() {
        head = null;
    }


    public void push(Student data) {
        if (data == null) {
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }


    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack of Student is Empty ");
            return null;
        }
        Student data = head.data;
        head = head.next;
        return data;
    }


    public boolean isEmpty() {
        return head == null;
    }


    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack of Student is Empty ");
            return null;
        }
        return head.data;
    }


    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void printStack(StackOfStudents s1) {
        Node temp = s1.head;
        temp.print(temp);
    }
}
