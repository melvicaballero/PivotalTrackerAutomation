package pivotal.ui.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotal.ui.pages.LoginPage;

import java.time.Duration;

/**
 * Created by Melvi Caballero.
 * Class to Account panel of pivotal tracker.
 */
public class AccountPanel extends TopBar {

    public static final int SECONDS = 10;
    @FindBy(xpath = "//button[text()=\"Sign Out\"]")
    private WebElement signOut;

    /**
     * This method did a press over Sign Out Link.
     *
     * @return The login page.
     */
    public LoginPage pressSignOutLink() {
        signOut.click();
        return new LoginPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.withTimeout(Duration.ofSeconds(SECONDS)).until(ExpectedConditions.elementToBeClickable(signOut));
    }
}
