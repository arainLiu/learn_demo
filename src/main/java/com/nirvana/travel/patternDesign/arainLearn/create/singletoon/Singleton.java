package com.nirvana.travel.patternDesign.arainLearn.create.singletoon;

/**
 * @author arainliu
 * @date 2023/2/15
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {
    }

    public Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
