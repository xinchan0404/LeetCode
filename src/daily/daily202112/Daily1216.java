package daily.daily202112;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1610. 可见点的最大数目
 * 提示：
 * 1 <= points.length <= 105
 * points[i].length == 2
 * location.length == 2
 * 0 <= angle < 360
 * 0 <= posx, posy, xi, yi <= 100
 *
 * @author xinchan
 * @version 1.0.1 2021-12-16
 */
public class Daily1216 {
    public static void main(String[] args) {
        /*
         * 测试 visiblePoints()
         */
        Daily1216 daily1216 = new Daily1216();

        List<List<Integer>> points = new ArrayList<>();
        List<Integer> point = new ArrayList<>();
        point.add(2);
        point.add(1);
        points.add(point);
        point.clear();
        point.add(2);
        point.add(2);
        points.add(point);
        point.clear();
        point.add(2);
        point.add(3);
        points.add(point);
        int angle = 90;
        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);

        int num = 0;

        num = daily1216.visiblePoints(points, angle, location);

        System.out.println(num);
    }

    /**
     * 可见点的最大数目
     *
     * @param points
     * @param angle
     * @param location
     * @return
     */
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameCnt = 0;
        int xLoc = location.get(0);
        int yLoc = location.get(1);
        List<Double> pointsDegrees = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            /*
             * 记录与 location 重合的点数
             */
            if (xLoc == points.get(i).get(0) && yLoc == points.get(i).get(1)) {
                sameCnt++;
                continue;
            }
            /*
             * 将直角坐标系转换为极坐标系
             */
            double degree = Math.atan2(yLoc - points.get(i).get(0), xLoc - points.get(i).get(1));
            pointsDegrees.add(degree);
        }
        Collections.sort(pointsDegrees);

        /*
         *
         */
        int size = pointsDegrees.size();
        for (int i = 0; i < size; i++) {
            pointsDegrees.add(pointsDegrees.get(i) + 2 * Math.PI);
        }

        int maxCnt = 0;
        int right = 0;
        double angle2Degree = angle * Math.PI / 180;
        for (int i = 0; i < size; i++) {
            double maxDegree = pointsDegrees.get(i) + angle2Degree;
            while (right < pointsDegrees.size() && pointsDegrees.get(right) <= maxDegree) {
                right++;
            }
            maxCnt = Math.max(maxCnt, right - i);
        }

        return maxCnt + sameCnt;
    }
}
