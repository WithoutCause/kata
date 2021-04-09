package me.sjl.mapstract.convert;

import me.sjl.mapstract.dto.PersonDTO;
import me.sjl.mapstract.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonConvert {

    PersonConvert INSTANCE = Mappers.getMapper(PersonConvert.class);

    Person personDTO2Person(PersonDTO personDTO);



}
