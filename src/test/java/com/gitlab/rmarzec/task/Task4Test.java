package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.framework.utils.pageObject.PageObject;
import com.gitlab.rmarzec.framework.utils.pageObject.PageObjectElement;
import com.gitlab.rmarzec.framework.utils.selenium.ApiRunner;
import com.gitlab.rmarzec.model.YTTile;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.gitlab.rmarzec.framework.utils.DriverFactory.getDriver;


public class Task4Test extends ApiRunner {

    private static final String YOUTUBE_URL = "https://www.youtube.com/";

    @Test
    public void Task4Test() {
        start(YOUTUBE_URL);

        //cookies
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dialog")));
        WebElement cookieElement = PageObjectElement.getElementByXpath("//span[@class='yt-core-attributed-string yt-core-attributed-string--white-space-no-wrap' and @role='text' and contains(text(), 'Zaakceptuj wszystko')]");
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", cookieElement);


        By itemRendererLocator = By.cssSelector("ytd-rich-item-renderer");
        By videoTitleSelector = By.cssSelector("#video-title");
        By channelNameSelector = By.cssSelector("a.yt-simple-endpoint.style-scope.yt-formatted-string");
        By videoLengthSelector = By.cssSelector("span.style-scope.ytd-thumbnail-overlay-time-status-renderer");

        PageObject.reload();
        List<WebElement> itemRenderers = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(itemRendererLocator, 11));


// Check if we found at least 12 elements
        if (itemRenderers.size() >= 12) {
            List<YTTile> collectedVideos = new ArrayList<>();
            for (int i = 1; i < 13; i++) {
                // Use the index to construct a unique locator for each parent element
                By uniqueParentLocator = By.cssSelector("ytd-rich-item-renderer:nth-of-type(" + (i + 1) + ")");

                try {
                    WebElement titleElement = retryingFindChildElement(getDriver(), uniqueParentLocator, videoTitleSelector);
                    wait.until(ExpectedConditions.visibilityOf(titleElement));
                    String title = titleElement.getText();

                    WebElement channelElement = retryingFindChildElement(getDriver(), uniqueParentLocator, channelNameSelector);
                    wait.until(ExpectedConditions.visibilityOf(channelElement));
                    String channelName = channelElement.getText();

                    WebElement videoLengthElement = retryingFindChildElement(getDriver(), uniqueParentLocator, videoLengthSelector);
                    wait.until(ExpectedConditions.visibilityOf(videoLengthElement));
                    String videoLength = videoLengthElement.getText();

                    collectedVideos.add(new YTTile(title, channelName, videoLength));
                } catch (TimeoutException e) {
                    System.out.println("Failed to find child elements for video at index " + i);
                }
            }

            collectedVideos.forEach(video ->
                    System.out.println("Title: " + video.getTitle() + "\n" +
                            "Channel Name: " + video.getChannel() + "\n" +
                            "Video Length: " + video.getLength() + "\n" + "\n"
                    )
            );
        }
    }

    private WebElement retryingFindChildElement(WebDriver driver, By parentLocator, By childLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(driver1 -> {
            WebElement parentElement = driver1.findElement(parentLocator); // Refetch the parent element
            try {
                return parentElement.findElement(childLocator); // Try to find the child
            } catch (StaleElementReferenceException e) {
                throw new NotFoundException("The child element is not found within the parent");
            }
        });
    }
}
