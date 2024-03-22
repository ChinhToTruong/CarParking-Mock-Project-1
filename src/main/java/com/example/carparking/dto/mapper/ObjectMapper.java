package com.example.carparking.dto.mapper;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapper<Entity, Dto> {
    private final ModelMapper modelMapper;

    @Autowired
    public ObjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Entity toEntity(Dto dto){
        return modelMapper.map(dto, new TypeToken<Entity>() {}.getType());
    }

    public Dto toDto(Entity entity){
        return modelMapper.map(entity, new TypeToken<Dto>() {}.getType());
    }

}
