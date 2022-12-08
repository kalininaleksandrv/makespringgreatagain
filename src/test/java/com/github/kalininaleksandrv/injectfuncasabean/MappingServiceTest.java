package com.github.kalininaleksandrv.injectfuncasabean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class MappingServiceTest {

    @Autowired
    MappingService mappingService;

    @Test
    void mapFromTo() {
        List<ToDTO> toDTOS = mappingService.mapFromTo(List.of(new FromDTO("vasya")
                , new FromDTO("petya")
                , new FromDTO("sasha")));

        Assertions.assertThat(toDTOS)
                .hasSize(3)
                .extracting(ToDTO::getName)
                .containsExactlyInAnyOrder("VASYA", "PETYA", "SASHA");

    }
}