package com.punojsoft.java8practice;

public class ThisReferenceInLamdaExample {

    public void doProcess(int i, Process p) {
        p.process(i);
    }

    public void execute() {
        doProcess(10, i -> {
            System.out.println("value of i is " + i);
            System.out.println(this);
        });
    }

    public static void main(String[] args) {
        ThisReferenceInLamdaExample thisReferenceInLamdaExample = new ThisReferenceInLamdaExample();
/**
 * java 7 ma this reference lai anonymous inner class
 * ko instance lai override garxa actual this lai
 */
        //        thisReferenceInLamdaExample.doProcess(10, new Process() {
//            @Override
//            public void process(int i) {
//                System.out.println("value of i is " + i);
//                System.out.println(this);
//            }
//
//            @Override
//            public String toString() {
//                return "This is the anonymous inner class!";
//            }
//        });

        /**
         * java lamdama this lai ovveride gardaina
         * so this same nai hunxa
         */

//        thisReferenceInLamdaExample.doProcess(10, i -> {
//            System.out.println("value of i is " + i);
////            System.out.println(this); this will not work
//        });

        thisReferenceInLamdaExample.execute();
    }

}

