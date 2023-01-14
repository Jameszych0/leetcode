package medium.greedy;

public class JumpGame55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int coverRange = 0;
        // 不用拘泥于每次究竟跳几步，而是看覆盖范围，覆盖范围内一定是可以跳过来的，不用管是怎么跳的。
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1)
                return true;
        }
        return false;
    }
}
