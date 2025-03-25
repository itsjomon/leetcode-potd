class Solution {
    static class Pair {
        int value;
        int type;

        Pair(int value, int type) {
            this.value = value;
            this.type = type;
        }
    }

    private boolean countLineIntersections(List<Pair> coordinates) {
        int lines = 0;
        int overlap = 0;

        for (Pair coord : coordinates) {
            if (coord.type == 0) {
                overlap--;
            } else {
                overlap++;
            }

            if (overlap == 0) {
                lines++;
            }
        }

        return lines >= 3;
    }

  public boolean checkValidCuts(int n, int[][] rectangles) {
    List<Pair> yCoordinates = new ArrayList<>();
    List<Pair> xCoordinates = new ArrayList<>();

    for (int[] rectangle : rectangles) {
        
        yCoordinates.add(new Pair(rectangle[1], 1));
        yCoordinates.add(new Pair(rectangle[3], 0));

        xCoordinates.add(new Pair(rectangle[0], 1));
        xCoordinates.add(new Pair(rectangle[2], 0));
    }

    Comparator<Pair> comparator = (a, b) -> {
        if (a.value != b.value) return Integer.compare(a.value, b.value);
        return Integer.compare(a.type, b.type);
    };

    Collections.sort(yCoordinates, comparator);
    Collections.sort(xCoordinates, comparator);

    return countLineIntersections(yCoordinates) || countLineIntersections(xCoordinates);
}

}
