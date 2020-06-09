package br.com.guerra08.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import br.com.guerra08.app.repository.CollaboratorRepository;
import br.com.guerra08.app.repository.ReservationRepository;
import br.com.guerra08.app.repository.ResourceRepository;
import br.com.guerra08.app.service.ICollaboratorService;
import br.com.guerra08.app.service.IReservationService;
import br.com.guerra08.app.service.IResourceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
public class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICollaboratorService collaboratorService;
    @MockBean
    private IResourceService resourceService;
    @MockBean
    private IReservationService reservationService;
    @MockBean
    private ReservationRepository reservationRepository;
    @MockBean
    private ResourceRepository resourceRepository;
    @MockBean
    private CollaboratorRepository collaboratorRepository;

    @Test
    public void testGetCreateReservationPage() throws Exception {
        mockMvc.perform(get("/create-reservation")).andExpect(status().isOk());
    }

    @Test
    public void testGetManageReservationsPage() throws Exception {
        mockMvc.perform(get("/manage-reservations")).andExpect(status().isOk());
    }

}
