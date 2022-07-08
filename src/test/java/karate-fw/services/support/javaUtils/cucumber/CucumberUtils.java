public class CucumberUtils {
    public String getFeatureName(ScenarioResult scenarioResult) {
        return scenarioResult.getScenario().getFeature().getName();
    }

    public String getScenarioName(ScenarioResult scenarioResult) {
        return scenarioResult.getScenario().getName();
    }

    public String getResponsibleName(ScenarioResult scenarioResult) {
        return scenarioResult.getScenario()
                .getTags()
                .stream()
                .filter(tag -> tag.toString().contains("@#"))
                .collect(Collectors.toList())
                .get(0)
                .toString()
                .replace("@#", "");
    }

    public boolean isErrorMessage(ScenarioResult scenarioResult) {
        try {
            scenarioResult.getError().getMessage();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage(ScenarioResult scenarioResult) {
        try {
            final String message = scenarioResult.getError().getMessage();
            return message;
        } catch (Exception e) {
            return "N/A";
        }
    }

    public List<String> getResponsibles(JsonArray responsibles) {
        List<String> responsible = new ArrayList<String>();
        Iterator iterator = responsibles.get(0).getAsJsonObject().keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            responsible.add(key);
        }
        return responsible;
    }

    public static void generateReport(String reportDirLocation){
        File reportDir = new File(reportDirLocation);
        Collection<File> jsonCollection = FileUtils.listFiles(reportDir, new String[] {"json"}, true);
        List<String> jsonFiles = new ArrayList<String>();
        jsonCollection.forEach(file -> jsonFiles.add(file.getAbsolutePath()));
        Configuration config = new Configuration(reportDir, "karate_api");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        reportBuilder.generateReports();
    }
}
