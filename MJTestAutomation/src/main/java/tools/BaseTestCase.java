/**
 *
 */
package tools;

import org.junit.Rule;
import org.junit.rules.TestName;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.SauceOnDemandTestWatcher;


/**
 * Base Test case which Needs to be extended
 */
public class BaseTestCase implements SauceOnDemandSessionIdProvider
{
	/**
	 * Sauce Username
	 */
	public static final String USERNAME = "MadhuYarli";;//"samikbanerjee1";//"MadhuYarli";
	/**
	 * Sauce AutomateKey
	 */
	public static final String AUTOMATE_KEY = "4a4a991a-58e2-4e58-9203-933b569f5f5f";//"176d0ad6-8028-4068-bf7a-8617758ed99b";//"4a4a991a-58e2-4e58-9203-933b569f5f5f";

	/**
	 * Sauce URL
	 */
	public static final String URL = "@ondemand.saucelabs.com:80/wd/hub";

	/**
	 * Sauce session id
	 */
	public String sessionId;
	/**
	 * Setting Up sauce authentication
	 */
	public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(USERNAME, AUTOMATE_KEY);
	/**
	 * Report Test Results
	 */
	@Rule
	public SauceOnDemandTestWatcher resultReportingTestWatcher = new SauceOnDemandTestWatcher(this, authentication);
	/**
	 * Get the test method name
	 */
	@Rule
	public TestName name = new TestName()
	{
		@Override
		public String getMethodName()
		{
			return String.format(super.getMethodName());
		};
	};

	public String getSessionId()
	{
		return sessionId;
	}
}
