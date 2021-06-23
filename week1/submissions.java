
class Solution {
    public int[] plusOne(int[] digits) 
    {
        String num="";
        boolean flg=false;
        for(int i= digits.length-1;i>=0;i--){
            digits[i]+=1;
            digits[i]=digits[i]%10;
            if (digits[i] != 0) break;
        
            

        }


        if(digits[0]==0){

            digits= new int[digits.length+1];

            digits[0]=1;
        }
        return digits;

    }
}