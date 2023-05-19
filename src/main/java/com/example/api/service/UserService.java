package com.example.api.service;


import com.example.api.dto.User;
import com.example.api.repository.UserRepository;
import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by dn070578noi on 05.05.23.
 */
@Service
@Slf4j
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        log.debug("Получение списка юзеров из БД");
        try {
            Iterable<User> userIterable = repository.findAll();
            log.debug("Users list {}", userIterable);

            return StreamSupport.stream(userIterable.spliterator(), false)
                    .map(data -> new User(data.getId(), data.getUserName(), data.getEmail()))
                    .sorted(Comparator.comparing(User::getId))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Ошибка при получении списка юзеров из БД", e);
            throw e;
        }
    }

    public User findById(Long id) {
        try {
            return repository
                    .findById(id)
                    .orElseThrow(() ->
                            new PersistenceException("Код не найден: " + id)
                    );
        } catch (Exception e) {
            log.error("Ошибка при получении кода операции по имени из БД", e);
            throw e;
        }
    }

    public boolean update(User user) {
        try {
            User update = repository
                    .findById(user.getId())
                    .orElseThrow(() ->
                            new PersistenceException("Код не найден: " + user.getId())
                    );
            update.setUserName(user.getUserName());
            update.setEmail(user.getEmail());
            repository.save(update);
            return true;
        } catch (Exception e) {
            log.error("Ошибка при обновлении кода операции по имени в БД", e);
            throw e;
        }
    }

    public boolean delete(Long id) {
        try {
            User deleteUser = repository
                    .findById(id)
                    .orElseThrow(() ->
                            new PersistenceException("Код операции не найден: " + id)
                    );
            repository.delete(deleteUser);
            return true;
        } catch (Exception e) {
            log.error("Ошибка при удалении кода операции по имени в БД", e);
            throw e;
        }
    }

    public boolean create(User user) {
        try {
            log.debug("save user {}", user);
            repository.save(user);
            return true;
        } catch (Exception e) {
            log.error("Ошибка при создании user", e);
            throw e;
        }
    }
}
