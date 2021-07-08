class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[]  result = new int[numCourses]; 
        int ii=0;
        int[] indegrees = new int[numCourses];
        
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            edges.add(new ArrayList<>());
        
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            edges.get(cp[1]).add(cp[0]);
        }
        
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);
        

        while(!queue.isEmpty()) {
            int pre = queue.poll();
            result[ii]=pre;
            ii++;
            numCourses--;
            for(int cur : edges.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        if(numCourses == 0) {

            return result;
        }

        return new int[]{} ;
        

    }
}