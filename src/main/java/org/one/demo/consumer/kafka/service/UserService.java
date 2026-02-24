package org.one.demo.consumer.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.one.demo.consumer.kafka.entity.UserEntity;
import org.one.demo.consumer.kafka.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    @Transactional
    public void save(UserEntity user) {
        var entity = repository.save(user);
        log.debug("Saved user entity: {}", entity);
    }
}
