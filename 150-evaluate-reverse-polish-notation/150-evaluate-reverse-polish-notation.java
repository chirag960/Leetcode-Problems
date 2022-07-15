class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int n = stack.pop() + stack.pop();
                stack.push(n);
            } else if(s.equals("-")){
                int n = -(stack.pop() - stack.pop());
                stack.push(n);
            }else if(s.equals("*")){
                int n = stack.pop() * stack.pop();
                stack.push(n);
            }else if(s.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                int n = a / b;
                stack.push(n);
            } else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}