package net.chrisrichardson.umangite;

import com.thoughtworks.selenium.Selenium;

public class DelegatingSelenium implements Selenium {

	protected Selenium selenium;

	public void addSelection(String locator, String optionLocator) {
		selenium.addSelection(locator, optionLocator);
	}

	public void altKeyDown() {
		selenium.altKeyDown();
	}

	public void altKeyUp() {
		selenium.altKeyUp();
	}

	public void answerOnNextPrompt(String answer) {
		selenium.answerOnNextPrompt(answer);
	}

	public void check(String locator) {
		selenium.check(locator);
	}

	public void chooseCancelOnNextConfirmation() {
		selenium.chooseCancelOnNextConfirmation();
	}

	public void click(String locator) {
		selenium.click(locator);
	}

	public void clickAt(String locator, String coordString) {
		selenium.clickAt(locator, coordString);
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

	public void createCookie(String nameValuePair, String optionsString) {
		selenium.createCookie(nameValuePair, optionsString);
	}

	public void deleteCookie(String name, String optionsString) {
		selenium.deleteCookie(name, optionsString);
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

	public String getAttribute(String attributeLocator) {
		return selenium.getAttribute(attributeLocator);
	}

	public String[] getAttributeFromAllWindows(String attributeName) {
		return selenium.getAttributeFromAllWindows(attributeName);
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

	public String getSpeed() {
		return selenium.getSpeed();
	}

	public String getTable(String tableCellAddress) {
		return selenium.getTable(tableCellAddress);
	}

	public String getText(String locator) {
		return selenium.getText(locator);
	}

	public String getTitle() {
		return selenium.getTitle();
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

	public void goBack() {
		selenium.goBack();
	}

	public void highlight(String locator) {
		selenium.highlight(locator);
	}

	public boolean isAlertPresent() {
		return selenium.isAlertPresent();
	}

	public boolean isChecked(String locator) {
		return selenium.isChecked(locator);
	}

	public boolean isConfirmationPresent() {
		return selenium.isConfirmationPresent();
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

	public boolean isPromptPresent() {
		return selenium.isPromptPresent();
	}

	public boolean isSomethingSelected(String selectLocator) {
		return selenium.isSomethingSelected(selectLocator);
	}

	public boolean isTextPresent(String pattern) {
		return selenium.isTextPresent(pattern);
	}

	public boolean isVisible(String locator) {
		return selenium.isVisible(locator);
	}

	public void keyDown(String locator, String keySequence) {
		selenium.keyDown(locator, keySequence);
	}

	public void keyPress(String locator, String keySequence) {
		selenium.keyPress(locator, keySequence);
	}

	public void keyUp(String locator, String keySequence) {
		selenium.keyUp(locator, keySequence);
	}

	public void metaKeyDown() {
		selenium.metaKeyDown();
	}

	public void metaKeyUp() {
		selenium.metaKeyUp();
	}

	public void mouseDown(String locator) {
		selenium.mouseDown(locator);
	}

	public void mouseDownAt(String locator, String coordString) {
		selenium.mouseDownAt(locator, coordString);
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

	public void open(String url) {
		selenium.open(url);
	}

	public void openWindow(String url, String windowID) {
		selenium.openWindow(url, windowID);
	}

	public void refresh() {
		selenium.refresh();
	}

	public void removeAllSelections(String locator) {
		selenium.removeAllSelections(locator);
	}

	public void removeSelection(String locator, String optionLocator) {
		selenium.removeSelection(locator, optionLocator);
	}

	public void select(String selectLocator, String optionLocator) {
		selenium.select(selectLocator, optionLocator);
	}

	public void selectFrame(String locator) {
		selenium.selectFrame(locator);
	}

	public void selectWindow(String windowID) {
		selenium.selectWindow(windowID);
	}

	public void setContext(String context) {
		selenium.setContext(context);
	}

	public void setCursorPosition(String locator, String position) {
		selenium.setCursorPosition(locator, position);
	}

	public void setMouseSpeed(String pixels) {
		selenium.setMouseSpeed(pixels);
	}

	public void setSpeed(String value) {
		selenium.setSpeed(value);
	}

	public void setTimeout(String timeout) {
		selenium.setTimeout(timeout);
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

	public void stop() {
		selenium.stop();
	}

	public void submit(String formLocator) {
		selenium.submit(formLocator);
	}

	public void type(String locator, String value) {
		selenium.type(locator, value);
	}

	public void typeKeys(String locator, String value) {
		selenium.typeKeys(locator, value);
	}

	public void uncheck(String locator) {
		selenium.uncheck(locator);
	}

	public void waitForCondition(String script, String timeout) {
		selenium.waitForCondition(script, timeout);
	}

	public void waitForPageToLoad(String timeout) {
		selenium.waitForPageToLoad(timeout);
	}

	public void waitForPopUp(String windowID, String timeout) {
		selenium.waitForPopUp(windowID, timeout);
	}

	public void windowFocus() {
		selenium.windowFocus();
	}

	public void windowMaximizein() {
		selenium.windowMaximize();
	}

	public void addLocationStrategy(String strategyName,
			String functionDefinition) {
		selenium.addLocationStrategy(strategyName, functionDefinition);
	}

	public void allowNativeXpath(String allow) {
		selenium.allowNativeXpath(allow);
	}

	public void assignId(String locator, String identifier) {
		selenium.assignId(locator, identifier);
	}

	public void captureScreenshot(String filename) {
		selenium.captureScreenshot(filename);
	}

	public void chooseOkOnNextConfirmation() {
		selenium.chooseOkOnNextConfirmation();
	}

	public Number getXpathCount(String xpath) {
		return selenium.getXpathCount(xpath);
	}

	public void runScript(String script) {
		selenium.runScript(script);
	}

	public void setBrowserLogLevel(String logLevel) {
		selenium.setBrowserLogLevel(logLevel);
	}

	public void waitForFrameToLoad(String frameAddress, String timeout) {
		selenium.waitForFrameToLoad(frameAddress, timeout);
	}

	public void windowMaximize() {
		selenium.windowMaximize();
	}

	public void addScript(String scriptContent, String scriptTagId) {
		selenium.addScript(scriptContent, scriptTagId);
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

	public String captureScreenshotToString() {
		return selenium.captureScreenshotToString();
	}

	public void contextMenu(String locator) {
		selenium.contextMenu(locator);
	}

	public void contextMenuAt(String locator, String coordString) {
		selenium.contextMenuAt(locator, coordString);
	}

	public void deleteAllVisibleCookies() {
		selenium.deleteAllVisibleCookies();
	}

	public void focus(String locator) {
		selenium.focus(locator);
	}

	public String getCookieByName(String name) {
		return selenium.getCookieByName(name);
	}

	public void ignoreAttributesWithoutValue(String ignore) {
		selenium.ignoreAttributesWithoutValue(ignore);
	}

	public boolean isCookiePresent(String name) {
		return isCookiePresent(name);
	}

	public void keyDownNative(String keycode) {
		selenium.keyDownNative(keycode);
	}

	public void keyPressNative(String keycode) {
		selenium.keyPressNative(keycode);
	}

	public void keyUpNative(String keycode) {
		selenium.keyUpNative(keycode);
	}

	public void mouseDownRight(String locator) {
		selenium.mouseDownRight(locator);
	}

	public void mouseDownRightAt(String locator, String coordString) {
		selenium.mouseDownRightAt(locator, coordString);
	}

	public void mouseUpRight(String locator) {
		selenium.mouseUpRight(locator);
	}

	public void mouseUpRightAt(String locator, String coordString) {
		selenium.mouseUpRightAt(locator, coordString);
	}

	public void removeScript(String scriptTagId) {
		selenium.removeScript(scriptTagId);
	}

	public String retrieveLastRemoteControlLogs() {
		return retrieveLastRemoteControlLogs();
	}

	public void rollup(String rollupName, String kwargs) {
		selenium.rollup(rollupName, kwargs);
	}

	public void setExtensionJs(String extensionJs) {
		selenium.setExtensionJs(extensionJs);
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

	public void start(String optionsString) {
		selenium.start(optionsString);
	}

	public void start(Object optionsObject) {
		selenium.start(optionsObject);
	}

	public void useXpathLibrary(String libraryName) {
		selenium.useXpathLibrary(libraryName);
	}

	public void addCustomRequestHeader(String key, String value) {
		selenium.addCustomRequestHeader(key, value);
	}

	public String captureNetworkTraffic(String type) {
		return selenium.captureNetworkTraffic(type);
	}

	public void deselectPopUp() {
		selenium.deselectPopUp();

	}

	public void selectPopUp(String windowID) {
		selenium.selectPopUp(windowID);

	}

	public Selenium getRealSelenium() {
		if (selenium instanceof DelegatingSelenium)
			return ((DelegatingSelenium) selenium).getRealSelenium();
		else
			return selenium;
	}
}
