class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            if (token.length() >= 2 && Character.isDigit(token.charAt(1))|| Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer b;
                Integer a;
                if (!stack.isEmpty()) {
                    b = stack.pop();
                } else {
                    return -1;
                }
                if (!stack.isEmpty()) {
                    a = stack.pop();
                } else {
                    return -1;
                }
                if (token.equals("+")) {
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    stack.push(a - b);
                } else if (token.equals("*")) {
                    stack.push(a * b);
                } else {
                    stack.push(a / b);
                }
            }
        }
        return stack.peek();
    }
}
