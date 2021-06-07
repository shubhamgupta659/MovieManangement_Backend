Steps to run backend service :
1)install mysql db
2)set username and password during installation
3)Run sql queries provided in schema.sql file under resourse folder
4)configure db username and password in dev properties file under resourse folder
5) build and run the application 

Steps to retrieve oauth Jwt token :
1) post type of request to : http://localhost:8081/oauth/token
2) header : 
     "Authorization" : "Basic c2hndXB0YS1jbGllbnQ6c2hndXB0YS1zZWNyZXQ=",
     "Content-Type":"application/x-www-form-urlencoded"
 3) body of type x-www-form-urlencoded :
     "username" : "admin",
     "password":"admin",
     "grant_type":"password"
 4) in response you will recieve jwt encoded access token
     
     
Steps to make any backend request :
   1) header : 
       "Authorization" : "Bearer <access_token>"
   2) now you can make any backend request (GET, POST, etc.)
       
 

