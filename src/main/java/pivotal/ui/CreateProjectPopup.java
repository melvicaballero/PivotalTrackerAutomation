package pivotal.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotal.entities.Project;
import pivotal.ui.pages.BasePage;

import java.util.concurrent.TimeUnit;

public class CreateProjectPopup extends BasePage {

    @FindBy(name = "project_name")
    private WebElement projectNameTextBox;

    @FindBy(xpath = "//div[@class=\"tc-account-selector__header\"]")
    private WebElement accountDropDown;

    @FindBy(xpath = "//ul[@class=\"tc-account-selector__option-list\"]/li[@class=\"tc-account-selector__option-account\"][1]")
    private WebElement getAccountDropDownFirstOption;

    @FindBy(xpath = "//input[@value=\"public\"]")
    private WebElement projectTypePublic;

    @FindBy(xpath = "//input[@value=\"private\"]")
    private WebElement projectTypePrivate;

    @FindBy(xpath = "//button[text()=\"Create\"]")
    private WebElement createButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    public void setProjectNameTextBox (String projectName) {

        projectNameTextBox.sendKeys(projectName);
    }

    public void pressAccountDropdown(){
        accountDropDown.click();
    }

    public void selectaccountDropdownFirstOption(){

        wait.withTimeout( 2, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(getAccountDropDownFirstOption));
        getAccountDropDownFirstOption.click();
    }

    public void setProjectTypePublic(){
        projectTypePublic.click();
    }

    public void setProjectTypePrivate(){
        projectTypePrivate.click();
    }

    public void pressCreateButton(){
        createButton.click();
    }

    public void createNewProject(Project project){
        setProjectNameTextBox(project.getName());
        pressAccountDropdown();
        selectaccountDropdownFirstOption();
        if(project.getPrivacy().equals("Public")){
            setProjectTypePublic();
        }
        else {
            setProjectTypePrivate();
        }
        pressCreateButton();

        wait.withTimeout( 10, TimeUnit.SECONDS).until(ExpectedConditions.urlContains("/n/projects"));
    }

}
