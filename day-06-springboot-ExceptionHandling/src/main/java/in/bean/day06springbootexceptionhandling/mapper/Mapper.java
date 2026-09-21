package in.bean.day06springbootexceptionhandling.mapper;

import in.bean.day06springbootexceptionhandling.dto.RequestDto;
import in.bean.day06springbootexceptionhandling.dto.ResponseDto;
import in.bean.day06springbootexceptionhandling.model.Student;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;


// During Creation
public class Mapper {
   public static Student toEntity(RequestDto reqDto){
       Student student = new Student();


       student.setAge(reqDto.getAge());
       student.setEmail(reqDto.getEmail());
       student.setName(reqDto.getName());
       student.setSubject(reqDto.getSubject());
       student.setRollNo(reqDto.getRollNo());

       student.setDeleted(false);

       return student;
   }

   //
   public static ResponseDto toDto(Student student){
       ResponseDto responseDto = new ResponseDto();

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

   // To Add messages During Create And Updated message so We can Ovverride Above methods

    public static ResponseDto toDto(Student student,String message){

       ResponseDto dto = toDto(student);

       dto.setMessage(message);
       return dto;

    }




   // Isme HUm bss Repalce karte h AAyi hui req Ko Student Entity ke elements se

   public static void updateEntity(Student student,RequestDto dto){
       student.setAge(dto.getAge());
       student.setEmail(dto.getEmail());
       student.setRollNo(dto.getRollNo());
       student.setName(dto.getName());

       student.setUpdatedAt(LocalDateTime.now());
   }





}
