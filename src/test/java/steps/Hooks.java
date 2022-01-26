package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class Hooks extends CommonMethods {


    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(Scenario scenario){
        byte[] pic;
        //scenario class from cucumber holds the complete information of your execution
        if(scenario.isFailed()){
            pic = takeScreenshot("failed/" + scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+ scenario.getName());
        }

        //it will attach the pics in report
        scenario.attach(pic,"image/png", scenario.getName());
        closeBrowser();
    }

    public static class EmployeeSearchSteps extends CommonMethods {

        @When("user navigates to employee list page")
        public void user_navigates_to_employee_list_page() {
           // DahsboardPage dash = new DahsboardPage();

            //WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
           // dash.PimOption.click();
           // click(dash.PimOption);
            jsClick(dash.PimOption);

         //   WebElement employeeListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
            //dash.employeeListButton.click();
            click(dash.employeeListButton);
        }

        @When("user enters valid employee id")
        public void user_enters_valid_employee_id() {
          //  EmployeeListPage employeeListPage = new EmployeeListPage();
           // WebElement searchByID = driver.findElement(By.id("empsearch_id"));
         //   employeeListPage.idEmployeeSearch.sendKeys("23638000");
            sendText(employeeListPage.idEmployeeSearch, "23638000");

        }

        @When("user clicks on search button")
        public void user_clicks_on_search_button() {
         //   EmployeeListPage employeeListPage = new EmployeeListPage();
         //   WebElement searchButton = driver.findElement(By.id("searchBtn"));
            //employeeListPage.searchButton.click();
            click(employeeListPage.searchButton);
        }

        @Then("user see employee information is displayed")
        public void user_see_employee_information_is_displayed() {
            System.out.println("Information is displayed on page");
        }

        @When("user enters valid employee name")
        public void user_enters_valid_employee_name() {
         //   EmployeeListPage employeeListPage = new EmployeeListPage();
           //WebElement name = driver.findElement(By.id("empsearch_employee_name_empName"));
          // employeeListPage.empSearchStepByName.sendKeys("XYZT");
           sendText(employeeListPage.empSearchStepByName,"XYZT"
           );
        }
    }
}
