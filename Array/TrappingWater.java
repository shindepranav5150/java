class TrappingWater{
    public static int trappingWater(int height[]){

        int n = height.length;

        if(n<=2)
        return 0;
        
        // left max boundary
        int leftMaxBoundary [] = new int[n];
        leftMaxBoundary[0] = height[0];
        for(int i=1;i<n;i++){
            leftMaxBoundary[i] = Math.max(leftMaxBoundary[i-1],height[i]);
        }

        // right max Boundary
        int rightMaxBoundary [] = new int[n];
        rightMaxBoundary[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMaxBoundary[i] = Math.max(rightMaxBoundary[i+1],height[i]);
        }

        int trapped = 0;
        for(int i=0;i<n;i++){
            //waterLevel = min(leftMaxBoundary,rightMaxBoundary)
            int waterLevel = Math.min(leftMaxBoundary[i],rightMaxBoundary[i]);

            //trappedWater = waterLevel - height
            trapped += (waterLevel-height[i]);
        }

        return trapped;
    }
    public static void main(String args[]){
        int height[] = {4,5,7,8,0,6,3,2,5};

        System.out.println(trappingWater(height));
    }
}