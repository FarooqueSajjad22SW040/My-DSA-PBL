
import java.util.Objects;
class QueueForParentalLevel {
    StackOfStudents stackOfStudents1;
    StackOfStudents stackOfStudents2;
    Node[] parentalLevelQueue;


    public QueueForParentalLevel(StackOfStudents s1, StackOfStudents s2) {
        this.stackOfStudents1 = s1;
        this.stackOfStudents2 = s2;
        this.parentalLevelQueue = new Node[10];

        for (int i = 0; i < 10; i++) {
            parentalLevelQueue[i] = new Node(null);

        }
    }


    public void push(Student data) {
        String level = data.parentalLevel;
        int index;
        switch (level) {
            case "high school" -> index = 0;
            case "some high school" -> index = 1;
            case "some college" -> index = 2;
            case "associate's degree" -> index = 3;
            case "bachelor's degree" -> index = 4;
            case "master's degree" -> index = 5;
            default -> {

                return;
            }
        }
        parentalLevelQueue[index].push(data);
    }


    public void createQueuesForParentalLevels() {
        StackOfStudents tempStackM = new StackOfStudents();
        StackOfStudents tempStackF = new StackOfStudents();
        while (!stackOfStudents1.isEmpty()) {
            Student student = stackOfStudents1.pop();
            tempStackM.push(student);
            push(student);
        }
        while (!stackOfStudents2.isEmpty()) {
            Student student = stackOfStudents2.pop();
            tempStackF.push(student);
            push(student);
        }

        // restoring our stack
        while (!tempStackM.isEmpty()){
            Student student = tempStackM.pop();
            stackOfStudents1.push(student);
        }
        while (!tempStackF.isEmpty()){
            Student student = tempStackF.pop();
            stackOfStudents2.push(student);
        }


    }


    void displayQueues() {
        for (int i = 0; i < 5; i++) {
            Node current = parentalLevelQueue[i].next;
            System.out.println((i+1)+ " : Queue for Parental Level: " );
            System.out.println("-----------------------------");

            if (current != null) {
                System.out.println("Parental Level: " + current.data.parentalLevel);
            }
            // Iterate through the students in the queue and print their details
            while (current != null) {
                System.out.println("Student: Average Marks - " + current.data.averageMarks() + ", Gender - " + current.data.gender);
                current = current.next;
            }
            System.out.println();
        }
    }



    public void checkLength(int length) {
        if (length >= parentalLevelQueue.length) {
            resizeQueuesArray();
        }
    }

    public void resizeQueuesArray() {
        int size = parentalLevelQueue.length;
        Node[] newQueue = new Node[2 * size];
        System.arraycopy(parentalLevelQueue, 0, newQueue, 0, size);
        parentalLevelQueue = newQueue;


    }

    public void betterPerformanceAtParentalLevel(){
        genderPerformanceFinder(parentalLevelQueue[0].next);
        genderPerformanceFinder(parentalLevelQueue[1].next);
        genderPerformanceFinder(parentalLevelQueue[2].next);
        genderPerformanceFinder(parentalLevelQueue[3].next);
        genderPerformanceFinder(parentalLevelQueue[4].next);
    }


    public void genderPerformanceFinder(Node head) {
        Node temp = head;
        String pl = head.data.parentalLevel;
        double male = 0, female = 0;
        int maleSize = 0;
        int femaleSize=0;

        while (temp != null && temp.data != null) {
            if (Objects.equals(temp.data.gender, "female")) {
                female += temp.data.averageScore;
                femaleSize++;
            } else {
                male += temp.data.averageScore;
                maleSize++;
            }

            temp = temp.next;
        }




        System.out.println("Performance Of Male Parental Level : " + pl + " : " + male / maleSize);
            System.out.println("Performance Of Female Parental Level : " + pl + " : " + female / femaleSize);
            if (male / maleSize > female / femaleSize) {
                System.out.println("Male performs better");
            } else if (male / maleSize < female / femaleSize) {
                System.out.println("Female performs better");
            }


        }

        public void groupPerformanceAtParentalLevel() {
            groupPerformanceFinder(parentalLevelQueue[0].next);
            groupPerformanceFinder(parentalLevelQueue[1].next);
            groupPerformanceFinder(parentalLevelQueue[2].next);
            groupPerformanceFinder(parentalLevelQueue[3].next);
            groupPerformanceFinder(parentalLevelQueue[4].next);
        }



    public void groupPerformanceFinder(Node head) {
        Node temp = head;
        String[] groups = {"group A", "group B", "group C", "group D", "group E"};
        double[] avgMarks = new double[groups.length];

                while (temp != null && temp.data != null) {
               for (int i = 0; i < groups.length; i++) {
                if (Objects.equals(temp.data.group, groups[i])) {
                    avgMarks[i] += temp.data.averageScore;

                }
            }
            temp = temp.next;
        }


        double max = avgMarks[0];
        int maxIndex = 0;
        for (int i = 1; i < avgMarks.length; i++) {
            if (avgMarks[i] > max) {
                max = avgMarks[i];
                maxIndex = i;
            }
        }


        System.out.println("The group with the highest average marks is: " + groups[maxIndex] + " at parental Level : " + head.data.parentalLevel );
    }

    public void medianOfAvgOfMaleAndFemale(){
        medianOfAvgMarksFinder(stackOfStudents1);
        medianOfAvgMarksFinder(stackOfStudents2);
    }

    public void medianOfAvgMarksFinder(StackOfStudents stackOfStudents ){
        Node temp1 = stackOfStudents.head;
        temp1.sort();
        int size = temp1.size(temp1);
        int limit = size/2;
        double medianMarks ;
        if(size%2==1){
            for(int i=0;i<limit+1;i++){
                temp1 = temp1.next;
            }
            medianMarks = temp1.data.averageScore;
        }
        else{
            for(int i=0;i<limit;i++){
                temp1=temp1.next;
            }
            medianMarks = (temp1.data.averageScore + temp1.next.data.averageScore)/2;
        }

        System.out.println("Median of Given AVG marks of list of " + temp1.data.gender + " is : " + medianMarks);

    }


















}











