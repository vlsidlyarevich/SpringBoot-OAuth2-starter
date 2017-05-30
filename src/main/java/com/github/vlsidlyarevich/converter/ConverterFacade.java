package com.github.vlsidlyarevich.converter;

import com.github.vlsidlyarevich.converter.factory.ConverterFactory;
import com.github.vlsidlyarevich.dto.UserDTO;
import com.github.vlsidlyarevich.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterFacade {

    private final ConverterFactory converterFactory;

    @Autowired
    public ConverterFacade(final ConverterFactory converterFactory) {
        this.converterFactory = converterFactory;
    }

    public User convert(final UserDTO dto) {
        return (User) converterFactory.getConverter(dto.getClass()).convert(dto);
    }
}
