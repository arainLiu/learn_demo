package com.nirvana.travel.patternDesign.state.thread;

public abstract class ThreadState_ {
    abstract void move(Action input);
    abstract void run();
}
