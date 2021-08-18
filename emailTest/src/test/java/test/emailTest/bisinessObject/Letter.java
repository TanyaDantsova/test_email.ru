package test.emailTest.bisinessObject;

public class Letter {
    private String subject;
    private String mailBody;

    public Letter(String subject, String mailBody) {
        this.subject = subject;
        this.mailBody = mailBody;
    }

    public String getSubject() {
        return subject;
    }

    public String getMailBody() {
        return mailBody;
    }
}
