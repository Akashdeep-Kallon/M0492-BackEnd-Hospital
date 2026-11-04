package com.hospital.hospital;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
 
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 
@ExtendWith(MockitoExtension.class)
public class NurseControllerTest {
 
    @Mock
    private NurseRepository nurseRepository;
 
    @InjectMocks
    private NurseController nurseController;
 
    private Nurse nurse;
 
    @BeforeEach
    void setUp() {
        nurse = new Nurse();
        nurse.setIdNurse(1);
        nurse.setUsername("test");
        nurse.setPassword("1234");
        nurse.setName("John");
        nurse.setSurname("Smith");
        nurse.setEmail("john@test.com");
    }
 
    // LOGIN
    @Test
    void testLoginSuccess() {
        when(nurseRepository.findByUsernameAndPassword("test", "1234"))
                .thenReturn(Optional.of(nurse));
 
        ResponseEntity<Boolean> response = nurseController.login(nurse);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(true, response.getBody());
    }
 
    @Test
    void testLoginFailure() {
        when(nurseRepository.findByUsernameAndPassword("test", "1234"))
                .thenReturn(Optional.empty());
 
        ResponseEntity<Boolean> response = nurseController.login(nurse);
 
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals(false, response.getBody());
    }
 
    // GET ALL
    @Test
    void testGetAll() {
        when(nurseRepository.findAll()).thenReturn(List.of(nurse));
 
        ResponseEntity<List<Nurse>> response = nurseController.getAll();
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }
 
    // FIND BY NAME
    @Test
    void testFindByNameSuccess() {
        when(nurseRepository.findByName("John"))
                .thenReturn(Optional.of(nurse));
 
        ResponseEntity<Nurse> response = nurseController.findByName("John");
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
 
    @Test
    void testFindByNameNotFound() {
        when(nurseRepository.findByName("Unknown"))
                .thenReturn(Optional.empty());
 
        ResponseEntity<Nurse> response = nurseController.findByName("Unknown");
 
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
 
    // CREATE
    @Test
    void testCreateNurse() {
        when(nurseRepository.save(nurse)).thenReturn(nurse);
 
        ResponseEntity<Nurse> response = nurseController.create(nurse);
 
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }
 
    // READ
    @Test
    void testFindByIdSuccess() {
        when(nurseRepository.findById(1)).thenReturn(Optional.of(nurse));
 
        ResponseEntity<Nurse> response = nurseController.findById(1);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
 
    @Test
    void testFindByIdNotFound() {
        when(nurseRepository.findById(99)).thenReturn(Optional.empty());
 
        ResponseEntity<Nurse> response = nurseController.findById(99);
 
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
 
    // UPDATE
    @Test
    void testUpdateNurse() {
        Nurse inputNurse = new Nurse();
        inputNurse.setUsername("updated");
        inputNurse.setPassword("5678");
        inputNurse.setName("Peter");
        inputNurse.setSurname("Brown");
        inputNurse.setEmail("peter@test.com");
 
        when(nurseRepository.findById(1)).thenReturn(Optional.of(nurse));
        when(nurseRepository.save(nurse)).thenReturn(nurse);
 
        ResponseEntity<Nurse> response = nurseController.update(1, inputNurse);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("updated", response.getBody().getUsername());
    }
 
    @Test
    void testUpdateNurseNotFound() {
        when(nurseRepository.findById(99)).thenReturn(Optional.empty());
 
        ResponseEntity<Nurse> response = nurseController.update(99, nurse);
 
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
 
    // DELETE
    @Test
    void testDeleteNurse() {
        when(nurseRepository.findById(1)).thenReturn(Optional.of(nurse));
 
        ResponseEntity<Nurse> response = nurseController.delete(1);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(nurseRepository).deleteById(1);
    }
 
    @Test
    void testDeleteNurseNotFound() {
        when(nurseRepository.findById(99)).thenReturn(Optional.empty());
 
        ResponseEntity<Nurse> response = nurseController.delete(99);
 
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(nurseRepository, never()).deleteById(99);
    }
}