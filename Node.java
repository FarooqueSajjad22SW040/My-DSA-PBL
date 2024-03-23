class Node {
    Student data;
    double averageMarks;
    Node next;

    public Node(Student data) {
        this.data = data;
        this.next = null;
    }


    Node head  ;




    public int size (Node head){
        Node temp = this;
        int size = 0;
        while (temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }








       public void push(Student data) {
           Node newNode = new Node(data);
           if (this.next == null) {
               this.next = newNode;
           } else {
               Node current = this.next;
               while (current.next != null) {
                   current = current.next;
               }
               current.next = newNode;
           }
       }






    public void print(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
            count++;
        }
        System.out.println("Total records printed: " + count);
    }

    public void sort() {
        boolean swapped;
        Node current;
        Node lastNode = null;

        do {
            swapped = false;
            current = this;


            while (current.next != lastNode) {
                if (current.data.averageMarks() > current.next.data.averageMarks()) {

                    Student temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
            lastNode = current;
        } while (swapped);
    }





}









