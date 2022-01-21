package ru.ea42.EaServices;

import java.util.concurrent.atomic.AtomicBoolean;

public class EaTimer extends Thread {
    public interface CallBack {
        void go();
    }

    private CallBack call;
    private int sleepMs = 0;
    private AtomicBoolean on = new AtomicBoolean(false);
    private AtomicBoolean inWorks = new AtomicBoolean(false);
    private AtomicBoolean pause = new AtomicBoolean(true);

    public EaTimer(CallBack goObj, int timeMs) {
        super();
        call = goObj;
        sleepMs = timeMs;
        on.set(true);
        pause.set(true);
        this.start();
    }

    public void on() {
        pause.set(false);
    }

    public void off() {
        pause.set(true);
    }

    public void run() {
        inWorks.set(true);
        while (on.get()) {
            if (pause.get()) oneMs();
            else {
                if (call != null) call.go();
                for (int i = 0; i < sleepMs; i++) {
                    if (!on.get()) break;
                    oneMs();
                }
            }
        }
        inWorks.set(false);
    }

    public void finit() {
        on.set(false);
        while (inWorks.get()) oneMs();
        // this.interrupt();
        //this.stop();
        call = null;
    }

    private void oneMs() {
        try {
            Thread.sleep(1);
        } catch (Exception ignore) {
        }
    }
}