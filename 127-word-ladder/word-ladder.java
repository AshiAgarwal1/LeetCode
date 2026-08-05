class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> set=new HashSet<>();
        for(String s: wordList){
            set.add(s);
        }
        if(!set.contains(endWord))
            return 0;
        set.remove(beginWord);
        
        while(!q.isEmpty()){
            Pair node=q.poll();
            String word=node.first;
            int steps=node.second;
            if(word.equals(endWord)) return steps;
        for(int i=0;i<word.length();i++){
            char[] replacedChar=word.toCharArray();
            for(char ch='a';ch<='z';ch++){
                
                if(replacedChar[i]==ch) continue;
                replacedChar[i]=ch;
                String replacedWord=new String(replacedChar);
                //if it exists in set
                if(set.contains(replacedWord)){
                    set.remove(replacedWord);
                    q.add(new Pair(replacedWord,steps+1));
                }
                //restore the word back for next iteration
                replacedChar[i]=word.charAt(i);
            }
        }
        }
        return 0;
    }
}