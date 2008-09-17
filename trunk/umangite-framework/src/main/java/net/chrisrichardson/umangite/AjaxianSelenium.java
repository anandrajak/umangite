package net.chrisrichardson.umangite;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Wait;

public class AjaxianSelenium extends DelegatingSelenium {

  public AjaxianSelenium(String host, int port, String browserType, String url) {
    selenium = new DefaultSelenium(host, port, browserType, url);
  }

  public void click(String selector) {
    waitForVisibility(selector);
    super.click(selector);
  }

  protected void waitForElementPresent(String selector) {
    WaitForElementPresent waiter = new WaitForElementPresent(selector);
    try {
      waiter.wait(String.format("Cannot find element <%s>", selector), 3000);
    } catch (Wait.WaitTimedOutException e) {
      return;
    }
  }

  protected void waitForVisibility(String selector) {
    WaitForElementVisible waiter = new WaitForElementVisible(selector);
    try {
      waiter.wait(String.format("Cannot find element <%s>", selector), 3000);
    } catch (Wait.WaitTimedOutException e) {
      return;
    }
  }

  @Override
  public boolean isElementPresent(String selector) {
    waitForElementPresent(selector);
    return super.isElementPresent(selector);
  }
  
  public void type(String selector, String text) {
    waitForVisibility(selector);
    super.type(selector, text);
  }

  @Override
  public boolean isTextPresent(String text) {
    waitForTextPresent(text);
    return super.isTextPresent(text);
  }

  private void waitForTextPresent(String text) {
    WaitForTextPresent waiter = new WaitForTextPresent(text);
    try {
      waiter.wait(String.format("Cannot find text element <%s>", text), 3000);
    } catch (Wait.WaitTimedOutException e) {
      return;
    }
  }

  @Override
  public boolean isVisible(String selector) {
    waitForVisibility(selector);
    return super.isVisible(selector);
  }
  
  class WaitForElementVisible extends Wait {
    private final String selector;

    public WaitForElementVisible(String selector) {
      this.selector = selector;
    }

    @Override
    public boolean until() {
      return selenium.isElementPresent(selector) && selenium.isVisible(selector);
    }

  }

  class WaitForTextPresent extends Wait {

    private final String text;

    public WaitForTextPresent(String text) {
      this.text = text;
    }

    @Override
    public boolean until() {
      return selenium.isTextPresent(text);
    }

  }

  class WaitForElementPresent extends Wait {

    private final String selector;

    public WaitForElementPresent(String selector) {
      this.selector = selector;
    }

    @Override
    public boolean until() {
      return selenium.isElementPresent(selector);
    }

  }
}
