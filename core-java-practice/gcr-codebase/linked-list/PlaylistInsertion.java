package linkedlist;

public class PlaylistInsertion {
    public void insertAfter(Node current, int trackId) {
        if (current == null) {
            return;
        }
        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
    }
}
