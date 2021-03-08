package JAVACORE.designpatterns.state;

public class Main {

    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer(new MPEGContainer());
        player.play();
        player.stop();
    }
}
