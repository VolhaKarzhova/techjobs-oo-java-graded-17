package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job firstJob = new Job();
        Job secondJob = new Job();
        Assert.assertNotEquals(firstJob, secondJob);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertTrue(testJob.getName() instanceof String);
        Assert.assertTrue(testJob.getEmployer() instanceof Employer);
        Assert.assertTrue(testJob.getLocation() instanceof Location);
        Assert.assertTrue(testJob.getPositionType()instanceof PositionType);
        Assert.assertTrue(testJob.getCoreCompetency()instanceof CoreCompetency);
        Assert.assertEquals(testJob.getName(), "Product tester");
        Assert.assertEquals(testJob.getEmployer().getValue(), "ACME");
        Assert.assertEquals(testJob.getLocation().getValue(), "Desert");
        Assert.assertEquals(testJob.getPositionType().getValue(), "Quality control");
        Assert.assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job secondJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertNotEquals(firstJob, secondJob);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newLine = System.lineSeparator();
        String expectedPrint = newLine + "ID: " + job.getId() +
                newLine + "Name: " + job.getName() +
                newLine + "Employer: " + job.getEmployer() +
                newLine + "Location: " + job.getLocation() +
                newLine + "Position Type: " + job.getPositionType() +
                newLine + "Core Competency: " + job.getCoreCompetency() + newLine;
        Assert.assertEquals(expectedPrint, job.toString());
        Assert.assertTrue(job.toString().startsWith(System.lineSeparator()));
        Assert.assertTrue(job.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertTrue(job.toString().contains("Name: " + job.getName()));
        Assert.assertTrue(job.toString().contains("ID: " + job.getId()));
        Assert.assertTrue(job.toString().contains("Employer: " + job.getEmployer()));
        Assert.assertTrue(job.toString().contains("Location: " + job.getLocation()));
        Assert.assertTrue(job.toString().contains("Position Type: " + job.getPositionType()));
        Assert.assertTrue(job.toString().contains("Core Competency: " + job.getCoreCompetency()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Test", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
        String noDataMessage = "Data not available";
        Assert.assertTrue(job.toString().contains("Employer: " + noDataMessage));
        Assert.assertTrue(job.toString().contains("Location: " + noDataMessage));
        Assert.assertTrue(job.toString().contains("Position Type: " + noDataMessage));
        Assert.assertTrue(job.toString().contains("Core Competency: " + noDataMessage));
        Job jobWithNoName = new Job("", new Employer("Test"), new Location(""),
                new PositionType(""), new CoreCompetency(""));
        Assert.assertTrue(jobWithNoName.toString().contains("Name: " + noDataMessage));
    }

    @Test
    public void testToStringHandlesJobWithOnlyIdPresent() {
        Job job = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
        String noDataMessage = "OOPS! This job does not seem to exist.";
        Assert.assertEquals(noDataMessage, job.toString());
    }
}
