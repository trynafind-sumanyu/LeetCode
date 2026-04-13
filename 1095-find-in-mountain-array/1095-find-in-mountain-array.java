/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int s = 0;
        int e = mountainArr.length()-1;
        while(s<e){
            int mid = s+(e-s)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                e = mid ;
            }else {
                s = mid + 1;
            }
        }
        int newStart = 0;
        int newEnd = e ;
        while (newStart<=newEnd){
            int mid = newStart+(newEnd-newStart)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }else if(mountainArr.get(mid)<target){
                newStart = mid +1;
            }else {
                newEnd = mid -1;
            }
        }
        int newEnd2 = mountainArr.length() -1;
        int newStart2 = s;
        while (newStart2<=newEnd2){
            int mid = newStart2+(newEnd2-newStart2)/2;
            if (mountainArr.get(mid)==target){
                return mid;
            }else if(mountainArr.get(mid)<target){
                newEnd2 = mid -1;
            }else {
                newStart2 = mid + 1;
            }
        }
        return -1;
    }
    
}