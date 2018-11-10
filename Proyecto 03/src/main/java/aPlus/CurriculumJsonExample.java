
package aPlus;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utilities.internal.SchemaPrinter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.Curriculum;
import domain.EducationRecord;
import domain.EndorserRecord;
import domain.MiscellaneousRecord;
import domain.PersonalRecord;
import domain.ProfessionalRecord;

public class CurriculumJsonExample {

	public static void main(final String[] args) {

		final Curriculum curriculum = CurriculumJsonExample.createDummyObject();

		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		final String json = gson.toJson(curriculum);

		System.out.println("CREATING JSON FROM CURRICULUM");
		System.out.println(json);

		try (FileWriter writer = new FileWriter(new File("Curriculum.json"))) {

			writer.write(json);

		} catch (final IOException e) {
			e.printStackTrace();
		}

		System.out.println("CREATING CURRICULUM FROM JSON:");

		try (Reader reader = new FileReader("Curriculum.json")) {

			final Curriculum curriculumFJson = gson.fromJson(reader, Curriculum.class);
			SchemaPrinter.print(curriculumFJson);

		} catch (final IOException e) {
			e.printStackTrace();
		}

	}
	private static Curriculum createDummyObject() {

		//Personal Record
		final PersonalRecord personalRecord = new PersonalRecord();

		personalRecord.setEmail("email@example.com");
		personalRecord.setFullName("John Doe");
		personalRecord.setId(1);
		personalRecord.setPhoneNumber("+34987654321");
		personalRecord.setPhoto("https://www.exampleImage.com");
		personalRecord.setUrlLinkedInProfile("https://www.urlLinkedInProfile.com");
		personalRecord.setVersion(1);

		//Professional Records
		final List<ProfessionalRecord> professionalRecords = new ArrayList<>();

		final ProfessionalRecord professionalRecord1 = new ProfessionalRecord();
		final ProfessionalRecord professionalRecord2 = new ProfessionalRecord();

		final List<String> comments = new ArrayList<>();
		comments.add("first comment");
		comments.add("second comment");

		final SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");

		Date d1 = null;
		try {
			d1 = sdf.parse("16/10/12");
		} catch (final ParseException e) {
			e.printStackTrace();
		}

		Date d2 = null;
		try {
			d2 = sdf.parse("16/01/12");
		} catch (final ParseException e) {
			e.printStackTrace();
		}

		Date d3 = null;
		try {
			d3 = sdf.parse("16/07/15");
		} catch (final ParseException e) {
			e.printStackTrace();
		}

		Date d4 = null;
		try {
			d4 = sdf.parse("13/01/09");
		} catch (final ParseException e) {
			e.printStackTrace();
		}

		professionalRecord1.setComments(comments);
		professionalRecord1.setEndDate(d1);
		professionalRecord1.setId(2);
		professionalRecord1.setNameCompany("Acme");
		professionalRecord1.setRole("carrier");
		professionalRecord1.setStartDate(d2);
		professionalRecord1.setUrl("https://www.url1.com");
		professionalRecord1.setVersion(1);
		professionalRecords.add(professionalRecord1);

		professionalRecord2.setComments(comments);
		professionalRecord2.setEndDate(d3);
		professionalRecord2.setId(3);
		professionalRecord2.setNameCompany("Love Muffin");
		professionalRecord2.setRole("baker");
		professionalRecord2.setStartDate(d4);
		professionalRecord2.setUrl("https://www.url2.com");
		professionalRecord2.setVersion(2);
		professionalRecords.add(professionalRecord2);

		//EducationRecords
		final List<EducationRecord> educationRecords = new ArrayList<>();

		final EducationRecord educationRecord1 = new EducationRecord();
		final EducationRecord educationRecord2 = new EducationRecord();

		Date d5 = null;
		try {
			d5 = sdf.parse("01/12/01");
		} catch (final ParseException e) {
			e.printStackTrace();
		}

		Date d6 = null;
		try {
			d6 = sdf.parse("00/01/12");
		} catch (final ParseException e) {
			e.printStackTrace();
		}

		Date d7 = null;
		try {
			d7 = sdf.parse("13/03/16");
		} catch (final ParseException e) {
			e.printStackTrace();
		}

		Date d8 = null;
		try {
			d8 = sdf.parse("12/01/09");
		} catch (final ParseException e) {
			e.printStackTrace();
		}

		educationRecord1.setComments(comments);
		educationRecord1.setEndDateStudy(d5);
		educationRecord1.setId(4);
		educationRecord1.setTitle("title1");
		educationRecord1.setInstitution("institution1");
		educationRecord1.setStartDateStudy(d6);
		educationRecord1.setUrl("https://www.url1.com");
		educationRecord1.setVersion(1);
		educationRecords.add(educationRecord1);

		educationRecord2.setComments(comments);
		educationRecord2.setEndDateStudy(d7);
		educationRecord2.setId(3);
		educationRecord2.setInstitution("institution2");
		educationRecord2.setTitle("title2");
		educationRecord2.setStartDateStudy(d8);
		educationRecord2.setUrl("https://www.url2.com");
		educationRecord2.setVersion(2);
		educationRecords.add(educationRecord2);

		//MiscellaneousRecords
		final List<MiscellaneousRecord> miscellaneousRecords = new ArrayList<>();
		final MiscellaneousRecord miscellaneousRecord1 = new MiscellaneousRecord();
		final MiscellaneousRecord miscellaneousRecord2 = new MiscellaneousRecord();

		miscellaneousRecord1.setComments(comments);
		miscellaneousRecord1.setId(5);
		miscellaneousRecord1.setLinkAttachement("http://www.linkAttachement1.com");
		miscellaneousRecord1.setTitle("title1");
		miscellaneousRecord1.setVersion(3);
		miscellaneousRecords.add(miscellaneousRecord1);

		miscellaneousRecord2.setComments(comments);
		miscellaneousRecord2.setId(6);
		miscellaneousRecord2.setLinkAttachement("http://www.linkAttachement2.com");
		miscellaneousRecord2.setTitle("title2");
		miscellaneousRecord2.setVersion(4);
		miscellaneousRecords.add(miscellaneousRecord2);

		//EndorserRecords
		final List<EndorserRecord> endorserRecords = new ArrayList<>();
		final EndorserRecord endorserRecord1 = new EndorserRecord();
		final EndorserRecord endorserRecord2 = new EndorserRecord();

		endorserRecord1.setComments(comments);
		endorserRecord1.setEmail("example@email.com");
		endorserRecord1.setFullName("Full Name 1");
		endorserRecord1.setId(7);
		endorserRecord1.setLinkLinkedInProfile("http://www.linkLinkedInProfile1.com");
		endorserRecord1.setPhoneNumber("+34987654321");
		endorserRecord1.setVersion(5);
		endorserRecords.add(endorserRecord1);

		endorserRecord2.setComments(comments);
		endorserRecord2.setEmail("example@email.com");
		endorserRecord2.setFullName("Full Name 2");
		endorserRecord2.setId(8);
		endorserRecord2.setLinkLinkedInProfile("http://www.linkLinkedInProfile2.com");
		endorserRecord2.setPhoneNumber("+34987654321");
		endorserRecord2.setVersion(6);
		endorserRecords.add(endorserRecord2);

		//Curriculum's setters:
		final Curriculum curriculum = new Curriculum();

		curriculum.setTicker("000001");	//Example value
		curriculum.setEducationRecords(educationRecords);
		curriculum.setEndorserRecords(endorserRecords);
		curriculum.setId(0);
		curriculum.setMiscellaneousRecords(miscellaneousRecords);
		curriculum.setPersonalRecord(personalRecord);
		curriculum.setProfessionalRecords(professionalRecords);
		curriculum.setVersion(0);

		return curriculum;
	}
}
