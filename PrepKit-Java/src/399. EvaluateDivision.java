class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> hashmap = new HashMap<>();
        
        for(int i=0; i< equations.size(); i++){
            List<String> val = equations.get(i);
            if (!hashmap.containsKey(val.get(0))){
                hashmap.put(val.get(0), new HashMap<>());
            }

            if (!hashmap.containsKey(val.get(1))){
                hashmap.put(val.get(1), new HashMap<>());
            }

            hashmap.get(val.get(0)).put(val.get(1), values[i]);
            hashmap.get(val.get(1)).put(val.get(0), 1/values[i]);
        }
        
        double[] res = new double[queries.size()];
        Arrays.fill(res,-1);
        int i=0;
        for (List<String> query: queries){
            String start = query.get(0);
            String end = query.get(1);
            int curr=i;
            if (!hashmap.containsKey(start) || !hashmap.containsKey(end)) {
                res[i++] =  -1;
                continue;
            }
            else if (start.equals(end)){
                res[i++] = 1;
                continue;
            }
            Queue<Pair>queue = new LinkedList<>();
            Pair newP = new Pair(start, 1.0);
            queue.offer(newP);
            System.out.println(start+"->"+end);
              
            Map<String, Boolean>visited = new HashMap<>();
            visited.put(start, true);
            while (!queue.isEmpty()){
                Pair<String, Double> pair = queue.poll();
                String s = pair.getKey();
                Double val= pair.getValue();
                System.out.println(s+"->"+val +"->"+ res[i]);
              
                if (s.equals(end)){
                    System.out.println("hello->"+val);
                    res[i++] = val;
                    break;
                }
                for (Map.Entry<String, Double> valuesOfTime: hashmap.get(s).entrySet()){
                    String tempKey = valuesOfTime.getKey();
                    Double tempVal =  valuesOfTime.getValue();
                    if (visited.containsKey(tempKey)) continue;
                    queue.offer(new Pair(tempKey, val * tempVal));
                    visited.put(tempKey, true);
                }
            }

            if (curr==i)i++;
            
        }

        return res;
    }
}

