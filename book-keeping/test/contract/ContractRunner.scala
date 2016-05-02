package contract

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith


@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("contracts"),
  glue = Array("contract"),
  format = Array("pretty", "html:target/cucumber-report"),
  tags = Array()
)
class ContractRunner {

}
