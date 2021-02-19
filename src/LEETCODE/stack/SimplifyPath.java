package LEETCODE.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 71. Simplify Path
 * Medium
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 * <p>
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 * <p>
 * The canonical path should have the following format:
 * <p>
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 * <p>
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 * <p>
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 */
public class SimplifyPath {
    public static void main(String[] args) {

        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/../fine"));
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath( "/a/../../b/../c//.//"));




    }

    private static String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();

        int N = paths.length;
        boolean validPathSeen = false;
        for (int i = N - 1; i >= 0; i--) {
            if (validPathSeen && paths[i].contains("."))
                break;
            if (!paths[i].isEmpty() && !paths[i].isBlank() && !paths[i].contains(".")) {
                stack.push(paths[i]);
                validPathSeen = true;
            }
        }


        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pop());
        }

        if (sb.length() == 0)
            return "/";

        return String.valueOf(sb);
    }
}
