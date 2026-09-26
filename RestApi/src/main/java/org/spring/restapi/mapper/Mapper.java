package org.spring.restapi.mapper;

import org.spring.restapi.dto.StudentRequestDto;
import org.spring.restapi.dto.StudentResponseDto;
import org.spring.restapi.entity.Student;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class Mapper {
    public static Student toEntity(StudentRequestDto reqDto){
        Student student = new Student();

        student.setAge(reqDto.getAge());
        student.setEmail(reqDto.getEmail());
        student.setRollNo(reqDto.getRollNo());
        student.setSubject(reqDto.getSubject());
        student.setName(reqDto.getName());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setDeleted(false);

        return student;


    }

    public static StudentResponseDto toDto(Student student){
        StudentResponseDto responseDto = new StudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setAge(student.getAge());
        responseDto.setName(student.getName());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setEmail(student.getEmail());
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());
        responseDto.setMessage("Present");

        return responseDto;
    }

    // ResponseMessage Sath me

    public static StudentResponseDto toDto(Student student,String message){
        StudentResponseDto responseDto = Mapper.toDto(student);

        responseDto.setMessage(message);

        return responseDto;


    }

    public static void update(StudentRequestDto dto , Student student){
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        student.setRollNo(dto.getRollNo());
        student.setName(dto.getName());

    }




}
