package com.digital.innovation.one.gestaodepessoas.mapper;


import com.digital.innovation.one.gestaodepessoas.dto.request.PessoaDTO;
import com.digital.innovation.one.gestaodepessoas.entity.Pessoa;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring")
public interface PessoaMapper {

//    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);
//    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

//    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO pessoaDTO);

    PessoaDTO toDTO(Pessoa pessoa);
}
