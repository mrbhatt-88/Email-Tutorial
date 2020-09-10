
# Email-Tutorial
- In this Repository Show the Exmples of Related to Java-Mail-API and also Check Email exist of not that use by ThirdParty API call inside java Code Using HttpClient.


## Requires Dependency for This Repository.
1. javax.mail-1.6.0.jar Get from [Here](https://mvnrepository.com/)
2. httpclient-4.3.1.wso2v1.jar Get from [Here](https://mvnrepository.com/)
3. org-apache-commons-logging.jar Get from [Here](https://mvnrepository.com/)
4. org.json.simple-0.4.jar Get from [Here](https://mvnrepository.com/)


## [Send-Mail](https://github.com/mrbhatt-88/Email-Tutorial/blob/master/src/EmailSend.java) : 
1. Setting in Email Account 
     * When We send mail using java-Mail-API then Send Person (TO) mail 2 step Authetication is OFF and Less-Secure APP is ON.
     * About the 2 step Authentication and Less-Secure app Visit this Link : [Here](https://myaccount.google.com/security)
2. Requrinment Data for Send mail
     * FROM email id and it's password. (With Above Setting)
     * TO email id
3. Properties Required for Read-Mail is below.
```
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
```


## [Read-Mail](https://github.com/mrbhatt-88/Email-Tutorial/blob/master/src/ReadMail.java) : 
1.   Requrinment Data for Read mail
     * FROM email id and it's password. (With Above Setting)
     * TO email id
     * Availability of UnRead mail In your INBOX folder.
2. Properties Required for Read-Mail is below.
```
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
```


## [Fetch-Attachment from Unread-Mail](https://github.com/mrbhatt-88/Email-Tutorial/blob/master/src/FetchMailAttachment.java) :
1. Requrinment Data for Fetch Attachment in the mail
     * FROM email id and it's password. (With Above Setting)
     * TO email id
     * Availability of UnRead mail In your INBOX folder.
2. Properties Required for Read-Mail is below.
```
        Properties properties = System.getProperties();
        properties.put("mail.pop3.host", "pop.gmail.com");
        properties.put("mail.pop3.port", "995");
        properties.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.pop3.socketFactory.fallback", "false");
        properties.setProperty("mail.pop3.socketFactory.port", String.valueOf("995"));
```


## [Check Email-Exist or not using ThirdParty API](https://github.com/mrbhatt-88/Email-Tutorial/blob/master/src/ExistenceOfMail.java)
1. Requrinment Data for Check Email-Exist mail
    * API key of ThirdParty API.
    * API key Get from here : [Here](https://mailboxlayer.com/)
    * Any mail Account.
2. First Understand The 2 things
    * What is MX Record [Here](https://www.copernica.com/en/blog/post/a-record-and-mx-record-how-does-it-work)
    * Understand the Boolean Status [smtp_check](https://mailboxlayer.com/documentation) and [mx_found](https://mailboxlayer.com/documentation)



 ## Contributor.
   1.  welcome to all contributors who are curious about this project then, contribute in it.Kindly fork this project for add your programs. You can learn Git from [Here](https://www.youtube.com/watch?v=OdbBmvfThJY&list=PLsyeobzWxl7q2eaUkorLZExfd7qko9sZC&index=1) and [Here](https://guides.github.com/activities/hello-world/)   

     
      

