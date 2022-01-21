package ru.ea42.EaServices;

public class DemoWork extends EaService {
    int count = 0;

    public DemoWork(App app) {
        super(app);
    }

    @Override
    protected void init() {
        oneDemoS();
        timer = new EaTimer(this, 200);
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
