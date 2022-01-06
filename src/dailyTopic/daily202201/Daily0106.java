package dailyTopic.daily202201;

import java.util.*;

/**
 * 71. 简化路径
 *
 * @author xinchan
 * @version 1.0.1 2022-01-06
 */
public class Daily0106 {
    public static void main(String[] args) {
        Daily0106 daily0106 = new Daily0106();
//        String path = "/home//";
//        String path = "/../";
        String path = "/a/./b/../../c/";
        String simplifyPath = "";
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            simplifyPath = daily0106.simplifyPath(path);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        System.out.println(simplifyPath);
    }

    /**
     * 简化路径
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Deque<String> deque = new ArrayDeque<>();

        for (String s : strings) {
            if (s.equals("..") && !deque.isEmpty()) {
                deque.removeLast();
            } else if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
                deque.addLast(s);
            }
        }

        StringBuilder simplifyPath = new StringBuilder("/");
        while (!deque.isEmpty()) {
            simplifyPath.append(deque.removeFirst());
            if (deque.size() != 0) {
                simplifyPath.append("/");
            }
        }

        return simplifyPath.toString();
    }
}
