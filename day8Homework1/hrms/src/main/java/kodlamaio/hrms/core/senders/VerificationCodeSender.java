package kodlamaio.hrms.core.senders;

public class VerificationCodeSender {
	public boolean sendVerificationCode(String email, String code) {
		System.out.println(email + " adresine doğrulama kodu: " + code + " gönderildi");
		return true;
	}
}
