package Util;

import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;

import javax.inject.Inject;

public class EmailUtil {

    private final MailerClient mailerClient;

    @Inject
    public EmailUtil(MailerClient mailerClient) {
        this.mailerClient = mailerClient;
    }

    public void sendOTP(String recipientEmail, String otp) {
        System.out.println(otp);
        Email email = new Email()
                .setSubject("OTP Verification")
                .setFrom("yash.mehrotra@biz4solutions.com")
                .addTo(recipientEmail)
                .setBodyText("Your OTP is: " + otp);
        System.out.println(email.getBodyText());

        mailerClient.send(email);
    }
    }



