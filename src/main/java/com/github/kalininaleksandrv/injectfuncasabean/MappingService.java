package com.github.kalininaleksandrv.injectfuncasabean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MappingService {

    private final Function<FromDTO, ToDTO> mappingFunction;

    List<ToDTO> mapFromTo(List<FromDTO> fromDTO) {
        return fromDTO
                .stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }
}
