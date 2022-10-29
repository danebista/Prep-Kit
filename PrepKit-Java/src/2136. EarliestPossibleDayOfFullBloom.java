class Solution {
    class PlantData {
        public int plantTime;
        public int growTime;

        PlantData(int plantTime, int growTime) {
            this.plantTime = plantTime;
            this.growTime = growTime;
        }

    }

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<PlantData> list = new ArrayList();

        for (int i = 0; i < plantTime.length; i++) {
            list.add(new PlantData(plantTime[i], growTime[i]));
        }

        Collections.sort(list, (a, b) -> b.growTime - a.growTime);

        int startTime = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            startTime += list.get(i).plantTime;
            max = Math.max(max, startTime + list.get(i).growTime);
        }

        return max;
    }
}
