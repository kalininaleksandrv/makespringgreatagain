package com.github.kalininaleksandrv.injectfuncasabean;

import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.function.Function;

@Component
public class MappingFunction implements Function<FromDTO, ToDTO> {

    @Override
    public ToDTO apply(FromDTO fromDTO) {
        ToDTO toDTO = new ToDTO();
        toDTO.setName(fromDTO.getName().toUpperCase(Locale.ROOT));
        return toDTO;
    }
}
