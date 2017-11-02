package org.bahmni.gauge.amman.specs;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import org.bahmni.gauge.amman.OTScheduling.otHomePage;
import org.bahmni.gauge.amman.OTScheduling.otSchedulingPage;
import org.bahmni.gauge.amman.OTScheduling.otSurgicalBlockPage;
import org.bahmni.gauge.common.BahmniPage;
import org.bahmni.gauge.common.DriverFactory;
import org.bahmni.gauge.common.PageFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by jaseenam on 20/07/17.
 */
public class OTSchedulingSpec {
    private otSchedulingPage OTSchedulingPage;
    private otHomePage OTHomePage;
    private otSurgicalBlockPage OTSurgicalBlockPage;

    public OTSchedulingSpec() {
        OTSchedulingPage = PageFactory.get(otSchedulingPage.class);
        OTHomePage = PageFactory.get(otHomePage.class);
        OTSurgicalBlockPage = PageFactory.get(otSurgicalBlockPage.class);
    }

    public void waitForAppReady() {
        BahmniPage.waitForSpinner(DriverFactory.getDriver());
    }

    @Step("Navigate to OT Scheduling tab")
    public void gotoOTScheduling() {
        OTHomePage.goToOTScheduling();
        waitForAppReady();
    }

    @Step("Create a new surgical block for <Surgeon> in <OT> from date <startDate> time <startTime> to date <endDate> time <endTime>")
    public void createNewSurgicalBlock(String surgeon, String OT, String startdate, String starttime, String enddate, String endtime) {
        OTSchedulingPage.gotoCreateSurgicalBlock();
        waitForAppReady();
        OTSurgicalBlockPage.selectSurgeon(surgeon);
        OTSurgicalBlockPage.selectLocation(OT);
        OTSurgicalBlockPage.selectDateTime(startdate, starttime, enddate, endtime);
        OTSurgicalBlockPage.clickSave();
        waitForAppReady();
    }

    @Step("Edit surgical block <surgicalBlock> in <OT> on <date> with following details <table>")
    public void editSurgicalBlock(String surgicalBlock, String OT, Date date, Table table) {
        OTSchedulingPage.goToSurgeryBlockDate(date);
        OTSchedulingPage.clickEditService(surgicalBlock, OT);
        waitForAppReady();
        List<String> columnNames = table.getColumnNames();
        otSurgicalBlockPage.editSurgicalBlock(table, columnNames);
        OTSurgicalBlockPage.clickSave();
        waitForAppReady();
    }

    @Step("Add surgery with below details <table>")
    public void addSurgeriesInBlock(Table table) {
        OTSurgicalBlockPage.addSugery(table);
        OTSurgicalBlockPage.clickSave();
        waitForAppReady();
    }

    @Step("Cancel surgical block from Surgical Block for <Hanna Janho> in <OT 1> on <09 Sep 2017, Sat> with reason <Cancel reason from Surgical Block>")
    public void cancelSurgicalBlockFromSurgicalBlock(Object arg0, Object arg1, Object arg2, Object arg3) {

    }

    @Step("Cancel surgical block from Calendar for <Hanna Janho> in <OT 1> on <09 Sep 2017, Sat> with reason <Cancel reason from calendar>")
    public void cancelSurgicalBlockFromCalendar(Object arg0, Object arg1, Object arg2, Object arg3) {

    }

    @Step("Postpone surgical block from Surgical Block for <Hanna Janho> in <OT 1> on <09 Sep 2017, Sat> with reason <Postpone reason from Surgical Block>")
    public void postponeSurgicalBlockFromSurgicalBlock(Object arg0, Object arg1, Object arg2, Object arg3) {

    }

    @Step("Postpone surgical block from Calendar for <Hanna Janho> in <OT 1> on <09 Sep 2017, Sat> with reason <Postpone reason from calendar>")
    public void postponeSurgicalBlockFromCalendar(Object arg0, Object arg1, Object arg2, Object arg3) {

    }

}
