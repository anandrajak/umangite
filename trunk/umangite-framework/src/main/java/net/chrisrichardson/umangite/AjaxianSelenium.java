package net.chrisrichardson.umangite;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleniumException;
import com.thoughtworks.selenium.Wait;

public class AjaxianSelenium extends DelegatingSelenium {

  private Log logger = LogFactory.getLog(getClass());
  
  private static final int DEFAULT_AJAX_TIMEOUT = 24*1000;
  private int ajaxTimeout = DEFAULT_AJAX_TIMEOUT;
  
  public void setAjaxTimeout(int timeout) {
    this.ajaxTimeout = timeout;
  }
  
  public AjaxianSelenium(String host, int port, String browserType, String url) {
    selenium = new DefaultSelenium(host, port, browserType, url);
  }

  public void click(String selector) {
    for (int i = 0; i < 3 && waitForVisibility(selector); i++) {
      try {
        super.click(selector);
        return;
      } catch (RuntimeException e) {
      }
    }
    super.click(selector);
  }

  protected boolean waitForElementPresent(String selector) {
    WaitForElementPresent waiter = new WaitForElementPresent(selector);
    try {
      waiter.wait(String.format("Cannot find element <%s>", selector), ajaxTimeout);
      return true;
    } catch (Wait.WaitTimedOutException e) {
      return false;
    }
  }

  protected boolean waitForVisibility(String selector) {
    WaitForElementVisible waiter = new WaitForElementVisible(selector);
    try {
      waiter.wait(String.format("Cannot find element <%s>", selector), ajaxTimeout);
      return true;
    } catch (Wait.WaitTimedOutException e) {
      return false;
    }
  }

  @Override
  public boolean isElementPresent(String selector) {
    return waitForElementPresent(selector);
  }
  
  public void type(String selector, String text) {
    waitForVisibility(selector);
    super.type(selector, text);
  }

  @Override
  public boolean isTextPresent(String text) {
    return waitForTextPresent(text);
  }

  private boolean waitForTextPresent(String text) {
    WaitForTextPresent waiter = new WaitForTextPresent(text);
    try {
      waiter.wait(String.format("Cannot find text element <%s>", text), ajaxTimeout);
      return true;
    } catch (Wait.WaitTimedOutException e) {
      return false;
    }
  }

  @Override
  public boolean isVisible(String selector) {
    return waitForVisibility(selector);
  }
  
  class WaitForElementVisible extends Wait {
    private final String selector;

    public WaitForElementVisible(String selector) {
      this.selector = selector;
    }

    @Override
    public boolean until() {
      if (!selenium.isElementPresent(selector))
        return false;
      try {
        return selenium.isVisible(selector);
      } catch (SeleniumException e) {
        logger.debug("isVisible threw exception", e);
        return false;
      }
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
