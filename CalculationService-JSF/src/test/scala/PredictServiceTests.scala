import com.prediction.service.PredictService
import org.hamcrest.Matchers
import org.junit.{Assert, Test}
import org.junit.Assert

/**
 * Created by prayagupd
 * on 12/13/15.
 */

class PredictServiceTests {

  val predictService = new PredictService

  @Test
  def randomShouldReturnARandomNumberBetweenGivenRange() = {
    val random : Int = predictService.random(range = Range(90, 91))
    Assert.assertThat(random, Matchers.equalTo(90))
//  Assert.assertThat(random, Matchers.greaterThan(90))
  }

}
