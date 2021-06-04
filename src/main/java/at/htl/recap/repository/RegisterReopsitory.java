package at.htl.recap.repository;

import at.htl.recap.entity.Register;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class RegisterReopsitory implements PanacheRepository<Register> {
}
