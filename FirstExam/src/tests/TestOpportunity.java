package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Virginia Sanabria on 8/10/2015.
 */
public class TestOpportunity {
    private HomePage homePage;
    private OpportunityDetailsPage opportunityDetailsPage;
    private NavigationTab navigationTab;
    private AccountDetailsPage accountDetailsPage;
    private AccountsPage accountsPage;
    private OpportunitiesPage opportunitiesPage;
    private final String opportunityName = "TestvirginiaOpt9";
    private final String closeDate = "8/11/2015";
    private final String stage = "Prospecting";
    private final String accountName = "accountTest9";

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUserNameTxt("svirginia05@freetest.com");
        loginPage.setPasswordTxt("Usu@rio01");
        homePage = loginPage.clickLoginBtn();

        navigationTab = homePage.goToNavigationTab();
        accountsPage = navigationTab.goToAccountsTab();
        AccountForm accountForm = accountsPage.clickNewBtn();
        accountDetailsPage = accountForm.setAccountName(accountName)
                                            .clickSaveBtn();

    }

    @Test
    public void opportunityTest() {

        opportunitiesPage = navigationTab.goToOpportunitiesTab();
        OpportunityForm opportunityForm = opportunitiesPage.clickNewBtn();
        opportunityDetailsPage = opportunityForm.setOpyName(opportunityName)
                .setCloseDate(closeDate)
                .selectStage(stage)
                .selectAccount(accountName)
                .clickSaveBtn();
        System.out.println(opportunityDetailsPage.getOpportunityName() + ":" + opportunityDetailsPage.getCloseDateValue() + ":" +opportunityDetailsPage.getStageValue()+ ":" + opportunityDetailsPage.getAccountName());
        Assert.assertEquals(opportunityDetailsPage.getOpportunityName(), opportunityName, "The opportunity name is not the expected");
        Assert.assertEquals(opportunityDetailsPage.getCloseDateValue(), closeDate, "The close date is not the expected");
        Assert.assertEquals(opportunityDetailsPage.getStageValue(), stage, "The stage value is not the expected");
        Assert.assertEquals(opportunityDetailsPage.getAccountName(), accountName, "The account name is not the expected");
    }

    @AfterClass
    public void tearDown() {
        accountsPage = navigationTab.goToAccountsTab();
        accountDetailsPage = accountsPage.openDetailsPage(accountName);
        accountDetailsPage.clickDeleteBtn();
        opportunitiesPage = navigationTab.goToOpportunitiesTab();
        opportunityDetailsPage = opportunitiesPage.openDetailsPage(opportunityName);
        opportunityDetailsPage.clickDeleteBtn();
    }
}
