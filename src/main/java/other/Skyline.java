package other;

import java.util.List;

/*
    create start and end of each building
    sort by x values.
    Move from L to R
    on start, push height in PriorityQueue(PQ)
        if max(PQ) changes, taller building is found and it needs to be part of answer
    on end, remove from PQ, if max(PQ) changed, it needs to be part of answer

    Edge cases:
    if buildings have same start, pick building with higher height first.
    if ends are same, pick building with lower height.
    if end of building A overlaps with end of building B, pick start of next building first.

    Time Complexity: O(logN) with TreeMap
 */
public class Skyline {

    public List<int[]> getSkyline(int[][] buildings){
        BuildingPoint[] points = new BuildingPoint[buildings.length];
    }

    static class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        int h;
        boolean start;

        public int compareTo(BuildingPoint p) {
            return this.x != p.x ? this.x - p.x : (this.start? -this.h : this.h) - (p.start? -p.h : p.h);
        }
    }
}
