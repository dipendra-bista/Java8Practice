package com.punojsoft.java8practice;

public class LamdaClosoursExample {
    public static void main(String[] args) {
        int i = 10;
        int b = 20;//final hunxa read garna milxa tra assign garna mildaina
//        doProcess(i, new Process() {
//            @Override
//            public void process() {
//                //       b=30; compiler le error falxa
//                System.out.println("process id " + i * b);
//            }
//        });
        doProcess(1, (i1) -> System.out.println(i1 + b));

    }

    public static void doProcess(int i, Process p) {
        p.process(i);
    }
}

interface Process {
    void process(int i);
}
