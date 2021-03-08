package JAVACORE.designpatterns.state;

public class HSLContainer implements MediaContainer {
    @Override
    public void play() {
        System.out.println("Playing HSL file");
    }

    @Override
    public void stop() {
        System.out.println("Stopping HSL file");
    }

    @Override
    public void pause() {
        System.out.println("Pausing HSL file");
    }
}
