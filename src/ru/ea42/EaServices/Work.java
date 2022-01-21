package ru.ea42.EaServices;

public class Work extends EaService {
    public Work(App app) {
        super(app);
    }

    // создание, считывание настоек, подключение к сервмсам, ...
    @Override
    protected void init() {
    }

    // разрешение выполнять работу
    @Override
    protected void start() {
    }

    // приостановка, запрет на выполнение работы
    @Override
    protected void stop() {
    }

    // сохранее состояния, отключение сеансов, уничтожение классов, ...
    @Override
    protected void finit() {
    }

    // квант полезной работы, если надо, вызов от таймера, timer
    @Override
    public void go() {
    }
}
