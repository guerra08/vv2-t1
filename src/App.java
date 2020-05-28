import controllers.CollaboratorController;

public class App {

    public static void main(String[] args) {
        CollaboratorController cc = new CollaboratorController();
        System.out.println(cc.getCollaborator("12345"));
    }

}
