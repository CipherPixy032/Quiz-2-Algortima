public class DoubleLinkedList {
    Node head, tail;
    int size;

    DoubleLinkedList(){
        head = tail = null;
        size = 0;
    }

    boolean isEmpty(){
        return size == 0;
    }

    void addFirst(int data){
        Node nu = new Node(data);
        if(isEmpty()){
            head = tail = nu;
        } else {
            nu.n = head;
            head.p = nu;
            head = nu;
        }
        size++;
    }

    void deleteFirst(){
        if (!isEmpty()) {
            head = head.n;
            if (head != null) {
                head.p = null;
            } else {
                tail = null;
            }
            size--;
        }
    }

    void print(){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.data + "-");
            tmp = tmp.n;
        }
        System.out.println("");

    }

    // 1. complete the missing code addLast
    void addLast(int data){
        Node nu = new Node(data);
        if(isEmpty()){
            head = tail = nu;
        } else {
            tail.n = nu;
            nu.p = tail;
            tail = nu;
        }
        size++;
    }

    // 2. complete the deleteLast
    void deleteLast(){
        if (!isEmpty()) {
            tail = tail.p;
            if (tail != null) {
                tail.n = null;
            } else {
                head = null;
            }
            size--;
        }
    }

    // 3. complete the printFromTail
    void printFromTail(){
        Node tmp = tail;
        while(tmp != null){
            System.out.print(tmp.data + "-");
            tmp = tmp.p;
        }
        System.out.println("");
    }

    // 4. complete getPositionFromTail
    int getPositionFromTail(int data){
        Node tmp = tail;
        int position = 1;
        while (tmp != null) {
            if (tmp.data == data) {
                return position;
            }
            tmp = tmp.p;
            position++;
        }
        return -1;
    }

    // 5. complete getLastPositionFromTail
    int getLastPositionFromTail(int data){
        Node tmp = tail;
        int position = 1;
        int lastPosition = -1;
        while (tmp != null) {
            if (tmp.data == data) {
                lastPosition = position;
            }
            tmp = tmp.p;
            position++;
        }
        return lastPosition;
    }

    // 6. complete getAverage
    double getAverage(){
        if (isEmpty()) {
            return 0;
        }
        Node tmp = head;
        double sum = 0;
        while (tmp != null) {
            sum += tmp.data;
            tmp = tmp.n;
        }
        return sum / size;
    }

    // 7. complete the missing code getNodeByIndex
    Node getNodeByIndex(int index){
        if (index < 0 || index >= size) {
            return null;
        }
        Node tmp = head;
        for(int i = 0; i < index; i++){
            tmp = tmp.n;
        }
        return tmp;
    }

    // 8. complete getMedian
    double getMedian(){
        if (isEmpty()) {
            return 0;
        }
        sort();
        if (size % 2 == 1) {
            return getNodeByIndex(size / 2).data;
        } else {
            return (getNodeByIndex(size / 2 - 1).data + getNodeByIndex(size / 2).data) / 2.0;
        }
    }

    void sort() {
        for(int i = 0; i < size - 1; i++){
            for(int j = 0; j < size - i - 1; j++){
                Node node1 = getNodeByIndex(j);
                Node node2 = getNodeByIndex(j + 1);
                if(node1.data > node2.data){
                    int tmp = node1.data;
                    node1.data = node2.data;
                    node2.data = tmp;
                }
            }
        }
    }

    // 9. complete main to make a simulation
    public static void main(String[] args){
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addFirst(45);
        dll.addFirst(10);
        dll.addFirst(10);
        dll.addFirst(15);
        dll.addFirst(150);
        dll.print();
        dll.deleteFirst();
        dll.print();
        dll.addLast(5);
        dll.addLast(20);
        dll.print();
        dll.deleteLast();
        dll.print();
        dll.printFromTail();
        System.out.println("Position of 10 from tail: " + dll.getPositionFromTail(10));
        System.out.println("Last position of 10 from tail: " + dll.getLastPositionFromTail(10));
        System.out.println("The Average: " + dll.getAverage());
        System.out.println("The Median: " + dll.getMedian());
    }
}