package at.htl.recap.repository;

import at.htl.recap.entity.Register;
import at.htl.recap.entity.Vehicle;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class RegisterReopsitoryTest {

    @Inject
    RegisterReopsitory registerReopsitory;

    @Inject
    AgroalDataSource ds;

    @Test
    void t010_simpleInsert_OK() {

        Vehicle vehicle = new Vehicle("Opel", "Kapitän", 1972);
        Register register = new Register("LL-123ABC", "BugsBunny", vehicle);

        registerReopsitory.persist(register);

        Table table = new Table(ds, "V_REGISTER");
        output(table);

        assertThat(table).row()
                .column("R_ID").value().isGreaterThanOrEqualTo(5000)
                .column("R_LICENSEPLATE").value().isEqualTo("LL-123ABC")
                .column("R_OWNER").value().isEqualTo("BugsBunny")
                .column("R_STARTDATE").value()
                    .isEqualTo(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .column("R_ENDDATE").value().isNull();

    }
}
