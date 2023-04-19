package com.example.registration.register.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken,Long>{
    Optional<ConfirmationToken> findByToken(String token);

    @Transactional
    @Modifying //it is used typically with methods like UPDATE,DELETE,INSERT and is used to indicate that a method modifies the state of the database
    @Query("UPDATE ConfirmationToken c "+"SET c.confirmedAt= ?2 "+"WHERE c.token=?1")
    int updateConfirmedAt(String token, LocalDateTime confirmedAt);
}
