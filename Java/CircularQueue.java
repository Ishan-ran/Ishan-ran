import java.util.Scanner; 
public class CircularQueue {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int max = 100;
            int[] queue = new int[max];
            int front = -1, rear = -1;

            while (true) {
                System.out.println("\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> { 
                        if ((rear + 1) % max == front) { 
                            System.out.println("Queue Overflow!");
                        } else {
                            if (front == -1) {
                                front = 0; 
                            }
                            System.out.print("Enter element to enqueue: ");
                            int elem = sc.nextInt();
                            rear = (rear + 1) % max;
                            queue[rear] = elem;
                            System.out.println(elem + " enqueued to queue.");
                        }
                    }

                    case 2 -> { 
                        if (front == -1) { 
                            System.out.println("Queue Underflow!");
                        } else {
                            System.out.println(queue[front] + " dequeued from queue.");
                            if (front == rear) { 
                                front = rear = -1; 
                            } else {
                                front = (front + 1) % max;
                            }
                        }
                    }

                    case 3 -> { 
                        if (front == -1) {
                            System.out.println("Queue is empty.");
                        } else {
                            System.out.println("Queue elements:");
                            int i = front;
                            while (i != rear) {
                                System.out.println(queue[i]);
                                i = (i + 1) % max;
                            }
                            System.out.println(queue[rear]); 
                        }
                    }

                    case 4 -> {
                        System.out.println("Exiting...");
                        return;
                    }

                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}