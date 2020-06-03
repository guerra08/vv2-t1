package br.com.guerra08.app.controller;

import br.com.guerra08.app.model.Collaborator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollaboratorControllerTest {

    private static final CollaboratorController cc = new CollaboratorController();

    @BeforeAll
    static void checkInit(){
        assertTrue(cc.getCollaborators().size() >= 5);
    }

    @Test
    void checkCreateCollaborator(){
        assertThrows(IllegalArgumentException.class, () -> new Collaborator("112233", "Fulano Legal", "fulano.legal.br"));
        assertDoesNotThrow(() -> new Collaborator("456789", "Roberto Silva", "rsilva@hotmail.com"));
        assertTrue(cc.createCollaborator(new Collaborator("123456789", "James Guerra", "jguerra@gmail.com")));
        assertFalse(cc.createCollaborator(null));
    }

}