# Day 04 - Spring Boot DTO and Validation

Aaj main seekh raha hoon ki Entity class ki jagah DTO use kyu karna chahiye.

## Aaj maine kya seekha?

### DTO

DTO ka full form **Data Transfer Object** hai.

- `RequestDTO`
- `ResponseDTO`

### DTO Flow

```text
RequestDTO
     |
     | Mapping
     v
ResponseDTO
```

### Validation

Request DTO ke fields par validation lagani hoti hai, taaki client ki request
process hone se pehle validation check ho jaye.

Iske liye validation dependency import karni hoti hai.

Jis field par validation lagani ho, us field ke upar validation annotation lagate hain.

## Important Annotations

| Annotation | Use |
|---|---|
| `@Valid` | Validation trigger karne ke liye |
| `@NotBlank` | Blank value check karne ke liye |
| `@NotNull` | Null value check karne ke liye |
| `@NotEmpty` | Empty value check karne ke liye |
| `@Email` | Email validate karne ke liye |
| `@Min` | Minimum value check karne ke liye |
| `@Max` | Maximum value check karne ke liye |
| `@Size(min, max)` | Size check karne ke liye |
| `@Positive` | Positive value check karne ke liye |
| `@Past` | Past date check karne ke liye |
| `@Future` | Future date check karne ke liye |

## Important Commands

```text
[Commands yahan likhenge]
```

## Default Port

```text
[Default port yahan likhenge]
```

## Error Faced

### Error 1: Port 8080 Already in Use

#### Error Message

```text
[Error message yahan likhenge]
```

#### Error ka Meaning

[Error ka meaning yahan likhenge]

#### Error ka Possible Reason

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

- Entity class ki jagah DTO use karna chahiye.
- `RequestDTO` aur `ResponseDTO` ka use hota hai.
- Request DTO ke fields par validation lagayi ja sakti hai.
- Client ki request process hone se pehle validation check ki ja sakti hai.
- Validation ke liye dependency import karni hoti hai.
- Jis field par validation lagani ho, us field par appropriate annotation lagate hain.