package org.one.demo.consumer.kafka.mapper;

import org.mapstruct.Mapper;
import org.one.demo.consumer.kafka.data.User;
import org.one.demo.consumer.kafka.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity map(User source);
}
