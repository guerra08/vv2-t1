package br.com.guerra08.app;

import br.com.guerra08.app.model.*;
import br.com.guerra08.app.repository.CollaboratorRepository;
import br.com.guerra08.app.repository.ReservationRepository;
import br.com.guerra08.app.repository.ResourceRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner initializer(CollaboratorRepository colRepo, ResourceRepository resourceRepository, ReservationRepository resRepo) {

        Collaborator colToReserve = new Collaborator("12345", "João da Silva", "jsilva@outlook.com");
        Resource resoToReserve = new Furniture("Mesa", 15, "Mobília");

        return args ->  {
            colRepo.saveAll(Arrays.asList(
                    colToReserve,
                    new Collaborator("54321", "Marcos Júnior", "junior.m@gmail.com"),
                    new Collaborator("11223", "Felipe Castro", "castrofelipe@yahoo.com"),
                    new Collaborator("90998", "Pedro Silva", "psilva@hotmail.com"),
                    new Collaborator("87866", "Luis Volpato", "volpluis@outlook.com")
            ));
            resourceRepository.saveAll(Arrays.asList(
                resoToReserve,
                new Furniture("Quadro", 17, "Mobília"),
                new Furniture("Armário de cadernos", 20, "Armário"),
                new MobileEquip("Motorola G5", 25, "Smartphone"),
                new MobileEquip("Laptop Dell", 40, "Computador"),
                new MobileEquip("iPad", 40, "Tablet"),
                new MobileEquip("Desktop Lenovo", 60, "Computador"),
                new Spaces("Auditório principal", 15, 70, "Auditório"),
                new Spaces("Sala 20", 10, 30, "Sala"),
                new Spaces("Área externa", 20, 100, "Área")
            ));
            resRepo.save(new Reservation(resoToReserve, colToReserve, LocalDate.of(2020, 3, 17), LocalDate.of(2020, 3, 21)));
        };
    }

}