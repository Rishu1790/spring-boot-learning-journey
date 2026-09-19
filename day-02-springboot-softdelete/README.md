# Day 02 - Spring Boot CRUD (Soft Delete)

- **Hard Delete:** Database se record permanently delete karna.
  Enterprise level par generally avoid kiya jata hai.

- **Soft Delete:** Record ko permanently delete nahi karte,
  sirf deleted mark karte hain.

## Aaj maine kya seekha?

### Soft Delete kaise work karta hai?

- Database me ek `deleted` column rakhenge.
- By default `deleted = false` rahega, iska matlab record delete nahi hua hai.
- Jab kisi student ko delete karenge, tab record permanently delete nahi hoga.
- Sirf `deleted = true` mark kiya jayega.
- Isliye soft delete ke liye `DELETE` ke bajay `PATCH` use karenge.

### Soft Delete Endpoint

```text
PATCH /api/students/delete-soft
```

### Soft Delete ka Basic Flow

```text
Student record
      ↓
deleted = false
      ↓
Soft delete request
      ↓
deleted = true
```

## Methods me kya change hoga?

- Sabhi methods me `deleted` field ka check hoga.
- Student find karte waqt check karenge:

```text
id = given id
AND
deleted = false
```

- Iske liye service layer me changes honge.
- `deleted` attribute ko client decide nahi karega.
- `deleted` ki default value `false` rahegi.

## JPA Method Naming Convention

Spring Data JPA method ke naam ko read karke query generate karta hai.

Basic formula:

```text
findBy + EntityFieldName + ConditionKeyword
```

### Examples

```java
findByDeletedIsFalse()
findByDeletedIsTrue()
findByIdAndDeletedIsFalse(Long id)
```

### Method Breakdown

```text
findBy | Id | And | Deleted | IsFalse
```

| Part | Meaning |
|---|---|
| `findBy` | Search query start |
| `Id` | Entity ka `id` field |
| `And` | Do conditions combine karna |
| `Deleted` | Entity ka `deleted` field |
| `IsFalse` | `deleted = false` |

JPA method name ko read karke query generate karta hai.

### Generated Query

```sql
SELECT *
FROM students
WHERE id = ?
AND is_deleted = false;
```

## Request Parameter ka Use

### Path Variable ke bajay Request Parameter

Path Variable use na karke `RequestParam` use karenge.

Isse `id` ya `name` ke through operation kar sakte hain.

Operation sirf `id` ke through karna zaroori nahi hai.

### Request Parameter ka Format

Postman me endpoint ke end me question mark `?` lagakar parameter denge.

```text
/api/students?id=1
```

## Important Annotations

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

```java
@RequestParam
```

## Important Commands

```text
[Commands yahan likhenge]
```

## Default Port

```text
[Default port yahan likhenge]
```

## Error Faced

### Error Message

```text
[Error message yahan likhenge]
```

### Error ka Meaning

[Error ka meaning yahan likhenge]

### Error ka Possible Reason

[Error ka possible reason yahan likhenge]

## Error ka Solution

```text
[Error ka solution yahan likhenge]
```

## Configuration File

```text
[Configuration details yahan likhenge]
```

## Important Learning

- **Hard Delete** me record database se permanently delete ho jata hai.
- **Soft Delete** me record database se delete nahi hota.
- Soft delete ke liye `deleted` field ka use karte hain.
- By default `deleted = false` rakha jata hai.
- Delete operation ke time `deleted = true` mark karte hain.
- Client `deleted` attribute ko directly change nahi karega.
- JPA method name ko read karke query generate karta hai.
- Basic formula:

```text
findBy + EntityFieldName + ConditionKeyword
```

- `findByDeletedIsFalse()` active records ke liye use hota hai.
- `findByDeletedIsTrue()` deleted records ke liye use hota hai.
- `findByIdAndDeletedIsFalse(Long id)` ID aur deleted status dono check karta hai.
- `@RequestParam` request ke andar parameter receive karne ke liye use hota hai.