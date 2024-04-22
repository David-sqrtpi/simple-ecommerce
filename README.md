# Simple Ecommerce
This is a Spring boot application, it allows to manage the cart module of an ecommerce, the project uses a in-memory database with JPA.
This project can be tested using any API tester like Postman or the [simple-ecommerce-client](https://github.com/David-sqrtpi/simple-e-commerce-client).
## Endpoints
For those methods who allows a request body it is a raw JSON
| Method | Endpoint | Description | Response
| ------------- | ------------- | -------------- | ------------- |  
| GET  | products | Get all products of the ecommerce| A list of products
| POST | products | Add a product with the body request|
| DELETE| products/{uuid} | Delete the product identified by the UUID `uuid` |
| PUT | products/{uuid} | Modify the product identified by the UUID `uuid` |
| GET | carts/{uuid} | Get the cart identified by the UUID `uuid` | A cart with its products
| POST | carts/{cartUuid} | Add a product to the cart identified by the UUID `cartUuid` | 
| DELETE | carts/{uuid} | Delete a product to the car identified by the UUID `uuid` | Confirmation String
| POST | carts/checkout/{uuid} | Make a checkout to the cart identified by the UUID `uuid` | Confirmation String 
| POST | carts | Allows to create a new cart |

The .jar artifact can be downloaded from https://github.com/David-sqrtpi/simple-ecommerce/blob/master/build/libs/simple-ecommerce-1.0.jar for making tests with java version 15. **Just download it and enjoy!!! :-)**.
