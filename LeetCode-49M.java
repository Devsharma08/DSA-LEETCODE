class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map <String,ArrayList<String>> hash = new HashMap<>();

      for(String str : strs){
        char[] charString = str.toCharArray();
        Arrays.sort(charString);

        String newString = new String(charString);

        if(!hash.containsKey(newString)){
            hash.put(newString,new ArrayList<>());
        }

        hash.get(newString).add(str);
      }

      return new ArrayList(hash.values());
}
}