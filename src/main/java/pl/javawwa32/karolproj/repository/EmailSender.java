package pl.javawwa32.karolproj.repository;


public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
