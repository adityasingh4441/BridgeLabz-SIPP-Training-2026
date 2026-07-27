public class PacketBuffer {
    private final int[] data;
    private int front;
    private int count;

    public PacketBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        this.data = new int[capacity];
        this.front = 0;
        this.count = 0;
    }

    public boolean enqueue(int packetId) {
        if (count == data.length) {
            return false;
        }
        int rearIndex = (front + count) % data.length;
        data[rearIndex] = packetId;
        count++;
        return true;
    }

    public int dequeue() {
        if (count == 0) {
            throw new RuntimeException("Buffer empty");
        }
        int value = data[front];
        front = (front + 1) % data.length;
        count--;
        return value;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == data.length;
    }

    public static void main(String[] args) {
        PacketBuffer buffer = new PacketBuffer(3);
        System.out.println(buffer.enqueue(10));
        System.out.println(buffer.enqueue(20));
        System.out.println(buffer.enqueue(30));
        System.out.println(buffer.enqueue(40));
        System.out.println(buffer.dequeue());
        System.out.println(buffer.enqueue(40));
        System.out.println(buffer.dequeue());
    }
}
