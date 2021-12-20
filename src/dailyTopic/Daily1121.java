package dailyTopic;

/**
 * 1154. 一年中的第几天
 * 提示：
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 *
 * @author xinchan
 * @version 1.0.1 2021-12-20
 */
public class Daily1121 {
    public static void main(String[] args) {
        /*
         * 测试 dayOfYear()
         */
        Daily1121 daily1121 = new Daily1121();
        String date = "2019-01-09";
//        String date = "2004-03-01";
//        String date = "2000-12-04";
        int dayOfYear = 0;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            dayOfYear = daily1121.dayOfYear(date);  // 1000000: 157 ms
            dayOfYear = daily1121.dayOfYear1(date);  // 1000000: 63 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        System.out.println(dayOfYear);
    }

    /**
     * 一年中的第几天 - split()
     *
     * @param date
     * @return
     */
    public int dayOfYear(String date) {
        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dateArray = date.split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int dayOfYear = 0;

        for (int i = 0; i < month - 1; i++) {
            dayOfYear += dayOfMonth[i];
        }
        if (month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            dayOfYear += 1;
        }

        return dayOfYear + Integer.parseInt(dateArray[2]);
    }

    /**
     * 一年中的第几天 - toCharArray()
     *
     * @param date
     * @return
     */
    public int dayOfYear1(String date) {
        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int dayOfYear = 0;

        for (int i = 0; i < month - 1; i++) {
            dayOfYear += dayOfMonth[i];
        }
        if (month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            dayOfYear += 1;
        }

        return dayOfYear + Integer.parseInt(date.substring(8, 10));
    }
}
