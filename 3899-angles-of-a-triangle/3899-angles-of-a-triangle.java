class Solution {
    public double[] internalAngles(int[] sides) {
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];

        if((a+b)<=c || (c+b)<=a || (a+c)<=b){
            return new double[]{};
        }

        double[] angles = new double[3];

        double angleA = Math.toDegrees(Math.acos((double)(b*b+c*c-a*a)/(2*b*c)));
        double angleB = Math.toDegrees(Math.acos((double)(c*c+a*a-b*b)/(2*a*c)));
        double angleC = Math.toDegrees(Math.acos((double)(b*b-c*c+a*a)/(2*b*a)));

        angles[0] = angleA;
        angles[1] = angleB;
        angles[2] = angleC;

        Arrays.sort(angles);
        return angles;
    }
}