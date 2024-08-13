class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List <List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>(), answer);
        return answer;
    }

    public void dfs(int s, int[] candidates, int target, List<Integer> path, List<List<Integer>> answer){
        if(target < 0) 
        return;
        if(target == 0){
            answer.add(new ArrayList<>(path));
            return;
        } 
        for(int i = s ; i < candidates.length; ++i){
            if(i>s && candidates[i] == candidates[i-1])
            continue;
            path.add(candidates[i]);
            dfs(i+1, candidates, target-candidates[i], path, answer);
            path.remove(path.size()-1);
        }
    }
}