class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i <numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int index = 0;
        int inc = -1;

                
        if(numRows <= 1)
            return s;
        
        for(int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));
            if(index == 0 || index == numRows-1) {
                inc = inc * -1;
            }
            index = index+inc;
        }

        for(int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}