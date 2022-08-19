import org.junit.Assert;
import org.junit.Test;

public class PetStoreTest {
    @Test
    public void signInTestN(){
        WrongSignIn signIn = new WrongSignIn("C:\\Users\\user1\\Desktop\\chromedriver.exe");
        String expectedUrl = "https://petstore.octoperf.com/actions/Catalog.action";
        String actualUrl = signIn.openSite(expectedUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("smoke test --- > pass");

        String expectedLabel = "Please enter your username and password.";
        String actualLabel = signIn.openSigninPage();
        Assert.assertEquals(expectedLabel,actualLabel);
        System.out.println("page test --- > pass");

        String expectedMessage = "Invalid username or password. Signon failed.";
        String actualMessage = signIn.signIn();
        Assert.assertEquals(expectedMessage,actualMessage);
        System.out.println("signIn test--- > pass");

        signIn.quit();
    }
    @Test
    public void searchTest(){
        Search search1 = new Search("C:\\Users\\user1\\Desktop\\chromedriver.exe");
        String expectedUrl = "https://petstore.octoperf.com/actions/Catalog.action";
        String actualUrl = search1.openSite(expectedUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("smoke test --- > pass");

        String expectedProductID = "K9-PO-02";
        String actualProductID = search1.searchPoodle();
        Assert.assertEquals(expectedProductID,actualProductID);
        System.out.println("search a product test --- > pass");
        search1.quit();
    }
}
