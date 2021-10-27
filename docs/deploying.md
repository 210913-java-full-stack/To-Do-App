# Steps to deploy to AWS
1. create an elastic beanstalk environment running tomcat and coretto 8
2. change POM.xml to package the application as a war instead of a jar
   1. if you don't see the <packaging> tags, add them under the other artifact info 
3. Optional: Alter the hibernate configuration to get settings from system properties
   1. may not be necessary because maven is bundling our hibernate.properties file into the war for us
   2. Set those system properties in the elastic beanstalk environment
4. build the project into a war file with "mvn package"
5. upload the war file to the tomcat server created in step 1
6. we need to change references to our API endpoints(in the UI) to point to the new location of the API
7. we need to create an S3 bucket - and make it public
8. we need to set our bucket for static site hosting 
   1. (click the bucket and click properties tab, scroll to bottom)
9. add a bucket policy to make the items in the bucket available for requests (see below)
   1. Optionally: provide an index.html as a homepage.
10. we need to upload our web pages to that bucket.
 

Don't forget to change the ARN, you can get that from the bucket properties. 
Note that after the bucket ARN you want to keep the "/*" part, 
this wildcard makes everything in the bucket publicly available.
```json
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "PublicReadGetObject",
            "Effect": "Allow",
            "Principal": "*",
            "Action": [
                "s3:GetObject"
            ],
            "Resource": [
                "arn:aws:s3:::Bucket-Name/*"
            ]
        }
    ]
}
```