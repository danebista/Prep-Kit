class Solution {
    class Profit{
        int profit;
        int capital;

        Profit(int profit, int capital){
            this.profit = profit;
            this.capital=capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Profit> list = new ArrayList<>();
        
        for (int i=0; i< profits.length; i++){
            list.add(new Profit(profits[i], capital[i]));
        }

        Collections.sort(list, (a,b)->(a.capital-b.capital));

        PriorityQueue<Profit> pq= new PriorityQueue<>((a,b)->(b.profit-a.profit));

        int i=0;
        int j=0;

        while (i<k){
            while (j<list.size() && list.get(j).capital<=w){
                pq.offer(list.get(j));
                j++;
            }
            if (pq.isEmpty()) break;
          
            Profit current = pq.poll();
            w+=current.profit;
            i++;
        }

        return w;
    }
}
