package testRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testRunner.mjb2c.MJB2CCASmokeTestCases;
import testRunner.mjb2c.MJB2CUSSmokeTestCases;
import testRunner.zo.ZOCASmokeTestCases;
import testRunner.zo.ZOUSSmokeTestCases;


/**
 * Test Suite to run all test cases
 */
@RunWith(Suite.class)
@SuiteClasses(
{ MJB2CUSSmokeTestCases.class, MJB2CCASmokeTestCases.class, ZOUSSmokeTestCases.class, ZOCASmokeTestCases.class })
public class TestSuite
{

}
