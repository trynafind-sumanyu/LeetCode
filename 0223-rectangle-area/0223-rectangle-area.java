class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        long area1 = (long)(Math.abs(ax1-ax2)*Math.abs(ay1-ay2));
        long area2 = (long)(Math.abs(bx1-bx2)*Math.abs(by1-by2));

        long widthOverLap = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        long heightOverLap = Math.min(ay2, by2) - Math.max(ay1, by1);

        long overLapArea = Math.max(0,widthOverLap)*Math.max(0,heightOverLap);

        return (int)(area1 - overLapArea + area2);
    }
}