$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/google.feature");
formatter.feature({
  "line": 2,
  "name": "Google Search",
  "description": "      As a user I should be able to search some shit in Google",
  "id": "google-search",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@RunAll"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Navigate to google and search something",
  "description": "",
  "id": "google-search;navigate-to-google-and-search-something",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Launch google.com",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Enter the string \"cucumber\" in the search box",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Click search",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Verify the output",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Extract all the result text",
  "keyword": "And "
});
formatter.match({
  "location": "googleSteps.launch_google_com()"
});
formatter.result({
  "duration": 5072684058,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cucumber",
      "offset": 18
    }
  ],
  "location": "googleSteps.enter_the_string_in_the_search_box(String)"
});
formatter.result({
  "duration": 247227826,
  "status": "passed"
});
formatter.match({
  "location": "googleSteps.click_search()"
});
formatter.result({
  "duration": 1357063884,
  "status": "passed"
});
formatter.match({
  "location": "googleSteps.verify_the_output()"
});
formatter.result({
  "duration": 23782493,
  "status": "passed"
});
formatter.match({
  "location": "googleSteps.extract_all_the_result_text()"
});
formatter.result({
  "duration": 8262457043,
  "status": "passed"
});
formatter.after({
  "duration": 720831073,
  "status": "passed"
});
});