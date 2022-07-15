class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recurFunction(n,0,"", result);
        return result;
    }

    public static void recurFunction(int openLeft, int closeLeft, String s, List<String> result){
        //System.out.println("Current string : " + s + " openleft is " + openLeft + " closeleft is " + closeLeft);
        if(openLeft > 0){
            recurFunction(openLeft-1, closeLeft+1, s+"(", result);
        }
        if(closeLeft > 0){
            recurFunction(openLeft, closeLeft-1, s+")", result);
        }
        if(openLeft == 0 && closeLeft == 0){
            //System.out.println("Adding result " + String.valueOf(s));
            result.add(String.valueOf(s));
        }
    }
}