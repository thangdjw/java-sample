API List

## User Service

used to management user info

### Retrieve user info

```http
GET /api/user/{id}
```
|param|type|description|
|---|---|---|
|id|string|id of user|

---

### Add new User

```http
POST /api/user
```
|body|type|description|
|---|---|---|
|fullName|string|user name|
|birthDay|yyyy-MM-dd|birthday of user|
|location|string|current living state|
|language|string|language code. ex : vn|

---

### Update user info

```http
PUT /api/user
```
|body|type|description|
|---|---|---|
|fullName|string|user name|
|birthDay|yyyy-MM-dd|birthday of user|
|location|string|current living state|
|language|string|language code. ex : vn|

## Product Service

Used to management product info

---

### Search product by identity with filter

```http
GET /api/product/search/{identity}
```
|param|type|description|
|---|---|---|
|identity|string|product name, or barcode|

|query|type|description|
|---|---|---|
|filter_name|string|exactly name of product|
|filter_lt_price|float|filter product with price <= given price|
|filter_gt_price|float|filter product with price >= given price|
|filter_owner|string|filter product by seller|
|filter_producer|string|filter product by maker|
|filter_species|string|filter product by species|
|sort_name|boolean|true if products sort desc by name|
|sort_price|boolean|true if products sort desc by price|

---

### Get product by id

```http
GET /api/product/{id}
```

|param|type|description|
|---|---|---|
|id|number|id of target product|

---

### Add a product

```http
POST /api/product
```

|body|type|description|
|---|---|---|
|barcode|number|barcode of product|
|name|string|name of product|
|image|string[]|list of product image url|
|ownerId|string|seller user id|
|producer|string|company or national who make this product|
|description|string|product information|
|version|string|version of this product|
|price|float|price of this product|
|species|string|species of this product. Ex : iphone|

---

### Update product info

```http
PUT /api/product/{id}
```

|body|type|description|
|---|---|---|
|barcode|number|barcode of product|
|name|string|name of product|
|image|string[]|list of product image url|
|ownerId|string|seller user id|
|producer|string|company or national who make this product|
|description|string|product information|
|version|string|version of this product|
|price|float|price of this product|
|species|string|species of this product. Ex : iphone|

## Order service
used to create & manager order to buy a product

### Get order by id

```http
GET /api/order/{id}
```

|param|type|description|
|---|---|---|
|id|number|id of target order|

---

### Add new order

```http
POST /api/order
```

|body|type|description|
|---|---|---|
|clientId|string|user id of this client|
|productId|string|id of target product|
|amount|string[]|number of order of this product|
|totalPrice|string|price of this order|
|deliveryAddress|string|address to delivery this product|
|transporter|string|shipper. include : SHIPPO, GIAO_HANG_NHANH, GIAO_HANG_TIET_KIEN|
|status|string|status of this order. include : COMPLETE, CANCEL, DELAY, WAIT|
