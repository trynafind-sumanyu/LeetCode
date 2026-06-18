class Solution {
    public double angleClock(int hour, int minutes) {
        double angleMinute = (double)(minutes)*6.0;

        double angleHour = (double)(hour%12)*30.0 + 0.5*minutes;

        double ans = Math.abs(angleHour - angleMinute);

        return Math.min(ans,360 - ans);
    }
}

/*
  60 min ---- 360

  1 min ----- 360/60

  12 hour ---- 360

  1 hour ------ 360/12 = 30

  60 ----- 30
  1 ------ 30/60 ---- 0.5



 */