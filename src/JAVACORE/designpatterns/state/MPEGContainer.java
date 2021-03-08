package JAVACORE.designpatterns.state;

public class MPEGContainer implements MediaContainer {
    @Override
    public void play() {
        System.out.println("Playing mpeg file");
    }

    @Override
    public void stop() {
        System.out.println("Stopping mpeg file");
    }

    @Override
    public void pause() {
        System.out.println("Pausing mpeg file");
    }
}
