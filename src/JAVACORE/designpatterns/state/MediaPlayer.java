package JAVACORE.designpatterns.state;

public class MediaPlayer {
    MediaPlayer(MediaContainer mediaContainer) {
        this.mediaContainer = mediaContainer;
    }

    final MediaContainer mediaContainer;

    public void play() {
        mediaContainer.play();
    }

    public void pause() {
        mediaContainer.pause();
    }

    public void stop() {
        mediaContainer.stop();
    }

}
