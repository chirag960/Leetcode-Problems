class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
        
        for(List<String> ticket : tickets){
            adjMap.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        
        LinkedList<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        
        stack.push("JFK");
        
        while(!stack.isEmpty()){
            String place = stack.peek();
            
            if(!adjMap.getOrDefault(place, new PriorityQueue<>()).isEmpty()){
                stack.push(adjMap.get(place).poll());
                System.out.println("Pushed to stack " + stack.peek());
            }else{
                System.out.println("Adding to result " + stack.peek());
                result.addFirst(stack.pop());
                
            }            
        }
        return result;
    }
}