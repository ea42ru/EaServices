package ru.ea42.EaServices;

public class Test_Work extends EaService {
    private int count = 0;

    // создание, считывание настоек, подключение к сервмсам, ...
    @Override
    protected void init() {
        oneDemoS();
        name = "Test EaServices v0.03";
        app.setLoger(new Test_Logger(true));
        setTimer(2000);
    }

    // разрешение выполнять работу
    @Override
    protected void start() {
        oneDemoS();
        timer.on();
    }

    // приостановка, запрет на выполнение работы
    @Override
    protected void stop() {
        oneDemoS();
        timer.off();
    }

    // сохранее состояния, отключение сеансов, уничтожение классов, ...
    @Override
    protected void finit() {
        oneDemoS();
        timer.finit();
        timer=null;
    }

    // квант полезной работы,  вызов от таймера, timer
    @Override
    public void go() {
        count++;
        log("<== " + count + " ==>");
    }

    private void oneDemoS() {
        try {
            Thread.sleep(1000);
        } catch (Exception ignore) {
        }
    }

}
