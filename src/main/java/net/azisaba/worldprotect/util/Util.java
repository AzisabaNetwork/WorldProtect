package net.azisaba.worldprotect.util;

public class Util {
    public static boolean stacktraceContains(String s) {
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.toString().contains(s)) {
                return true;
            }
        }
        return false;
    }
}
