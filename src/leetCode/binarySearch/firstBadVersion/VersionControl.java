package leetCode.binarySearch.firstBadVersion;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-28
 */
public class VersionControl {
    /*
     * methods
     */
    public boolean isBadVersion(int version) {
        int bad = 9;
        return version >= bad;
    }
}
