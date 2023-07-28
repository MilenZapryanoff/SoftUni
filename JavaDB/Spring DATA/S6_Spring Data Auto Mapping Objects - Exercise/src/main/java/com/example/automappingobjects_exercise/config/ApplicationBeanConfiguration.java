package com.example.automappingobjects_exercise.config;

import com.example.automappingobjects_exercise.model.dto.GameAddDto;
import com.example.automappingobjects_exercise.model.entity.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        //за конвертиране на датата от String в LocalDate
        Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(),
                        DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        };
        modelMapper.addConverter(localDateConverter);

        //мапване на Thumbnail-а
        modelMapper.typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper -> {
                    mapper.map(GameAddDto::getThumbnailUrl,
                            Game::setImageThumbnail);
                    mapper.using(localDateConverter).map(GameAddDto::getReleaseDate, Game::setReleaseDate);
                });

        return modelMapper;
    }
}