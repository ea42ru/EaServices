package ru.ea42.EaServices;

public class Start {
    public static void main(String[] args) {
        App app = new App();
        Work work = new Work(app);
        //app.ждём окончания работы
    }
}
