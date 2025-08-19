# Tour Package Management API

```
->This is a simple Tour Managaement Project that can be used to create packages with some certain criteria.  
-> I added a Location field to perform filtering

Apis Implemented:

1. Get all tours
API : http://15.206.13.100:9890/api/tours
example response:
[
  {
    "id": 1,
    "title": "Beach Holiday",
    "location": "Goa",
    "duration": "5 days",
    "actualPrice": "1500",
    "discountedPrice": "1200",
    "discountInPercentage": "20",
    "imageUrl": "https://example.com/beach.jpg",
    "description": "Relax on sunny beaches."
  }
]

2. Get tour by ID
API : /api/tours/{id}
example response:
{
  "id": 1,
  "title": "Beach Holiday",
  "location": "Goa",
  "duration": "5 days",
  "actualPrice": "1500",
  "discountedPrice": "1200",
  "discountInPercentage": "20",
  "imageUrl": "https://example.com/beach.jpg",
  "description": "Relax on sunny beaches."
}

3. Get tours by location
API: /api/tours/location?place=GOA
example response:

[
  {
    "id": 1,
    "title": "Beach Holiday",
    "location": "Goa",
    "duration": "5 days",
    "actualPrice": "1500",
    "discountedPrice": "1200",
    "discountInPercentage": "20",
    "imageUrl": "https://example.com/beach.jpg",
    "description": "Relax on sunny beaches."
  }
]

4. Create a new tour(POST)
API: /api/tours
example request:
{
  "title": "Mountain Trek",
  "location": "Himalayas",
  "duration": "7 days",
  "actualPrice": "2000",
  "discountedPrice": "1500",
  "discountInPercentage": "25",
  "imageUrl": "https://example.com/trek.jpg",
  "description": "Adventure trek in the Himalayas."
}

example response:
{
  "id": 2,
  "title": "Mountain Trek",
  "location": "Himalayas",
  "duration": "7 days",
  "actualPrice": "2000",
  "discountedPrice": "1500",
  "discountInPercentage": "25",
  "imageUrl": "https://example.com/trek.jpg",
  "description": "Adventure trek in the Himalayas."
}


-> Deployed on AWS EC2
-> Used AWS RDS for postgresql
-> Added Exception Handling
-> Added Logging using AOP



```
