package br.com.guerra08.app;

import static org.junit.jupiter.api.Assertions.*;
import br.com.guerra08.app.model.Resource;
import br.com.guerra08.app.service.ResourceService;
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
public class ResourceServiceIntegrationTest {

    @Autowired
    private ResourceService resourceService;

    @Test
    public void testFindAll(){
        List<Resource> allResources = resourceService.findAll();
        assertEquals(10, allResources.size());
    }

    @Test
    public void testFindAllByInvalidTypeInteger(){
        List<Resource> allResourcesByInvalidType = resourceService.findAllByType(4);
        assertEquals(0, allResourcesByInvalidType.size());
    }

    @Test
    public void testFindAllByInvalidTypeChar(){
        List<Resource> allResourcesByInvalidType = resourceService.findAllByType('a');
        assertEquals(0, allResourcesByInvalidType.size());
    }

    @Test
    public void testFindAllByValidType1(){
        List<Resource> allResourcesByValidType = resourceService.findAllByType(1);
        assertEquals(3, allResourcesByValidType.size());
    }

    @Test
    public void testFindAllByValidType2(){
        List<Resource> allResourcesByValidType = resourceService.findAllByType(2);
        assertEquals(4, allResourcesByValidType.size());
    }

    @Test
    public void testFindAllByValidType3(){
        List<Resource> allResourcesByValidType = resourceService.findAllByType(3);
        assertEquals(3, allResourcesByValidType.size());
    }

}
