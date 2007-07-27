package net.chrisrichardson.umangite;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.fail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.thoughtworks.selenium.SeleniumException;

public abstract class AbstractSeleniumTest {

	private Log logger = LogFactory.getLog(getClass());

	protected SeleniumLauncher selenium;

	protected WebContainerLauncher container;

	protected ApplicationContext appCtx;

	public AbstractSeleniumTest() {
	}

	@BeforeClass
	public void setUp() throws Exception {
		injectDependencies();
		prepareWebApplication();
		
		logger.debug("starting container...");
		container.start();
		logger.debug("starting selenium for container port: " + container.getActualPort());
		selenium.startSelenium(container.getActualPort());
		logger.debug("Started");
	}


	@AfterClass
	public void tearDown() throws Exception {
		try {
			container.stop();
		} catch (Throwable e) {
			logger.error(e);
		}

		selenium.stopSelenium();
	}

	private void injectDependencies() {
		appCtx = new ClassPathXmlApplicationContext(getConfigLocations());
		((ClassPathXmlApplicationContext) appCtx).getBeanFactory()
				.autowireBeanProperties(this,
						AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
		assertNotNull(container);
		assertNotNull(selenium);
	}

	public void setSelenium(SeleniumLauncher selenium) {
		this.selenium = selenium;
	}

	public void setContainer(WebContainerLauncher container) {
		this.container = container;
	}

	protected String getContainerType() {
		return System.getProperty("umangite.container.type", "jetty");
	}

	protected void prepareWebApplication() {
		
	}

	protected abstract String[] getConfigLocations();

	// methods for delegating to selenium

	public void addSelection(String arg0, String arg1) {
		selenium.addSelection(arg0, arg1);
	}

	public void altKeyDown() {
		selenium.altKeyDown();
	}

	public void altKeyUp() {
		selenium.altKeyUp();
	}

	public void answerOnNextPrompt(String arg0) {
		selenium.answerOnNextPrompt(arg0);
	}

	public void check(String arg0) {
		selenium.check(arg0);
	}

	public void chooseCancelOnNextConfirmation() {
		selenium.chooseCancelOnNextConfirmation();
	}

	public void click(String arg0) {
		try {
			selenium.click(arg0);
		} catch (SeleniumException e) {
			try {
				String body = selenium.getHtmlSource();
				logger.error("error in click", e);
				fail("Couldn't click on <" + arg0 + "> in " + body);
			} catch (SeleniumException e2) {
				throw e;
			}
		}
	}

	public void clickAt(String arg0, String arg1) {
		selenium.clickAt(arg0, arg1);
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

	public void createCookie(String arg0, String arg1) {
		selenium.createCookie(arg0, arg1);
	}

	public void deleteCookie(String arg0, String arg1) {
		selenium.deleteCookie(arg0, arg1);
	}

	public void doubleClick(String arg0) {
		selenium.doubleClick(arg0);
	}

	public void doubleClickAt(String arg0, String arg1) {
		selenium.doubleClickAt(arg0, arg1);
	}

	public void dragAndDrop(String arg0, String arg1) {
		selenium.dragAndDrop(arg0, arg1);
	}

	public void dragAndDropToObject(String arg0, String arg1) {
		selenium.dragAndDropToObject(arg0, arg1);
	}

	public void dragdrop(String arg0, String arg1) {
		selenium.dragdrop(arg0, arg1);
	}

	public boolean equals(Object obj) {
		return selenium.equals(obj);
	}

	public void fireEvent(String arg0, String arg1) {
		selenium.fireEvent(arg0, arg1);
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

	public String getAttribute(String arg0) {
		return selenium.getAttribute(arg0);
	}

	public String[] getAttributeFromAllWindows(String arg0) {
		return selenium.getAttributeFromAllWindows(arg0);
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

	public Number getCursorPosition(String arg0) {
		return selenium.getCursorPosition(arg0);
	}

	public Number getElementHeight(String arg0) {
		return selenium.getElementHeight(arg0);
	}

	public Number getElementIndex(String arg0) {
		return selenium.getElementIndex(arg0);
	}

	public Number getElementPositionLeft(String arg0) {
		return selenium.getElementPositionLeft(arg0);
	}

	public Number getElementPositionTop(String arg0) {
		return selenium.getElementPositionTop(arg0);
	}

	public Number getElementWidth(String arg0) {
		return selenium.getElementWidth(arg0);
	}

	public String getEval(String arg0) {
		return selenium.getEval(arg0);
	}

	public String getExpression(String arg0) {
		return selenium.getExpression(arg0);
	}

	public String getHtmlSource() {
		return selenium.getHtmlSource();
	}

	public String getLocation() {
		return selenium.getLocation();
	}

	public String getLogMessages() {
		return selenium.getLogMessages();
	}

	public Number getMouseSpeed() {
		return selenium.getMouseSpeed();
	}

	public String getPrompt() {
		return selenium.getPrompt();
	}

	public String getSelectedId(String arg0) {
		return selenium.getSelectedId(arg0);
	}

	public String[] getSelectedIds(String arg0) {
		return selenium.getSelectedIds(arg0);
	}

	public String getSelectedIndex(String arg0) {
		return selenium.getSelectedIndex(arg0);
	}

	public String[] getSelectedIndexes(String arg0) {
		return selenium.getSelectedIndexes(arg0);
	}

	public String getSelectedLabel(String arg0) {
		return selenium.getSelectedLabel(arg0);
	}

	public String[] getSelectedLabels(String arg0) {
		return selenium.getSelectedLabels(arg0);
	}

	public String getSelectedValue(String arg0) {
		return selenium.getSelectedValue(arg0);
	}

	public String[] getSelectedValues(String arg0) {
		return selenium.getSelectedValues(arg0);
	}

	public String[] getSelectOptions(String arg0) {
		return selenium.getSelectOptions(arg0);
	}

	public void getSpeed() {
		selenium.getSpeed();
	}

	public String getTable(String arg0) {
		return selenium.getTable(arg0);
	}

	public String getText(String arg0) {
		try {
			return selenium.getText(arg0);
		} catch (SeleniumException e) {
			try {
				String body = selenium.getHtmlSource();
				logger.error("error in getText()", e);
				fail("Couldn't get text on <" + arg0 + "> in " + body);
				return null;
			} catch (SeleniumException e2) {
				throw e;
			}
		}
	}

	public String getTitle() {
		return selenium.getTitle();
	}

	public String getValue(String arg0) {
		return selenium.getValue(arg0);
	}

	public boolean getWhetherThisFrameMatchFrameExpression(String arg0,
			String arg1) {
		return selenium.getWhetherThisFrameMatchFrameExpression(arg0, arg1);
	}

	public boolean getWhetherThisWindowMatchWindowExpression(String arg0,
			String arg1) {
		return selenium.getWhetherThisWindowMatchWindowExpression(arg0, arg1);
	}

	public void goBack() {
		selenium.goBack();
	}

	public void highlight(String arg0) {
		selenium.highlight(arg0);
	}

	public boolean isAlertPresent() {
		return selenium.isAlertPresent();
	}

	public boolean isChecked(String arg0) {
		return selenium.isChecked(arg0);
	}

	public boolean isConfirmationPresent() {
		return selenium.isConfirmationPresent();
	}

	public boolean isEditable(String arg0) {
		return selenium.isEditable(arg0);
	}

	public boolean isElementPresent(String arg0) {
		return selenium.isElementPresent(arg0);
	}

	public boolean isOrdered(String arg0, String arg1) {
		return selenium.isOrdered(arg0, arg1);
	}

	public boolean isPromptPresent() {
		return selenium.isPromptPresent();
	}

	public boolean isSomethingSelected(String arg0) {
		return selenium.isSomethingSelected(arg0);
	}

	public boolean isTextPresent(String arg0) {
		return selenium.isTextPresent(arg0);
	}

	public boolean isVisible(String arg0) {
		return selenium.isVisible(arg0);
	}

	public void keyDown(String arg0, String arg1) {
		selenium.keyDown(arg0, arg1);
	}

	public void keyPress(String arg0, String arg1) {
		selenium.keyPress(arg0, arg1);
	}

	public void keyUp(String arg0, String arg1) {
		selenium.keyUp(arg0, arg1);
	}

	public void metaKeyDown() {
		selenium.metaKeyDown();
	}

	public void metaKeyUp() {
		selenium.metaKeyUp();
	}

	public void mouseDown(String arg0) {
		selenium.mouseDown(arg0);
	}

	public void mouseDownAt(String arg0, String arg1) {
		selenium.mouseDownAt(arg0, arg1);
	}

	public void mouseMove(String arg0) {
		selenium.mouseMove(arg0);
	}

	public void mouseMoveAt(String arg0, String arg1) {
		selenium.mouseMoveAt(arg0, arg1);
	}

	public void mouseOut(String arg0) {
		selenium.mouseOut(arg0);
	}

	public void mouseOver(String arg0) {
		selenium.mouseOver(arg0);
	}

	public void mouseUp(String arg0) {
		selenium.mouseUp(arg0);
	}

	public void mouseUpAt(String arg0, String arg1) {
		selenium.mouseUpAt(arg0, arg1);
	}

	public void open(String arg0) {
		selenium.open(arg0);
	}

	public void openWindow(String arg0, String arg1) {
		selenium.openWindow(arg0, arg1);
	}

	public void refresh() {
		selenium.refresh();
	}

	public void removeAllSelections(String arg0) {
		selenium.removeAllSelections(arg0);
	}

	public void removeSelection(String arg0, String arg1) {
		selenium.removeSelection(arg0, arg1);
	}

	public void select(String arg0, String arg1) {
		selenium.select(arg0, arg1);
	}

	public void selectFrame(String arg0) {
		selenium.selectFrame(arg0);
	}

	public void selectWindow(String arg0) {
		selenium.selectWindow(arg0);
	}

	public void setContext(String arg0, String arg1) {
		selenium.setContext(arg0, arg1);
	}

	public void setCursorPosition(String arg0, String arg1) {
		selenium.setCursorPosition(arg0, arg1);
	}

	public void setMouseSpeed(String arg0) {
		selenium.setMouseSpeed(arg0);
	}

	public void setSpeed(String arg0) {
		selenium.setSpeed(arg0);
	}

	public void setTimeout(String arg0) {
		selenium.setTimeout(arg0);
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

	public void submit(String arg0) {
		selenium.submit(arg0);
	}

	public void type(String arg0, String arg1) {
		try {
			selenium.type(arg0, arg1);
		} catch (SeleniumException e) {
			try {
				String body = selenium.getHtmlSource();
				logger.error("Error in type()", e);
				fail("Couldn't click on <" + arg0 + "> in " + body);
			} catch (SeleniumException e2) {
				throw e;
			}
		}	
	}

	public void typeKeys(String arg0, String arg1) {
		selenium.typeKeys(arg0, arg1);
	}

	public void uncheck(String arg0) {
		selenium.uncheck(arg0);
	}

	public void waitForCondition(String arg0, String arg1) {
		selenium.waitForCondition(arg0, arg1);
	}

	public void waitForPageToLoad(String arg0) {
		selenium.waitForPageToLoad(arg0);
	}

	public void waitForPopUp(String arg0, String arg1) {
		selenium.waitForPopUp(arg0, arg1);
	}

	public void windowFocus(String arg0) {
		selenium.windowFocus(arg0);
	}

	public void windowMaximize(String arg0) {
		selenium.windowMaximize(arg0);
	}

	protected void clickAndWait(String selector) {
		click(selector);
		waitForPageToLoad("30000");
	}

	protected void assertTextPresent(String text) {
		assertPageContent("Could not find on page" + text, isTextPresent(text));
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
		assertEquals(expectedText, getText(selector));
	}

	protected void assertElementPresent(String locator) {
		assertPageContent(String.format("Expected element <%s>: ", locator), isElementPresent(locator));
	}

}