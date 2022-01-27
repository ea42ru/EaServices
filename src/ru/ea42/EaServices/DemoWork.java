package ru.ea42.EaServices;

public class DemoWork extends EaService {
    private int count = 0;

    @Override
    protected void init() {
        oneDemoS();
        timer.init(this, 200);
    }

    @Override
    protected void start() {
        oneDemoS();
        timer.on();
    }

    @Override
    protected void stop() {
        oneDemoS();
        timer.off();
    }

    @Override
    protected void finit() {
        oneDemoS();
        timer.finit();
    }

    @Override
    public void go() {
        count++;
        System.out.println("<== " + count + " ==>");
    }

    private void oneDemoS() {
        try {
            Thread.sleep(1000);
        } catch (Exception ignore) {
        }
    }

}
