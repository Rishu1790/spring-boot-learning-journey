# Day 01 - Spring Boot CRUD

## Aaj maine kya seekha?

- Work Flow 
- /api/student (controller - service - repository layer)
- 
-                         Student(Entity)
- |postman | → |Student controller| → |Student Service | → |Student Repo -> DB
- |(client)|    |  (HTTP req)     |    |Business Logic|     | DB interaction|

## Controller
- create --> POSTn--> /api/students/create
- Read Once → GET --> /api/students/{id}
- Read All --> GET --> /api/students
- Update --> PUT --> /api/students/{id}
- Delete --> DELETE --> /api/students/{id}
-  
- ## Response Entity :- Khud se kOi response Create code Generate karna h tabb use karte h 
- yeh ResponseEntity<Student>
- yeh ek class h jo Kiss tarah ke response ko send karna h -> mtlb student types
- ResponseEntity.status(HttpStatus.CREATED).body(createdStudent) ->> yeh hum return karenge alag methods use karke; 
- status method:- Https Status hote enum me stored alag se unhe call karte h
- body method :- 

- ## JPA (Jakarta Persistance API)
- Some Methods 
- create --> save() --> INsert into student();
- Read All --> findAll() --> select*from student;
- Read One --> find() --> select*from student where   ;
- Delete --> deleteById() 
- update --> save()
-        --> existById() (return boolean)
- Method Override nhi karna hota h :- JPA khud methd handle karta h;
- 
- ## DataBase se connection Ke liye
- 
- spring.datasource.url= jdbc:mysql://localhost:3306/student_crud_db
  spring.datasource.username=root
  spring.datasource.password=Rishu@9534901790

- Yeh jpa ko bta rahe h ki ise tum hi handle karo
  spring.jpa.hibernate.ddl-auto=update

- Agar hume sql query dekhni h
  spring.jpa.show-sql=true

-  Agar hume Sundar sa dekhna h to 
- spring.jpa.properties.hibernate.format_sql = true

## Optional Class
- --> Isme Values exist Karr nhi sakti h Ya null bhi ho skata h wo optonal h 

## CRUD Operation Finally performed 





## Important Concept

Spring Boot Java application develop karne ke liye use hota hai.
Isme configuration aur server setup easy hota hai.

## Important Command
@PathVariable
@RequestBody




## Error Faced
1. Failed to configure a DataSource:
→ Because humne dependency sql driver ki di jisse humne use nhi kiya thats why error
so resolve
@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class} )

2. org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' 
    defined in class path resource [org/springframework/boot/hibernate/autoconfigure/HibernateJpaConfiguration.class]: Unable to build Hibernate SessionFactory  [persistence unit: default] ;
    nested exception is java.lang.IllegalArgumentException: Unrecognized 'hibernate.hbm2ddl.auto' setting: 'true'
3. 




```bash
mvn spring-boot:run