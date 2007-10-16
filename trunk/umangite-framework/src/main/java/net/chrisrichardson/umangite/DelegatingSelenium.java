package net.chrisrichardson.umangite;

import com.thoughtworks.selenium.Selenium;

public class DelegatingSelenium implements Selenium {
	
	protected Selenium selenium;

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
		selenium.click(arg0);
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
		return selenium.getText(arg0);
	}

	public String getTitle() {
		return selenium.getTitle();
	}

	public String getValue(String arg0) {
		return selenium.getValue(arg0);
	}

	public boolean getWhetherThisFrameMatchFrameExpression(String arg0, String arg1) {
		return selenium.getWhetherThisFrameMatchFrameExpression(arg0, arg1);
	}

	public boolean getWhetherThisWindowMatchWindowExpression(String arg0, String arg1) {
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

	public void setContext(String arg0) {
		selenium.setContext(arg0);
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

	public void stop() {
		selenium.stop();
	}

	public void submit(String arg0) {
		selenium.submit(arg0);
	}

	public void type(String arg0, String arg1) {
		selenium.type(arg0, arg1);
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

	public void windowFocus() {
		selenium.windowFocus();
	}

	public void windowMaximizein() {
		selenium.windowMaximize();
	}

	public void addLocationStrategy(String arg0, String arg1) {
		selenium.addLocationStrategy(arg0, arg1);
	}

	public void allowNativeXpath(String arg0) {
		selenium.allowNativeXpath(arg0);
	}

	public void assignId(String arg0, String arg1) {
		selenium.assignId(arg0, arg1);
	}

	public void captureScreenshot(String arg0) {
		selenium.captureScreenshot(arg0);
	}

	public void chooseOkOnNextConfirmation() {
		selenium.chooseOkOnNextConfirmation();
	}

	public Number getXpathCount(String arg0) {
		return selenium.getXpathCount(arg0);
	}

	public void runScript(String arg0) {
		selenium.runScript(arg0);
	}

	public void setBrowserLogLevel(String arg0) {
		selenium.setBrowserLogLevel(arg0);
	}

	public void waitForFrameToLoad(String arg0, String arg1) {
		selenium.waitForFrameToLoad(arg0, arg1);
	}

	public void windowMaximize() {
		selenium.windowMaximize();
	}
	
	
	
}
