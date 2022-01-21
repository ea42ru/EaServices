package ru.ea42.EaServices;

public class App {
    /*private static App instance;

    public static synchronized App getInstace() {
        if (instance == null) instance = new App();
        return instance;
    }
*/
    public State state = State.STOP;
    private EaService srv;

    public void addService(EaService srv) {
        this.srv = srv;
    }

    public void cmdInit() {
        state = State.STARTED;
        srv.init();
        state = State.START;
    }

    public void cmdStart() {
        state = State.WORKED;
        srv.start();
        state = State.WORK;
    }

    public void cmdPause() {
        state = State.PAUSED;
        srv.stop();
        state = State.PAUSE;
    }

    public void cmdStop() {
        state = State.STOPED;
        srv.finit();
        state = State.STOP;
    }

}
