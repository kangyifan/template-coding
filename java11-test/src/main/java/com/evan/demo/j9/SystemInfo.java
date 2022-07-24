package com.evan.demo.j9;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/3/2022 8:34 PM
 */
public class SystemInfo {
    public static void main(String[] args) {

        ProcessHandle.allProcesses().forEach(processHandle -> {
            ProcessHandle.Info processInfo = processHandle.info();
            System.out.println(processHandle.pid());
            System.out.println(processInfo.commandLine().orElse(""));
            System.out.println(processInfo.arguments().isPresent());
            System.out.println(processInfo.command().isPresent());
            System.out.println(processInfo.command().map(cmd-> cmd.contains("java")).orElse(false));
            System.out.println(processInfo.startInstant().isPresent());
        });

//        String javaPrompt = processInfo.command().getAbsolutePath();
//        ProcessBuilder processBuilder = new ProcessBuilder(javaPrompt, "-version");
//        Process process = processBuilder.inheritIO().start();
//        ProcessHandle processHandle = process.toHandle();
    }
}
