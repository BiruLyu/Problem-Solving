private List<Point> nearestKPoint_1(List<Point> list, final Point center, int k) {
    List<Point> ans = new ArrayList<>();
    PriorityQueue<Point> maxHeap = new PriorityQueue<>(k + 1, new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return distance(center, o2) - distance(center, o1);
        }
    });
    for (Point p : list) {
        maxHeap.offer(p);
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
    }
    Iterator<Point> i = maxHeap.iterator();
    while (i.hasNext()) {
        ans.add(i.next());
    }
    return ans;
}

public int distance(Point p1, Point p2) {
    return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
}

static class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}