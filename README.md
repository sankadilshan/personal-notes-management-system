# personal-notes-management-system

this is a REST API for personl notes management System

# technology
  java- spring boot <br/>
  (database- mysql)

# how to run
 first clone the respostiory <br/>
 there have 2 project folders <br/>
     1. persional notes management models- which include all the model classes and dto classes <br/>
     2. management service  <br/> <br/>
 
 first need to build mangement model- it is a simple maven project include our roles <br/>
     command to build: mvn clean install (cmd) <br/> <br/>
 second run to our management service enter <br/> 
    command: mvn spring-boot:run (cmd) <br/>
    Note: need mysql started (locally used) <br/>
    
    
 # why used this technology
  Spring boot is best framework for implement REST APIs with web application. It is annotation base framework and highly used dependency injection,it provide high performance
  and easily test (its provide test package when we create our project (default provide junit dependency)) also. <br/>
  In additionally if need to scale this system can scale most independly as separate service. <br/>
  In this project we are going to update our notes and user details, and because there haven't multiple relation and its not going to more complex mysql used as database service. <br/>
  
  # for ui/ux / frontend team
   In this project provide all the requirement as mention in description. You can easily get your data by putting needed variable in request url. Response is coming from backend easily handle in your frontend. <br/>
   ex: all archive notes <br/>
       /api/v1/notes/{userid}/archive <br/>
 
     
