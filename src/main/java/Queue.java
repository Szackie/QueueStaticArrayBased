class Queue<T> {

    T[] queue;
    int capacity;
    int last = 0;
    int first = 0;

    Queue() {
        this(10);
    }

    Queue(int len) {
        this.capacity = len;
        this.queue = (T[]) new Object[len];
    }

    boolean isFull() {
        return queue[last] != null;
    }

    void enqueuing(T elem) {
        last = last % capacity;
        if (!isFull()) {
            queue[last] = elem;
            last++;
        } else
            throw new RuntimeException("Queue is Full");
    }

    T peek() {
        return queue[first];
    }

    void dequeuing() {
        if (queue[first] != null) {
            queue[first] = null;
            first = (1 + first) % capacity;
        }
    }

    public void tString() {
        for (int i = 0; i < capacity; i++)
            System.out.print(" " + queue[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Character> queue = new Queue<>();
        queue.dequeuing();
        queue.enqueuing('a');
        queue.enqueuing('b');
        queue.enqueuing('c');
        queue.enqueuing('d');
        queue.tString();
        queue.dequeuing();
        queue.tString();
        queue.enqueuing('f');
        queue.dequeuing();
        queue.tString();
        queue.enqueuing('g');
        queue.enqueuing('h');
        queue.enqueuing('i');
        queue.enqueuing('j');
        queue.enqueuing('k');
        queue.enqueuing('l');
        queue.enqueuing('m');
        queue.dequeuing();
        queue.enqueuing('m');
        queue.tString();
        System.out.println(queue.peek());
        queue.dequeuing();
        System.out.println(queue.isFull());
        queue.tString();
    }
}