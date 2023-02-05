package tn.pi.server.repositories;
import tn.pi.server.models.Chat;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>{

}
