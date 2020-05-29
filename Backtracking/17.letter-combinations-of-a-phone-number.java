import java.util.ArrayList;

/*
17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});

        letterCombinations(digits, 0, map, result, new StringBuilder());
        return result;
    }

    private void letterCombinations(String digits, int index, Map<Character, char[]>, List<String> result, StringBuilder sb) {
        if(index == digits.length()) {
            result.add(new String(sb));
            return;
        }

        Character ch = digits.charAt(index);
        char[] arr = map.get(ch);
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            letterCombinations(digits, index+1, map, result, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}