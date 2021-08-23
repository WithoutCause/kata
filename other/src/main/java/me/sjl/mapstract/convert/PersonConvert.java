package me.sjl.mapstract.convert;

import me.sjl.mapstract.dto.PersonDTO;
import me.sjl.mapstract.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonConvert {

    PersonConvert INSTANCE = Mappers.getMapper(PersonConvert.class);

    List<Person> personDTOUSer2Person(List<PersonDTO> personDTO);

    @Mapping(source = "username", target = "name")
    Person toPerson(PersonDTO personDTO);
}
