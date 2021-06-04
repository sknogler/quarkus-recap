package at.htl.recap.repository;

import at.htl.recap.entity.Register;
import at.htl.recap.entity.Vehicle;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class RegisterReopsitoryTest {

    @Inject
    RegisterReopsitory registerReopsitory;

    @Test
    void t010_simpleInsert_OK() {

        Vehicle vehicle = new Vehicle("Opel", "Kapitän", 1972);
        Register register = new Register("LL-123ABC", "BugsBunny", vehicle);

        registerReopsitory.persist(register);
    }
}
