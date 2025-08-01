package com.example.raspberriesUserService.service;

import com.example.raspberriesUserService.dto.UserDto;
import com.example.raspberriesUserService.dto.UserRegisteredEvent;
import com.example.raspberriesUserService.model.User;
import com.example.raspberriesUserService.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper=new ObjectMapper();
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics="user-registered", groupId = "user-service-group")
    public void handleUserRegistrationEvent(List<ConsumerRecord<Long,String>> records, Acknowledgment ack) throws JsonProcessingException {
        List<User> usersToSave = new ArrayList<>();
        for(var record:records){
            var event=objectMapper.readValue(record.value(),UserRegisteredEvent.class);
            if(userRepository.findById(event.getId()).isEmpty()){
                usersToSave.add(new User(event.getId(), event.getName(), event.getRole()));
                System.out.println("Created user with id "+event.getId());
            }
        }
        if(!usersToSave.isEmpty()){
            userRepository.saveAll(usersToSave);
        }
        ack.acknowledge();
    }
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
    }
}
