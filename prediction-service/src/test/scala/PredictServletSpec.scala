import com.prediction.service.PredictService
import org.scalatest._

class PredictServletSpec extends FlatSpec with Matchers {
  "Predict" should "return a random number between a range" in {
    val randomService = new PredictService
    90 should be === randomService.random(Range(90, 91))
  }
}
