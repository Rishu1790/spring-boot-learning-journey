# Day 03 - Spring Boot CRUD(Practice Session)



## Aaj maine kya seekha?
Ajj Maine Bass Practice ki h Spring boot Crud Operation ki
## Important Annotation
- Only Revision
## Important Commands


## Default Port

```

## Error Faced


### Error 1: Port 8080 Already in Use

#### Error Message
- 1. java.lang.IllegalStateException: Method expects at least 1 arguments but only found 0; This leaves an operator of type 'SIMPLE_PROPERTY' for property 'id' unbound
	at org.springframework.data.jpa.repository.query.PartTreeJpaQuery.throwExceptionOnArgumentMismatch(PartTreeJpaQuery.java:174) ~[spring-data-jpa-4.1.1.jar:4.1.1]
- 2. caused by: org.springframework.data.repository.query.QueryCreationException: Cannot create query for method [StudentRepository.findAllByIdAndDeletedIsFalse()]; 
Method expects at least 1 arguments but only found 0; This leaves an operator of type 'SIMPLE_PROPERTY' for property 'id' unbound


#### Error ka Meaning

-Query Galat Likh di thi (findAllByDeletedIsFalse())
-Yeh Shi hai
-




#### Error ka Possible Reason



## Error ka Solution
-change the query


```

## Configuration File


## Important Learning

