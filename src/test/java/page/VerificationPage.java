package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.confirm;
//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;

public class VerificationPage {

    private final SelenideElement codeField = $("[data-test-id=code] input");
    private final SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public void verifycationPageVisiblity() {
        codeField.shouldBe(visible);
    }

    public void verifyErrorNotificationVisiblity() {
        errorNotification.shouldBe(visible);
    }

    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return new DashboardPage();
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}
