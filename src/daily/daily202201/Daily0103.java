package daily.daily202201;

/**
 * 1185. 一周中的第几天
 *
 * @author xinchan
 * @version 1.0.1 2022-01-03
 */
public class Daily0103 {
    public static void main(String[] args) {
        Daily0103 daily0103 = new Daily0103();
        int day = 18;
        int month = 7;
        int year = 1999;
        String dayOfTheWeek = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            dayOfTheWeek = daily0103.dayOfTheWeek(day, month, year);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(dayOfTheWeek);
    }

    /**
     * 一周中的第几天
     *
     * @param day
     * @param month
     * @param year
     * @return
     */
    public String dayOfTheWeek(int day, int month, int year) {
        /*
         * 1971.01.01 是 Friday
         */
        String[] dayInfo = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int[] dayOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int yearDiff = ((year - 1971) / 4 * 5) + ((year - 1971) % 4 == 0 ? 0 : (year - 1971) % 4 == 1 ? 1 : (year - 1971) % 4 == 2 ? 3 : 4);
        int dayMonthDiff = day;
        for (int i = 0; i < month - 1; i++) {
            dayMonthDiff += dayOfMonth[i];
        }
        if (year % 4 == 0 && month > 2 && year != 2100) {
            dayMonthDiff++;
        }
        int dayDiff = (dayMonthDiff % 7 + yearDiff - 1) % 7;

        return dayInfo[dayDiff];
    }
}
