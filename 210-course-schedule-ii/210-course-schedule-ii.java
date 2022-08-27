class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
                int ans[] = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>(numCourses);

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        if(checkCycle(numCourses, adj)){
            return new int[]{};
        }

        boolean[] visited = new boolean[numCourses];

        Stack<Integer> stack = new Stack<>();

        for(int v=0;v<numCourses;v++){
            if(!visited[v])
                topologicalSort(v, visited, adj ,stack);
        }

        int ind=0;
        while(!stack.empty()){
            int i = stack.pop();
            ans[ind] = i;
            ind++;
        }

        return ans;
    }
    
        public static void topologicalSort(
            int v, boolean[] visited, List<List<Integer>> adj, Stack<Integer> stack){
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj.get(v).iterator();
        while(it.hasNext()){
            i = it.next();
            if(!visited[i]){
                topologicalSort(i, visited, adj, stack);
            }
        }
        stack.push(v);
    }

    public static boolean isCycle(int v, List<List<Integer>> adj, boolean[] visited, boolean[] recStack){
        if(recStack[v]){
            return true;
        }

        if(visited[v]){
            return false;
        }

        visited[v] = true;

        recStack[v] = true;
        List<Integer> child = adj.get(v);
        for(Integer c : child){
            if(isCycle(c,adj,visited,recStack)){
                return true;
            }
        }

        recStack[v] = false;
        return false;

    }

    public static boolean checkCycle(int numCourses, List<List<Integer>> adj){
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(isCycle(i,adj,visited,recStack))
                return true;
        }
        return false;
    }
}