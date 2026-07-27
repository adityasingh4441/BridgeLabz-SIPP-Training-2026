public class CallStack {
    private static class Frame {
        private final String functionName;
        private final Frame next;

        private Frame(String functionName, Frame next) {
            this.functionName = functionName;
            this.next = next;
        }
    }

    private Frame top;

    public void push(String functionName) {
        top = new Frame(functionName, top);
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("No active call to return from");
        }
        String name = top.functionName;
        top = top.next;
        return name;
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("No active call");
        }
        return top.functionName;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        CallStack stack = new CallStack();
        stack.push("main");
        stack.push("helper");
        stack.push("leaf");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
