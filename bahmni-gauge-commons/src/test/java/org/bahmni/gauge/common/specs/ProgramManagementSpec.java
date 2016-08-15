package org.bahmni.gauge.common.specs;

import com.thoughtworks.gauge.BeforeClassSteps;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.bahmni.gauge.common.BahmniPage;
import org.bahmni.gauge.common.DriverFactory;
import org.bahmni.gauge.common.PageFactory;
import org.bahmni.gauge.common.TestSpecException;
import org.bahmni.gauge.common.program.ProgramManagementPage;
import org.bahmni.gauge.common.program.domain.PatientProgram;
import org.bahmni.gauge.common.program.domain.Program;
import org.bahmni.gauge.common.registration.domain.Patient;
import org.bahmni.gauge.rest.BahmniRestClient;
import org.junit.Assert;

import java.util.List;

public class ProgramManagementSpec extends BahmniPage {

	private ProgramManagementPage programManagementPage = null;

	@BeforeClassSteps
	public void waitForAppReady(){
		new BahmniPage().waitForSpinner(DriverFactory.getDriver());
	}

	public ProgramManagementSpec(){
		this.programManagementPage = PageFactory.getProgramManagementPage();
	}

	@Step("Register the patient to following program <programDetails>")
	public void enrollPatientToProgram(Table programDetails) {
		ProgramManagementPage programManagementPage = PageFactory.getProgramManagementPage();
		Program treatment = programManagementPage.transformTableToProgram(programDetails);
		programManagementPage.storeProgramInSpecStore(treatment);
		programManagementPage.enrollPatientToProgram(treatment);
	}

	@Step("Ensure that the patient is registered to mentioned program")
	public void verifyThePatientIsEnrolledToTheProgram() {
		ProgramManagementPage programManagementPage = PageFactory.getProgramManagementPage();
		Program programDetails = programManagementPage.getProgramFromSpecStore();
		Assert.assertTrue(programManagementPage.isPatientEnrolledToProgram(programDetails));
	}

	@Step("Edit attribute to registration <registration> and facility <facility>")
	public void editAttributesEnrolledToTheProgram(String registration, String facility) {
		ProgramManagementPage programManagementPage = PageFactory.getProgramManagementPage();
		Program programDetails = programManagementPage.getProgramFromSpecStore();
		programManagementPage.editProgramAttributes(programDetails, registration, facility);
	}

	@Step("End the program <TB Program>")
	public void endTheProgram(Program program) {
		ProgramManagementPage programManagementPage = PageFactory.getProgramManagementPage();
		programManagementPage.endProgram(program);
	}

	@Step("Enroll patient to the program <table>")
	public void enrollPatientToTheProgram(Table table){
		Program program = transformTableToProgram(table);
		Patient patient = PageFactory.getRegistrationFirstPage().getPatientFromSpecStore();

		PatientProgram patientProgram = new PatientProgram();
		patientProgram.setPatient(patient);
		patientProgram.setProgram(program);
		BahmniRestClient.get().enrollToProgram(patientProgram);
		programManagementPage.storePatientProgramInSpecStore(patientProgram);
	}

	@Step("Click on the patients previously program enrolled")
	public void clickOnThePatientsPreviouslyProgramEnrolled(){
		programManagementPage.clickTreatmentDashboard(programManagementPage.getPatientProgramFromSpecStore());
	}

	private Program transformTableToProgram(Table table){
		List<TableRow> rows = table.getTableRows();
		List<String> columnNames = table.getColumnNames();
		if (rows.size() != 1) {
			throw new TestSpecException("Only one patient should be provided in the table");
		}
		Program program = programManagementPage.transformTableRowToProgram(rows.get(0), columnNames);

		return program;
	}


}