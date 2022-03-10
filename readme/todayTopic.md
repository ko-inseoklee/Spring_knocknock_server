
## 오늘의 주제 (~22.02.28)
## - Get Today Topic
특정 날짜의 데이터를 받아오기 위한 method.
### GET </br>
#### - URL
IP_address:8080/today-topic/<U>날짜</U> </br>
#### - Parameter

| parameter      | type | default |
|----------|------|-------|
| date           | Long | X     |  


#### - Result
|parameter| type   |
|---------|--------|
|date| Long   |
|title| String |
|contents| String |
|like| int|


#### - example
127.0.0.1:8080/today-topic/20220306  </br>

## - Get Topics From Today.
오늘로부터 특정 날짜 안의 주제들을 모두 가져오는 method.
### GET </br>
#### - URL
IP_address:8080/today-topic/get-topics/<U>날짜</U>?period=<U>기간</U> </br>
#### - Parameter

| parameter | type | default |
|-----------|------|---------|
| date      | Long | X       |  
| peroid    | Long | X       |


#### - Result : 아래 Class의 리스트 형태로 반환.
|parameter| type   |
|---------|--------|
|date| Long   |
|title| String |
|contents| String |
|like| int|


#### - example
127.0.0.1:8080/today-topic/get-topic/20220306?period=3  </br>

