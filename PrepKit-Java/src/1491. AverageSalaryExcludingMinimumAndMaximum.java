class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int sum=0;
        for (int i=1; i<salary.length-1; i++){
            sum+=salary[i];
        }
        System.out.println(sum);
        System.out.println(salary.length);
        double val = (double) sum/(salary.length-2);

        return val;
    }
}
