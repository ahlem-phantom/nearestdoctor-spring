package tn.pi.server.repositories;
import tn.pi.server.models.Chat;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>{

    @Query("SELECT c FROM Chat c where c.user.id=:id")
	public List<Chat> getChatByUser(@Param("id") Long id);

}
