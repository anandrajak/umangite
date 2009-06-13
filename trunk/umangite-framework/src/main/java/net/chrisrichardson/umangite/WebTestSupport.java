package net.chrisrichardson.umangite;

import static org.testng.AssertJUnit.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;

public abstract class WebTestSupport implements Selenium {
	
	private Log logger = LogFactory.getLog(getClass());

	protected static SeleniumLauncher selenium;

	protected static WebContainerLauncher container;

	public static ApplicationContextContainer applicationContextContainer = new ApplicationContextContainer();

	protected ApplicationContext appCtx;

  private boolean screenshotOnError;
	
	public WebTestSupport() {
	}

	public void setScreenshotOnError(boolean screenshotOnError) {
    this.screenshotOnError = screenshotOnError;
  }
	
	protected void startSeleniumAndWebApplication() throws Exception {
		injectUmangiteDependencies();
		prepareWebApplication();
		
		logger.debug("starting container...");
		try {
			container.start();
		} catch (Exception e) {
			logger.fatal("error starting container: ", e);
			throw e;
		}
		logger.debug("starting selenium for container port: " + container.getActualPort());
		selenium.startSelenium(getContainerHost(), container.getActualPort());
		logger.debug("Started");
	}
	
	@BeforeClass
	public void initializeDependencies() {
		injectDependencies();
	}


	protected void stopSeleniumAndWebApplication() {
		try {
			container.stop();
		} catch (Throwable e) {
			logger.error(e);
		}

		selenium.stopSelenium();
	}

	private void injectDependencies() {
		appCtx = applicationContextContainer.getApplicationContext(getConfigLocations());
		((ClassPathXmlApplicationContext) appCtx).getBeanFactory()
				.autowireBeanProperties(this,
						AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
	}

	private void injectUmangiteDependencies() {
		appCtx = applicationContextContainer.getApplicationContext(getUmangiteConfigLocations());
		((ClassPathXmlApplicationContext) appCtx).getBeanFactory()
		.autowireBeanProperties(this,
				AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
		assertNotNull("Web container launcher required", container);
		assertNotNull("Selenium launcher required", selenium);
	}

	public void setSelenium(SeleniumLauncher selenium) {
		WebTestSupport.selenium = selenium;
	}

	public void setContainer(WebContainerLauncher container) {
		WebTestSupport.container = container;
	}

	protected String getContainerType() {
		return System.getProperty("umangite.container.type", "jetty");
	}

	protected void prepareWebApplication() {
		
	}

	protected abstract String[] getConfigLocations();
	protected abstract String[] getUmangiteConfigLocations();

	// methods for delegating to selenium


	public void altKeyDown() {
		selenium.altKeyDown();
	}

	public void altKeyUp() {
		selenium.altKeyUp();
	}



	public void chooseCancelOnNextConfirmation() {
		selenium.chooseCancelOnNextConfirmation();
	}

	public void click(String locator) {
		try {
			selenium.click(locator);
		} catch (SeleniumException e) {
			try {
				String body = selenium.getHtmlSource();
				logger.error("error in click", e);
				fail("Couldn't click on <" + locator + "> in " + body);
			} catch (SeleniumException e2) {
				logger.error("Error getting HTML", e2);
				throw e;
			}
		}
	}
	
	protected void fail(String message) {
	  message = maybeCaptureScreenshot(message);
	  org.testng.AssertJUnit.fail(message);
  }

  private String maybeCaptureScreenshot(String message) {
    if (screenshotOnError)
  	  try {
  	    String fileName = captureScreenshotToTempFile(message);
        message = "Screenshot in " + fileName + " for error: " + message;
  	  } catch (Exception e) {
  	    logger.error("error: captureScreenshot", e);
  	  }
    return message;
  }

  protected String captureScreenshotToTempFile(String message) throws IOException {
    File file = File.createTempFile("seleniumscreenshot", ".png");
    String fileName = file.getAbsolutePath();
    selenium.captureScreenshot(fileName);
    if (message != null)
      FileUtils.writeStringToFile(new File(fileName + ".txt"), message);
    return fileName;
  }
	


	public void close() {
		selenium.close();
	}

	public void controlKeyDown() {
		selenium.controlKeyDown();
	}

	public void controlKeyUp() {
		selenium.controlKeyUp();
	}

	public boolean equals(Object obj) {
		return selenium.equals(obj);
	}


	public String getAlert() {
		return selenium.getAlert();
	}

	public String[] getAllButtons() {
		return selenium.getAllButtons();
	}

	public String[] getAllFields() {
		return selenium.getAllFields();
	}

	public String[] getAllLinks() {
		return selenium.getAllLinks();
	}

	public String[] getAllWindowIds() {
		return selenium.getAllWindowIds();
	}

	public String[] getAllWindowNames() {
		return selenium.getAllWindowNames();
	}

	public String[] getAllWindowTitles() {
		return selenium.getAllWindowTitles();
	}

	public String getBodyText() {
		return selenium.getBodyText();
	}

	public String getConfirmation() {
		return selenium.getConfirmation();
	}

	public String getCookie() {
		return selenium.getCookie();
	}

	public String getHtmlSource() {
		return selenium.getHtmlSource();
	}

	public String getLocation() {
		return selenium.getLocation();
	}

	public Number getMouseSpeed() {
		return selenium.getMouseSpeed();
	}

	public String getPrompt() {
		return selenium.getPrompt();
	}

	public String getSpeed() {
		return selenium.getSpeed();
	}

	public String getText(String locator) {
		try {
			return selenium.getText(locator);
		} catch (SeleniumException e) {
			try {
				String body = selenium.getHtmlSource();
				logger.error("error in getText()", e);
				fail("Couldn't get text on <" + locator + "> in " + body);
				return null;
			} catch (SeleniumException e2) {
				logger.error("Error getting HTML", e2);
				throw e;
			}
		}
	}

	public String getTitle() {
		return selenium.getTitle();
	}

	public void goBack() {
		selenium.goBack();
	}

	public boolean isAlertPresent() {
		return selenium.isAlertPresent();
	}

	public boolean isConfirmationPresent() {
		return selenium.isConfirmationPresent();
	}

	public boolean isPromptPresent() {
		return selenium.isPromptPresent();
	}

	public boolean isVisible(String locator) {
		return isElementPresent(locator) && selenium.isVisible(locator);
	}

	public void metaKeyDown() {
		selenium.metaKeyDown();
	}

	public void metaKeyUp() {
		selenium.metaKeyUp();
	}

	public void open(String url) {
		try {
			selenium.open(url);
		} catch (SeleniumException e) {
			String message = maybeCaptureScreenshot("Failed to open: " + url + " " + e.getMessage());
	      logger.error(message, e); 
	      throw new RuntimeException(message, e);
	    }
	}

	public void refresh() {
		selenium.refresh();
	}

	public void select(String selectLocator, String optionLocator) {
		try {
			selenium.select(selectLocator, optionLocator);
		} catch (SeleniumException e) {
			try {
				String body = selenium.getHtmlSource();
				logger.error("Error in select()", e);
				fail("Couldn't select in <" + selectLocator + "," + optionLocator + "> in " + body);
			} catch (SeleniumException e2) {
				logger.error("Error getting HTML", e2);
				throw e;
			}

		}
	}

	public void shiftKeyDown() {
		selenium.shiftKeyDown();
	}

	public void shiftKeyUp() {
		selenium.shiftKeyUp();
	}

	public void start() {
		selenium.start();
	}

	public void type(String locator, String value) {
		try {
			selenium.type(locator, value);
		} catch (SeleniumException e) {
			try {
				String body = selenium.getHtmlSource();
				logger.error("Error in type()", e);
				fail("Couldn't type in <" + locator + "> in " + body);
			} catch (SeleniumException e2) {
				logger.error("Error getting HTML", e2);
				throw e;
			}
		}	
	}

	public void windowFocus() {
		selenium.windowFocus();
	}

	public void windowMaximize() {
		selenium.windowMaximize();
	}

	protected void clickAndWait(String selector) {
		click(selector);
		waitForPageToLoad("30000");
	}

	protected void assertTextPresent(String text) {
		assertPageContent("Could not find on page" + text, isTextPresent(text));
	}

  protected void assertIsVisible(String selector) {
    assertPageContent("Is not visible " + selector, isVisible(selector));
  }

  protected void assertTitle(String title) {
		assertPageContent(String.format("Expected title <%s> but got <%s>", title, getTitle()), title.equals(getTitle()));
	}

	private void assertPageContent(String message, boolean result) {
		if (!result) {
			fail(message + " on page: " + getHtmlSource());
		}
	}

	protected void assertTextEquals(String expectedText, String selector) {
	  assertElementPresent(selector);
		String actualText = getText(selector);
		if (!expectedText.equals(actualText)) {
			String html = null;
			try {
				html = getHtmlSource();
			} catch (SeleniumException e) {
				logger.error("Error getting HTML", e);
			}
			fail(String.format("For selector <%s> expected text <%s> but got <%s> on page <%s>", selector, expectedText, actualText, html));
		}
	}

	protected void assertElementPresent(String locator) {
		assertPageContent(String.format("Expected element <%s>: ", locator), isElementPresent(locator));
	}

	public void chooseOkOnNextConfirmation() {
		selenium.chooseOkOnNextConfirmation();
	}

	public int hashCode() {
		return super.hashCode();
	}

	public void setBrowserType(String browserType) {
		selenium.setBrowserType(browserType);
	}

	public void setPort(int port) {
		selenium.setPort(port);
	}

	public void startSelenium(int containerPort) throws Exception {
		selenium.startSelenium(getContainerHost(), containerPort);
	}

  protected String getContainerHost() {
    return "localhost";
  }

	public void stop() {
		selenium.stop();
	}

	public void stopSelenium() {
		selenium.stopSelenium();
	}

	public void windowMaximizein() {
		selenium.windowMaximizein();
	}
	
	public Selenium getRealSelenium() {
	  return selenium.getRealSelenium();
	}

	public void addCustomRequestHeader(String key, String value) {
		selenium.addCustomRequestHeader(key, value);
	}

	public void addLocationStrategy(String strategyName,
			String functionDefinition) {
		selenium.addLocationStrategy(strategyName, functionDefinition);
	}

	public void addScript(String scriptContent, String scriptTagId) {
		selenium.addScript(scriptContent, scriptTagId);
	}

	public void addSelection(String locator, String optionLocator) {
		selenium.addSelection(locator, optionLocator);
	}

	public void allowNativeXpath(String allow) {
		selenium.allowNativeXpath(allow);
	}

	public void answerOnNextPrompt(String answer) {
		selenium.answerOnNextPrompt(answer);
	}

	public void assignId(String locator, String identifier) {
		selenium.assignId(locator, identifier);
	}

	public void attachFile(String fieldLocator, String fileLocator) {
		selenium.attachFile(fieldLocator, fileLocator);
	}

	public void captureEntirePageScreenshot(String filename, String kwargs) {
		selenium.captureEntirePageScreenshot(filename, kwargs);
	}

	public String captureEntirePageScreenshotToString(String kwargs) {
		return selenium.captureEntirePageScreenshotToString(kwargs);
	}

	public String captureNetworkTraffic(String type) {
		return selenium.captureNetworkTraffic(type);
	}

	public void captureScreenshot(String filename) {
		selenium.captureScreenshot(filename);
	}

	public String captureScreenshotToString() {
		return selenium.captureScreenshotToString();
	}

	public void check(String locator) {
		selenium.check(locator);
	}

	public void clickAt(String locator, String coordString) {
		selenium.clickAt(locator, coordString);
	}

	public void contextMenu(String locator) {
		selenium.contextMenu(locator);
	}

	public void contextMenuAt(String locator, String coordString) {
		selenium.contextMenuAt(locator, coordString);
	}

	public void createCookie(String nameValuePair, String optionsString) {
		selenium.createCookie(nameValuePair, optionsString);
	}

	public void deleteAllVisibleCookies() {
		selenium.deleteAllVisibleCookies();
	}

	public void deleteCookie(String name, String optionsString) {
		selenium.deleteCookie(name, optionsString);
	}

	public void deselectPopUp() {
		selenium.deselectPopUp();
	}

	public void doubleClick(String locator) {
		selenium.doubleClick(locator);
	}

	public void doubleClickAt(String locator, String coordString) {
		selenium.doubleClickAt(locator, coordString);
	}

	public void dragAndDrop(String locator, String movementsString) {
		selenium.dragAndDrop(locator, movementsString);
	}

	public void dragAndDropToObject(String locatorOfObjectToBeDragged,
			String locatorOfDragDestinationObject) {
		selenium.dragAndDropToObject(locatorOfObjectToBeDragged,
				locatorOfDragDestinationObject);
	}

	public void dragdrop(String locator, String movementsString) {
		selenium.dragdrop(locator, movementsString);
	}

	public void fireEvent(String locator, String eventName) {
		selenium.fireEvent(locator, eventName);
	}

	public void focus(String locator) {
		selenium.focus(locator);
	}

	public String getAttribute(String attributeLocator) {
		return selenium.getAttribute(attributeLocator);
	}

	public String[] getAttributeFromAllWindows(String attributeName) {
		return selenium.getAttributeFromAllWindows(attributeName);
	}

	public String getCookieByName(String name) {
		return selenium.getCookieByName(name);
	}

	public Number getCursorPosition(String locator) {
		return selenium.getCursorPosition(locator);
	}

	public Number getElementHeight(String locator) {
		return selenium.getElementHeight(locator);
	}

	public Number getElementIndex(String locator) {
		return selenium.getElementIndex(locator);
	}

	public Number getElementPositionLeft(String locator) {
		return selenium.getElementPositionLeft(locator);
	}

	public Number getElementPositionTop(String locator) {
		return selenium.getElementPositionTop(locator);
	}

	public Number getElementWidth(String locator) {
		return selenium.getElementWidth(locator);
	}

	public String getEval(String script) {
		return selenium.getEval(script);
	}

	public String getExpression(String expression) {
		return selenium.getExpression(expression);
	}

	public String getSelectedId(String selectLocator) {
		return selenium.getSelectedId(selectLocator);
	}

	public String[] getSelectedIds(String selectLocator) {
		return selenium.getSelectedIds(selectLocator);
	}

	public String getSelectedIndex(String selectLocator) {
		return selenium.getSelectedIndex(selectLocator);
	}

	public String[] getSelectedIndexes(String selectLocator) {
		return selenium.getSelectedIndexes(selectLocator);
	}

	public String getSelectedLabel(String locator) {
		return selenium.getSelectedLabel(locator);
	}

	public String[] getSelectedLabels(String selectLocator) {
		return selenium.getSelectedLabels(selectLocator);
	}

	public String getSelectedValue(String selectLocator) {
		return selenium.getSelectedValue(selectLocator);
	}

	public String[] getSelectedValues(String selectLocator) {
		return selenium.getSelectedValues(selectLocator);
	}

	public String[] getSelectOptions(String selectLocator) {
		return selenium.getSelectOptions(selectLocator);
	}

	public String getTable(String tableCellAddress) {
		return selenium.getTable(tableCellAddress);
	}

	public String getValue(String locator) {
		return selenium.getValue(locator);
	}

	public boolean getWhetherThisFrameMatchFrameExpression(
			String currentFrameString, String target) {
		return selenium.getWhetherThisFrameMatchFrameExpression(
				currentFrameString, target);
	}

	public boolean getWhetherThisWindowMatchWindowExpression(
			String currentWindowString, String target) {
		return selenium.getWhetherThisWindowMatchWindowExpression(
				currentWindowString, target);
	}

	public Number getXpathCount(String xpath) {
		return selenium.getXpathCount(xpath);
	}

	public void highlight(String locator) {
		selenium.highlight(locator);
	}

	public void ignoreAttributesWithoutValue(String ignore) {
		selenium.ignoreAttributesWithoutValue(ignore);
	}

	public boolean isChecked(String locator) {
		return selenium.isChecked(locator);
	}

	public boolean isCookiePresent(String name) {
		return selenium.isCookiePresent(name);
	}

	public boolean isEditable(String locator) {
		return selenium.isEditable(locator);
	}

	public boolean isElementPresent(String locator) {
		return selenium.isElementPresent(locator);
	}

	public boolean isOrdered(String locator1, String locator2) {
		return selenium.isOrdered(locator1, locator2);
	}

	public boolean isSomethingSelected(String selectLocator) {
		return selenium.isSomethingSelected(selectLocator);
	}

	public boolean isTextPresent(String pattern) {
		return selenium.isTextPresent(pattern);
	}

	public void keyDown(String locator, String keySequence) {
		selenium.keyDown(locator, keySequence);
	}

	public void keyDownNative(String keycode) {
		selenium.keyDownNative(keycode);
	}

	public void keyPress(String locator, String keySequence) {
		selenium.keyPress(locator, keySequence);
	}

	public void keyPressNative(String keycode) {
		selenium.keyPressNative(keycode);
	}

	public void keyUp(String locator, String keySequence) {
		selenium.keyUp(locator, keySequence);
	}

	public void keyUpNative(String keycode) {
		selenium.keyUpNative(keycode);
	}

	public void mouseDown(String locator) {
		selenium.mouseDown(locator);
	}

	public void mouseDownAt(String locator, String coordString) {
		selenium.mouseDownAt(locator, coordString);
	}

	public void mouseDownRight(String locator) {
		selenium.mouseDownRight(locator);
	}

	public void mouseDownRightAt(String locator, String coordString) {
		selenium.mouseDownRightAt(locator, coordString);
	}

	public void mouseMove(String locator) {
		selenium.mouseMove(locator);
	}

	public void mouseMoveAt(String locator, String coordString) {
		selenium.mouseMoveAt(locator, coordString);
	}

	public void mouseOut(String locator) {
		selenium.mouseOut(locator);
	}

	public void mouseOver(String locator) {
		selenium.mouseOver(locator);
	}

	public void mouseUp(String locator) {
		selenium.mouseUp(locator);
	}

	public void mouseUpAt(String locator, String coordString) {
		selenium.mouseUpAt(locator, coordString);
	}

	public void mouseUpRight(String locator) {
		selenium.mouseUpRight(locator);
	}

	public void mouseUpRightAt(String locator, String coordString) {
		selenium.mouseUpRightAt(locator, coordString);
	}

	public void openWindow(String url, String windowID) {
		selenium.openWindow(url, windowID);
	}

	public void removeAllSelections(String locator) {
		selenium.removeAllSelections(locator);
	}

	public void removeScript(String scriptTagId) {
		selenium.removeScript(scriptTagId);
	}

	public void removeSelection(String locator, String optionLocator) {
		selenium.removeSelection(locator, optionLocator);
	}

	public String retrieveLastRemoteControlLogs() {
		return selenium.retrieveLastRemoteControlLogs();
	}

	public void rollup(String rollupName, String kwargs) {
		selenium.rollup(rollupName, kwargs);
	}

	public void runScript(String script) {
		selenium.runScript(script);
	}

	public void selectFrame(String locator) {
		selenium.selectFrame(locator);
	}

	public void selectPopUp(String windowID) {
		selenium.selectPopUp(windowID);
	}

	public void selectWindow(String windowID) {
		selenium.selectWindow(windowID);
	}

	public void setBrowserLogLevel(String logLevel) {
		selenium.setBrowserLogLevel(logLevel);
	}

	public void setContext(String context) {
		selenium.setContext(context);
	}

	public void setCursorPosition(String locator, String position) {
		selenium.setCursorPosition(locator, position);
	}

	public void setExtensionJs(String extensionJs) {
		selenium.setExtensionJs(extensionJs);
	}

	public void setMouseSpeed(String pixels) {
		selenium.setMouseSpeed(pixels);
	}

	public void setSeleniumClass(Class<? extends Selenium> seleniumClass) {
		selenium.setSeleniumClass(seleniumClass);
	}

	public void setSpeed(String value) {
		selenium.setSpeed(value);
	}

	public void setTimeout(String timeout) {
		selenium.setTimeout(timeout);
	}

	public void showContextualBanner() {
		selenium.showContextualBanner();
	}

	public void showContextualBanner(String className, String methodName) {
		selenium.showContextualBanner(className, methodName);
	}

	public void shutDownSeleniumServer() {
		selenium.shutDownSeleniumServer();
	}

	public void start(Object optionsObject) {
		selenium.start(optionsObject);
	}

	public void start(String optionsString) {
		selenium.start(optionsString);
	}

	public void startSelenium(String host, int containerPort) throws Exception {
		selenium.startSelenium(host, containerPort);
	}

	public void submit(String formLocator) {
		selenium.submit(formLocator);
	}

	public void typeKeys(String locator, String value) {
		selenium.typeKeys(locator, value);
	}

	public void uncheck(String locator) {
		selenium.uncheck(locator);
	}

	public void useXpathLibrary(String libraryName) {
		selenium.useXpathLibrary(libraryName);
	}

	public void waitForCondition(String script, String timeout) {
		selenium.waitForCondition(script, timeout);
	}

	public void waitForFrameToLoad(String frameAddress, String timeout) {
		selenium.waitForFrameToLoad(frameAddress, timeout);
	}

	public void waitForPageToLoad(String timeout) {
		selenium.waitForPageToLoad(timeout);
	}

	public void waitForPopUp(String windowID, String timeout) {
		selenium.waitForPopUp(windowID, timeout);
	}

}
