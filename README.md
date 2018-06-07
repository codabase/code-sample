# Charter Enterprise MOTD Sample Project
I created two new Java classes for the project.
#### MessageOfTheDay.java
* Long id;
* String msg;
The MessageOfTheDay is an Entity Bean with two members.
* id is Primary Key and is generated.
* msg is the Message of the Day and is the only data in this class.
* The no argument constructor is private to prevent user to create a blank message. It may be called internally.
* The constructor wih String argument is used for the REST service. 
* The method equal added to test if two messages are equal and prevent user to added duplicates.  
#### MotdRepository.java
The MotdRepository is CrudRepository interface has find, create, update and delete operations. 
The object of this class is injected by spring framework

### Existing Classes of Project:
#### Motd.java 
* This class annotated as SpringBootApplication, the **_main_** method in this class starts the **_Motd_** server
* The init method is called to initialize MotdRepository with some data.
   
#### MotdController.java
* This class is a center of the project. 
* All the REST API and service of the applications are defined here.   
### REST APIs   
###### Find a Message By Id 
* URL: **_<base_url>/motds/{id}_**
* HTTP Method Type: **_`GET`_**
* Method:  **_findById(Long id)_**
* Returns a Singe message or null. The message returned has the same id as the id passed by user.
  * Returned Types
  * **_MessageOfTheDay_** An instance of this class returned if message found   
  * **_null_** is returned if the id not found
###### Find All Messages
 * URL: **_<base_url>/motds**_ 
 * HTTP Method Type: _**`GET`**_
 * Method:  **_findAll()_**
 * Returns the list of all messages on the severs. 
 * Returned Type 
 * List<MessageOfTheDay> list of all massages 
###### Create a Message
 * URL **_<base_url>/motds_** 
 * HTTP Method Type: **_`POST`_**
 * Method  :  **_addMsg(String msg)_**
 * Creates a message on the server using the same string passed by user.
 * Returned Http Status Code 
 * OK       if the message created.
 * FOUND    if a msg with the same content is found. No messae is created in this case.

###### Update a Message by passing a message as String
* URL: **_<base_url>motd/{id}_**
* HTTP Method **_`PUT`_**
* Method:**_updateMsg(Long id, String msg)_**
* Find and update the message on the server using the id provided by user
* Returned Http Status Code
* OK Message is updated.
* NOT_FOUND id not found.
###### Update Message by passing it as MessageOfTheDay object 
* URL: **_<base_url>/motd_** 
* HTTP Method **_`PUT`_**
* Find and update the message on the server using the id provided by user`
* Method:  (MessageOfTheDay msgOfTheDay)
* msgOfTheDay.id required 
* msgOfTheDay.msg required not empty
* Post Condition: The message on the server is equals o the message provided by user.
* If the message with the same id not found, application returns null,no change to the messages on server.
* Returned Http Status 
* OK        Message is updated.
* NOT_FOUND id not found.
###### Delete Message
* URL **_<base_url>/motds_** 
* HTTP Method **_DELETE_**
* Find and delete the message on the server using the id povided by user`
* Method:  deleteMsgBId(Long rid)
* Post Condition: The message with id=rid on is deleted from server.
* Returned Http Status 
* OK        The Message id=rid is deleted.
* NOT_FOUND message with id=rid not found.
###### Delete All Message
* URL **_<base_url>/motds_** 
* HTTP Method **_DELETE_**
* Find and delete all the message on the server
* Method Arguments :  deleteAll()
* Post Condition: No message left on the server  .
* Returned Http Status 
* OK  
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