api list

## Account Service

used for authenticate & management user account. User may login by many way

1. Basic Login
### POST /api/account/login/basic
- *IN* : login using username (email) and password. auth info will be hash to search in database
- *OUT* : status 200, body "true", cookie access_token if login success. Or >400 status if failed

Body
- username : string
- password : string

2. OAuth Login
### POST /api/account/login/{oauth}
- *IN* : login using oauth method
- *OUT* : redirect to 3rth provider, return status 200, body "true", cookie access_token if login success. Or >400 status if failed

## User Service

used to management user info

1. Create user info
### POST /api/user
- *IN* : user info
- *OUT* : changed user info

Body
- full_name : string
- birthday : date
- location : string
- language : string

2. Retrieve user info
### GET /api/user/{id}
- *IN* : retrieve special user info by id
- *OUT* : user info except sensitive field

### Product Service

used to retrieve product info

1. List product
### GET /api/products?category&price&query

used to retrieve product info by some of field

- *IN* : filtered field value
- *OUT* : list of valid product

2. Get product
### GET /api/product/{id|barcode}

used to retrieve special product

3. Add product

### POST /api/product

### Rating Service
schedule job to recalculate rating & update product db

1. Re-Calculate
### GET /api/rating/re-cal

2. Set State
### GET /api/rating/{status}/status

### Order Service
Used to add order

1. Add Order

### POST : /api/order

2. Update Order
### PUT : /api/order/{id}

3. Get Order
### GET : /api/order/{id}

4. List Order
### GET : /api/orders/{uid}
