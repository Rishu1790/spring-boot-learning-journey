# Day 02 - Spring Boot CRUD(SOFT DELETE)
* Hard Delete :- Permanent Delete From db (Not Used in Enterprise Level).
* Soft Delete :- Mark As Delete
* 


## Aaj maine kya seekha?
Soft Delete --> PATCH --> /api/students/delete-soft 

* How Soft Delete Work 
- By default deleted(0){means not deleted} rakhenge ek col abb jabb bhi hum delete
- karenge kisi student ko deleted(1) mark karenge simple. na ki permanent delete call
- karenge.

* isiliye Sabb methods me chhota sa change hoga.
- check findBy(id) && Deleted(0);
- service me hi saare change shonge sayad.
- deleted Attribute Ko Change client Decide nhi karega byDefault false hi hoga

* How MAgical Jpa create Methods In The name I wrote;
{{findBy + EntityFieldName + ConditionKeyword}}

- findByDeletedIsFalse()
  findByDeletedIsTrue()
  findByIdAndDeletedIsFalse(Long id)
- in methods me tum dekh sakte ho ki jpa khud read karke query generate karta h 
- Eg:-
findBy | Id | And | Deleted | IsFalse
| Part | Meaning |
| --- | --- |
| `findBy` | Search query start |
| `Id` | Entity ka `id` field |
| `And` | Do conditions combine |
| `Deleted` | Entity ka `deleted` field |
| `IsFalse` | `deleted = false` |

SELECT *
FROM students
WHERE id = ?
AND is_deleted = false;
- 

### Path Variable Use na Karke Request Parameter Use kAre
-  kyunki mai id na bhejke Name ke through Ya id Ke thru Operation karr pau
- EndPoint id Ke thru jarurai nhi h generate ho bass.
- postman me endpoint dalunga Using Question Mark(?). end me dena h url ke.
- 
- 












## Important Annotation

* @GeneratedValue(strategy =  GenerationType.IDENTITY)
* @RequestParam





## Important Commands


## Default Port

```

## Error Faced


#### Error Message



#### Error ka Meaning



#### Error ka Possible Reason



## Error ka Solution


```

## Configuration File


## Important Learning

