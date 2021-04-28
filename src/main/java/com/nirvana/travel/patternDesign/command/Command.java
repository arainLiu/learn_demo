package com.nirvana.travel.patternDesign.command;

public abstract class Command {
    public abstract void doit(); //exec run
    public abstract void undo();
}
