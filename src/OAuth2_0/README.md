# Email-Tutorial


## Send Mail using OAuth2.0 Authorization Framework
1. You can learn this Framework from [Here](https://auth0.com/docs/protocols/oauth2)

2. Process of Generate AccessToken

    * [Click Here](https://developers.google.com/identity/protocols/oauth2/web-server#httprest_3) and Follow the process for generating access token.

3.  Requirnment Parameter for this package
    
       * FROM email id. Here password not required.
       * TO email id

4. Require Properties for send email with OAuth2.0

```
Properties props = new Properties();
props.put("mail.smtp.ssl.enable", "true");  // required for Gmail account
props.put("mail.smtp.sasl.enable", "true");
props.put("mail.smtp.sasl.mechanisms", "XOAUTH2");
props.put("mail.smtp.auth.login.disable", "true");
props.put("mail.smtp.auth.plain.disable", "true");
```

5. Step by Step Process of OAuth2.0 with IMAP and SMTP of Gmail

    *  [Click Here](https://kgiann78.github.io/java/gmail/2017/03/16/JavaMail-send-mail-at-Google-with-XOAUTH2.html) and Follow the Process.
