class Solution {
    public boolean parseBoolExpr(String s) {
        Stack<Integer> stack = new Stack();
        List<Character> index = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '&' || s.charAt(i) == '|'
                    || s.charAt(i) == '!') {
                stack.push(i);
            }
            index.add(s.charAt(i));
        }

        while (!stack.isEmpty()) {
            int startIndex = stack.pop();
            char startCar = index.get(startIndex);
            int ind = startIndex + 2;

            int truth = 0;
            int falsity = 0;
            while (index.get(ind) != ')') {
                if (index.get(ind) == 't')
                    truth++;
                if (index.get(ind) == 'f')
                    falsity++;
                ind++;
            }

            char result = evaluator(startCar, truth, falsity);
            for (int i = ind; i >= startIndex; i--) {

                index.remove(i);
            }
            index.add(startIndex, result);
        }

        return index.get(0) == 't';

    }

    public Character evaluator(Character value, int truth, int falsity) {

        if (value == '|') {
            if (truth <= 0 && falsity > 0)
                return 'f';
            return 't';
        } else if (value == '&') {
            if (truth > 0 && falsity == 0)
                return 't';
            return 'f';
        }

        if (truth > 0)
            return 'f';

        return 't';
    }
}
