import controller.CollaboratorController;
import model.Collaborator;

public class App {

    public static void main(String[] args) {
        CollaboratorController cc = new CollaboratorController();
        cc.createCollaborator((new Collaborator("9988", "James Silva", "jamess@gmail.com")));
        System.out.println(cc.getCollaborator("12345"));
    }

}
