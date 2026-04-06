class Robot {
    private int h;
    private int w;
    private boolean hasMoved = false;
    private String dir;
    private int xCod = 0;
    private int yCod = 0;
    public Robot(int width, int height) {
        this.h = height;
        this.w = width;
        this.dir = "East";

    }

    public void step(int num) {
        if(num > 0){
            hasMoved = true;
        }
        num = num %(2*w + 2*h - 4);
        while(num > 0){
            switch (dir) {
                case "East" -> {
                    xCod++;
                    if (xCod == w) {
                        xCod--;
                        yCod++;
                        dir = "North";
                    }
                }
                case "North" -> {
                    yCod++;
                    if (yCod == h) {
                        yCod--;
                        xCod--;
                        dir = "West";
                    }
                }
                case "West" -> {
                    xCod--;
                    if (xCod == -1) {
                        xCod++;
                        yCod--;
                        dir = "South";
                    }
                }
                default -> {
                    yCod--;
                    if (yCod == -1) {
                        yCod++;
                        xCod++;
                        dir = "East";
                    }
                }
            }
            num--;
        }
    }

    public int[] getPos() {
        return new int[]{xCod,yCod};
    }

    public String getDir() {
        if(hasMoved){
            return (xCod == 0 && yCod == 0) ? "South" : dir;
        }
        else{
            return "East";
        }
    }
}