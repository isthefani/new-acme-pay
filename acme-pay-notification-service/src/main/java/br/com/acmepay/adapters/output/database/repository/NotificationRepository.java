package br.com.acmepay.adapters.output.database.repository;

import br.com.acmepay.adapters.output.database.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
}