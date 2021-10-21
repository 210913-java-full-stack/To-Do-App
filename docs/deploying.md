# Steps to deploy to AWS
1. create an elastic beanstalk environment running tomcat and coretto 8
2. change POM.xml to package the application as a war instead of a jar
3. Alter the hibernate configuration to get settings from system properties
4. Set those system properties in the elastic beanstalk environment
5. build the project into a war file with "mvn package"
6. upload the war file to the tomcat server created in step 1
7. we need to change references to our API endpoints to point to the new location
8. we need to create an S3 bucket - and make it public
9. we need to upload our web pages to that bucket.
 