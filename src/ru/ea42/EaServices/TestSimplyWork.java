package ru.ea42.EaServices;

public class TestSimplyWork extends EaSimplyService {
    private int count = 0;

    public TestSimplyWork(String name) {
        super(name);
    }

    @Override
    protected void init() {
        System.out.println("start");
        timer.init(this, 2000, false);
    }

    @Override
    protected void finit() {
        System.out.println("stop");
        timer.finit();
    }

    @Override
    public void go() {
        count++;
        System.out.println("<== " + count + " ==>");
        if (count > 10) System.exit(0);
    }
}
