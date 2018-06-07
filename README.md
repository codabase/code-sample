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
* Usage `using the id provided by user returns a single message. The message id must be the same as the id paased by user.
 If message with the same is not found returns null. ` 
###### Find All Messages
 * URL **`motds`** 
 * HTTP Method _**`GET`**_
 * Usage `Returns the collection of all messages on the severs.` 
###### Create Message
 * URL **`motds`** 
 * HTTP Method **_`POST`_**
 * Usage `Creates a message on the server using the string passed by user.`
###### Update Message
  * URL **`motd/{id}`** 
  * HTTP Method **_`PUT`_**
  * Usage `Find and update the message on the server using the id povided by user`
  * arguments :  (Long id,String msg)
  * id provided 
  * msg provided
  * Post Condition: The message on the server is the same as the message provided by user.
  * If the message with the same id not found, application returns null.
###### Update Message
 * URL **`motd`** 
  * HTTP Method **_`PUT`_**
  * Usage `Find and update the message on the server using the id povided by user`
  * arguments : (MessageOfTheDay msgOfTheDay)
  * msgOfTheDay.id provided 
  * msgOfTheDay.msg provided
  * Post Condition: The message on the server is equals o the message provided by user.
  * If the message with the same id not found, application returns null,no change to the messages on server.
  
  
  
## Instructions
We have provided a webservice that provides a "message of the day", similar to what you might see logging into a Unix system. Unfortuantely, at Charter things don't always go as planned and we need to change the message.  We need you to add the ability to change the message.   The message can be stored in the service using any mechanism you like, but aim for simplicity.  Something very simple, and in memory can be used.   It does not have to be durable between restarts, so please avoid writing to a file.  A persistent store like MySQL or Hypersonic could be overkill for this new requirement.  Iterative requests for the MOTD should return the new message, if it has been changed. Be sure to edit this README.md so we understand what you've done.

Also, a rogue developer has left the code base broken.  To get anything done, you're doing to have to fix the tests first! And, no, -DskipTests is not a solution!

Push your answer to this Github repo as a feature branch and create a pull request so we know you're done.

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