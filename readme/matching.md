
## 매칭방
## - create matching room
매칭방을 생성하는 메소드
### POST </br>
#### - URL
IP_address:8080/matching/create
#### - request argument

Matching

| parameter       | type         | default |
|-----------------|--------------|---------|
| id              | Long         | X       |
| ownerID         | String       | X       |
| joinerID        | String       | null    |
| title           | String       | X       |
| category        | String       | X       |
| requirementsAge | List<String> | X       |
| creationTime    | date         | X       |


#### - Result
Boolean status

    true - success
    false - fail

## - Get matching room
매칭방에 접속.
### GET </br>
#### - URL
IP_address:8080/matching/<U>매칭방 ID</U> </br>
#### - Parameter

| parameter | type | default |
|-----------|------|-------|
| user-id   | Long | X     |  


#### - Result

| parameter       | type         | default |
|-----------------|--------------|---------|
| id              | Long         | X       |
| ownerID         | String       | X       |
| joinerID        | String       | X       |
| title           | String       | X       |
| category        | String       | X       |
| requirementsAge | List<String> | X       |
| creationTime    | date         | X       |


#### - example
127.0.0.1:8080/matching/1?user-id=1234  </br>
