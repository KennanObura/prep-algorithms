package JAVACORE.designpatterns.momento;

public class Editor {
    private final History history = new History();


    public void setContent(String content) {
        State prev = history.peek();

        history.push(new State(prev.getContent() + " " +content));
    }

    public String currentContent() {
        return history.peek().getContent();
    }

    public String undoContent() {
        State state = history.pop();
        return state.getContent();
    }

    public static void main(String[] args) {
        Editor editor = new Editor();

        editor.setContent("the moment is here");

        System.out.println(editor.currentContent());
        editor.setContent(" are more advance");

        System.out.println(editor.currentContent());


        editor.undoContent();

        System.out.println(editor.currentContent());

    }
}
