class Solution {
    public int lengthOfLongestSubstring(String string) {
        Integer leftPointer = 0;
		Integer rightPointer = 0;
		Integer length = string.length();
		Integer result = 0;
		
		HashMap <Character,Integer> characterStore = new HashMap<Character,Integer>();
		
		while (rightPointer < length) {
			
			if (characterStore.containsKey(string.charAt(rightPointer))){
				
				int temp = characterStore.get(string.charAt(rightPointer));
				for (int i=leftPointer; i<characterStore.get(string.charAt(rightPointer)); i++) {
					characterStore.remove(string.charAt(i));
				}
				leftPointer = temp+1;
				characterStore.put(string.charAt(rightPointer), rightPointer);
					
			}
			else {
				characterStore.put(string.charAt(rightPointer),rightPointer);
			}
			
			//Maintain the Longest Substring
			
			if (characterStore.size() > result)
				result = characterStore.size();
			rightPointer++;
			
		}
		
		return result;
}
}
