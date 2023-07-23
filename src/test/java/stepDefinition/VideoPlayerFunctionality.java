package stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.CommonMethod;
import generic.SetUpAndTearDown;
import generic.parametrizedLocators;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VideoPlayerFunctionality extends CommonMethod {

	String currentVideoTitle;

	// Element for Git it button
	@FindBy(xpath = "//button[text()='Got it']")
	private WebElement gotItButton;

	// Elements for Play Button
	@FindBy(xpath = "(//video[contains(@id,'video')])[1]")
	private WebElement video;

	// Elements for Advertisement Button
	@FindBy(xpath = "//div[text()='Advertisement']")
	private WebElement advertisement;

	// Elements for Play Button
	@FindBy(xpath = "//video[contains(@id,'video')]")
	// "//span[text()='Play']//ancestor::div[contains(@class,'play')][1]")
	private WebElement playButton;

	// Elements for Pause Button
	@FindBy(xpath = "//span[text()='Pause']//ancestor::div[contains(@class,'playing')][1]")
	private WebElement pauseButton;

	// Elements for forward Button
	@FindBy(xpath = "//div[contains(@class,'skip')]")
	private WebElement forwardButton;

	// Elements for back Button
	@FindBy(xpath = "//div[contains(@class,'previous')]")
	private WebElement backButton;

	// Elements for mute Button
	@FindBy(xpath = "//div[contains(@class,'skip')]")
	private WebElement muteButton;

	// Elements for unmute Button
	@FindBy(xpath = "//div[contains(@class,'control-bar')]//div[contains(@class,'volume-menu')]")
	private WebElement speakerButton;

	// Elements for nextVedioURL Button
	@FindBy(xpath = "//div[contains(@class,'control-bar')]//div[contains(@class,'volume-menu')]")
	private WebElement nextVedioUrl;

	// Elements for current video headline
	@FindBy(xpath = "//div[@class='video-headline']//a")
	private WebElement currentVideoHeadline;

	// Elements for next video headline
	@FindBy(xpath = "//div[@class='item']//div[contains(@class,'vjs-title-text')]//div")
	private WebElement videoTitle;

	// Elements for video end
	@FindBy(xpath = "//div[@class='video-headline']//a")
	private WebElement videoEnd;

	// Elements for Sport Menu
	@FindBy(xpath = "//div[contains(@class,'header')]//li[@class='sport']")
	private WebElement sportMenu;

	// Elements for Premier League Table
	@FindBy(xpath = "//div[contains(@class,'sideRailsHeading_2J913')]//div[text()='Premier League']")
	private WebElement premierLeagueTable;

	// Elements for View all Table
	@FindBy(xpath = "//div[@class='video-headline']//a")
	private WebElement viewAllTable;

	// Elements for View fixtures
	@FindBy(xpath = "//div[text()='View fixtures']")
	private WebElement ViewFixtures;

	//// div[contains(@class,'displayMode')]//div[text()='Tables']

	// Elements for View fixtures
	@FindBy(xpath = "// div[contains(@class,'displayMode')]//div[text()='Tables']")
	private WebElement ViewFixtures_table;

	// Elements for table rows
	@FindBy(xpath = "// tr[contains(@class,'competitionTableRow')]")
	private List<WebElement> tableRows;

	// Elements for table rows
	@FindBy(xpath = "// tr[contains(@class,'competitionTableRow')]//td[4]")
	private List<WebElement> tableCell;

	// Elements for Pos
	@FindBy(xpath = "//div[@class='video-headline']//a")
	private WebElement Pos;

	// Elements for View all Table
	@FindBy(xpath = "//div[@class='video-headline']//a")
	private WebElement PTS;

	// By settingButton = By.xpath("//div[contains(@class,'quality')]");

	public VideoPlayerFunctionality() {
		PageFactory.initElements(driver, this);
	}

	@Given("user navigate to application and accept cookies")
	public void user_navigate_to_home_page(String urlName) throws InterruptedException {
		// Launch application
		launchApplication(urlName);
		if (gotItButton.isDisplayed()) {
			waitFor(2);
			scrollToViewElement(gotItButton);
			gotItButton.click();
			waitFor(5);
		}
	}

	@When("user clicks on Video in page to begin playback")
	public void clickOnPlayButton() throws Exception {

		try {
			// Find the other element. If found, it means the element is present.
			scrollToViewElement(video);
			if (advertisement.isDisplayed()) {
				waitForEC(video, 42);
				video.click();
			}
		} catch (NoSuchElementException e) {
			// The other element is not present. Perform the click on the desired element.
			video.click();
			waitFor(10);
			System.out.println("Clicked on the element successfully.");
		}

	}

	@And("user clicks the video again to pause playback")
	public void clickOnPauseButton() throws Exception {

		try {
			// Find the other element. If found, it means the element is present.
			if (advertisement.isDisplayed()) {
				waitForEC(video, 22);
				video.click();
			}
		} catch (NoSuchElementException e) {
			// The other element is not present. Perform the click on the desired element.
			waitForEC(video, 22);
			video.click();
			waitFor(10);
			System.out.println("Clicked on the element successfully.");
		}
	}

	@And("user clicks on the forward arrow to change to the next video")
	public void clickOnForwardButton() throws InterruptedException {
		currentVideoTitle = videoTitle.getText();
		SetUpAndTearDown.scenario.log("Current Video Title Is : " + currentVideoTitle);

		try {
			// Find the other element. If found, it means the element is present.
			if (advertisement.isDisplayed()) {
				waitForEC(video, 22);
				forwardButton.click();
			}
		} catch (NoSuchElementException e) {
			// The other element is not present. Perform the click on the desired element.
			waitForEC(video, 22);
			forwardButton.click();
			System.out.println("Clicked on the element successfully.");
		}
	}

	@And("user clicks on the back arrow to navigate to the previous video")
	public void clickOnBackButton() throws InterruptedException {

		try {
			// Find the other element. If found, it means the element is present.
			if (advertisement.isDisplayed()) {
				// waitForEC(video, 30);
				waitForEC(video, 50);
				backButton.click();
			}
		} catch (NoSuchElementException e) {
			// The other element is not present. Perform the click on the desired element.
			waitForEC(video, 50);
			backButton.click();
			System.out.println("Clicked on the element successfully.");
		}
	}

	@And("user on the speaker icon to mute the video")
	public void clickOnMuteButton() {

		try {
			// Find the other element. If found, it means the element is present.
			if (advertisement.isDisplayed()) {
				waitForEC(video, 30);
				speakerButton.click();
			}
		} catch (NoSuchElementException e) {
			// The other element is not present. Perform the click on the desired element.
			speakerButton.click();
			System.out.println("Clicked on the element successfully.");
		}
	}

	@And("user on the speaker icon again to unmute the video")
	public void clickOnUnmuteButton() {

		try {
			// Find the other element. If found, it means the element is present.
			if (advertisement.isDisplayed()) {
				waitForEC(video, 30);
				speakerButton.click();
			}
		} catch (NoSuchElementException e) {
			// The other element is not present. Perform the click on the desired element.
			speakerButton.click();
			System.out.println("Clicked on the element successfully.");
		}
	}

	@Then("user checks video is finished and next video should autoplay")
	public void videoFinished() {

		String nextVideoTitle = videoTitle.getText();
		SetUpAndTearDown.scenario.log("Next Video Title Is : " + nextVideoTitle);
		Assert.assertNotEquals(currentVideoTitle, nextVideoTitle);

	}

	@And("user clicks on on Sport menu and scroll down to the Premier League table")
	public void clickOnSportMenuAndScrollDown() {

		sportMenu.click();
		waitFor(2);
		scrollToViewElement(premierLeagueTable);
		waitFor(2);
		ViewFixtures.click();

	}

	@And("user clicks on on the View all tables")
	public void clickOnViewAllTables() {
		waitFor(2);
		ViewFixtures_table.click();
		waitFor(7);

	}

	@And("user retrieves the Pos and PTS for the given team {string}")
	public void retrieveThePosAndPTS(String team) {

		String pos = parametrizedLocators.pos(team).getText();
		SetUpAndTearDown.scenario.log(team + " " + "Point Is : " + pos);

		String pts = parametrizedLocators.pts(team).getText();
		SetUpAndTearDown.scenario.log(team + " " + "PTS Is : " + pts);

	}

}
