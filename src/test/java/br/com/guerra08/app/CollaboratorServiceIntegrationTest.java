package br.com.guerra08.app;

import static org.junit.jupiter.api.Assertions.*;
import br.com.guerra08.app.model.Collaborator;
import br.com.guerra08.app.service.CollaboratorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CollaboratorServiceIntegrationTest {

    @Autowired
    private CollaboratorService collaboratorService;

    @Test
    public void testFindAllCollaborators(){
        List<Collaborator> allCollaborators = collaboratorService.findAll();
        assertTrue(allCollaborators.size() >= 5);
    }

}
