# Charter Enterprise MOTD Sample Project
In this project we have created two new Java classes:
##### MessageOfTheDay
##### MotdRepository

The MessageOfTheDay is an Entity Bean with two attributes.
* id is Primary and is generated in sequence.
* msg is the Message of the Day and is the only data in this class.
* The no argument constructor is private to prevent user to create a blank message.It may be called internally.
* The constructor wih String argument is used for REST service 
* The other method is equal method. Added to test if two message are equal and prevent user to added duplicates.  

The MotdRepository is CrudRepository interface with normal Find, Create, Update and Delete operations. The object is injected by spring framework

The two existing classes in this project are:
##### Motd
The **_main_** method in this ****class is called by SpringBoot to start the **_Message of the Day_** Application 
The init method of the method is called to initialize our repository with some data.
The **_motdRepository_** is our repository to create and maintain the Messages.   
##### MotdController
The class is the main engine of the our application provides the REST service method to other application to use or maintain the messages.   
##### REST API  
###### Find a Message By Id 
* URL **`motds/{id}`**  
* HTTP Method **_`GET`_**
* Method Arguments :  (Long id)
* Usage `using the id provided by user returns a single message. The message id must be the same as the id paased by user.
 If message with the same not found the metod returns null. ` 
  * Returned Values 
  * MessageOfTheDay object if Object with the same id found
  * null if the id not found
###### Find All Messages
 * URL **`motds`** 
 * HTTP Method _**`GET`**_
 * Method Arguments :  ()
 * Usage `Returns the collection of all messages on the severs.` 
 * Returned Values 
 * List<MessageOfTheDay> list of all massages 
###### Create Message
 * URL **`motds`** 
 * HTTP Method **_`POST`_**
 * Method Arguments :  (String msg)
 * Usage `Creates a message on the server using the string passed by user.`
 * Returned Values 
 * Http Status OK           if the message created.
 * Http Status FOUND    if the message already exist in server.

###### Update Message
* URL **`motd/{id}`** 
* HTTP Method **_`PUT`_**
* Method Arguments :  (Long id, String msg)
* Usage `Find and update the message on the server using the id povided by user`
* id provided 
* msg provided
* Post Condition: The message on the server is the same as the message provided by user.
* Returned Values 
* Http Status OK        Message is updated.
* Http Status NOT_FOUND Message exist on server.
###### Update Message
* URL **`motd`** 
* HTTP Method **_`PUT`_**
* Usage `Find and update the message on the server using the id povided by user`
* Method Arguments :  (MessageOfTheDay msgOfTheDay)
* msgOfTheDay.id required 
* msgOfTheDay.msg required not empty
* Post Condition: The message on the server is equals o the message provided by user.
* If the message with the same id not found, application returns null,no change to the messages on server.
* Returned Values 
* Http Status OK        Message is updated.
* Http Status NOT_FOUND Message exist on server.
###### Delete Message
* URL **`motd`** 
* HTTP Method **_`DELETE`_**
* Usage `Find and delete the message on the server using the id povided by user`
* Method Arguments :  (Long id)
* Post Condition: The message on the server is equals o the message provided by user.
* If the message with the same id not found, application returns null,no change to the messages on server.
* Returned Values 
* Http Status OK        Message is updated.
* Http Status NOT_FOUND Message exist on server.
## Instructions


### Getting Started
* To compile
```mvn clean package```

* To run
```mvn spring-boot:run```

* To see the message:
```curl localhost:8080```

### Prerequisites
* Java 1.8
* Maven
* cURL
  
### Deployment
If you whiz through this sample, try adding a deployment.   We are a Docker and AWS shop.  Getting something into an AWS or Heroku, or whatever you're comfortable with will be an "A+"

### Project hints and questions
* Stuck getting started?
  * The official Spring Boot "hello world" example is a great starting point.
* Still need help?
  * Further hints are available, Feel free to ask questions here.  Edit this file in your branch by adding to the questions section, push it, and we will update the file with answers. 