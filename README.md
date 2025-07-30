
# Raspberries User Service

Simple user service for marketplace.


## Authentication API

### Get Page With Users

```http
POST /api/users?page=0&size=2
Content-Type: application/json

```


**Response (201 Created):**
```json
{
    "content": [
        {
            "id": 2,
            "name": "user1",
            "registrationDate": "2025-07-29T19:55:37.047754",
            "balance": 0.0,
            "spent": 0.0,
            "role": "ROLE_ADMIN"
        },
        {
            "id": 5,
            "name": "user2",
            "registrationDate": "2025-07-29T20:05:22.81794",
            "balance": 0.0,
            "spent": 0.0,
            "role": "ROLE_USER"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 2,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalElements": 4,
    "totalPages": 2,
    "first": true,
    "size": 2,
    "number": 0,
    "numberOfElements": 2,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "empty": false
}
```
### Get User By Id

```http
POST /api/user/{id}
Content-Type: application/json

```


**Response (201 Created):**
```json
{
    "id": 1,
    "name": "user",
    "registrationDate": "2025-07-29T13:39:11.808542",
    "balance": 0.0,
    "spent": 0.0,
    "role": "ROLE_USER"
}
```
### Creating a User

The service contains handleUserRegistrationEvent for creating new registered users from the **user-registered** topic (from Auth Service)


## Related

Here are other services of my project:

- [**Raspberries Gateway**](https://github.com/rvfw/Raspberries_Gateway)
- [Raspberries Auth Service](https://github.com/rvfw/Raspberries_AuthService)
- [Raspberries Seller Service](https://github.com/rvfw/Raspberries_SellerService)

