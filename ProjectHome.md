The Umangite framework simplifies the task of writing web tests with Selenium. It's built on TestNG, Spring and Cargo.

Here is an example of a simple test:

```
public class HelloWorldTest extends AbstractSeleniumTest {

  @Override
  protected String[] getConfigLocations() {
   return new String[] { ... };
  }
	
  @Test
  public void test() {
    open('/testwebapp/index.html');
    assertTextPresent('Hello There');
  }

}
```

AbstractSeleniumTest has an @BeforeClass method that starts the web container and Selenium and @AfterClass method that shuts them down. It also injects itself with Spring beans (from an application context defined by the getConfigLocations()). The Spring beans are responsible for launching Selenium and the web container. There are currently two launchers: one that runs an embedded Jetty and the other uses Cargo to launch Tomcat (To be generalized to support other containers).

Here are some example bean definitions:
```
  <bean id='seleniumLauncher'
   class='net.chrisrichardson.umangite.SeleniumLauncher' />

  <bean id='webContainerLauncher'
    class='net.chrisrichardson.umangite.JettyLauncher'>
   <property name='webAppDirectory'
             value='../umangite-testwebapp/src/main/webapp' />
   <property name='contextPath'
             value='testwebapp' />
  </bean>
```

Once of the nice things around this framework is that the same test class can be run with multiple containers - e.g. both Jetty for nimble developer testing and Tomcat for other tests.
