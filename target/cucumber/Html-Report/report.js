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
formatter.before({
  "duration": 4189737276,
  "status": "passed"
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
  "name": "Click on wikipedia link and take a snap",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Navigate to https://cucumber.io/",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Click on the link Automate with Cucumber",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Click on the donate button",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Click on Join Free link",
  "keyword": "Then "
});
formatter.match({
  "location": "googleSteps.launch_google_com()"
});
formatter.result({
  "duration": 722663420,
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
formatter.write("Google should be open");
formatter.embedding("image/png", "embedded0.png");
formatter.result({
  "duration": 597239652,
  "status": "passed"
});
formatter.match({
  "location": "googleSteps.click_search()"
});
formatter.result({
  "duration": 1708468870,
  "status": "passed"
});
formatter.match({
  "location": "googleSteps.verify_the_output()"
});
formatter.write("Search results are displayed!");
formatter.embedding("image/png", "embedded1.png");
formatter.result({
  "duration": 591188406,
  "status": "passed"
});
formatter.match({
  "location": "googleSteps.click_on_wikipedia_link_and_take_a_snap()"
});
formatter.write("Wikipedia page should be open.");
formatter.embedding("image/png", "embedded2.png");
formatter.result({
  "duration": 1815264927,
  "status": "passed"
});
formatter.match({
  "location": "googleSteps.navigate_to_https_cucumber_io()"
});
formatter.write("cucumber.io should be open");
formatter.embedding("image/png", "embedded3.png");
formatter.result({
  "duration": 10527270493,
  "status": "passed"
});
formatter.match({
  "location": "googleSteps.click_on_the_link_Automate_with_Cucumber()"
});
formatter.write("Unable to click Automate with cucumber link...");
formatter.embedding("image/png", "embedded4.png");
formatter.result({
  "duration": 58837588406,
  "status": "passed"
});
formatter.match({
  "location": "googleSteps.click_on_the_donate_button()"
});
formatter.write("Donate button should be clicked");
formatter.embedding("image/png", "embedded5.png");
formatter.result({
  "duration": 31502810435,
  "status": "passed"
});
formatter.match({
  "location": "googleSteps.click_on_Join_Free_link()"
});
formatter.write("Joining for free page should be open!");
formatter.embedding("image/png", "embedded6.png");
formatter.result({
  "duration": 21224596406,
  "status": "passed"
});
formatter.after({
  "duration": 751663768,
  "status": "passed"
});
});