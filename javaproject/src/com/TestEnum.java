package com;

/**
 * Created by doshest on 2017/7/14.
 */
public class TestEnum {
    public static void main(String[] args) {
        WeekEnum week = WeekEnum.TUES;
        switch (week) {
            case MON:
                System.out.println("星期一");
                break;
            case TUES:
                System.out.println("星期二");
                break;
            case WED:
                System.out.println("星期三");
                break;
            case THURS:
                System.out.println("星期四");
                break;
            case FRI:
                System.out.println("星期五");
                break;
            case SAT:
                System.out.println("星期六");
                break;
            case SUN:
                System.out.println("星期天");
                break;
        }
    }
}
