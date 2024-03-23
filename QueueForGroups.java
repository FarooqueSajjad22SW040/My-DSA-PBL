
class QueueForGroups {
    StackOfStudents stackOfStudents1;
    StackOfStudents stackOfStudents2;

    Node [] groupQueue;

    public QueueForGroups(StackOfStudents s1, StackOfStudents s2) {
        this.stackOfStudents1 = s1;
        this.stackOfStudents2 = s2;
        this.groupQueue = new Node[10];

        for (int i = 0; i < 10; i++) {
            groupQueue[i] = new Node(null);
        }
    }



    public void push(Student data) {
        String group = data.group;
        int index;
        switch (group) {
            case "group A" -> index = 0;
            case "group B" -> index = 1;
            case "group C" -> index = 2;
            case "group D" -> index = 3;
            case "group E" -> index = 4;
            case "group F" -> index = 5;
            default -> {

                return;
            }
        }
        groupQueue[index].push(data);
    }


    public void checkLength(int length) {
        if (length >= groupQueue.length) {
            resizeQueuesArray();
        }
    }
    public void resizeQueuesArray() {
        int size =groupQueue.length;
        Node[] newQueue = new Node[2 * size];
        System.arraycopy(groupQueue, 0, newQueue, 0, size);
        groupQueue = newQueue;

    }


    public void createQueuesForGroups() {
        while (!stackOfStudents1.isEmpty()) {
            Student student = stackOfStudents1.pop();
            push(student);
        }
        while (!stackOfStudents2.isEmpty()) {
            Student student = stackOfStudents2.pop();
            push(student);
        }
    }


    public void displayQueues() {
        for (int i = 0; i < 10; i++) {
            Node current = groupQueue[i].next;
            if (current != null) {
                System.out.println((i+1)+". Queue for Group : " +  current.data.group);
                System.out.println("-----------------------------");
                while (current != null) {
                    System.out.println("Student: Average Marks - " + current.data.averageMarks() + ", Gender - " + current.data.gender);
                    current = current.next;
                }
                System.out.println();
            }
        }
    }

    public void bestAvgMarksOfGroups() {
        bestAvgMarksFinder(groupQueue[0].next);
        bestAvgMarksFinder(groupQueue[3].next);
    }

    public void bestAvgMarksFinder(Node head) {
        if (head == null) {
            System.out.println("No data found.");
            return;
        }

        double bestAvg = 0;
        Node best = null;

        Node temp = head;
        while (temp != null&&temp.data!=null) {
            if (temp.data.averageScore > bestAvg) {
                best = temp;
                bestAvg = temp.data.averageScore;
            }
            temp = temp.next;
        }

        System.out.println("Best AVG marks of " + best.data.group + " : " + bestAvg);
    }







}

