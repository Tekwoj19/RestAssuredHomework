package feature;

import com.google.common.collect.Lists;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;

public class AddNumbers {

    private ArrayList<Integer> numbers = Lists.newArrayList();
    private int result;


    @Given("^number is (\\d+)$")
    public void number_is(int number) {

            numbers.add(number);

    }

    @When("^I add numbers$")
    public void i_add_numbers() {

            result = numbers.stream().mapToInt(Integer::intValue).sum();

    }

    @Then("^I get (\\d+) in result$")
    public void i_get_in_result(int number) {


        Assert.assertEquals(result,number);
    }



}
