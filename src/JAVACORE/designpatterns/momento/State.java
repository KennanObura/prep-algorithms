package JAVACORE.designpatterns.momento;

public class State {

    public State(String content){
        this.content = content;
    }

    private final String content;

    public String getContent() {
        return content;
    }
}
