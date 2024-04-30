# 학습

## 테이블 구조

- fruit

|   | Field        | Type        | Null | Key | Default | Extra          |
|---|--------------|-------------|------|-----|---------|----------------|
| 1 | id           | bigint      | NO   | PRI | <null>  | auto_increment |
| 2 | name         | varchar(20) | YES  |     | <null>  |                |
| 3 | price        | int         | YES  |     | <null>  |                |
| 4 | stocked_date | date        | YES  |     | <null>  |                |

### PostgreSQL

```sql
CREATE TABLE fruit
(
    id           SERIAL,
    name         VARCHAR(20),
    price        INT,
    stocked_date DATE,
    PRIMARY KEY (id)
);
```

- user

|   | Field | Type        | Null | Key | Default | Extra          |
|---|-------|-------------|------|-----|---------|----------------|
| 1 | id    | bigint      | NO   | PRI | <null>  | auto_increment |
| 2 | name  | varchar(25) | YES  |     | <null>  |                |
| 3 | age   | int         | YES  |     | <null>  |                |

### PostgreSQL

```sql
CREATE TABLE user
(
    id   SERIAL,
    name VARCHAR(25),
    age  INT,
    PRIMARY KEY (id)
);
```
