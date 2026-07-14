package com.kristian.gerenciamentosms.business;

import com.kristian.gerenciamentosms.business.converter.SmsMessageConverterMapper;
import com.kristian.gerenciamentosms.business.dto.SmsMessageInDTO;
import com.kristian.gerenciamentosms.business.dto.SmsMessageOutDTO;
import com.kristian.gerenciamentosms.infrastructure.entity.SmsMessage;
import com.kristian.gerenciamentosms.infrastructure.enums.StatusEnvioEnum;
import com.kristian.gerenciamentosms.infrastructure.exceptions.ConflictException;
import com.kristian.gerenciamentosms.infrastructure.exceptions.IllegalArgumentException;
import com.kristian.gerenciamentosms.infrastructure.exceptions.ResourceNotFoundException;
import com.kristian.gerenciamentosms.infrastructure.repository.SmsMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SmsMessageService {

    private final SmsMessageRepository repository;
    private final SmsMessageConverterMapper mapper;

    public SmsMessageOutDTO smsCadastrada(SmsMessageInDTO dto) {
        if (dto.getTelefone() == null || dto.getTelefone().isBlank()) {
            throw new IllegalArgumentException("Telefone obrigatório.");
        }
        SmsMessage entity = mapper.paraEntity(dto);

        entity.setStatusEnvio(StatusEnvioEnum.ENVIADO);
        entity.setDataHoraEnvio(LocalDateTime.now());
        repository.save(entity);
        return mapper.paraDTO(entity);
    }

    public List<SmsMessageOutDTO> buscarSmsPorStatus(StatusEnvioEnum status, LocalDateTime dataHora) {
        LocalDateTime dataTime = LocalDateTime.now().minusHours(24);
        List<SmsMessage> entity = repository.findByStatusEnvioAndDataHoraEnvioAfter(status, dataTime);
        if (Objects.isNull(entity)) {
            throw new ResourceNotFoundException("SMS não encontrado");
        }
        return entity.stream()
                .map(mapper::paraDTO)
                .toList();
    }

    public SmsMessageOutDTO alterarStatusMessage(Long id, StatusEnvioEnum status) {
        SmsMessage entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Mensagem não encontrada."));

        if (entity.getStatusEnvio() == status) {
            throw new ConflictException("A mensagem já possui esse status.");
        }
        if (entity.getStatusEnvio() != StatusEnvioEnum.ENVIADO) {
            throw new ConflictException("A mensagem já foi processada.");
        }

        entity.setStatusEnvio(status);
        repository.save(entity);
        return mapper.paraDTO(entity);
    }

}
