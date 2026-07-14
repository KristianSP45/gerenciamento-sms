package com.kristian.gerenciamentosms.business.converter;

import com.kristian.gerenciamentosms.business.dto.SmsMessageInDTO;
import com.kristian.gerenciamentosms.business.dto.SmsMessageOutDTO;
import com.kristian.gerenciamentosms.infrastructure.entity.SmsMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SmsMessageConverterMapper {

    //@Mapping(source = "dataHoraEnvio", target = "dataHoraEnvio")

    SmsMessage paraEntity(SmsMessageInDTO smsMessageInDTO);

    SmsMessageOutDTO paraDTO(SmsMessage smsMessage);
}
