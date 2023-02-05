package tn.pi.server.repositories;
import org.springframework.stereotype.Repository;
import tn.pi.server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
