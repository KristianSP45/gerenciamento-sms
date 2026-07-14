package com.kristian.gerenciamentosms.infrastructure.repository;

import com.kristian.gerenciamentosms.infrastructure.entity.SmsMessage;
import com.kristian.gerenciamentosms.infrastructure.enums.StatusEnvioEnum;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SmsMessageRepository extends CrudRepository<SmsMessage, Long> {
    SmsMessage save(SmsMessage smsMessage);

    Optional<SmsMessage> findById(Long id);

    SmsMessage findByStatusEnvio(StatusEnvioEnum statusEnvioEnum);

    List<SmsMessage> findByStatusEnvioAndDataHoraEnvioAfter(
            StatusEnvioEnum status,
            LocalDateTime dataHora);

    void deleteById(String id);
}
