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
* The MotdRepository extending Spring CrudRepository interface.
* The interface provides all crud method find, create, update, delete plus more and injected by spring framework

### Existing Classes of Project:
#### Motd.java 
* This class annotated as SpringBootApplication, the **_main_** method in this class starts the **_Motd_** server
* The init method is called to initialize MotdRepository with some data.
   
#### MotdController.java
* This class is a center of the project. 
* All the REST API and service of the applications are defined here.   
### REST APIs   
####findById(Long id)
* URL: **_<base_url>/motds/{id}
* HTTP Method Type: **_`GET`_**
* Returns a Singe message or null. 
  * Method Return
  * **_MessageOfTheDay_** if id is found   
  * **_null_** if the id not found
#### findAll() 
 * URL: **_<base_url>/motds**_ 
 * HTTP Method Type: _**`GET`**_
 
 * Returns the list of all messages on the severs. 
 * Returned Type 
 * List<MessageOfTheDay> list of all massages 
##### addMsgOfTheDay(String msg)
 * URL **_<base_url>/motds_** 
 * HTTP Method Type: **_`POST`_**
 * Creates a message on the server using the same string passed by user.
 * Returned Http Status Code 
    * OK      
    * FOUND    

##### updateMsg(Long id, String msg)
* URL: **_<base_url>motd/{id}_**
* HTTP Method **_`PUT`_**
* Find and update the message on the server using the id provided by user
* Returned Http Status Code
    * OK 
    * NOT_FOUND 
##### update(MessageOfTheDay msgOfTheDay) 
* URL: **_<base_url>/motd_** 
* HTTP Method **_`PUT`_**
* Updates message if the id is found.
* Returned Http Status 
    *  OK        
    * NOT_FOUND 
#####deleteMsgBId(Long rid)
* URL **_<base_url>/motds_** 
* HTTP Method **_DELETE_**
* Deletes a Single message
* Returned Http Status 
    * OK     
    * NOT_FOUND 
##### deleteAll()
* URL **_<base_url>/motds_** 
* HTTP Method **_DELETE_**
* Delete all the message on the server  
* Returned Http Status 
    *  OK  
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