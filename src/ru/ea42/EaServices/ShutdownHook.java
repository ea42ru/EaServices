package ru.ea42.EaServices;

public class ShutdownHook extends Thread {
    public interface CallBack {
        void terminate();
    }

    private CallBack sh = null;

    public ShutdownHook(CallBack sh) {
        super();
        this.sh = sh;
        Runtime.getRuntime().addShutdownHook(this);
    }

    @Override
    public void run() {
        if (sh != null) sh.terminate();
    }
}

