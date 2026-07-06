import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite
@SelectClasses({
        AssertionsTest.class,
        EvenchechTest.class,
        AAA.class
})
public class SuiteTest
{

}
