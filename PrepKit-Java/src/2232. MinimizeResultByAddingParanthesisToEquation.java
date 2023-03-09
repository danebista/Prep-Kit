class Solution {
    public String minimizeResult(String s) {
        int indexOfAdder = s.indexOf("+");
        int currMin=Integer.MAX_VALUE;
        StringBuilder sb= new StringBuilder();

        for (int i=0; i< indexOfAdder; i++){
            int n1=0;
            if (i==0) n1=1;
            else n1 = Integer.parseInt(s.substring(0,i));
            int n2=Integer.parseInt(s.substring(i, indexOfAdder));
            for (int j=indexOfAdder+1; j< s.length(); j++){
                int n3 = Integer.parseInt(s.substring(indexOfAdder+1, j+1));
                int n4=1;
                if (j== s.length()-1) n4=1;
                else n4 = Integer.parseInt(s.substring(j+1));
                int val = n1*(n2+n3)*n4;
                if (val< currMin){
                    currMin = val;
                    sb.setLength(0);
                    if (i==0){sb.append("(");}
                    else {  
                        sb.append(s.substring(0,i));
                        sb.append("(");
                    }
                    sb.append(s.substring(i, indexOfAdder));
                    sb.append("+");
                    sb.append(s.substring(indexOfAdder+1, j+1));
                    sb.append(")");
                    if (j!=s.length()-1){
            
                        sb.append(s.substring(j+1));
                    }
                    
                }
            }
        }

        return sb.toString();
    }
}
