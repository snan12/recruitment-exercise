package runner;

import io.cucumber.junit.platform.engine.Constants;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import  com.example.utils.W;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,value = "src/test/resources/tests/")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "gluesteps")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@regression")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/cucumber.html")
public class Runner {
	  
	
}


